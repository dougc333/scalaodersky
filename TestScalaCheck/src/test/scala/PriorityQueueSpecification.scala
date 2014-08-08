
import org.scalacheck.Gen
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import scala.collection.mutable.PriorityQueue


object PriorityQueueSpecification extends Properties("PriorityQueue") {
  val smallInt = Gen.choose(1,10)
  
  property("testmin") = forAll(smallInt) {
    a:Int=>
       println(a)
       val test = PriorityQueue(0)
       val addOne = test++PriorityQueue(a)      
       addOne.min == 0
  }  

  property("testa") = forAll(smallInt,smallInt) {
   (a,b)=> 
        println("testa")
	println(a+","+b)
        true
  }

  //create some priority queues  
  property("testb") = forAll(smallInt,smallInt) {
    (a,b)=>
       println("testb")
       //println(a+","+b)
       val h = PriorityQueue(a,b)
       if(a<b) {
	 //println("a less than b a:"+a+" ,b:"+b+"h.min:"+h.min+" h.max:"+h.max)
         a==h.min && b==h.max
       }
       else if (a>b) { 
         //println("a not less than b a:"+a+" b:"+b+" h.max:"+h.max+" h.min:"+h.min)
         a==h.max && b==h.min
       }
       else {
         println("equal a:"+a+" b:"+b+" h.max:"+h.max+" h.min:"+h.min) 
         a==b && h.min==h.max
       }
 	 
  }
 
}
