package com.example.futurepromises

import scala.concurrent.duration._
import scala.concurrent._
import java.io._
import ExecutionContext.Implicits.global

//test future example
//note f.onSuccess to print out result. 
//may not need the Await.ready()
object TestFuture{
  def main(args:Array[String]){
     println("before future is started")
     val s = "hello"
     val f = Future{
       Thread.sleep(10000)
       s+"future after sleep"
     }
     println("test print after future declared")
     f.onSuccess{case s=>println(s)}
     Await.ready(f,Duration.Inf)
  }
}
