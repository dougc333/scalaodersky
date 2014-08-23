package com.example.memcached

import io.netty.channel.{ChannelOption,ChannelInitializer,ChannelFutureListener,ChannelFuture,SimpleChannelInboundHandler}
import scala.concurrent.ExecutionContext.Implicits.global
import io.netty.util.internal.logging.{Slf4JLoggerFactory, InternalLoggerFactory}
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.bootstrap.Bootstrap
import ChannelFutureTransformer.toFuture
import io.netty.channel._
import io.netty.channel.socket.nio.NioSocketChannel
import org.slf4j.LoggerFactory


object NettyClient {
 // InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory())
  val DefaultEventLoopGroup = new NioEventLoopGroup()
 // val log = LoggerFactory.getLogger(classOf[NettyClient])
  
  def createBootstrap(handler:ChannelHandler)=new Bootstrap()
  .group(DefaultEventLoopGroup)
  .channel(classOf[NioSocketChannel])
  .option[java.lang.Boolean](ChannelOption.SO_KEEPALIVE,true)
  .handler(new ChannelInitializer[io.netty.channel.Channel]{
    def initChannel(ch:io.netty.channel.Channel){
      //MemcachedEncoder bad
      ch.pipeline().addLast(new MemcachedDecoder,new MemcachedEncoder,  handler)
    }
  })
}

class NettyClient(host:String="localhost", port:Int=11211) 
extends SimpleChannelInboundHandler[ServerResponse] with Client {
  import NettyClient._
  
  private val bootstrap = createBootstrap(this)
  private val connectPromise = Promise[Client]()
  private var disconnectFuture:Future[Client]=null
  private var currentContext:ChannelHandlerContext=null
  private var commandPromise:Promise[ServerResponse]=null
  
  def set(key:String, bytes:Array[Byte],flags:Int=0, expiration:Int=0):Future[StatusResponse]=
    this.write(new SetRequest(key,bytes,flags, expiration)).castTo[StatusResponse]
  
  def get(key:String):Future[GetResponse]=
    this.write(new GetRequest(key)).castTo[GetResponse]
  
  def delete(key:String)=
    this.write(new DeleteRequest(key)).castTo[StatusResponse]
  
  def connect():Future[Client]={
    println("nettyclient connect")
    this.bootstrap.connect(host,port).onFailure{
      case e:Throwable=>println("connect failure host:"+host+" port:"+port);this.connectPromise.failure(e)
    }
    println("connect sending future")
   this.connectPromise.future
  }
  
  def close():Future[Client]={
    if(this.currentContext!=null && this.currentContext.channel().isActive && this.disconnectFuture==null){
      this.disconnectFuture = this.currentContext.close().map(v=>this)
    }
    
    if(this.disconnectFuture==null){
      Promise.success[Client](this).future
    }else{
      this.disconnectFuture
    }
        
  }
  
  private def write(request:ClientRequest):Future[ServerResponse]={
    this.synchronized{
      if(this.commandPromise!=null){
        throw new BusyClientException
      }
      
      val result = Promise[ServerResponse]()
      this.currentContext.writeAndFlush(request).onFailure{
        case e:Throwable=>result.tryFailure(e)
      }
      this.commandPromise=result
      this.commandPromise.future
    }

  }
  
  def channelRead0(ctx:ChannelHandlerContext, msg:ServerResponse){
    this.synchronized{
      if(this.commandPromise!=null){
        if(msg.isError){
          //typo in the class. one m instead of 2
          val exception = new ComandFailedException(msg)
          exception.fillInStackTrace()
          this.commandPromise.failure(exception)
        }else{
          this.commandPromise.success(msg)
        }
        this.commandPromise=null
      }else{
  //      log.error("channelRead0 error",msg)
      }
      
    }
  }
  
  override def exceptionCaught(ctx:ChannelHandlerContext, cause:Throwable){
   // log.error("Connection failed",cause)
    this.synchronized{
      if(this.commandPromise!=null){
        this.commandPromise.tryFailure(cause)
        this.commandPromise=null
      }
      this.connectPromise.tryFailure(cause)
    }
  }
  
  override def handlerAdded(ctx:ChannelHandlerContext){
    this.currentContext=ctx
    this.connectPromise.success(this)
  }
  
  
  
  
  
  
  
}