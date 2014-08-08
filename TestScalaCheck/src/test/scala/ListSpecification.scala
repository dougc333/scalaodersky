
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll



object ListSpecification extends Properties("List") {
  
  property("listlen") = forAll{
    (listA:List[Int],listB:List[Int])=>(listA.size+listB.size)==(listA:::listB).size
  }

  

}
