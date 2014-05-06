package testscalacode


object Test2{

  def matchStr(s:String):String= s match{
    case "a"=>"match a"
    case _=> "matching:" +s
  }
//  def a(arg:String):String={
//    case Nil=>"nil"
//    case List()=>"got list"
//    case Array()=>"got array"
//  }
  
  def testCase(arg:String):Unit=arg match{
    case "1" => println ("is 1")
    case "0" => {
      println ("is 0")
    }
  }
  
  def testCaseOnList[A](list:List[A]):Int =list match {
    case head::tail=>1 + testCaseOnList(tail)
    case Nil =>0    
  }
  
  def testCaseOnList1(list:List[String]):Unit=list match{
    case Nil => println("empty list")
    case head::tail => println(head);testCaseOnList1(tail)
  }
  
  
  //head is start at first element in list then rest of list. tail 
  //is rest of list not last element
  //:: cons operator
  def testObjectCase(list:List[Person]):Unit = list match{
    case Nil=>println("null list")
    case head::tail => println(head); testObjectCase(tail)
  }
  
  def testNil(list:List[Any]):Unit = list match{
    case Nil=>println("nil");
    case _ =>println ("not nil");
  }
  
  //have to count the parenthesis, left add one, right subtract one. The count sould be 0 for a balanced set. 
  //other algos dont work, looking from ends to balance like string
  def testMatchParen(list:List[Char]):Boolean = {    
    def matchParen(list:List[Char],count:Int):Boolean=  list match{
    case Nil=>{if (count==0)true else false}
    case head::tail => {
    	head match {
      	 case '(' => print("head:"+head+" "); println("incrementing counter:"+count);matchParen(tail,count+1) 
      	 case ')' => print("match )");if((count-1)<0) false; println("decrementing counter:"+count); matchParen(tail,count-1) 
      	 case _ => print("match nonparen:"+head); println("counter:"+count);matchParen(tail,count);
    	}
      }
    }
    matchParen(list,0)
  }
  
  
  //comboTree, building a tree with num branches equal to number of elements in list
  //stop at 0 and add 1 to count, if not <0 dont add to count
  def comboTree(amount:Int,list:List[Int]):Int ={
	def makeComboTree(amount:Int,list:List[Int]):Int={
	  println("amount:"+ amount+ "list:"+list)
	  if (amount==0) 1 
	  else if(amount<0) 0
	  else if(list.isEmpty) 0 
	  else makeComboTree(amount-list.head,list)+makeComboTree(amount,list.tail)
	}
	
	makeComboTree(amount,list)
	  
  }
  
  def testMatch2(list:List[Char]):Unit = list match{
    case Nil=> println("nil")
    case head::tail => head match {
      case '(' =>println("left paren match (")
      case ')' =>println("right paren match )");
      case _ => println("nonparen match")
    }
  }
  
  def mutableList(){
    val list= scala.collection.mutable.ListBuffer(1,2,3,4,5)
    list+=6
    println(list)
    //is this still mutable? 
    list-=4
    println(list)
    list-=100
    println(list)
  }
  
  
  class Person(name:String, age:Int){}
  
  //def countChange(money: Int, coins: List[Int]): Int={
    
    
    
  //}
  
  def sum(list:List[Int]):Int={
    def sumMe(list:List[Int],sum:Int):Int=list match{
      case Nil=>0
      case head::tail => head match{
        case _ =>list.head+sumMe(list.tail,sum+list.head)
      }	
    }
    sumMe(List(1,2,3,4),0)
  }
  
  def max(list:List[Int]):Int={
    def maxMe(list:List[Int],max:Int):Int= list match{
      case Nil=>max
      case head::tail=>head match{
        case _ => if(list.head>max) maxMe(list.tail,head) else maxMe(list.tail,max)
      }
    }
    maxMe(list,0)
  }
  
  /**
  def main(args:Array[String]):Unit={
//	println(sum(List(1,2,3,4,5)))
	println("max-------------------");
	println(max(List(1,2,3,4)))
    println("asdfasdf")
    var foo="asdfasdf"
    testCase("0")
    testCase("1")
    println(testCaseOnList(List(1,2,3,4,5)))
    testCaseOnList1(List("a","b","c","d"))
    val list = List(new Person("a",10),new Person("b",20), new Person("c",30))
    println("testNilList-------------")
    val list2 = List()
    if(list2.isEmpty){
      println("list2 empty")
    }
    //println(testNil(list2))
    //println(testNil(List("1","2")))
    //println("+++++++++++++++++++++++++")
    mutableList()
    //println("++++++++++++++++++++++++++ test paren matches")
    
    //println(testMatchParen(List('(','(','(','d','e','f')))
    //println(testMatchParen(List('a','b','c','d','e',')')))
    //println("++++++++++++++++++++++++++ combo tree")
    //println(comboTree(4,List(1,2)))
    //println("++++++++++++++++++++++++++ combo tree")
    //println(comboTree(300,List(5,10,20,50,100,200,500)))
    //println("++++++++++++++++++++++++++ combo tree")
    //println(comboTree(301,List(5,10,20,50,100,200,500)))
    //println("++++++++++++++++++++++++++ combo tree")
    //println(comboTree(300,List(500,5,50,100,20,200,10)))
  }
*/
}
