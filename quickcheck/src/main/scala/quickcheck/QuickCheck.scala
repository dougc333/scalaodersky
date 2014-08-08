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
  
  property("printme")= forAll { 
    (p:(Int,Int))=> 
      println("p.1:"+p._1+", p._2:"+p._2)
      true
      //val h1 = insert(p._1,empty)
      //val h2 = insert(p._2,h1)
      //findMin(h2) == ord.min(p._1,p._2)
  }
  
  property("min2")= forAll {
    (p:(Int,Int))=>
      val h1 = insert(p._1, empty)
      val h2 = insert(p._2, empty)
      findMin(h2) == ord.min(p._1,p._2)
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
      v<-1
      m<- oneOf(empty, genHeap)
    } yield insert(v,m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
