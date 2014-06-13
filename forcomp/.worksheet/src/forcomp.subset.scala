package forcomp
import common._

object subset {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(92); 
  println("Welcome to the Scala worksheet");$skip(43); 
  val a = List(('d'->1),('b'->2),('c'->3));System.out.println("""a  : List[(Char, Int)] = """ + $show(a ));$skip(30); val res$0 = 
  collection.SortedSet(a: _*);System.out.println("""res0: scala.collection.SortedSet[(Char, Int)] = """ + $show(res$0));$skip(729); val res$1 = 
  //http://stackoverflow.com/questions/6674156/convert-list-of-ints-to-a-sortedset-in-scala
  //no understand
  //  collection.SortedSet(myList: _*)
  //The way you used it, the compiler thinks you want to create a SortedSet[List[Int]]
  //not a SortedSet[Int]. That's why it complains about no implicit Ordering for List[Int].

  //Notice the repeated parameter of type A* in the signature of the method:

  //def apply [A] (elems: A*)(implicit ord: Ordering[A]): SortedSet[A]
  //To treat myList as a sequence argument of A use, the _* type annotation.
  //what is sequence argument? http://stackoverflow.com/questions/4176440/syntax-sugar-for-treating-seq-as-method-parameters
  
  
  
  List(1,2).map(Map(1->"aaa",2->"bbb"));System.out.println("""res1: List[String] = """ + $show(res$1));$skip(1442); 
  /*  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
   *
   *    List(
   *      List(),
   *      List(('a', 1)),
   *      List(('a', 2)),
   *      List(('b', 1)),
   *      List(('a', 1), ('b', 1)),
   *      List(('a', 2), ('b', 1)),
   *      List(('b', 2)),
   *      List(('a', 1), ('b', 2)),
   *      List(('a', 2), ('b', 2))
   * List(a,2)(a,1)(b,2),(b,1)
   *
   *((a,1),(a,1))
                                                  * ((a,1),(b,1))
                                                  * ((a,1),(b,2))
                                                  * ((a,2))
                                                  * ((a,2),(b,1))
                                                  * ((a,2),(b,2))
                                                  *((b,1),(a,2))
                                                  *(b,1),(b,1))
                                                  * ((b,2),(a,1))
                                                  * ((b,2),(a,2))
                                                  * ((b,2),(b,2))
                                                  //subtract the sets with generated elements. doesnt make sense why. Technically you cant have any words that
                                                  //have aa twice then a once would be aaa. So he removes those. Or bb + b. Not sure what his algorithm is
   *
   *
   */
   
   val a1 = List(('a', 2), ('b', 2));System.out.println("""a1  : List[(Char, Int)] = """ + $show(a1 ));$skip(155); 
   //iterate through all pairs in list
   def makeSubset1(list:List[(Char,Int)]):Unit={
      for(z<-list){
        println(z+" z._2:"+z._2)
       }
   };System.out.println("""makeSubset1: (list: List[(Char, Int)])Unit""");$skip(19); 
   makeSubset1(a1);$skip(145); 
   //make subset for a pair
   def makeSubset2(pair:(Char,Int)):Unit={
     for(i<-0 until pair._2){
        println((pair._1,i))
        }
   };System.out.println("""makeSubset2: (pair: (Char, Int))Unit""");$skip(24); 
   makeSubset2(('a',4));$skip(53); 
   
   //list to set
   val list = List(3,4,5,6,1,3);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(50); 
   val setList = collection.SortedSet( list: _* );System.out.println("""setList  : scala.collection.SortedSet[Int] = """ + $show(setList ));$skip(256); 
   //make subets for set of ints
   
   
   //make subsets for list of pairs
   
   
   def combine(in: List[Char]): Seq[String] ={
    for {
        len <- 1 to in.length
        combinations <- in combinations len
    } yield combinations.mkString
    };System.out.println("""combine: (in: List[Char])Seq[String]""");$skip(29); val res$2 = 
  combine(List('a','b','c'));System.out.println("""res2: Seq[String] = """ + $show(res$2));$skip(46); 
  
  val g: Option[String] = Some("asdfasdf");System.out.println("""g  : Option[String] = """ + $show(g ));$skip(32); 
  val g1: Option[String] = None;System.out.println("""g1  : Option[String] = """ + $show(g1 ));$skip(190); 
  //
  def power[T](set: Set[T]) = {
   var res = Set[Set[T]]()
   res ++= set.map(Set(_))

   for (i <- 1 until set.size)
      res = res.map(x => set.map(x + _)).flatten

   res+Set()
  };System.out.println("""power: [T](set: Set[T])scala.collection.immutable.Set[Set[T]]""");$skip(22); val res$3 = 
  power(Set(1,3,4,5));System.out.println("""res3: scala.collection.immutable.Set[Set[Int]] = """ + $show(res$3));$skip(254); 
  
  //double loop, big deal.... who cares if this is a double loop or nested function?
  def makeSets(list:List[Int]):Unit={
     for(i <- 0 until list.length){
       for(j<-0 until list.length){
        println((list(i),list(j)))
        }
     }
  };System.out.println("""makeSets: (list: List[Int])Unit""");$skip(26); 
  makeSets(List(1,2,3,4));$skip(179); 
  
  def makeSetsPair(list:List[(Char,Int)]):Unit={
  	 for(i <- 0 until list.length){
       for(j<-0 until list.length){
        println((list(i),list(j)))
        }
     }
  };System.out.println("""makeSetsPair: (list: List[(Char, Int)])Unit""");$skip(57); 
  
  makeSetsPair(List(('a',1),('a',2),('b',1),('b',2)))}
}
  case class User(id:Int, firstName:String, lastName:String, age:Int, gender:Option[String])

object UserRepository{
  private val users = Map(1->User(1,"John","Doe",100,Some("M")), 2->User(2,"Jane","Doe",10,None))

  def findById(id:Int):Option[User]={users.get(id)}
  def findAll=users.values
}
