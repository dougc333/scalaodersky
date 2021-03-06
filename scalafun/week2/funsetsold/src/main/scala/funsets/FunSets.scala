package funsets

import common._

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   * This set takes in Int types only. How to extend for Any? 
   * This set is a mapping from Int to Boolean. Looks like a function
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = {
    (x=>if (x==elem) true else false)
    // can remove and make only (x==elem)
  }

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = {
    (x=>s(x:Int)||t(x:Int))
  }

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = {
    (x=>s(x)&&t(x))
  }

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = {
    (x=>s(x) && !t(x))
  }

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = {
    (x=>s(x:Int) && p(x:Int))
  }

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      //if (s(a) && p(a) || a>bound) true, needs variable
      if (a>bound) true
      else if (contains(s,a) && !p(a)) false
      else iter(a+1)
    }
    iter(-bound)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   
  def exists(s: Set, p: Int => Boolean): Boolean = {
     def iter(a: Int): Boolean = {
//      println("processing:"+a+" s(a):"+s(a)+" p(a):"+p(a)+"s(a) && p(a)"+(s(a) && p(a)) )
      if (a > bound) return false //went to end no false case
      if (s(a) && p(a)) true 
      else iter(a+1) 
    }
    //start from negative bound and increment up to bound
    iter(-bound)
  }
*/
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, (x => !p(x)))
  
  
  def map(s: Set, f: Int => Int): Set = {
    def innerMap(s: Set, f: Int => Int,newSet:Set,a:Int):Set={
      if (a>bound) newSet
      else if (newSet==Nil && s(a)) innerMap(s,f,singletonSet(f(a)),a+1) 
      else if(newSet!=Nil && s(a)) innerMap(s,f,union(newSet,singletonSet(f(a))),a+1)
      else innerMap(s,f,newSet,a+1)
    }
    innerMap(s,f,Nil,-bound)
  }
  
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
