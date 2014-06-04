package forcomp

object Test1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(41); val res$0 = 
  "asdfasdSDFSFsd".filter (x=>x.isUpper);System.out.println("""res0: String = """ + $show(res$0));$skip(31); val res$1 = 
  "asdfFsdf".map(x=>x.isUpper);System.out.println("""res1: scala.collection.immutable.IndexedSeq[Boolean] = """ + $show(res$1));$skip(37); val res$2 = 
  "asdfSDFSdf".groupBy(x=>x.isUpper);System.out.println("""res2: scala.collection.immutable.Map[Boolean,String] = """ + $show(res$2))}
 // "asdfasdfDFSDF".foldLeft(x=>x.isUpper)
  
}
  
 