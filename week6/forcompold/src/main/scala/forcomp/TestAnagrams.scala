package forcomp
import forcomp.Anagrams._

object TestAnagrams extends App{
  val chars = 'a' to 'z'
  val perms = chars.flatMap({x=>Seq("%c".format(x))})
  println("perms:"+perms);  
  
}