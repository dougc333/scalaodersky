package streams
import streams.GameDef

object vector {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Welcome to the Scala worksheet");$skip(26); 
  val v=Vector(1,2,3,4,5);System.out.println("""v  : scala.collection.immutable.Vector[Int] = """ + $show(v ));$skip(14); 
  val v1=v(1);System.out.println("""v1  : Int = """ + $show(v1 ));$skip(29); 
  
  val u=Vector(1,2,3,4,5);System.out.println("""u  : scala.collection.immutable.Vector[Int] = """ + $show(u ));$skip(7); val res$0 = 
  u(2);System.out.println("""res0: Int = """ + $show(res$0));$skip(76); 
  val w=Vector(Vector(1,2,3),Vector(4,5,6),Vector(7.,8.9),Vector(10,11,12));System.out.println("""w  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[AnyVal]] = """ + $show(w ));$skip(10); val res$1 = 
  w(1)(1)
 case class Pos1(x: Int, y: Int) {
    /** The position obtained by changing the `x` coordinate by `d` */
    def dx(d: Int) = copy(x = x + d)

    /** The position obtained by changing the `y` coordinate by `d` */
    def dy(d: Int) = copy(y = y + d)
  };System.out.println("""res1: AnyVal = """ + $show(res$1));$skip(445); 
  
  
  //have to add the () before => so we can access he pos value
  def foo(v:Vector[Vector[Int]]):Pos1=>Boolean=(pos:Pos1)=>{
    if(v(pos.x)(pos.y)==1) true
    else
     false
  
  };System.out.println("""foo: (v: Vector[Vector[Int]])streams.vector.Pos1 => Boolean""");$skip(213); 
  
  
//  http://stackoverflow.com/questions/16503387/how-to-capture-inner-matched-value-in-indexwhere-vector-expression
  //test indexOf
  val Some((posY, posX)) = w.map(_ indexOf 4).zipWithIndex.find(_._1 > -1);System.out.println("""posY  : Int = """ + $show(posY ));System.out.println("""posX  : Int = """ + $show(posX ));$skip(27); val res$2 = 
  //test indexWhere
  posY;System.out.println("""res2: Int = """ + $show(res$2));$skip(7); val res$3 = 
  posX;System.out.println("""res3: Int = """ + $show(res$3));$skip(53); val res$4 = 
  

//test zipWithIndex
  List(1,2,3,4).zipWithIndex;System.out.println("""res4: List[(Int, Int)] = """ + $show(res$4));$skip(34); val res$5 = 
  List(1,2,3,4).view.zipWithIndex;System.out.println("""res5: scala.collection.SeqView[(Int, Int),Seq[_]] = """ + $show(res$5));$skip(331); 
  
  //is this better?
  def locationOf(v: Vector[Vector[Int]])(num: Int): Option[(Int, Int)] = {
  var i, j = 0
  var found = false

  while (i < v.size && !found) {
    j = 0

    while (j < v(i).size && !found)
      if (v(i)(j) == num) found = true else j += 1

    if (!found) i += 1
  }

  if (!found) None else Some(i, j)
};System.out.println("""locationOf: (v: Vector[Vector[Int]])(num: Int)Option[(Int, Int)]""")}


  
// def findChar(c: Char, levelVector: Vector[Vector[Char]]): ={
 //   val x = levelVector.indexWhere(_.indexOf(c) >= 0)
 //   Pos1(x, lvelVector(x).indexOf(c))
 // }
  
  
  
  
  
}
