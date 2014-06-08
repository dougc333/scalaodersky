import forcomp.Anagrams._
import common._

object subsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(103); 
  println("Welcome to the Scala worksheet");$skip(35); 
  val a = List(('a', 2), ('b', 2));System.out.println("""a  : List[(Char, Int)] = """ + $show(a ));$skip(50); 
  val b = forcomp.Anagrams.wordOccurences("asdf");System.out.println("""b  : <error> = """ + $show(b ))}
  
}
