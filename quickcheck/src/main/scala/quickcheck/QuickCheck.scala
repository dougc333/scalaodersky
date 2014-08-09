package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

//define property
//add forAll, ()=> 
//return a boolean
abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  val smallInteger = Gen.choose(1,10)
  val propSmallInteger = Prop.forAll(smallInteger)(n=>n>=0 && n<=100)
  
  
  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll {
    (h:H) => 
      val m = if(isEmpty(h)) 0 else findMin(h)
      findMin(insert(m,h))==m
  }
  
  property("printme")= forAll(propSmallInteger,propSmallInteger) { 
    (a,b)=> 
      println("a:"+a.toString()+", b:"+b)
      true
  }
  
  property("min2")= forAll {
    (a:Int,b:Int)=>
      //println(" min2: p._1:"+p._1+" p._2"+p._2)
      val h1 = insert(a, empty)
      val h2 = insert(b, empty)
      println(" min2 a:"+a+" b"+b+" h1.min"+findMin(h1)+" h2 min:"+findMin(h2))
      findMin(h2) == ord.min(a,b)
  }
  
  property("empty") = forAll {
    (a:Int)=> 
      val h = insert(a,empty)
      deleteMin(h) == empty
  }
  
  property("sorting") = forAll {
    (h:H)=>
      val list: List[Int] = heapToList(h)
      list.sorted == list
  }
  
  property("melding") = forAll {
    (heaps:(H,H))=>
      if(!isEmpty(heaps._1) && !isEmpty(heaps._2)){
        val m1 = findMin(heaps._1)
        val m2 = findMin(heaps._2)
        val melded = meld(heaps._1,heaps._2)
        val meldedMin = findMin(melded)
        (meldedMin == m1) || (meldedMin == m2)
      }else 
        true
  }
  
  property("melding and sorting") = forAll {
    (heaps:(H,H))=>
      val l1 = heapToList(heaps._1)
      val l2 = heapToList(heaps._2)
      val melded = meld(heaps._1,heaps._2)
      val listMelded = heapToList(melded)
      (l1++l2).sorted == listMelded
  }
  
  
  def heapToList(heap:H) :List[Int]= {
    if(isEmpty(heap)) Nil 
    else 
      findMin(heap)::heapToList(deleteMin(heap))
  }
  
  lazy val genHeap: Gen[H] = 
    for {
      v<-Gen.choose(1,10)
//      println("generating heap v:"+v)
      m<- oneOf(empty, genHeap)
 //     m<-empty
    } yield insert(v,m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
