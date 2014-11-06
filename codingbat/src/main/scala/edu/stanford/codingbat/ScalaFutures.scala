package edu.stanford.codingbat

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.util.Random
import scala.concurrent.Await
import scala.concurrent.duration._

//web example wrong, needs dot
//blocking example do not do this
object ScalaFutures{
 
 def main(args:Array[String]){ 
   //foo()

   //testAndThen()
   //id type list? 
   task1 onComplete{
      case Success(list) => for (x <-x) println("oncomplete:"+x)
      case Failure(t) => println("An error has occured: " + t.getMessage)
   }
 }


 def blocking(){
   val future = Future{
      println("1+1 is:"+(1+1))
   }

   val result = Await.result(future, 1.second)
 }

 
 //lifecycle of future without the callback function, use andThen
 def testAndThen()={
    val f = Future(3)
    val g = f andThen{case Success(i)=>println(i)} andThen{case _ => println("done")}
 }
 
 def task1:Future[List[Int]]={
   println("task 1 before sleep")
   Thread.sleep(3)
   println("task 1 woke up")
   Future{List(3)}
 }

 
 
 def task2(list:List[Int]):Future[List[String]]={
   println("task 2 before sleep")
   Thread.sleep(3)
   println("task 2 woke up")
   Future{List("asfd")}
 }
 def task3(list:List[String]):Future[List[Double]]={
   println("task 3 before sleep")
   Thread.sleep(3)
   println("task 3 woke up")
   Future{List(23.05)}
 }

 

}
