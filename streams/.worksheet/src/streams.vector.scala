package streams
import common._


object vector {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(93); 
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
  };System.out.println("""res1: AnyVal = """ + $show(res$1));$skip(529); 
  
  
  //have to add the () before => so we can access he pos value
  def foo(v:Vector[Vector[Char]]):Pos1=>Boolean=(pos:Pos1)=>{
    print("pos.x"+pos.x+"pos.y:"+pos.y+"map:"+v(pos.x)(pos.y))
    if ( v(pos.x)(pos.y)!='T') {print("asdf");true}
    else
     false
  
  };System.out.println("""foo: (v: Vector[Vector[Char]])streams.vector.Pos1 => Boolean""");$skip(77); 
  
    
val vec=Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'));System.out.println("""vec  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(vec ));$skip(23); val res$2 = 

  foo(vec)(Pos1(0,1));System.out.println("""res2: Boolean = """ + $show(res$2));$skip(79); val res$3 = 
  foo(Vector(Vector('S', '-'), Vector('o', 'o'), Vector('o', 'o')))(Pos1(0,1));System.out.println("""res3: Boolean = """ + $show(res$3));$skip(207); 
//  http://stackoverflow.com/questions/16503387/how-to-capture-inner-matched-value-in-indexwhere-vector-expression
  //test indexOf
  val Some((posY, posX)) = w.map(_ indexOf 4).zipWithIndex.find(_._1 > -1);System.out.println("""posY  : Int = """ + $show(posY ));System.out.println("""posX  : Int = """ + $show(posX ));$skip(27); val res$4 = 
  //test indexWhere
  posY;System.out.println("""res4: Int = """ + $show(res$4));$skip(7); val res$5 = 
  posX;System.out.println("""res5: Int = """ + $show(res$5));$skip(53); val res$6 = 
  

//test zipWithIndex
  List(1,2,3,4).zipWithIndex;System.out.println("""res6: List[(Int, Int)] = """ + $show(res$6));$skip(151); 
  
  //how does he know there is an extra iteration w/zipWithIndex?
  List(1,2,3,4).zipWithIndex foreach({case(i,j)=>println("value:"+i+" index:"+j)});$skip(91); 
  
  List(1,2,3,4).view.zipWithIndex foreach({case(i,j)=>println("value:"+i+" index:"+j)});$skip(69); val res$7 = 
  
  
  //dont know what a view is
  List(1,2,3,4).view.zipWithIndex;System.out.println("""res7: scala.collection.SeqView[(Int, Int),Seq[_]] = """ + $show(res$7));$skip(351); 
  
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
};System.out.println("""locationOf: (v: Vector[Vector[Int]])(num: Int)Option[(Int, Int)]""");$skip(61); 


val level="""ST
          |oo
          |oo""".stripMargin;System.out.println("""level  : String = """ + $show(level ));$skip(39); val res$8 = 

 Vector(1,2,3,4).indexWhere(x=>(x>2));System.out.println("""res8: Int = """ + $show(res$8));$skip(39); val res$9 = 
 Vector(1,2,3,4).indexWhere(x=>(x>10));System.out.println("""res9: Int = """ + $show(res$9));$skip(47); val res$10 = 
 
 Vector('a','b','c').indexWhere(x=>(x!='-'));System.out.println("""res10: Int = """ + $show(res$10));$skip(45); val res$11 = 
 Vector('a','b','c').indexWhere(x=>(x=='c'));System.out.println("""res11: Int = """ + $show(res$11));$skip(97); val res$12 = 
 
 Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o')).indexWhere(x=>(x.contains('T')));System.out.println("""res12: Int = """ + $show(res$12));$skip(95); val res$13 = 
 Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o')).indexWhere(x=>(x.contains('o')));System.out.println("""res13: Int = """ + $show(res$13));$skip(119); 
 
 //return vector then get index using of.
 val vecTest= Vector(Vector('S', 'T'), Vector('o', 'p'), Vector('q', 'r'));System.out.println("""vecTest  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(vecTest ));$skip(51); 
 val index =vecTest.indexWhere(x=>x.contains('o'));System.out.println("""index  : Int = """ + $show(index ));$skip(27); 
 val vecT = vecTest(index);System.out.println("""vecT  : scala.collection.immutable.Vector[Char] = """ + $show(vecT ));$skip(19); val res$14 = 
 vecT.indexOf('o');System.out.println("""res14: Int = """ + $show(res$14));$skip(118); 
 def findChar(c: Char, levelVector: Vector[Vector[Char]]):Unit ={
    val x = levelVector.indexOf(c)
    print(x)
  };System.out.println("""findChar: (c: Char, levelVector: Vector[Vector[Char]])Unit""")}
  
  
  
  
  
}
