package subsets


object Subset {

   
  /**
   * subset of string, base case is one character
   * inductive step is adding another character to all positions first in front then in 2nd position till end. 
   * do with match/case
   *   do this in steps
   *   1)show you can traverse the list
   *   2)show you can add a new element to both the beginning and end in consecutively increasing positions via 
   *   an accumulator function. Return value is Unit 
   *   3) change to returning List
   *   
   * list match 
   */
  def ListWalk(list:List[Int]):Unit=list match{
    case Nil =>println("empty list")
    case x::xs => println("x:"+x+" rest of list:"+xs); ListWalk(xs)
  }
  
  def subsetListMatch(list:List[Int]):Unit = {
    def subsetListMatchAcc(list:List[Int],acc:List[List[Int]]):Unit=list match{
      case Nil=>println("Nil"); 
      case x::xs=> println("x:"+x);println("acc:"+acc);subsetListMatchAcc(xs,acc++List(List(x))) //use a flatMap or foldLeft to iterate through each entry in acc to add x
    }
    subsetListMatchAcc(list,List())
  }
  
  println("asdf:"+List(1,2,3).map(List(_)))
  
  
  //note the _ :: _ first tests for n==1 this doesnt do anything
  //is a test only. 
  // then the head and tail create subsets
  def xcombinations(n: Int,l:List[Int]): List[List[Int]] =
  if (n > l.size) Nil
  else l match {
    case _ :: _  =>println("underscore ::");List(List(1))//if n == 1 =>l.map(List(_));
    case hd :: tl =>println("list head tail"); xcombinations(n - 1,tl).map(hd :: _) ::: xcombinations(n,tl)
    case _ => println("list underscore");Nil
  }
  
  xcombinations(2,List(1,2,3))  
  
  
  //combinations using for comprehensions
  
  def combinations[A](s: Seq[A]) = for {i <- 0 to s.length; j <- s combinations i} yield j
  
  def repeatedCombinations[A](s: Set[A], n: Int) : Traversable[List[A]] = n match {
    case 0 => List(Nil)
    //case _ => for {(x, xs) <- s X repeatedCombinations(s, n-1)} yield x :: xs
  }
  
  //def xsubsets: List[List[A]] =
  //(2 to xsize).foldLeft(l.xcombinations(1))((a, i) => l.xcombinations(i) ::: a)
  
  def main(args:Array[String]){
    val l = subsetListMatch(List(1,2,3,4))
    println("l:"+l)
    println(xcombinations(1,List(1,2,3)))
  }
}