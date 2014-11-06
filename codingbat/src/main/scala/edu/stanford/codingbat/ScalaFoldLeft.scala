package edu.stanford


//def foldLeft[B](z: B)(f: (B, A) => B): B
//A is the list item
//Applies a binary operator f to a start value and all elements of this sequence, going left to right.
//Note: will not terminate for infinite-sized collections.
//B the result type of the binary operator. 
//z the start value. returns the result of inserting op 
//between consecutive elements of this sequence, going left to right with the start value z on the left:
//f(...f(z, x_1), x_2, ..., x_n)

//for strings foldLeft:
//def foldLeft[B](z: B)(op: (B, Char) ⇒ B): B
class ScalaFoldLeft {

  //use foldLeft to add one to each member of a list
  def sumList(list:List[Int])={
    val sum = list.foldLeft(0)((B,A)=>A+B)
  }
  
  //return orig string, b is the accumulator, Char is the char in the string going from left to right
  //append Char to accumulator b. 
  def foldString(s:String){
    s.foldLeft("")((b,Char)=>b+Char)
  }
  //return last char in string using fold left
  def getLast(s:String){
    s.foldLeft("")((b,Char)=>Char.toString)
  }
  
  //add a for comprehenshion to foldLeft
  
  
}
