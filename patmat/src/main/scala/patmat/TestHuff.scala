package patmat
import patmat._
import Huffman.CodeTree
import scala.collection.immutable.HashMap


//lecture notes: mutable map vs. immutable map removes
//


//class TreeMe extends CodeTree{
//  def asdf (){
//    println("aaaaa")
//  }
//}

object TestHuff extends Application{
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree

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
println("map2 + doesnt increment value:"+map2)
val map3  = map2+('c'->4)
println("map3:"+map3)
val map3a=map3('a')->10
println("map3a after value change:"+map3a)
val map4=('a'->1)

def f(x:Char)= if(x=='a') 2 else 1
val map5 = charList.map(x=>f(x)) //doesnt work for maps
//how apply predicate to map keys and values/ 


val map6 = Map('a'->1,'b'->1,'c'->1,'d'->1)
println("map6:"+map6)
//overwrite values with updated
println("map6 increment a:"+map6.updated('a',10))
//how to add one to existing?
val map6A=map6.updated('a',map6('a')+1)
println("map6a:"+map6A);

//removal mutable map
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

//test map update values
val testMap1 = Map('a'->1)
val testMap2=testMap1+('a'->10) //writes over
println("testMap2:"+testMap2);

//accumulate pairs, need map cant iterate over list in list
def testMe3(chars:List[Char]):Unit={
  def testMe3Acc(chars:List[Char],acc:Map[Char,Int]):Unit = chars match{
    case Nil => println("testMe3 match empty list")
    case x::xs => println("testMe3 not empty List x:"+x+",xs:"+xs);println("acc:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("contains acc after add+"+tmpacc);testMe3Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe3Acc(xs,tmpacc)};
  }
  testMe3Acc(chars,Map())
}


def testParams(a:Int,b:Int,c:Int):Unit=(a,b,c) match{
  case (0,0,0) => println("testParams match "+"0,0,0")
  case _ => println("restS")
}

println("testParams match test:"+testParams(0,0,0))


val temp = testMe2(remove.keys.toList)
println("temp:"+temp)


testMe3(List('a','b','c','a'))
//make pairs
def testMe4(chars:List[Char]):Map[Char,Int]={
  def testMe4Acc(chars:List[Char],acc:Map[Char,Int]):Map[Char,Int] = chars match{
    case Nil => println("testMe4 empty list");println("Nil acc:"+acc);acc;
    case x::xs => println("testMe4 char:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("tmpacc+"+tmpacc);testMe4Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe4Acc(xs,tmpacc)};
  }
  testMe4Acc(chars,Map())
}


val a=testMe4(List('a','b','c','a'))
println("testMe4 a:"+a);

 val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
 val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)

 
 def weight(tree: CodeTree): Int = tree match{
    case Fork( _, _, _, weight) => weight
    case Leaf(_, weight)       => weight
  }

  def chars(tree: CodeTree): List[Char] = tree match{
   case Fork(_, _, chars, _) => chars
   case Leaf(char, _)        => List(char) 
  }

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right))

 println("weight t2:"+weight(t2))
 println("weight t1:"+weight(t1))
 println("chars t2:"+chars(t2))
 println("chars t1:"+chars(t1))
 def string2Chars(str: String): List[Char] = str.toList
 
 println("string2Chars:"+string2Chars("hello, world"));
//getters and setters for Pair? 
val pairList = List(('a',1),('b',2),('c',3))

//step 1 verify create pairs
//step 2 return the datastructure 
//def testMe5(chars:List[Char]):Unit={
//  def testMe5Acc(chars:List[Char],acc:Map[Char,(Char,Int)]):Unit = chars match{
//    case Nil => println("testMe4 empty list");
 //   case x::xs => println("x pair:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("tmpacc+"+tmpacc);testMe4Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe5Acc(xs,tmpacc)};
//  }
//  testMe5Acc(chars,Map())
///}

//map to list



//filter  tests using Option
//scala> map.filter(_._2.isDefined)
//res4: scala.collection.immutable.Map[String,Option[Int]] = Map(one -> Some(1), two -> Some(2))





//map tests



//reduce tests


//partition tests



//foldleft, foldright
//def foldLeft[B](z: B)(f: (B, A) => B): B
//A is a list item, f takes B and a list item as parameters to f and returns B. 
//take type B + list item to modify and return B. Iterates through list items
val l = List(1,2,3,4,5)
//fold takes 2 arguments, the 0 which is the start value
// and a function type which is (b,a)=>b+a. Since the a is a list item we know this is an int so 
//{(b,a:Int)=>b+a:Int}). We know the start value is an int so b is now an Int;
//{(b:Int,a:Int)=>b:Int+a:Int}) this takes the first value 0 starts from the left part of the list 
//which is 1 then adds and returns as the new b, then a becomes the next value in the list and we 
//repeat till nil or end of list
println(l.foldLeft(0){(b,a)=>b+a})
println(l.foldRight(0){(b,a)=>b+a})

