package com.example.memcached

import io.netty.handler.codec.ByteToMessageDecoder
import io.netty.channel.ChannelHandlerContext
import io.netty.buffer.ByteBuf
import java.util
import scala.annotation.switch
import io.netty.util.CharsetUtil

class MemcachedDecoder extends ByteToMessageDecoder{

  def decode(ctx:ChannelHandlerContext, in:ByteBuf, out:util.List[AnyRef]){
    
    if(in.readableBytes()>=24){
      in.markReaderIndex()
      in.readByte()
      val commandCode = in.readByte()
      val keyLength = in.readUnsignedShort()
      val extrasLength = in.readUnsignedByte()
      val dataType = in.readByte()
      val status = in.readShort()
      val bodyLength = in.readUnsignedInt()
      val opaque = in.readInt()
      val cas = in.readLong()
      
      if(in.readableBytes()>=body.length){
        (commandCode: @switch) match{
          case Keys.Get => {
            
            val flags = if(extrasLength>0){
              in.readInt()
            }else{
              0
            }
            
            val bytes = new Array[Byte](bodyLength.toInt-extrasLength)
            in.readBytes(bytes)
            
            val value = if(status==ServerResponse.Ok){
              Some(bytes)->None
            }else{
              None->Some(new String(bytes, CharsetUtil.US_ASCII))
            }
            
            out.add(new GetResponse())
            
          }
          
          case _ if extrasLength==0=>{
            val body=if(bodyLength>0){
              Some(in.toString(CharSetUtil.US_ASCII))
            }else{
              None
            }
            in.readerIndex()
            out.add(new StatusResponse(commandCode, status, opaque, cas, body))
          }
          
          case _ => throw new UnknownResponseException(commandCode)
        }
        
      }else{
        in.resetReaderIndex()
      }
    }
    
  }
  
  
}