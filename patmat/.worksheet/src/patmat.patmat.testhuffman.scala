package patmat

package patmat
import patmat._
import Huffman.CodeTree
import scala.collection.immutable.HashMap


object testhuffman {
  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
  case class Leaf(char: Char, weight: Int) extends CodeTree;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(322); 

  
 val list1=List(1,2,3);System.out.println("""list1  : List[Int] = """ + $show(list1 ));$skip(23); 
 val list2=List(4,5,6);System.out.println("""list2  : List[Int] = """ + $show(list2 ));$skip(14); val res$0 = 
 list1++list2;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(15); val res$1 = 
 list1:::list2;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(46); 
 println(list1++list2);$skip(40);  //add 2 lists together
 println(list1:::list2);$skip(39);  //same as above
 println(list1.reverse);$skip(61);  //reverse list
 //println(list1.updated(3,100))
 println(list1.indexOf(1));$skip(23); ;
 println(list1.length);$skip(36); 
 println(list1.last);$skip(36);  //last element
 println(list1.head);$skip(48);  //first elemnt
 println(list1.init);$skip(55);  //list except last element
 println(list1.drop(1));$skip(40);  //rest after taking n elements
 println(list1 apply 1);$skip(19);  //same as below
 println(list1(1));$skip(33); 

  
val testList = List(1,2,3,4);System.out.println("""testList  : List[Int] = """ + $show(testList ));$skip(37); 
val charList = List('a','b','c','d');System.out.println("""charList  : List[Char] = """ + $show(charList ));$skip(32); 

val map= Map('a'->1, 'b' -> 2);System.out.println("""map  : scala.collection.immutable.Map[Char,Int] = """ + $show(map ));$skip(24); 
val map2 = map+('a'->1);System.out.println("""map2  : scala.collection.immutable.Map[Char,Int] = """ + $show(map2 ));$skip(47); 
println("map2 + doesnt increment value:"+map2);$skip(26); 
val map3  = map2+('c'->4);System.out.println("""map3  : scala.collection.immutable.Map[Char,Int] = """ + $show(map3 ));$skip(22); 
println("map3:"+map3);$skip(24); 
val map3a=map3('a')->10;System.out.println("""map3a  : (Int, Int) = """ + $show(map3a ));$skip(43); 
println("map3a after value change:"+map3a);$skip(18); 
val map4=('a'->1);System.out.println("""map4  : (Char, Int) = """ + $show(map4 ));$skip(36); 

def f(x:Char)= if(x=='a') 2 else 1;System.out.println("""f: (x: Char)Int""");$skip(56); 
val map5 = charList.map(x=>f(x));System.out.println("""map5  : List[Int] = """ + $show(map5 ));$skip(46);  //doesnt work for maps


val map6 = Map('a'->1,'b'->1,'c'->1,'d'->1);System.out.println("""map6  : scala.collection.immutable.Map[Char,Int] = """ + $show(map6 ));$skip(22); 
println("map6:"+map6);$skip(82); 
//overwrite values with updated
println("map6 increment a:"+map6.updated('a',10));$skip(70); 
//how to add one to existing?
val map6A=map6.updated('a',map6('a')+1);System.out.println("""map6A  : scala.collection.immutable.Map[Char,Int] = """ + $show(map6A ));$skip(25); 
println("map6a:"+map6A);$skip(47); ;

//removal mutable map
val remove = map6 - 'b';System.out.println("""remove  : scala.collection.immutable.Map[Char,Int] = """ + $show(remove ));$skip(26); 
println("remove:"+remove);$skip(118); 
//val temp = testMe2(remove.keys.toList)
//println("temp:"+temp)

//test map update values
val testMap1 = Map('a'->1);System.out.println("""testMap1  : scala.collection.immutable.Map[Char,Int] = """ + $show(testMap1 ));$skip(46); 
val testMap2=testMap1+('a'->10);System.out.println("""testMap2  : scala.collection.immutable.Map[Char,Int] = """ + $show(testMap2 ));$skip(31);  //writes over
println("testMap2:"+testMap2);$skip(275); ;



//iterate through the list
def testMe2(chars:List[Char]):Unit={
  def testMe2Acc(chars:List[Char]) = chars match{
    case Nil => println("testMe2 match empty list")
    case x::xs => println("testMe2 not empty List x:"+x+",xs:"+xs); testMe2(xs)
  }
  testMe2Acc(chars)
};System.out.println("""testMe2: (chars: List[Char])Unit""");$skip(19); 

testMe2(charList);$skip(571); 

//add map to list to count num of times char appears
def testMe3(chars:List[Char]):Unit={
  def testMe3Acc(chars:List[Char],acc:Map[Char,Int]):Unit = chars match{
    case Nil => println("testMe3 match empty list")
    case x::xs => println("testMe3 not empty List x:"+x+",xs:"+xs);println("acc:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("contains acc after add+"+tmpacc);testMe3Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe3Acc(xs,tmpacc)};
  }
  testMe3Acc(chars,Map())
};System.out.println("""testMe3: (chars: List[Char])Unit""");$skip(32); 

testMe3(List('a','b','c','a'));$skip(573); 

//change return type from Unit to Map
def testMe4(chars:List[Char]):Map[Char,Int]={
  def testMe4Acc(chars:List[Char],acc:Map[Char,Int]):Map[Char,Int] = chars match{
    case Nil => println("testMe4 empty list");println("Nil acc:"+acc);acc;
    case x::xs => println("testMe4 char:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("tmpacc+"+tmpacc);testMe4Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe4Acc(xs,tmpacc)};
  }
  testMe4Acc(chars,Map())
};System.out.println("""testMe4: (chars: List[Char])Map[Char,Int]""");$skip(38); 

val a=testMe4(List('a','b','c','a'));System.out.println("""a  : Map[Char,Int] = """ + $show(a ));$skip(25); 
println("testMe4 a:"+a);$skip(33); ;


testMe3(List('a','b','c','a'));$skip(536); 
//make pairs, w/o return type
def testMe5(chars:List[Char]):Unit={
  def testMe5Acc(chars:List[Char],acc:Map[Char,(Char,Int)]):Unit = chars match{
    case Nil => println("testMe5 empty list");
    case x::xs => println("testMe5 char:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));println("tmpacc+"+tmpacc);testMe5Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->(x,1));print("acc after add:"+tmpacc);testMe5Acc(xs,tmpacc)};
  }
  testMe5Acc(chars,Map())
};System.out.println("""testMe5: (chars: List[Char])Unit""");$skip(585); 
 
def testMe6(chars:List[Char]):List[(Char,Int)]={
  def testMe6Acc(chars:List[Char],acc:Map[Char,(Char,Int)]):Map[Char,(Char,Int)] = chars match{
    case Nil => println("testMe6 empty list");acc
    case x::xs => println("testMe6 char:"+x);println("testMe6 acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));println("testMe6 tmpacc+"+tmpacc);testMe6Acc(xs,tmpacc)} else {println("testMe6 not contains adding");val tmpacc=acc+(x->(x,1));print("testMe6 acc after add:"+tmpacc);testMe6Acc(xs,tmpacc)};
  }
  testMe6Acc(chars,Map()).values.toList
};System.out.println("""testMe6: (chars: List[Char])List[(Char, Int)]""");$skip(56); 
 

 println("testeMe6:"+testMe6(List('a','b','c','a')));$skip(228); 
// testeMe6:List((a,2), (b,1), (c,1)




//match practice, matching multiple parameters
def testParams(a:Int,b:Int,c:Int):Unit=(a,b,c) match{
  case (0,0,0) => println("testParams match "+"0,0,0")
  case _ => println("restS")
};System.out.println("""testParams: (a: Int, b: Int, c: Int)Unit""");$skip(52); 
println("testParams match test:"+testParams(0,0,0));$skip(63); 




 val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : patmat.patmat.testhuffman.Fork = """ + $show(t1 ));$skip(100); 
 val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9);System.out.println("""t2  : patmat.patmat.testhuffman.Fork = """ + $show(t2 ));$skip(137); 

 
 def weight(tree: CodeTree): Int = tree match{
    case Fork( _, _, _, weight) => weight
    case Leaf(_, weight)       => weight
  };System.out.println("""weight: (tree: patmat.Huffman.CodeTree)Int""");$skip(140); 

  def chars(tree: CodeTree): List[Char] = tree match{
   case Fork(_, _, chars, _) => chars
   case Leaf(char, _)        => List(char)
  };System.out.println("""chars: (tree: patmat.Huffman.CodeTree)List[Char]""");$skip(137); 

  def makeCodeTree(left: CodeTree, right: CodeTree) =
    Fork(left, right, chars(left) ::: chars(right), weight(left) + weight(right));System.out.println("""makeCodeTree: (left: patmat.Huffman.CodeTree, right: patmat.Huffman.CodeTree)patmat.patmat.testhuffman.Fork""");$skip(35); 

 println("weight t2:"+weight(t2));$skip(34); 
 println("weight t1:"+weight(t1));$skip(32); 
 println("chars t2:"+chars(t2));$skip(32); 
 println("chars t1:"+chars(t1));$skip(56); 
 def string2Chars(str: String): List[Char] = str.toList;System.out.println("""string2Chars: (str: String)List[Char]""");$skip(58); 
 
 println("string2Chars:"+string2Chars("hello, world"));$skip(77); ;
//getters and setters for Pair?
val pairList = List(('a',1),('b',2),('c',3));System.out.println("""pairList  : List[(Char, Int)] = """ + $show(pairList ));$skip(250); 



//foldleft, foldright
//def foldLeft[B](z: B)(f: (B, A) => B): B
//A is a list item, f takes B and a list item as parameters to f and returns B.
//take type B + list item to modify and return B. Iterates through list items
val l = List(1,2,3,4,5);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(498); 
//fold takes 2 arguments, the 0 which is the start value
// and a function type which is (b,a)=>b+a. Since the a is a list item we know this is an int so
//{(b,a:Int)=>b+a:Int}). We know the start value is an int so b is now an Int;
//{(b:Int,a:Int)=>b:Int+a:Int}) this takes the first value 0 starts from the left part of the list
//which is 1 then adds and returns as the new b, then a becomes the next value in the list and we
//repeat till nil or end of list
println(l.foldLeft(0){(b,a)=>b+a});$skip(36); 
println(l.foldRight(0){(b,a)=>b+a})

// a more meaningful example from websearch.
class Foo(val name: String, val age: Int, val sex: Symbol)

object Foo {
  def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
};$skip(362); 

//why make list  with :: vs. ()?
val fooList = Foo("H", 25, 'male) ::
              Foo("B ", 43, 'male) ::
              Foo("I", 37, 'female) ::
              Nil;System.out.println("""fooList  : List[patmat.patmat.testhuffman.Foo] = """ + $show(fooList ));$skip(183); 
val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
  val title = f.sex match {
    case 'male => "Mr."
    case 'female => "Ms."
  }
  z :+ s"$title ${f.name}, ${f.age}"
};System.out.println("""stringList  : List[String] = """ + $show(stringList ));$skip(21); 

println(stringList);$skip(36); 
              
val l1 = List(1,2,3);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(21); 
val l2 = List(4,5,6);System.out.println("""l2  : List[Int] = """ + $show(l2 ));$skip(16); 
val l3 = l1++l2;System.out.println("""l3  : List[Int] = """ + $show(l3 ));$skip(17); 
val l4 = l1:::l2;System.out.println("""l4  : List[Int] = """ + $show(l4 ));$skip(28); 
println("l3:"+l3+" l4:"+l4);$skip(204); 


//foldleft on map
//def foldLeft[B](z: B)(f: (B, A) => B): B
// A is list item which is (k,v)
// B is 0 or int
val m = Map("first"->1, "second"->2).foldLeft(0){ case (a:Int, (k:String, v:Int)) => a+v };System.out.println("""m  : Int = """ + $show(m ));$skip(17); 
println("m:"+m);$skip(67); ;

//convert map to list of pairs
val m1 = Map('a'->1,'b'->2,'c'->4);System.out.println("""m1  : scala.collection.immutable.Map[Char,Int] = """ + $show(m1 ));$skip(40); 
val m2 = m1.map({case(k,v)=>Pair(k,v)});System.out.println("""m2  : scala.collection.immutable.Map[Char,Int] = """ + $show(m2 ));$skip(13); 
println(m2);$skip(37); ;
val p1=List(('a',1),('b',2),('c',3));System.out.println("""p1  : List[(Char, Int)] = """ + $show(p1 ));$skip(13); 
println(p1);$skip(51); ;
val p2 = List(Pair('z',1),Pair('x',2),Pair('c',4));System.out.println("""p2  : List[(Char, Int)] = """ + $show(p2 ));$skip(12); 
println(p2);$skip(403); 
//m1.map { case (k,v) => (k.getBytes, v) }(collection.breakOut): List[(Array[Byte], List[Int])]

//def foldLeft[B](z: B)(f: (B, A) => B): B
//B =(head,1.0) or pair, returns a pair
//A=list items
def average(list: List[Double]): Double = list match {
  case head :: tail => tail.foldLeft( (head,1.0) )((r,c) =>
    ((r._1 + (c/r._2)) * r._2 / (r._2+1), r._2+1) )._1
  case Nil => print("empty list");0
};System.out.println("""average: (list: List[Double])Double""");$skip(332); 


//r is a pair of (listelement,1.0) this is such a waste of time
//this sucks cause you cant put print statements in a function type
//crappy 1 liner style
def averageTest(list: List[Double]): Double = list match {
  case head :: tail => tail.foldLeft( (head,30.0) )((r,c) =>
  (r._2,4.0))._1
  case Nil => print("empty list");0
};System.out.println("""averageTest: (list: List[Double])Double""");$skip(33); 

println(averageTest(List(3,2)));$skip(56); 

val mappy=Map('a'->('a',1),'b'->('b',4),'c'->('c',10));System.out.println("""mappy  : scala.collection.immutable.Map[Char,(Char, Int)] = """ + $show(mappy ));$skip(81); 
//convert to list of values
println("mappy values to list:"+mappy.values.toList);$skip(207); 


//  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[(Char,Int)] =
//    {
  //use pair or Tuple2
//    freqs.sortBy(Tuple2 => Tuple2._2)
//    }
 val testList1 = List(('t', 2), ('e', 1), ('x', 3));System.out.println("""testList1  : List[(Char, Int)] = """ + $show(testList1 ));$skip(186); 
// println(makeOrderedLeafList(testList1))
//create a leaf out of each pair in the list; can do a fold;foldRight;foldLeft
 println(testList1.map(Tuple2=>new Leaf(Tuple2._1, Tuple2._2)));$skip(187); 
 
 //test singleton
   def singleton(trees: List[CodeTree]): Boolean = trees match{
    case Nil=>false
    case x::xs =>if (xs==Nil) return true else return false
    case _ =>false
  };System.out.println("""singleton: (trees: List[patmat.Huffman.CodeTree])Boolean""");$skip(45); 
 
 println("singleton:"+singleton(List(t1)));$skip(46); 
 println("singleton:"+singleton(List(t1,t2)));$skip(123); 
 
 def singleton2(trees: List[CodeTree]): Boolean = trees match {
    case _ :: Nil => true
    case _        => false
  };System.out.println("""singleton2: (trees: List[patmat.Huffman.CodeTree])Boolean""");$skip(46); 

 println("singleton2:"+singleton2(List(t1)));$skip(48); 
 println("singleton2:"+singleton2(List(t1,t2)));$skip(65); 
 
 
 //insertion sort
 val fruit = List("apple","orange","pear");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(26); 
 val nums = List(1,2,3,4);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(54); 
 val diag = List(List(1,0,0),List(0,1,0),List(0,0,1));System.out.println("""diag  : List[List[Int]] = """ + $show(diag ));$skip(161); 
 

 def insertInt(addMe:Int, list:List[Int]):List[Int]=list match{
   case Nil=>List(addMe)
   case x::xs=> if(addMe<x) addMe::xs else x::insertInt(addMe,xs)
 };System.out.println("""insertInt: (addMe: Int, list: List[Int])List[Int]""");$skip(40); 
 
 
 println("-----------------------");$skip(48); 
 println("insert"+insertInt(1,List(2,3,4,5,6)));$skip(52); 
 println("insert"+insertInt(4,List(1,2,3,5,6,7,8)));$skip(52); 
println("insert"+insertInt(20,List(4,10,11,12,14)));$skip(36); 
 println("-----------------------");$skip(502); 
 
 
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
 };System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(368); 
 
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
 };System.out.println("""msort1: (xs: List[Int])List[Int]""");$skip(28); 
 println("--------------");$skip(111); ;
 def squareList(xs:List[Int]):List[Int]=xs match{
   case Nil=>xs
   case y::ys=>List(y*y):::squareList(ys)
 };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(35); 
 println(squareList(List(1,2,3)));$skip(62); ;

def squareList2(xs:List[Int]):List[Int]={
  xs map(x=>x*x)
};System.out.println("""squareList2: (xs: List[Int])List[Int]""");$skip(36); 
 println(squareList2(List(1,2,3)));$skip(85); ;

 //select all list
 def posElems(xs:List[Int]):List[Int]={
   xs filter (x=>x>0)
 };System.out.println("""posElems: (xs: List[Int])List[Int]""");$skip(135); 
 
 def posElem2(list:List[Int]):List[Int]=list match{
   case Nil=>list
   case x::xs => if (x>0) x::posElem2(xs) else posElem2(xs)
 };System.out.println("""posElem2: (list: List[Int])List[Int]""");$skip(35); 
 println(posElems(List(-1,0,5,6)));$skip(35); 
 println(posElem2(List(-1,0,5,6)));$skip(672); 

 //this is incorrect!!!
 //def combine(trees: List[CodeTree]): List[CodeTree] = trees match {
 //   case lowest :: secondLowest :: tail => {
 //     val newTree = makeCodeTree(lowest, secondLowest)
 //     tail.filter(tree => weight(tree) <= weight(newTree)) ::: newTree :: tail.filter(tree => weight(tree) > weight(newTree))
 //   }
 //   case _ => trees
 // }
 
 def combine(trees: List[CodeTree]): List[CodeTree] = trees match{
    case first::second::restofList => {
      println("first/second/restoflist");
      val ct = makeCodeTree(first,second)
      insertTree(ct,restofList)
    }
    case _ => println("less than 2"); trees //if less than 2 return trees
  };System.out.println("""combine: (trees: List[patmat.Huffman.CodeTree])List[patmat.Huffman.CodeTree]""");$skip(226); 


   
  def insertTree(addMe: CodeTree, list: List[CodeTree]): List[CodeTree] = list match {
      case List() => List(addMe)
      case x :: xs => if (weight(addMe) <= weight(x)) addMe :: xs else x::insertTree(addMe, xs)
  };System.out.println("""insertTree: (addMe: patmat.Huffman.CodeTree, list: List[patmat.Huffman.CodeTree])List[patmat.Huffman.CodeTree]""");$skip(35); 
  

  
  
 val ll4=List(1,2,3,4,5);System.out.println("""ll4  : List[Int] = """ + $show(ll4 ));$skip(35); 
 println("drop test"+ll4.drop(2));$skip(203); ;
 
 def combine1(trees: List[CodeTree]): List[CodeTree] = {
     if (trees.length>=2) {
       val ct = makeCodeTree(trees.head,trees(2))
       return ct::trees.drop(2)
     }
     else
       trees
  };System.out.println("""combine1: (trees: List[patmat.Huffman.CodeTree])List[patmat.Huffman.CodeTree]""");$skip(65); 
 
 val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4));System.out.println("""leaflist  : List[patmat.patmat.testhuffman.Leaf] = """ + $show(leaflist ));$skip(19); val res$2 = 
 combine(leaflist);System.out.println("""res2: List[patmat.Huffman.CodeTree] = """ + $show(res$2));$skip(30); 
 println("leaflist"+leaflist);$skip(28); 
 println(combine(leaflist));$skip(32); 
 
 val l10 = List(1,3,5,7,9,12);System.out.println("""l10  : List[Int] = """ + $show(l10 ));$skip(33); 
 println(l10.partition(x=>x<=6));$skip(33); 
 println(l10.partition(x=>x>=6));$skip(35); 
 
 println(l10.partition(x=>x==5));$skip(414); 

 
 //until, keep on calling combiner until singleton is true. or keep calling combiner till 1 tree in list. combines
 //first 2 elements on list till there is onely 1 tree
 def until(singleton:List[CodeTree]=>Boolean, combiner:List[CodeTree]=>List[CodeTree])(zzz: List[CodeTree]):CodeTree = singleton(zzz) match{
    case true =>println(zzz);zzz.head
    case false =>until(singleton,combiner)(combiner(zzz))
  };System.out.println("""until: (singleton: List[patmat.Huffman.CodeTree] => Boolean, combiner: List[patmat.Huffman.CodeTree] => List[patmat.Huffman.CodeTree])(zzz: List[patmat.Huffman.CodeTree])patmat.Huffman.CodeTree""");$skip(383); 
  
  def times(chars: List[Char]): List[(Char, Int)] = {
    def timesAcc(chars:List[Char],acc:Map[Char,(Char,Int)]):Map[Char,(Char,Int)] = chars match {
      case Nil => acc
      case x::xs =>  if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));timesAcc(xs,tmpacc)} else {val tmpacc=acc+(x->(x,1));timesAcc(xs,tmpacc)};
  }
    timesAcc(chars,Map()).values.toList
  };System.out.println("""times: (chars: List[Char])List[(Char, Int)]""");$skip(157); 
 
  
  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.sortBy(Tuple2 => Tuple2._2).map(Tuple2 => Leaf(Tuple2._1, Tuple2._2))
  };System.out.println("""makeOrderedLeafList: (freqs: List[(Char, Int)])List[patmat.patmat.testhuffman.Leaf]""");$skip(126); 
 
  
 def createCodeTree(chars: List[Char]): CodeTree = {
    until(singleton,combine)(makeOrderedLeafList(times(chars)))
  };System.out.println("""createCodeTree: (chars: List[Char])patmat.Huffman.CodeTree""");$skip(55); 
 
 val tree1=createCodeTree(List('a','a','b','b','b'));System.out.println("""tree1  : patmat.Huffman.CodeTree = """ + $show(tree1 ));$skip(26); 
 println("tree1:"+tree1);$skip(69); ;
 val tree2=createCodeTree(List('a','a','b','b','b','d','d','d','d'));System.out.println("""tree2  : patmat.Huffman.CodeTree = """ + $show(tree2 ));$skip(26); 
 println("tree2:"+tree2);$skip(47); ;
 
 val u1 = until(singleton,combine)(List(t1));System.out.println("""u1  : patmat.Huffman.CodeTree = """ + $show(u1 ));$skip(100); 
 val u2 = until(singleton,combine)(List(createCodeTree(List('d','d','d','d','a','a','b','b','b'))));System.out.println("""u2  : patmat.Huffman.CodeTree = """ + $show(u2 ));$skip(19); 

 println("t1"+t1);$skip(19); 
 println("u1:"+u1);$skip(19); 
 println("t2"+t2);$skip(19); ;
 println("u2:"+u2);$skip(58); 
 
 
 
 println(List('d','d','d','d','a','a','b','b','b'));$skip(59); 
 println(times(List('d','d','d','d','a','a','b','b','b')));$skip(80); 
 println(makeOrderedLeafList(times(List('d','d','d','d','a','a','b','b','b'))));$skip(101); 
 println("combine:"+combine(makeOrderedLeafList(times(List('d','d','d','d','a','a','b','b','b')))));$skip(103); ;
 println("combine1:"+combine1(makeOrderedLeafList(times(List('d','d','d','d','a','a','b','b','b')))));$skip(35); ;
 println("----------------------");$skip(86); 
 println("createCodeTree:"+createCodeTree(List('d','d','d','d','a','a','b','b','b')));$skip(544); 
 
 
 def decode(tree: CodeTree, bits: List[Bit]): List[Char] = {
    def innerDecode(innerTree: CodeTree, bits: List[Bit], acc: List[Char]): List[Char] = innerTree match {
      case Leaf(char, _)           => innerDecode(tree, bits, char :: acc)
      case Fork(left, right, _, _) => bits match {
        case List()       => acc
        case head :: tail => head match {
          case 0 => innerDecode(left, tail, acc)
          case 1 => innerDecode(right, tail, acc)
        }
      }
    }
    innerDecode(tree, bits, List()).reverse
  };System.out.println("""decode: (tree: patmat.Huffman.CodeTree, bits: List[patmat.patmat.testhuffman.Bit])List[Char]""");$skip(1698); 
    

  /**
   * A Huffman coding tree for the French language.
   * Generated from the data given at
   *   http://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
   */
  val frenchCode: CodeTree = Fork(Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x','j'),14279),Leaf('f',16351),List('x','j','f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k','w'),2492),List('z','k','w'),4585),Leaf('y',4725),List('z','k','w','y'),9310),Leaf('h',11298),List('z','k','w','y','h'),20608),Leaf('q',20889),List('z','k','w','y','h','q'),41497),List('x','j','f','z','k','w','y','h','q'),72127),List('d','x','j','f','z','k','w','y','h','q'),128396),List('s','d','x','j','f','z','k','w','y','h','q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o','l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m','p'),91856),Leaf('u',96785),List('m','p','u'),188641),List('o','l','m','p','u'),355071),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u'),605362),Fork(Fork(Fork(Leaf('r',100500),Fork(Leaf('c',50003),Fork(Leaf('v',24975),Fork(Leaf('g',13288),Leaf('b',13822),List('g','b'),27110),List('v','g','b'),52085),List('c','v','g','b'),102088),List('r','c','v','g','b'),202588),Fork(Leaf('n',108812),Leaf('t',111103),List('n','t'),219915),List('r','c','v','g','b','n','t'),422503),Fork(Leaf('e',225947),Fork(Leaf('i',115465),Leaf('a',117110),List('i','a'),232575),List('e','i','a'),458522),List('r','c','v','g','b','n','t','e','i','a'),881025),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u','r','c','v','g','b','n','t','e','i','a'),1486387)
 type Bit = Int;System.out.println("""frenchCode  : patmat.Huffman.CodeTree = """ + $show(frenchCode ));$skip(315); 
  /**
   * What does the secret message say? Can you decode it?
   * For the decoding use the `frenchCode' Huffman tree defined above.
   */
  val secret: List[Bit] = List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1);System.out.println("""secret  : List[patmat.patmat.testhuffman.Bit] = """ + $show(secret ));$skip(128); 

  /**
   * Write a function that returns the decoded secret
   */
  def decodedSecret: List[Char] = decode(frenchCode, secret);System.out.println("""decodedSecret: => List[Char]""");$skip(29); 
  
   println(decodedSecret);$skip(55); 
 
 
 
 //sort
  println( List(5,3,4,100).sortBy(x=>x))}
 
 
 
 
 
}
