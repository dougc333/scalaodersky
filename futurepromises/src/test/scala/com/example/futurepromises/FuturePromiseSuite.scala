
package com.example.futurepromise

import java.io.{FileWriter,File,PrintWriter}
import org.scalatest.FunSuite
import com.example.futurepromises.Promise
import scala.util.{Failure,Try}

object FuturePromise extends FunSuite {

 test("test"){
   println("FuturePromiseSuite......")
 }//end test

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

  test("test tryComplete"){  
    val promise = Promise[String]()
    //val testValue = promise.tryComplete()
  }//end test
 
}
