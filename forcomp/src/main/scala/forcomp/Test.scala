package forcomp

object Test extends Application {
 val s = "asdf"
 val m= Map[Char,Int]()
 type Occurrences = List[(Char, Int)]
 val input = Map('a'->1,'b'->2,'c'->3)
 val output = input.map{ case(k,v) => (k, v) }.toList
 println(output)
 println(input.toList)
 val makeList = input.toList
 println(makeList)
 "hello".count( _ =='h')
 
 println("AADSDSASDFGSDF".toLowerCase())
 println("AADSDSASDFGSDF".toLowerCase().toList)
 //if y is not a list or doesnt support length do we get an exception
 //no cause it wouldnt compile, would get the red mark (Test)
 println("AADSDSASDFGSDF".toLowerCase().toList.groupBy(x=>x).map( { case (x, y) => (x, y.length) } )
 )
 val temp = "AADSDSASDFGSDF".toLowerCase().toList.groupBy(x=>x).map( { case (x, y) => (x, y.length) } ).toList
 println(temp.sortBy(x=>x._1))
 //what does x=x really mean?  This is not identity
 
 
 //digression.. how to tokenize a string into a list in scala? 
 val a = "this is a test sentence for tokenization"
 val ab = new java.util.StringTokenizer(a) //you can do this? 
 //ok how to iterate over this? 
 while (ab.hasMoreTokens()) println(ab.nextToken()) //not scalish... how to fix? 
 val tokenizeMe = a.split(" ").toList
 println("tokenizeMe:"+tokenizeMe)
 //more string tests
 println("asdfsadfasdf".groupBy(x=>x).map({case(x,y)=>(x,y.length)}).toList.sortBy(x=>x._1))
 println("remove spaces:"+a.replaceAll(" ",""))
 
 val sen = List("aaaa","bbbb","cccc")
 val testGroupBy = List("aaa","bbb","ccc","aa1","bb1","aaa") //groupby converts list to map
 println(testGroupBy.groupBy(x=>x));
 
 println("sort by len:"+testGroupBy.sortBy(x=>x.length))
 //use short cut below for anonymous function
 println("sort by len:"+testGroupBy.sortBy( _.length))
 println("sort by len:"+testGroupBy.sortBy(x=>x.last))
 
 
 type Word = String
  /** A sentence is a `List` of words. */
 type Sentence = List[Word]

 val dictionary: List[Word] = loadDictionary
 println(dictionary.head)
 def wordOccurrences(w: Word): Occurrences = {
    w.toLowerCase().groupBy(x=>x).map( { case (x, y) => (x, y.length) } ).toList.sortBy(x=>x._1)
 }

  /** Converts a sentence into its character occurrence list. */
  //list of words 
  def sentenceOccurrences(s: Sentence): Occurrences = wordOccurrences(s.mkString)

  val dictSmall=List("litter", "dog","god")
  //convert List[Word] to Occurrences->List[Word]
  //
  println( dictSmall.groupBy(x=>wordOccurrences(x)))
 //lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary.map(w=>wordOccurrences(w))
  
  //create seq of integers...
  
  val list1 = List(1,2,3,4)
  val list2 = List(6,7,8,9)
  val seq1 = (1 to 4)
  val seq2 = (6 to 9)
  val seqprod = seq1.flatMap(x=>seq2.map(y=>(x,y)))
  println(seqprod); //this is better than java
  
  //scalar product 2 vectors
  
  def scalarProduct(xs:Vector[Double], ys:Vector[Double]):Double={
    (xs zip ys).map(xy=>xy._1*xy._2).sum
  }
  println("scalarProduct"+scalarProduct(Vector(1,2,3), Vector(4,5,6)))
 //practice queries on logs 
 val testlog=List(("www.google.com","10.1.22.224",100),("www.cnn.com","10.1.22.223",10),("www.cnn.com","10.1.22.199",100),("www.yahoo.com","10.1.22.223",123),("www.cbs.com","10.1.22.222",1000),("www.example.com","10.1.22.222",500))
 
 //how to break up second part of list? 
 println(testlog.groupBy(x=>x._1).map( (y)=>y._2))
 //find numbytes from each server
// allPagesRDD.keyBy(getWebserver)
//  .map(k => (k.pageSizeBytes, 1))
//  .reduceByKey( (a,b) => (a._1 + b._1, a._2 + b._2)
//  .mapValues( v => (v._1 / v._2) )

 
 
 
 
 
  
  
}
 
//traits have no parameters and are used inside classes for composition of function tpye behavior
object newOrdering extends Ordering[String]{
   def compare(a:String, b:String)={b.length compareTo(a.length)}
 }
