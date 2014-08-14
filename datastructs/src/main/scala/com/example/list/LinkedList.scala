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
  def size : Int
  //pass function for each element in list
  def forEach(f:(E)=>Unit)= {
    def forEachRec(list:LinkedList[E]):Unit = {
      list match {
      case Node(head,tail) => {
        f(head) 
        forEachRec(tail)
      }
      case Empty=>{}
      }
    }
    forEachRec(this)
  }

  def ::[B>:E](element: B):LinkedList[B]= Node(element,this)
  def :::[B>:E](prefix:LinkedList[B]):LinkedList[B] = {
    def foo(acc:LinkedList[B],other:LinkedList[B]):LinkedList[B]={
      other match{
        case Node(head,tail) => foo(head::acc,tail)
        case Empty => acc
      }
    }
    foo(this,prefix.reverse)
  }

  def map[R](f: E=>R):LinkedList[R] = foldRight(LinkedList[R]()){
    (item,acc)=>
      Node(f(item),acc)
  }
  
  def reverse():LinkedList[E] = {
    foldLeft(LinkedList[E]()){
      (acc,item)=>
        Node(item,acc)
    }
  }
  
  def foldRight[B](accumulator:B)(f:(E,B)=>B):B = {
    reverse().foldLeft(accumulator)((acc,item)=>f(item,acc))
  }
  def filter(f:(E)=>Boolean):LinkedList[E] = {
    foldRight(LinkedList[E]()) {
      (item, acc) =>
        if (f(item)) {
          Node(item, acc)
        } else {
          acc
        }
    }
  }
  def foldLeft[B](accumulator:B)(f:(B,E)=> B):B = 
    {
    this match {
      case Node(head, tail) => {
        val current = f(accumulator, head)
        tail.foldLeft(current)(f)
      }
      case Empty => accumulator
    }
  }
  
  def find(p:(E)=>Boolean):Option[E] = {
    this match {
      case Node( head, tail ) => {
        if ( p(head) ) {
          Some(head)
        } else {
          tail.find(p)
        }
      }
      case Empty => None
    }
  }

}

object LinkedList {
  def apply[E](items:E*):LinkedList[E] = {
    if(items.isEmpty){
      Empty
    } else{
      Node(items.head,apply(items.tail:_*))
    }
    
  }
  
  def sum(numbers:LinkedList[Int]):Int = {
    numbers match{
      case Node(head,tail)=> head+ sum(tail)
      case Empty => 0
    }
  }
  
  def join(numbers:LinkedList[String]):String =  {
    numbers match {
      case Node(head, tail) => head + join(tail)
      case Empty => ""
    }
  }

}

  
case class Node[+E]( head : E, tail : LinkedList[E]  ) extends LinkedList[E]{
  val size = 1+tail.size
}

case object Empty extends LinkedList[Nothing]{
  val size = 0
}


