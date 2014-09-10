import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


class HttpStaticFileServerInitializer extends ChannelInitializer[SocketChannel] {

    var sslCtx:SslContext=null

    def HttpStaticFileServerInitializer(sslCtx:SslContext) {
        this.sslCtx = sslCtx;
    }

    @Override
    def initChannel(ch:SocketChannel) {
        val pipeline:ChannelPipeline = ch.pipeline();
        if (sslCtx != null) {
            pipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpStaticFileServerHandler());
    }
}

object HttpStaticFileServer{
  val SSL = System.getProperty("ssl") !=null
  val PORT = 8080
  
  def main(args:Array[String]){
    val sslCtx:SslContext=null
    
    val bossGroup:EventLoopGroup = new NioEventLoopGroup(1)
    val workerGroup:EventLoopGroup = new NioEventLoopGroup()
    try{
      val b:ServerBootstrap = newServerBootstrap()
      b.group(bossGroup,workerGroup).channel(classOf(NioServerSocketChannel)).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new HttpStaticFileInitializer(sslCtx))
      
      val ch:Channel =b.bind(PORT).sync().channel()
      ch.closeFuture().sync()

    }finally{
      bossGroup.shutdownGracefully()
      workerGroup.shutdownGracefully()
    }

  }

}
