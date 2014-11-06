package edu.stanford

//foldRight, the list element is A, different position than foldLeft
//def foldRight[B](z: B)(op: (A, B) ⇒ B): B
class ScalaFoldRight {
  
  //print out the length of each character in a list of strings
//  scala> val l = List("aaaa","nnn")
//l: List[java.lang.String] = List(aaaa, nnn)

//scala> for{
//     | s1<-l
//     | e1<-s1
//     | if e1>0
//     | } yield e1.toString.length
//res12: List[Int] = List(1, 1, 1, 1, 1, 1, 1)

//what design  pattern requires foldRight and  for? 
//iterating through list and testinng each component, how does foldRight work? 
//accumulator and the initial value?  
  
//how to add to an initial value of an empty list? 
  

  
  
}