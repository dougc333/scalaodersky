package streams
import common._


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
  def foo(v:Vector[Vector[Char]]):Pos1=>Boolean=(pos:Pos1)=>{
    print("pos.x"+pos.x+"pos.y:"+pos.y+"map:"+v(pos.x)(pos.y))
    if ( v(pos.x)(pos.y)!='T') {print("asdf");true}
    else
     false
  
  }                                               //> foo: (v: Vector[Vector[Char]])streams.vector.Pos1 => Boolean
  
    
val vec=Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
                                                  //> vec  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[C
                                                  //| har]] = Vector(Vector(S, T), Vector(o, o), Vector(o, o))

  foo(vec)(Pos1(0,1))                             //> pos.x0pos.y:1map:Tres2: Boolean = false
  foo(Vector(Vector('S', '-'), Vector('o', 'o'), Vector('o', 'o')))(Pos1(0,1))
                                                  //> pos.x0pos.y:1map:-asdfres3: Boolean = true
//  http://stackoverflow.com/questions/16503387/how-to-capture-inner-matched-value-in-indexwhere-vector-expression
  //test indexOf
  val Some((posY, posX)) = w.map(_ indexOf 4).zipWithIndex.find(_._1 > -1)
                                                  //> posY  : Int = 0
                                                  //| posX  : Int = 1
  //test indexWhere
  posY                                            //> res4: Int = 0
  posX                                            //> res5: Int = 1
  

//test zipWithIndex
  List(1,2,3,4).zipWithIndex                      //> res6: List[(Int, Int)] = List((1,0), (2,1), (3,2), (4,3))
  
  //how does he know there is an extra iteration w/zipWithIndex?
  List(1,2,3,4).zipWithIndex foreach({case(i,j)=>println("value:"+i+" index:"+j)})
                                                  //> value:1 index:0
                                                  //| value:2 index:1
                                                  //| value:3 index:2
                                                  //| value:4 index:3
  
  List(1,2,3,4).view.zipWithIndex foreach({case(i,j)=>println("value:"+i+" index:"+j)})
                                                  //> value:1 index:0
                                                  //| value:2 index:1
                                                  //| value:3 index:2
                                                  //| value:4 index:3
  
  
  //dont know what a view is
  List(1,2,3,4).view.zipWithIndex                 //> res7: scala.collection.SeqView[(Int, Int),Seq[_]] = SeqViewZ(...)
  
  //is this better? More lines of code.
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


val level="""ST
          |oo
          |oo""".stripMargin                      //> level  : String = ST
                                                  //| oo
                                                  //| oo

 Vector(1,2,3,4).indexWhere(x=>(x>2))             //> res8: Int = 2
 Vector(1,2,3,4).indexWhere(x=>(x>10))            //> res9: Int = -1
 
 Vector('a','b','c').indexWhere(x=>(x!='-'))      //> res10: Int = 0
 Vector('a','b','c').indexWhere(x=>(x=='c'))      //> res11: Int = 2
 
 Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o')).indexWhere(x=>(x.contains('T')))
                                                  //> res12: Int = 0
 Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o')).indexWhere(x=>(x.contains('o')))
                                                  //> res13: Int = 1
 
 //return vector then get index using of.
 val vecTest= Vector(Vector('S', 'T'), Vector('o', 'p'), Vector('q', 'r'))
                                                  //> vecTest  : scala.collection.immutable.Vector[scala.collection.immutable.Vec
                                                  //| tor[Char]] = Vector(Vector(S, T), Vector(o, p), Vector(q, r))
 val index =vecTest.indexWhere(x=>x.contains('o'))//> index  : Int = 1
 val vecT = vecTest(index)                        //> vecT  : scala.collection.immutable.Vector[Char] = Vector(o, p)
 vecT.indexOf('o')                                //> res14: Int = 0
 def findChar(c: Char, levelVector: Vector[Vector[Char]]):Unit ={
    val x = levelVector.indexOf(c)
    print(x)
  }                                               //> findChar: (c: Char, levelVector: Vector[Vector[Char]])Unit
  
  
  
  
  
}