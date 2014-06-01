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

//basic list, map ops 
  
  println("asdf")

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

  
val testList = List(1,2,3,4)
val charList = List('a','b','c','d')

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
val temp = testMe2(remove.keys.toList)
println("temp:"+temp)

//test map update values
val testMap1 = Map('a'->1)
val testMap2=testMap1+('a'->10) //writes over
println("testMap2:"+testMap2);



//iterate through the list
def testMe2(chars:List[Char]):Unit={
  def testMe2Acc(chars:List[Char]) = chars match{
    case Nil => println("testMe2 match empty list")
    case x::xs => println("testMe2 not empty List x:"+x+",xs:"+xs); testMe2(xs) 
  }
  testMe2Acc(chars)
}

testMe2(charList)

//add map to list to count num of times char appears
def testMe3(chars:List[Char]):Unit={
  def testMe3Acc(chars:List[Char],acc:Map[Char,Int]):Unit = chars match{
    case Nil => println("testMe3 match empty list")
    case x::xs => println("testMe3 not empty List x:"+x+",xs:"+xs);println("acc:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("contains acc after add+"+tmpacc);testMe3Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe3Acc(xs,tmpacc)};
  }
  testMe3Acc(chars,Map())
}

testMe3(List('a','b','c','a'))

//change return type from Unit to Map
def testMe4(chars:List[Char]):Map[Char,Int]={
  def testMe4Acc(chars:List[Char],acc:Map[Char,Int]):Map[Char,Int] = chars match{
    case Nil => println("testMe4 empty list");println("Nil acc:"+acc);acc;
    case x::xs => println("testMe4 char:"+x);println("acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,acc(x)+1);println("tmpacc+"+tmpacc);testMe4Acc(xs,tmpacc)} else {println("not contains adding");val tmpacc=acc+(x->1);print("acc after add:"+tmpacc);testMe4Acc(xs,tmpacc)};
  }
  testMe4Acc(chars,Map())
}

val a=testMe4(List('a','b','c','a'))
println("testMe4 a:"+a);


testMe3(List('a','b','c','a'))
//make pairs, w/o return type
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
    case x::xs => println("testMe6 char:"+x);println("testMe6 acc before insert:"+acc); if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));println("testMe6 tmpacc+"+tmpacc);testMe6Acc(xs,tmpacc)} else {println("testMe6 not contains adding");val tmpacc=acc+(x->(x,1));print("testMe6 acc after add:"+tmpacc);testMe6Acc(xs,tmpacc)};
  }
  testMe6Acc(chars,Map()).values.toList
}
 

 println("testeMe6:"+testMe6(List('a','b','c','a')))
// testeMe6:List((a,2), (b,1), (c,1)




//match practice, matching multiple parameters
def testParams(a:Int,b:Int,c:Int):Unit=(a,b,c) match{
  case (0,0,0) => println("testParams match "+"0,0,0")
  case _ => println("restS")
}
println("testParams match test:"+testParams(0,0,0))




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

// a more meaningful example from websearch.
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


//  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[(Char,Int)] = 
//    {
  //use pair or Tuple2
//    freqs.sortBy(Tuple2 => Tuple2._2)
//    }
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
 
 println("singleton:"+singleton(List(t1)))
 println("singleton:"+singleton(List(t1,t2)))
 
 def singleton2(trees: List[CodeTree]): Boolean = trees match {
    case _ :: Nil => true
    case _        => false
  }

 println("singleton2:"+singleton2(List(t1)))
 println("singleton2:"+singleton2(List(t1,t2)))
 
 
 //insertion sort
 val fruit = List("apple","orange","pear")
 val nums = List(1,2,3,4)
 val diag = List(List(1,0,0),List(0,1,0),List(0,0,1))
 

 def insertInt(addMe:Int, list:List[Int]):List[Int]=list match{
   case Nil=>List(addMe)
   case x::xs=> if(addMe<x) addMe::xs else x::insertInt(addMe,xs) 
 }
 
 
 println("-----------------------")
 println("insert"+insertInt(1,List(2,3,4,5,6)))
 println("insert"+insertInt(4,List(1,2,3,5,6,7,8)))
