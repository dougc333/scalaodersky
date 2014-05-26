package patmat
import patmat._
import Huffman.CodeTree


//lecture notes: mutable map vs. immutable map removes
//


//class TreeMe extends CodeTree{
//  def asdf (){
//    println("aaaaa")
//  }
//}

object TestHuff extends Application{

//val h:TreeMe = new TreeMe
//h.asdf
println("asdf")
val testList = List(1,2,3,4)
def matchTest(t:List[Int]) = t match{
  case head =>println("head:"+head);if(head.isEmpty) println("list empty") else println("list not empty")
  case _ => println("match else")
}

matchTest(List())
println("++++++++")
matchTest(testList)

val charList = List('a','b','c','d')
def matchList(t:List[Char])= t match{
  case _ => println("m")
}

val map= Map('a'->1, 'b' -> 2)
val map2 = map+('a'->1)
println(map2)
var map3  = map2+('c'->4)
println("map3:"+map3)
val map3a=map3('a')->10
println("map3a after value change:"+map3a)
val map4=('a'->1)
def f(x:Char)= if(x=='a') 2 else 1
val map5 = charList.map(x=>f(x)) //doesnt work for maps
//how apply predicate to map keys and values/ 


val map6 = Map('a'->1,'b'->1,'c'->1,'d'->1)
println("map6:"+map6)
println("map6 contains a:"+map6.contains('a'))
println("map6 contains e:"+map6.contains('e'))
println("map6 a:"+map6('a'))
//println("map6 e:"+map6('e')) //exception 
println("map6 e:"+map6.getOrElse('e',0)) //no exception
//update values use update
println("map6 increment a:"+map6.updated('a',10))
//removal mutable map
var map7 = Map('a'->1,'b'->1,'c'->1,'d'->1)
map7-=('a') //cant print out? 
println("map7 remove a:"+map7)
println("map6 ")
//removing immutable map
//you need a function to itreate through elements 
//this is built into a library functions
val removeMe = map6('a') match{
  case 1 =>println("value 1");map6 - 'a'
  case _ =>println("value not 1");map6
}
println("removeMe:"+removeMe)
val remove = map6 - 'b'
println("remove:"+remove)

//iterate through the list
def testMe2(chars:List[Char]):Unit={
  def testMe2Acc(chars:List[Char]) = chars match{
    case Nil => println("testMe2 match empty list")
    case x::xs => println("testMe2 not empty List x:"+x+",xs:"+xs); testMe2(xs) 
  }
  testMe2Acc(chars)
}

val temp = testMe2(remove.keys.toList)
println("temp:"+temp)
//calculate sum of values, looking for duplicates

trait Pair{
  val c: Char
  val n: Int
}

//how to iterate through list? 


//filter  tests using Option
//scala> map.filter(_._2.isDefined)
//res4: scala.collection.immutable.Map[String,Option[Int]] = Map(one -> Some(1), two -> Some(2))





//map tests



//reduce tests



//partition tests



//foldleft, foldright



//JSON tests



}