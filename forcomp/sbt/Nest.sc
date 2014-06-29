package forcomp

object Nest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
    
  val n=7                                         //> n  : Int = 7
   ((1 until n )map (i=>(1 until i )map(j=>(i,j))))
                                                  //> res0: scala.collection.immutable.IndexedSeq[scala.collection.immutable.Index
                                                  //| edSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2)), V
                                                  //| ector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((6,1)
                                                  //| , (6,2), (6,3), (6,4), (6,5)))
 //change vector of vectors to vector of pairs
 ((1 until n )map (i=>(1 until i )map(j=>(i,j)))).flatten
                                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))



//where does the vector type inference come from?
   (1 until n) flatMap(i=>(1 until i map(j=>(i,j))))
                                                  //> res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))


 for{
    i<-1 until n
    j<-1 until n
    if (j<=i)
 }  yield (i*j)                                   //> res3: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 4, 3, 6, 9, 
                                                  //| 4, 8, 12, 16, 5, 10, 15, 20, 25, 6, 12, 18, 24, 30, 36)

}