println("insert"+insertInt(20,List(4,10,11,12,14)))
 println("-----------------------")
 
 
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
  }


   
  def insertTree(addMe: CodeTree, list: List[CodeTree]): List[CodeTree] = list match {
      case List() => List(addMe)
      case x :: xs => if (weight(addMe) <= weight(x)) addMe :: xs else x::insertTree(addMe, xs)
  }
  

  
  
 val ll4=List(1,2,3,4,5)
 println("drop test"+ll4.drop(2));
 
 def combine1(trees: List[CodeTree]): List[CodeTree] = {
     if (trees.length>=2) {
       val ct = makeCodeTree(trees.head,trees(2))
       return ct::trees.drop(2)  
     }
     else 
       trees
  }
 
 val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
 combine(leaflist)
 println("leaflist"+leaflist)
 println(combine(leaflist))
 
 val l10 = List(1,3,5,7,9,12)
 println(l10.partition(x=>x<=6))
 println(l10.partition(x=>x>=6))
 
 println(l10.partition(x=>x==5))

 
 //until, keep on calling combiner until singleton is true. or keep calling combiner till 1 tree in list. combines 
 //first 2 elements on list till there is onely 1 tree
 def until(singleton:List[patmat.Huffman.CodeTree]=>Boolean, combiner:List[patmat.Huffman.CodeTree]=>List[patmat.Huffman.CodeTree])(zzz: List[patmat.Huffman.CodeTree]):CodeTree = singleton(zzz) match{
    case true =>println(zzz);zzz.head
    case false =>until(singleton,combiner)(combiner(zzz))   
  }
  
  def times(chars: List[Char]): List[(Char, Int)] = {
    def timesAcc(chars:List[Char],acc:Map[Char,(Char,Int)]):Map[Char,(Char,Int)] = chars match {
      case Nil => acc
      case x::xs =>  if (acc contains x) {val tmpacc=acc.updated(x,(x,acc(x)._2+1));timesAcc(xs,tmpacc)} else {val tmpacc=acc+(x->(x,1));timesAcc(xs,tmpacc)};
  }
    timesAcc(chars,Map()).values.toList
  }
 
  
  def makeOrderedLeafList(freqs: List[(Char, Int)]): List[Leaf] = {
    freqs.sortBy(Tuple2 => Tuple2._2).map(Tuple2 => Leaf(Tuple2._1, Tuple2._2))
  }
 
  
 def createCodeTree(chars: List[Char]): CodeTree = {
    until(singleton,combine)(makeOrderedLeafList(times(chars))) 
  }
 
 val tree1=createCodeTree(List('a','a','b','b','b'))
 println("tree1:"+tree1);
 val tree2=createCodeTree(List('a','a','b','b','b','d','d','d','d'))
 println("tree2:"+tree2);
 
 val u1 = until(singleton,combine)(List(t1))
 val u2 = until(singleton,combine)(List(createCodeTree(List('d','d','d','d','a','a','b','b','b'))))

 println("t1"+t1)
 println("u1:"+u1)
 println("t2"+t2);
 println("u2:"+u2)
 
 
 
 println(List('d','d','d','d','a','a','b','b','b'))
 println(times(List('d','d','d','d','a','a','b','b','b')))
 println(makeOrderedLeafList(times(List('d','d','d','d','a','a','b','b','b'))))
 println("combine:"+combine(makeOrderedLeafList(times(List('d','d','d','d','a','a','b','b','b')))));
 println("combine1:"+combine1(makeOrderedLeafList(times(List('d','d','d','d','a','a','b','b','b')))));
 println("----------------------")
 println("createCodeTree:"+createCodeTree(List('d','d','d','d','a','a','b','b','b')))
 
 
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
  }
    

  /**
   * A Huffman coding tree for the French language.
   * Generated from the data given at
   *   http://fr.wikipedia.org/wiki/Fr%C3%A9quence_d%27apparition_des_lettres_en_fran%C3%A7ais
   */
  val frenchCode: CodeTree = Fork(Fork(Fork(Leaf('s',121895),Fork(Leaf('d',56269),Fork(Fork(Fork(Leaf('x',5928),Leaf('j',8351),List('x','j'),14279),Leaf('f',16351),List('x','j','f'),30630),Fork(Fork(Fork(Fork(Leaf('z',2093),Fork(Leaf('k',745),Leaf('w',1747),List('k','w'),2492),List('z','k','w'),4585),Leaf('y',4725),List('z','k','w','y'),9310),Leaf('h',11298),List('z','k','w','y','h'),20608),Leaf('q',20889),List('z','k','w','y','h','q'),41497),List('x','j','f','z','k','w','y','h','q'),72127),List('d','x','j','f','z','k','w','y','h','q'),128396),List('s','d','x','j','f','z','k','w','y','h','q'),250291),Fork(Fork(Leaf('o',82762),Leaf('l',83668),List('o','l'),166430),Fork(Fork(Leaf('m',45521),Leaf('p',46335),List('m','p'),91856),Leaf('u',96785),List('m','p','u'),188641),List('o','l','m','p','u'),355071),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u'),605362),Fork(Fork(Fork(Leaf('r',100500),Fork(Leaf('c',50003),Fork(Leaf('v',24975),Fork(Leaf('g',13288),Leaf('b',13822),List('g','b'),27110),List('v','g','b'),52085),List('c','v','g','b'),102088),List('r','c','v','g','b'),202588),Fork(Leaf('n',108812),Leaf('t',111103),List('n','t'),219915),List('r','c','v','g','b','n','t'),422503),Fork(Leaf('e',225947),Fork(Leaf('i',115465),Leaf('a',117110),List('i','a'),232575),List('e','i','a'),458522),List('r','c','v','g','b','n','t','e','i','a'),881025),List('s','d','x','j','f','z','k','w','y','h','q','o','l','m','p','u','r','c','v','g','b','n','t','e','i','a'),1486387)
 type Bit = Int
  /**
   * What does the secret message say? Can you decode it?
   * For the decoding use the `frenchCode' Huffman tree defined above.
   */
  val secret: List[Bit] = List(0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,0,1,0,1)

  /**
   * Write a function that returns the decoded secret
   */
  def decodedSecret: List[Char] = decode(frenchCode, secret)
  
   println(decodedSecret)
 
 
 
 //sort
  println( List(5,3,4,100).sortBy(x=>x))
 
 
 
 
 
}


