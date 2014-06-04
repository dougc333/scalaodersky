object ForTeste {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet");$skip(38); val res$0 = 

  List(1,2,3,4,5).map(x=>println(x));System.out.println("""res0: List[Unit] = """ + $show(res$0));$skip(46); val res$1 = 
  
  for(x<-List(1,2,3,4,5)) yield println(x);System.out.println("""res1: List[Unit] = """ + $show(res$1))}


}
