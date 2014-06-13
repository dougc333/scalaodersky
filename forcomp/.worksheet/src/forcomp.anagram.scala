package forcomp

object anagram {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet")
 
   /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)];$skip(833); val res$0 = 

  /** The dictionary is simply a sequence of words.
   *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
   */
//  val dictionary: List[Word] = loadDictionary
  //  def wordOccurrences(w: Word): Occurrences = {
  //  w.toLowerCase().groupBy(x=>x).map( { case (x, y) => (x, y.length) } ).toList.sortBy(x=>x._1)
  //}
  
  //  test("wordOccurrences: abcd") {
  //  assert(wordOccurrences("abcd") === List(('a', 1), ('b', 1), ('c', 1), ('d', 1)))
  //}

  //test("wordOccurrences: Robert") {
  //  assert(wordOccurrences("Robert") === List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1)))
 // }

   "asdf".toLowerCase();System.out.println("""res0: String = """ + $show(res$0));$skip(80); 
   //for(x<-"asdf".groupBy(x=>x) ) yield x
   val m = Map('a'->1,'b'->2,'c'->3);System.out.println("""m  : scala.collection.immutable.Map[Char,Int] = """ + $show(m ))}
   //m.groupByKey()
   
   
   
   
}
