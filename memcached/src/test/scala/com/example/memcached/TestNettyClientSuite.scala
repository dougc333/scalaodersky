
package com.example.memcached

import scala.concurrent.ExecutionContext.Implicits.global
import java.io.{FileWriter,File,PrintWriter,BufferedWriter}
import org.scalatest.FunSuite

import scala.util.{Failure,Try,Success}
import scala.collection.mutable.ArrayBuffer


class TestNettyClientSuite extends FunSuite{

  test("test connections"){
    println("before connection")
    //default localhost, 11211
//    val client:Future[Client] = new NettyClient().connect
//    println("waiting for connection")
    await( new NettyClient().connect)
    
    
  }
 
  def await[T](future: Future[T], seconds: Int = 5): T = {
    var count = 0
    println("await")
    while (!future.isCompleted && count <= seconds) {
      println("sleep")
      Thread.sleep(1000)
      count += 1
    }

    if (future.isCompleted) {
      println("future isCompleted")
      future.value.get.get
    } else {
      throw new IllegalStateException(s"Trying to access the future did timeout after ${seconds} seconds")
    }
  }
 
}