package com.example.memcached


import io.netty.handler.codec.MessageToByteEncoder
import io.netty.channel.ChannelHandlerContext
import io.netty.buffer.ByteBuf
import java.util
import scala.annotation.switch
import io.netty.util.CharsetUtil

class MemcachedEncoder extends MessageToByteEncoder[ClientRequest]  {
  def encode(ctx:ChannelHandlerContext, msg:ClientRequest, out:ByteBuf){
    (msg.code: @switch) match{
      case Keys.Set => encodeSet(out, msg.asInstanceOf[SetRequest])
      case Keys.Get => encodeGet(out, msg.asInstanceOf[GetRequest])
      case Keys.Delete => encodeDelete(out, msg.asInstanceOf[DeleteRequest])
      case _ => throw new UnknownRequestException(msg)
    }
  }
  
  def encodeSet(buffer: ByteBuf, set:SetRequest){
    val key = set.key.getBytes(CharsetUtil.US_ASCII)
    buffer.writeByte(Keys.RequestKey)
    .writeByte(Keys.Set)
    .writeShort(key.size)
    .writeByte(8)
    .writeByte(0)
    .writeShort(0)
    .writeInt(0)
    .writeInt(key.size+8+set.value.size)
    .writeLong(0)
    .writeInt(set.flags)
    .writeInt(set.expiration)
    .writeBytes(key)
    .writeBytes(set.value)
  }
  
  def encodeGet(buffer:ByteBuf, get:GetRequest){
    encodeKeyMessage(buffer, get.key, Keys.Get)
  }
  def encodeDelete(buffer:ByteBuf, delete:DeleteRequest){
    encodeKeyMessage(buffer,delete.key,Keys.Delete)
  }
  def encodeKeyMessage(buffer:ByteBuf, keyName:String, code:Int){
    val key = keyName.getBytes(CharsetUtil.US_ASCII)
    buffer.writeByte(Keys.RequestKey)
    .writeByte(code)
    .writeShort(key.size)
    .writeByte(0)
    .writeByte(0)
    .writeShort(0)
    .writeInt(key.size)
    .writeInt(0)
    .writeLong(0)
    .writeBytes(key)
  }
}