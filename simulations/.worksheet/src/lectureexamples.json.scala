package lectureexamples


abstract class JSON1{
  case class JSeq(elems:List[JSON1]) extends JSON1
  case class JObj(bindings: Map[String,JSON1]) extends JSON1
  case class JNum(num:Double) extends JSON1
  case class JStr(str:String) extends JSON1
  case class JBool(b:Boolean) extends JSON1
  case class JNull() extends JSON1
}


object json{;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(387); 
  println("Welcome to the Scala worksheet");$skip(605); val res$0 = 
 
 //this is kinda a hassle to have the namespace nested
  new JSON1{
    val data = JObj(Map(
      "firstName"->JStr("Jonh"),
      "lastName"->JStr("Smith"),
      "address"->JObj(Map(
        "streetaddress"->JStr("12 12 street"),
        "state"->JStr("NY"),
        "postalCode"->JNum(12345)
      )),
      "phoneNumbers"->JSeq(List(
        JObj(Map(
          "type"->JStr("home"), "number"->JStr("111-11-1111")
        )),
        JObj(Map(
          "type"->JStr("fax"), "number"->JStr("111-11-1111")
        ))
      ))
    ))
  
   //as the man says lets do something with the data
  
  
  };System.out.println("""res0: lectureexamples.JSON1{val data: this.JObj} = """ + $show(res$0));$skip(139); 
  val g: PartialFunction[List[Int],String]={
    case Nil=>"one"
    case x::rest=>
       rest match{
         case Nil=>"two"
     }
  };System.out.println("""g  : PartialFunction[List[Int],String] = """ + $show(g ));$skip(32); val res$1 = 
  
  g.isDefinedAt(List(1,2,3));System.out.println("""res1: Boolean = """ + $show(res$1));$skip(17); val res$2 = 
  g(List(1,2,3));System.out.println("""res2: String = """ + $show(res$2));$skip(105); 
  
  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  };System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(73); 

  // All primes as a lazy sequence
  val primes = sieve(Stream.from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(70); 

  // Dumping the first five primes
  print(primes.take(5).toList) //}
                                                  
//  val x= isPrime(3)
}
