package streamexamples

import Stream._
import org.joda.time._

object streams {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
  println("Welcome to the Scala worksheet");$skip(45); 
  val stream1 = cons(0,cons(1,Stream.empty));System.out.println("""stream1  : Stream.Cons[Int] = """ + $show(stream1 ));$skip(24); 
  stream1 foreach print;$skip(70); 
  //cons operator like above
  val stream2 = 0 #:: 1 #:: Stream.empty;System.out.println("""stream2  : scala.collection.immutable.Stream[Int] = """ + $show(stream2 ));$skip(24); 
  stream2 foreach print;$skip(78); 
  //need this asdf to flush buffer to get above 01 to print
  println("asdf");$skip(612); 
 //streams are constructed recursively  like lists with the caveat the construction is lazy
 //so you can have conceptually an infinitely long sequence wo running out of memory
 //the assumption is on the user/client defines the termination and it is correct and you don't run of of memory
 //what happens when the last cons is a function? this may or may not terminate the stream properly
  
 //there are some queries which are much easier to process with streams.
 //e.g. time series queries
 //when will the 10 event occur based on some filter condition
 //stream create 10 timestamps
 val timeStream=1 to 10;System.out.println("""timeStream  : scala.collection.immutable.Range.Inclusive = """ + $show(timeStream ));$skip(37); 
 val tenth = timeStream.drop(9).head;System.out.println("""tenth  : Int = """ + $show(tenth ));$skip(225); 
 
 //this isnt a stream, is an iterator. How  does stream make this better?
  def dateRange(from: DateTime,to:DateTime, step:Period):Iterator[DateTime]={
    Iterator.iterate(from)(_.plus(step)).takeWhile(!_.isAfter(to))
  };System.out.println("""dateRange: (from: org.joda.time.DateTime, to: org.joda.time.DateTime, step: org.joda.time.Period)Iterator[org.joda.time.DateTime]""");$skip(84); 
  val dates = dateRange(DateTime.now.minusYears(5),DateTime.now(),Period.months(6));System.out.println("""dates  : Iterator[org.joda.time.DateTime] = """ + $show(dates ));$skip(22); 
  print(dates.toList)}

//well that sucks....still not a stream
//implicit classes add to existing classes and can take only 1 arg in the ctor.
implicit class DateTimeOps(startDate:DateTime){
  def until(endDate:DateTime) =
    for(dayNo<-0 until Days.daysBetween(startDate,endDate).getDays) yield (startDate.plusDays(dayNo))
 
}



}
