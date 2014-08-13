package com.example.list

//design compare sealed trait vs abstract class?
//abstract classes can be called by java code, traits only can be called if 
//they dont have any implementation code
//abstract classes can have ctor params as well as type params
//traits can have only type params...gee better to use abstract class
//traits can be reused in multiple unrelated classes. traits can be mixed into different class hierarchies
//trait with only abstract members is like a java interface so this can be used in java
//
//none of this code is reusable. ok for first rev
sealed trait LinkedList[+E] {
    def size:Int
  //pass function for each element in list
  def foreach(f:(E)=>Unit)= {
    def forEachRec(list:LinkedList[E]) = {
      list match {
      case Node(head,tail) => {println("x");}
      //case Node(head,tail) => {f(head); forEachRec(tail)}
      case Empty=>{}
      }
    }
    forEachRec(this)
  }

  def ::[B>:E](element: B):LinkedList[B]= Node(element,this)
  def map[R](f: E=>R):LinkedList[R] = ???
  def reverse():LinkedList[E] = ???
  def foldRight[B](accumulator:B)(f:(E,B)=>B):B = ???
  def filter(f:(E)=>Boolean):LinkedList[E] = ???
  def foldLeft[B](accumulator:B)(f:(B,E)=> B):B = ???
  def find(p:(E)=>Boolean):Option[E] = ???
}

object LinkedList {

  
  def apply[E](items:E*):LinkedList[E] = ???
  
  //{
  //  if(items.isEmpty) Empty 
  //  else
  //    Node(items.head, apply(items.tail:_*))
 // }
  def sum(numbers:LinkedList[Int]):Int = ???
  def join(numbers:LinkedList[String]):String = ???

}
  
case class Node[+E]( head : E, tail : LinkedList[E]  ) extends LinkedList[E]
case object Empty extends LinkedList[Nothing]{
  val size = 0
}


