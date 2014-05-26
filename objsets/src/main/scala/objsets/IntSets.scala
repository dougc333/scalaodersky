package objsets

//abstract class IntSet {
//  def incl(x:Int):IntSet
//  def contains(x:Int):Boolean
//}

//when use trait vs. abstract class? 
trait IntSet {
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean
}


class EmptySet extends IntSet{
  def incl(x:Int):IntSet = new NonEmpty(x,new EmptySet, new EmptySet)
  def contains(x:Int):Boolean = false 
}

class NonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet{
  def incl(x:Int):IntSet=
  def contains(x:Int):Boolean=
}

object foo extends Application{
  
  println("asdf")
  val i = new IntSet
}
