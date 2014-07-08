package lectureexamples


abstract class JSON1{
  case class JSeq(elems:List[JSON1]) extends JSON1
  case class JObj(bindings: Map[String,JSON1]) extends JSON1
  case class JNum(num:Double) extends JSON1
  case class JStr(str:String) extends JSON1
  case class JBool(b:Boolean) extends JSON1
  case class JNull() extends JSON1
}


object json{
  println("Welcome to the Scala worksheet")
 
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
  
  
  }
  val g: PartialFunction[List[Int],String]={
    case Nil=>"one"
    case x::rest=>
       rest match{
         case Nil=>"two"
     }
  }
  
  g.isDefinedAt(List(1,2,3))
  g(List(1,2,3))
  
  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }

  // All primes as a lazy sequence
  val primes = sieve(Stream.from(2))

  // Dumping the first five primes
  print(primes.take(5).toList) //
                                                  
//  val x= isPrime(3)
}