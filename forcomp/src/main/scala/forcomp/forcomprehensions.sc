package forcomp

object forcomprehensions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet


//def manFun[T,U](xs:List[T],f:T=>U):List[U]=
//for (x<-xs) yield f(x)


//def flatMap[T,U](xs:List[T],f:T=>Iterable[U]:List[U])=
//for(x<-xs; y<-f(x)) yield y


//def filter[T](xs:List[T],p:T=>Boolean):List[T]=
//for(x<-xs if p(x)) yield x
//3 types for expression
//1)for(x<-e1) yield e2 is e1.map(x=>e2)
//2)for(x<-e1 if f; s) yield e2 is for(x<-e1.withFilter(x=>f;s)yield e2
//3)for (x<-e1;y<-e2;s) yield e3 is e1.flatMap(x=>for(y<-e2;s) yield e3)


  //for comprehension
   //   for {i <- generator
   //  if guard
  //   j = assignment } yield result

  val mmm=Map(1->"one",2->"two",3->"three")       //> mmm  : scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 
                                                  //| 3 -> three)
  val testIt = for((key,value)<-mmm) yield println("key:"+key+ " value:"+value)
                                                  //> key:1 value:one
                                                  //| key:2 value:two
                                                  //| key:3 value:three
                                                  //| testIt  : scala.collection.immutable.Iterable[Unit] = List((), (), ())

  //filtering in for comprehensions; note there is no else available. only an if
  val testItFilter = for((key,value)<-mmm if(key==2)) yield println("key:"+key+ " value:"+value)
                                                  //> key:2 value:two
                                                  //| testItFilter  : scala.collection.immutable.Iterable[Unit] = List(())
  
  //nested loops in for comprehensions; how many can you nest?
  //combining 2 lists, sequences, 2 objects with iterators. Don't need to use the length of the object
  val iList = List(1,2,3)                         //> iList  : List[Int] = List(1, 2, 3)
  val jList = List(4,5,6)                         //> jList  : List[Int] = List(4, 5, 6)
  val combo = for(i<-iList; j<-jList) yield (i,j) //> combo  : List[(Int, Int)] = List((1,4), (1,5), (1,6), (2,4), (2,5), (2,6), 
                                                  //| (3,4), (3,5), (3,6))
  //another format for nested for comprehensions
  //for(i<-expr1) yeild for(j<-i) yield ???
  

}