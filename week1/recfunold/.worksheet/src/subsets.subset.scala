package subsets

object subset {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(76); 
  println("Welcome to the Scala worksheet");$skip(53); 
  
  //sequence comprehensions
  val foo = 1 until 5;System.out.println("""foo  : scala.collection.immutable.Range = """ + $show(foo ));$skip(22); val res$0 = 
  for(a<-foo) yield 4;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$0));$skip(22); val res$1 = 
  for(a<-foo) yield a;System.out.println("""res1: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$1));$skip(87); 
  
  //Sequences come with a combinations method
  val it = List(1,2,3) combinations 2;System.out.println("""it  : Iterator[List[Int]] = """ + $show(it ));$skip(122); 
  //can only use one of the statements
  //it.size
  //while(it.hasNext) println("a:"+it.next)
  
  for(a<-it) println(a);$skip(69); val res$2 = 
  //use combinations to get all subsets
  List(1,2,3) combinations 2;System.out.println("""res2: Iterator[List[Int]] = """ + $show(res$2));$skip(29); val res$3 = 
  List(1,2,3) combinations 1;System.out.println("""res3: Iterator[List[Int]] = """ + $show(res$3));$skip(29); val res$4 = 
  List(1,2,3) combinations 3;System.out.println("""res4: Iterator[List[Int]] = """ + $show(res$4));$skip(104); 
  
  
  
  
   def combinations[A](s: Seq[A]) = for {i <- 0 to s.length; j <- s combinations i} yield j;System.out.println("""combinations: [A](s: Seq[A])scala.collection.immutable.IndexedSeq[Seq[A]]""");$skip(31); val res$5 = 
   
   combinations(List(1,2));System.out.println("""res5: scala.collection.immutable.IndexedSeq[Seq[Int]] = """ + $show(res$5));$skip(30); val res$6 = 

   combinations(List(1,2,3));System.out.println("""res6: scala.collection.immutable.IndexedSeq[Seq[Int]] = """ + $show(res$6))}
}
