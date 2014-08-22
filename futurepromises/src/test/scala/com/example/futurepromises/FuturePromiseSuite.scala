
package com.example.futurepromise


import scala.concurrent.ExecutionContext.Implicits.global
import java.io.{FileWriter,File,PrintWriter,BufferedWriter}
import org.scalatest.FunSuite

import com.example.futurepromises.sepnamespace.{Promise,Future,DefaultFuture}
import scala.util.{Failure,Try,Success}
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.Future

class FuturePromiseSuite extends FunSuite {

 test("test FuturePromiseSuite"){
   println("FuturePromiseSuite......")
 }


 test("test complete with value"){
  val promise = Promise[String]()
  promise.complete(Try("some value in the future"))
  if(promise.isCompleted){
    println("promise completed")
  }else if(promise.value.isFailure==true){
    println("promise isFailure true")
  }else{
    println("nada....")
  }
  }//end test
  
  test("test complete with error"){
    val promise = Promise[String]()
    promise.complete(Failure(new Exception()))
    if(promise.isCompleted==true && promise.value.isFailure==true){ 
      println("promise isCompleted and isFailure true")
    }else{
      println("promise completed or isFailure not true")
    }  
  }//end test

  test("test callbacks"){  
    val future = new DefaultFuture[String]()
    val items = new ArrayBuffer[String]()
    future.onSuccess{case value=>items+=value}
    future.complete(Success("some-value"))

    items==List("some-value")
    future.isCompleted == true
  }//end test
 
  test("scala future callback"){
    println("test scala future callback")
    val f:Future[List[Int]] = Future{
      throw new IllegalArgumentException 
      List[Int](1,2,3)
    }

    val items = List[Int]()

    f.onComplete{
      case Success(value)=>println("success"+value)
      case Failure(t)=>println("error:"+t.getMessage)
    }

    f.onSuccess{
      case value  => println("onSuccess value:"+value)
    }
    f.onFailure{
      case t=>println("failure exception:"+t)
    }
    
    assert(true)   
    
  }
  
  test("scala promise write to disk"){
    val p = scala.concurrent.Promise[File]
    val pF:Future[File] = p.future
    p.success(writeToFile)
    //pull the future out and test for success
    pF onSuccess{case x => println(x.toURI())}
  }

  def writeToFile():File={ 
    try{
       val bw = new BufferedWriter(new FileWriter("/home/dc/testfuturepromisetest.txt")) 
       bw.write("this is sample content")
       bw.write("this is more sample content")
       bw.close()
    }catch{ 
      case _:Throwable=>println("disk write exception")
    }
    return new File("/home/dc/test/testfuturepromisetest.txt")
  }
}
