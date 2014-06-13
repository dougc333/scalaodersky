package forcomp

object testcombos {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(24); 

val chars = 'a' to 'z';System.out.println("""chars  : scala.collection.immutable.NumericRange.Inclusive[Char] = """ + $show(chars ));$skip(52); 
val perms = chars.flatMap({x=>Seq("%c".format(x))});System.out.println("""perms  : scala.collection.immutable.IndexedSeq[String] = """ + $show(perms ))}
//val perms1 = chars.Map()
//val perms = chars flatMap { a =>chars flatMap { b =>
 //   if (a != b) Seq("%c%c".format(a, b))
 //   else Seq()
 // }
//}

}