// a more meaningful example
class Foo(val name: String, val age: Int, val sex: Symbol)

object Foo {
  def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
}

//why make list  with :: vs. ()? 
val fooList = Foo("H", 25, 'male) ::
              Foo("B ", 43, 'male) ::
              Foo("I", 37, 'female) ::
              Nil
val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
  val title = f.sex match {
    case 'male => "Mr."
    case 'female => "Ms."
  }
  z :+ s"$title ${f.name}, ${f.age}"
}

println(stringList)
              
val l1 = List(1,2,3)
val l2 = List(4,5,6)
val l3 = l1++l2
val l4 = l1:::l2
println("l3:"+l3+" l4:"+l4)

//average


//foldleft on map
//def foldLeft[B](z: B)(f: (B, A) => B): B
// A is list item which is (k,v)
// B is 0 or int
val m = Map("first"->1, "second"->2).foldLeft(0){ case (a:Int, (k:String, v:Int)) => a+v }
println("m:"+m);

//convert map to list of pairs
val m1 = Map('a'->1,'b'->2,'c'->4)
val m2 = m1.map({case(k,v)=>Pair(k,v)})
println(m2);
val p1=List(('a',1),('b',2),('c',3))
println(p1);
val p2 = List(Pair('z',1),Pair('x',2),Pair('c',4))
println(p2)
//m1.map { case (k,v) => (k.getBytes, v) }(collection.breakOut): List[(Array[Byte], List[Int])]

//def foldLeft[B](z: B)(f: (B, A) => B): B
//B =(head,1.0) or pair, returns a pair
//A=list items
def average(list: List[Double]): Double = list match {
  case head :: tail => tail.foldLeft( (head,1.0) )((r,c) =>
    ((r._1 + (c/r._2)) * r._2 / (r._2+1), r._2+1) )._1
  case Nil => print("empty list");0
}


//r is a pair of (listelement,1.0) this is such a waste of time
//this sucks cause you cant put print statements in a function type
//crappy 1 liner style
def averageTest(list: List[Double]): Double = list match {
  case head :: tail => tail.foldLeft( (head,30.0) )((r,c) =>
  (r._2,4.0))._1   
  case Nil => print("empty list");0
}

println(averageTest(List(3,2)))

val mappy=Map('a'->('a',1),'b'->('b',4),'c'->('c',10))
//convert to list of values
println("mappy values to list:"+mappy.values.toList)

//lets redo the times now that we see there are pairs or tuple2s



//JSON tests


  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[(Char,Int)] = 
    {
  //use pair or Tuple2
    freqs.sortBy(Tuple2 => Tuple2._2)
    }
 val testList1 = List(('t', 2), ('e', 1), ('x', 3))
 println(makeOrderedLeafList(testList1))
//create a leaf out of each pair in the list; can do a fold;foldRight;foldLeft
 println(testList1.map(Tuple2=>new Leaf(Tuple2._1, Tuple2._2)))
 
 //test singleton
   def singleton(trees: List[CodeTree]): Boolean = trees match{
    case Nil=>false
    case x::xs =>if (xs==Nil) return true else return false
    case _ =>false
  }
 
 println(singleton(List(t1)))
 println(singleton(List(t1,t2)))
 
 
testMe3(List('a','b','c','a'))
//make pairs, make the value a pair then convert to a list
def testMe5(chars:List[Char]):Unit={
  def testMe5Acc(chars:List[Char],acc:Map[Char,(Char,Int)]):Unit = chars match{
    case Nil => println("testMe5 empty list");
    case x::xs => println("testMe5 char:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));println("tmpacc+"+tmpacc);testMe5Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->(x,1));print("acc after add:"+tmpacc);testMe5Acc(xs,tmpacc)};
  }
  testMe5Acc(chars,Map())
}
 
def testMe6(chars:List[Char]):List[(Char,Int)]={
  def testMe6Acc(chars:List[Char],acc:Map[Char,(Char,Int)]):Map[Char,(Char,Int)] = chars match{
    case Nil => println("testMe6 empty list");acc
    case x::xs => println("testMe6 char:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));println("tmpacc+"+tmpacc);testMe6Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->(x,1));print("acc after add:"+tmpacc);testMe6Acc(xs,tmpacc)};
  }
  testMe6Acc(chars,Map()).values.toList
}
 
 
 println(testMe6(List('a','b','c','a')))
 //you suck scala like perl
 
 
 //insertion sort
 val fruit = List("apple","orange","pear")
 val nums = List(1,2,3,4)
 val diag = List(List(1,0,0),List(0,1,0),List(0,0,1))
 
// def insertionSort(addMe:Int, list List[Int]):List[Int]=list match{
 //  case Nil=> Nil;
 //  case x::xs=> if(addMe<x) x:::x:::xs
 //  case _ insertionSort(addMe,xs)
// }
 
 def insert(x:Int,list:List[Int]):List[Int]={
   def insertRecursive(addMe:Int, list:List[Int]):List[Int] = list match{
   case Nil=>Nil
   case x::xs if(addMe<x)=> addMe::x::xs 
   case x::xs => x::insertRecursive(addMe,xs) 
   } 
   insertRecursive(x,list)
 }
 
 
 println("insert"+insert(1,List(2,3)))
 println("insert"+insert(4,List(3,5)))
 println("insert"+insert(20,List(4,10)))
 
 val list1=List(1,2,3)
 val list2=List(4,5,6)
 println(list1++list2) //add 2 lists together
 println(list1:::list2) //same as above
 println(list1.reverse) //reverse list
 //println(list1.updated(3,100))
 println(list1.indexOf(1));
 println(list1.length) 
 println(list1.last) //last element
 println(list1.head) //first elemnt
 println(list1.init) //list except last element
 println(list1.drop(1)) //rest after taking n elements
 println(list1 apply 1) //same as below
 println(list1(1))
def foo{}
 
 //should have stuck to vector interface. waste of time
 
 //mistake in lecture on merge function, should return list
def msort(xs:List[Int]):List[Int]={
   val n = xs.length/2
   if(n==0) xs
   else{
     def merge(xs:List[Int],ys:List[Int]):List[Int]=xs match{
       case Nil=>ys
       case x::xs1=>ys match {
         case Nil=>xs
         case y::ys1=>if(x<y) x:: merge(xs1,ys) else y::merge(xs,ys1)
       }
     }
     val (fst,snd) = xs splitAt n
     merge(msort(fst),msort(snd))
   }
 } 
 
 def msort1(xs:List[Int]):List[Int]={
   val n = xs.length/2
   if(n==0) xs
   else{
     def merge(xs:List[Int],ys:List[Int]):List[Int]=(xs,ys )match{
       case (Nil,ys)=>ys
       case (xs,Nil) =>xs
       case (x::xs1,y::ys1) => if(x<y) x :: merge(xs1,ys) else y::merge(xs,ys1)
     }
     val (fst,snd) = xs splitAt n
     merge(msort(fst),msort(snd))
   }
 } 
 println("--------------");
 def squareList(xs:List[Int]):List[Int]=xs match{
   case Nil=>xs
   case y::ys=>List(y*y):::squareList(ys)
 } 
 println(squareList(List(1,2,3)));

def squareList2(xs:List[Int]):List[Int]={
  xs map(x=>x*x)
}
 println(squareList2(List(1,2,3)));

 //select all list 
 def posElems(xs:List[Int]):List[Int]={
   xs filter (x=>x>0)  
 }
 
 def posElem2(list:List[Int]):List[Int]=list match{
   case Nil=>list
   case x::xs => if (x>0) x::posElem2(xs) else posElem2(xs)
 }
 println(posElems(List(-1,0,5,6)))
 println(posElem2(List(-1,0,5,6)))

 def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
    case lowest :: secondLowest :: tail => {
      val newTree = makeCodeTree(lowest, secondLowest)
      tail.filter(tree => weight(tree) <= weight(newTree)) ::: newTree :: tail.filter(tree => weight(tree) > weight(newTree))
    }
    case _ => trees
  } 
 
 def combine1(trees: List[CodeTree]): Unit = trees match{
    case Nil=>println("null list"); Nil
    case first::second::restofList => {
      val ct = makeCodeTree(first,second)
      //where to insert ct? 
      
      val small = trees.filter(x=>weight(x)<weight(ct))
      val large = trees.filter(x=>weight(x)>weight(ct))
      println("small:"+small)
      println("large:"+large)
      println("ct:"+ct)
      val boo = ct::large
      println("ct add to list"+boo)
    }
    case _ => println("rest match"); Nil
  }
 
 val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
 combine1(leaflist)
 println("leaflist"+leaflist)
 println(combine(leaflist))
// def insertTree(addMe:CodeTree,trees:List[CodeTree]):List[CodeTree]=trees match{
//   case Nil=>trees
//   case x::xs=> if (weight(addMe)<weight(x)) makeCodeTree(addMe) else xs
// }
 
// def posElemInsert(acc:Int, list:List[Int]):List[Int]=list match{
//   case Nil=>Nil
//   case first::second::xs => 
// }
 
 val l10 = List(1,3,5,7,9,12)
 println(l10.partition(x=>x<=6))
 println(l10.partition(x=>x>=6))
 
 println(l10.partition(x=>x==5))
 
}


