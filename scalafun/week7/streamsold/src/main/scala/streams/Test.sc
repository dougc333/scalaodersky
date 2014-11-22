package streams

import common._

import Bloxorz._


object Test{
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  case class TestObject(name:String,age:Int)
  
  val l = List(TestObject("sam",100),TestObject("d",10),TestObject("a",1000))
                                                  //> l  : List[streams.Test.TestObject] = List(TestObject(sam,100), TestObject(d,
                                                  //| 10), TestObject(a,1000))
  l.map(l=>print(l.name))                         //> samdares0: List[Unit] = List((), (), ())
  case object TestValid
  case class TestIsValid(reason:String)
  trait ValidateMe {
   def validate {
     print("validateMe")
    }
  }
   
}