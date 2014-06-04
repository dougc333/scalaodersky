package forcomp

object Nest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("Welcome to the Scala worksheet");$skip(15); 
    
  val n=7;System.out.println("""n  : Int = """ + $show(n ));$skip(52); val res$0 = 
   ((1 until n )map (i=>(1 until i )map(j=>(i,j))));System.out.println("""res0: scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[(Int, Int)]] = """ + $show(res$0));$skip(105); val res$1 = 
 //change vector of vectors to vector of pairs
 ((1 until n )map (i=>(1 until i )map(j=>(i,j)))).flatten;System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(106); val res$2 = 



//where does the vector type inference come from?
   (1 until n) flatMap(i=>(1 until i map(j=>(i,j))));System.out.println("""res2: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$2));$skip(72); val res$3 = 


 for{
    i<-1 until n
    j<-1 until n
    if (j<=i)
 }  yield (i*j);System.out.println("""res3: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$3))}

}
