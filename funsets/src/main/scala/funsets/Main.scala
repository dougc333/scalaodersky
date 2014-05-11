package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  printSet(singletonSet(1))
  printSet(union(singletonSet(1),singletonSet(2)))
  printSet(intersect(union(singletonSet(1),singletonSet(2)),(union(singletonSet(3),singletonSet(2)))))
  val testSet = Set(1,2,3,4,5)
  val it = testSet.iterator
  it foreach {t=>println(t.toInt)}
  //t is a bound var
  testSet.iterator foreach {t=>println(t*3);println(t*2);println("+++++++++++");}
  println(testSet.exists((x)=>(x==2)))
  //what do do with foreach? no return value. applies predicate to each member in set
  println(testSet.foreach((x)=>(x==2)))
  val newSet = union(singletonSet(1),singletonSet(2))
  println("test exists")
  println(exists(newSet,(x)=>(x==2)))
  println(exists(newSet,(x)=>(x==100)))
  println("test forall")
  printSet(newSet)
  println(forall(newSet,(x=>(x==2 || x==1))))
  println(forall(newSet,(x=>(x==3 || x==100))))
  println("testmap")
  var mutSet = union(singletonSet(100),singletonSet(200))
  mutSet = map(mutSet,x=>x+1)
  printSet(mutSet)
}
