package subsets

object subset {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //sequence comprehensions
  val foo = 1 until 5                             //> foo  : scala.collection.immutable.Range = Range(1, 2, 3, 4)
  for(a<-foo) yield 4                             //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(4, 4, 4, 4)
  for(a<-foo) yield a                             //> res1: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 3, 4)
  
  //Sequences come with a combinations method
  val it = List(1,2,3) combinations 2             //> it  : Iterator[List[Int]] = non-empty iterator
  //can only use one of the statements
  //it.size
  //while(it.hasNext) println("a:"+it.next)
  
  for(a<-it) println(a)                           //> List(1, 2)
                                                  //| List(1, 3)
                                                  //| List(2, 3)
  //use combinations to get all subsets
  List(1,2,3) combinations 2                      //> res2: Iterator[List[Int]] = non-empty iterator
  List(1,2,3) combinations 1                      //> res3: Iterator[List[Int]] = non-empty iterator
  List(1,2,3) combinations 3                      //> res4: Iterator[List[Int]] = non-empty iterator
  
  
  
  
   def combinations[A](s: Seq[A]) = for {i <- 0 to s.length; j <- s combinations i} yield j
                                                  //> combinations: [A](s: Seq[A])scala.collection.immutable.IndexedSeq[Seq[A]]
   
   combinations(List(1,2))                        //> res5: scala.collection.immutable.IndexedSeq[Seq[Int]] = Vector(List(), List(
                                                  //| 1), List(2), List(1, 2))

   combinations(List(1,2,3))                      //> res6: scala.collection.immutable.IndexedSeq[Seq[Int]] = Vector(List(), List(
                                                  //| 1), List(2), List(3), List(1, 2), List(1, 3), List(2, 3), List(1, 2, 3))
}