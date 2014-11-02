package streamexamples

import Stream._
import org.joda.time._

object streams {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val stream1 = cons(0,cons(1,Stream.empty))      //> stream1  : Stream.Cons[Int] = Stream(0, ?)
  stream1 foreach print                           //> 01
  //cons operator like above
  val stream2 = 0 #:: 1 #:: Stream.empty          //> stream2  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
  stream2 foreach print                           //> 01
  //need this asdf to flush buffer to get above 01 to print
  println("asdf")                                 //> asdf
 //streams are constructed recursively  like lists with the caveat the construction is lazy
 //so you can have conceptually an infinitely long sequence wo running out of memory
 //the assumption is on the user/client defines the termination and it is correct and you don't run of of memory
 //what happens when the last cons is a function? this may or may not terminate the stream properly
  
 //there are some queries which are much easier to process with streams.
 //e.g. time series queries
 //when will the 10 event occur based on some filter condition
 //stream create 10 timestamps
 val timeStream=1 to 10                           //> timeStream  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4,
                                                  //|  5, 6, 7, 8, 9, 10)
 val tenth = timeStream.drop(9).head              //> tenth  : Int = 10
 
 //this isnt a stream, is an iterator. How  does stream make this better?
  def dateRange(from: DateTime,to:DateTime, step:Period):Iterator[DateTime]={
    Iterator.iterate(from)(_.plus(step)).takeWhile(!_.isAfter(to))
  }                                               //> dateRange: (from: org.joda.time.DateTime, to: org.joda.time.DateTime, step:
                                                  //|  org.joda.time.Period)Iterator[org.joda.time.DateTime]
  val dates = dateRange(DateTime.now.minusYears(5),DateTime.now(),Period.months(6))
                                                  //> dates  : Iterator[org.joda.time.DateTime] = non-empty iterator
  print(dates.toList)                             //> List(2009-07-03T22:18:20.635-07:00, 2010-01-03T22:18:20.635-08:00, 2010-07-
                                                  //| 03T22:18:20.635-07:00, 2011-01-03T22:18:20.635-08:00, 2011-07-03T22:18:20.6
                                                  //| 35-07:00, 2012-01-03T22:18:20.635-08:00, 2012-07-03T22:18:20.635-07:00, 201
                                                  //| 3-01-03T22:18:20.635-08:00, 2013-07-03T22:18:20.635-07:00, 2014-01-03T22:18

//well that sucks....still not a stream
//implicit classes add to existing classes and can take only 1 arg in the ctor.
implicit class DateTimeOps(startDate:DateTime){
  def until(endDate:DateTime) =
    for(dayNo<-0 until Days.daysBetween(startDate,endDate).getDays) yield (startDate.plusDays(dayNo))
 
}



}