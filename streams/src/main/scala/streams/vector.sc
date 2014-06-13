package streams
import streams.GameDef

object vector {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val v=Vector(1,2,3,4,5)                         //> v  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)
  val v1=v(1)                                     //> v1  : Int = 2
  
  val u=Vector(1,2,3,4,5)                         //> u  : scala.collection.immutable.Vector[Int] = Vector(1, 2, 3, 4, 5)
  u(2)                                            //> res0: Int = 3
  val w=Vector(Vector(1,2,3),Vector(4,5,6),Vector(7.,8.9),Vector(10,11,12))
                                                  //> w  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Any
                                                  //| Val]] = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7.0, 8.9), Vector(10
                                                  //| , 11, 12))
  w(1)(1)                                         //> res1: AnyVal = 5
 case class Pos1(x: Int, y: Int) {
    /** The position obtained by changing the `x` coordinate by `d` */
    def dx(d: Int) = copy(x = x + d)

    /** The position obtained by changing the `y` coordinate by `d` */
    def dy(d: Int) = copy(y = y + d)
  }
  
  
  //have to add the () before => so we can access he pos value
  def foo(v:Vector[Vector[Int]]):Pos1=>Boolean=(pos:Pos1)=>{
    if(v(pos.x)(pos.y)==1) true
    else
     false
  
  }                                               //> foo: (v: Vector[Vector[Int]])streams.vector.Pos1 => Boolean
  
  
//  http://stackoverflow.com/questions/16503387/how-to-capture-inner-matched-value-in-indexwhere-vector-expression
  //test indexOf
  val Some((posY, posX)) = w.map(_ indexOf 4).zipWithIndex.find(_._1 > -1)
                                                  //> posY  : Int = 0
                                                  //| posX  : Int = 1
  //test indexWhere
  posY                                            //> res2: Int = 0
  posX                                            //> res3: Int = 1
  

//test zipWithIndex
  List(1,2,3,4).zipWithIndex                      //> res4: List[(Int, Int)] = List((1,0), (2,1), (3,2), (4,3))
  List(1,2,3,4).view.zipWithIndex                 //> res5: scala.collection.SeqView[(Int, Int),Seq[_]] = SeqViewZ(...)
  
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
}                                                 //> locationOf: (v: Vector[Vector[Int]])(num: Int)Option[(Int, Int)]


  
// def findChar(c: Char, levelVector: Vector[Vector[Char]]): ={
 //   val x = levelVector.indexWhere(_.indexOf(c) >= 0)
 //   Pos1(x, lvelVector(x).indexOf(c))
 // }
  
  
  
  
  
}