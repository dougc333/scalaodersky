package streams

import common._

import Bloxorz._


object Test{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
  println("Welcome to the Scala worksheet")
  case class TestObject(name:String,age:Int);$skip(126); 
  
  val l = List(TestObject("sam",100),TestObject("d",10),TestObject("a",1000));System.out.println("""l  : List[streams.Test.TestObject] = """ + $show(l ));$skip(26); val res$0 = 
  l.map(l=>print(l.name));System.out.println("""res0: List[Unit] = """ + $show(res$0))}
  case object TestValid
  case class TestIsValid(reason:String)
  trait ValidateMe {
   def validate {
     print("validateMe")
    }
  }
   
}
