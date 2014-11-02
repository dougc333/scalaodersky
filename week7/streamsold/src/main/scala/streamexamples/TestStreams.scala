package streamexamples

import Stream._
import org.joda.time._
import scala.math._

object TestStreams extends App{

  val stream1 = cons(0,cons(1,Stream.empty))
  println(stream1)
  stream1 foreach print
  
  val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

  fibs take 5 foreach println
  
  //val i = 10
  
  
  
 // val factorial: Stream[Int] = 1 #:: 2 
  //(naturals map {i => i*factorial(i - 1)})
  
}