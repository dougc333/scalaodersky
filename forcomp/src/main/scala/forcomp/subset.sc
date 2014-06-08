package forcomp
import common._

object subset {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val a = List(('d'->1),('b'->2),('c'->3))        //> a  : List[(Char, Int)] = List((d,1), (b,2), (c,3))
  collection.SortedSet(a: _*)                     //> res0: scala.collection.SortedSet[(Char, Int)] = TreeSet((b,2), (c,3), (d,1))
                                                  //| 
  //http://stackoverflow.com/questions/6674156/convert-list-of-ints-to-a-sortedset-in-scala
  //no understand
  //  collection.SortedSet(myList: _*)
  //The way you used it, the compiler thinks you want to create a SortedSet[List[Int]]
  //not a SortedSet[Int]. That's why it complains about no implicit Ordering for List[Int].

  //Notice the repeated parameter of type A* in the signature of the method:

  //def apply [A] (elems: A*)(implicit ord: Ordering[A]): SortedSet[A]
  //To treat myList as a sequence argument of A use, the _* type annotation.
  //what is sequence argument? http://stackoverflow.com/questions/4176440/syntax-sugar-for-treating-seq-as-method-parameters
  
  
  
  List(1,2).map(Map(1->"aaa",2->"bbb"))           //> res1: List[String] = List(aaa, bbb)
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
                                                  | ((a,1),(b,1))
                                                  | ((a,1),(b,2))
                                                  | ((a,2))
                                                  | ((a,2),(b,1))
                                                  | ((a,2),(b,2))
                                                  | ((b,1),(a,1))
                                                  | ((b,1),(a,2))
                                                  | ((b,1),(b,1))
                                                  | ((b,2),(a,1))
                                                  | ((b,2),(a,2))
                                                  | ((b,2),(b,2))
                                                  //subtract the sets with generated elements. doesnt make sense why. Technically you cant have any words that
                                                  //have aa twice then a once would be aaa. So he removes those. Or bb + b. Not sure what his algorithm is
   *
   *
   */
   
   val a1 = List(('a', 2), ('b', 2))              //> a1  : List[(Char, Int)] = List((a,2), (b,2))
   //iterate through all pairs in list
   def makeSubset1(list:List[(Char,Int)]):Unit={
      for(z<-list){
        println(z+" z._2:"+z._2)
       }
   }                                              //> makeSubset1: (list: List[(Char, Int)])Unit
   makeSubset1(a1)                                //> (a,2) z._2:2
                                                  //| (b,2) z._2:2
   //make subset for a pair
   def makeSubset2(pair:(Char,Int)):Unit={
     for(i<-0 until pair._2){
        println((pair._1,i))
        }
   }                                              //> makeSubset2: (pair: (Char, Int))Unit
   makeSubset2(('a',4))                           //> (a,0)
                                                  //| (a,1)
                                                  //| (a,2)
                                                  //| (a,3)
   
   //list to set
   val list = List(3,4,5,6,1,3)                   //> list  : List[Int] = List(3, 4, 5, 6, 1, 3)
   val setList = collection.SortedSet( list: _* ) //> setList  : scala.collection.SortedSet[Int] = TreeSet(1, 3, 4, 5, 6)
   //make subets for set of ints
   
   
   //make subsets for list of pairs
   
   
   def combine(in: List[Char]): Seq[String] ={
    for {
        len <- 1 to in.length
        combinations <- in combinations len
    } yield combinations.mkString
    }                                             //> combine: (in: List[Char])Seq[String]
  combine(List('a','b','c'))                      //> res2: Seq[String] = Vector(a, b, c, ab, ac, bc, abc)
  
  val g: Option[String] = Some("asdfasdf")        //> g  : Option[String] = Some(asdfasdf)
  val g1: Option[String] = None                   //> g1  : Option[String] = None
  //
  def power[T](set: Set[T]) = {
   var res = Set[Set[T]]()
   res ++= set.map(Set(_))

   for (i <- 1 until set.size)
      res = res.map(x => set.map(x + _)).flatten

   res+Set()
  }                                               //> power: [T](set: Set[T])scala.collection.immutable.Set[Set[T]]
  power(Set(1,3,4,5))                             //> res3: scala.collection.immutable.Set[Set[Int]] = Set(Set(), Set(5, 3, 1), S
                                                  //| et(3, 1), Set(5, 4), Set(1, 4, 5, 3), Set(4), Set(5, 1), Set(1, 4, 5), Set(
                                                  //| 5), Set(4, 5, 3), Set(3, 4), Set(3), Set(1, 4), Set(5, 3), Set(1), Set(1, 4
                                                  //| , 3))
  
  //double loop, big deal.... who cares if this is a double loop or nested function?
  def makeSets(list:List[Int]):Unit={
     for(i <- 0 until list.length){
       for(j<-0 until list.length){
        println((list(i),list(j)))
        }
     }
  }                                               //> makeSets: (list: List[Int])Unit
  makeSets(List(1,2,3,4))                         //> (1,1)
                                                  //| (1,2)
                                                  //| (1,3)
                                                  //| (1,4)
                                                  //| (2,1)
                                                  //| (2,2)
                                                  //| (2,3)
                                                  //| (2,4)
                                                  //| (3,1)
                                                  //| (3,2)
                                                  //| (3,3)
                                                  //| (3,4)
                                                  //| (4,1)
                                                  //| (4,2)
                                                  //| (4,3)
                                                  //| (4,4)
  
  def makeSetsPair(list:List[(Char,Int)]):Unit={
  	 for(i <- 0 until list.length){
       for(j<-0 until list.length){
        println((list(i),list(j)))
        }
     }
  }                                               //> makeSetsPair: (list: List[(Char, Int)])Unit
  
  makeSetsPair(List(('a',1),('a',2),('b',1),('b',2)))
                                                  //> ((a,1),(a,1))
                                                  //| ((a,1),(a,2))
                                                  //| ((a,1),(b,1))
                                                  //| ((a,1),(b,2))
                                                  //| ((a,2),(a,1))
                                                  //| ((a,2),(a,2))
                                                  //| ((a,2),(b,1))
                                                  //| ((a,2),(b,2))
                                                  //| ((b,1),(a,1))
                                                  //| ((b,1),(a,2))
                                                  //| ((b,1),(b,1))
                                                  //| ((b,1),(b,2))
                                                  //| ((b,2),(a,1))
                                                  //| ((b,2),(a,2))
                                                  //| ((b,2),(b,1))
                                                  //| ((b,2),(b,2))
}
  case class User(id:Int, firstName:String, lastName:String, age:Int, gender:Option[String])

object UserRepository{
  private val users = Map(1->User(1,"John","Doe",100,Some("M")), 2->User(2,"Jane","Doe",10,None))

  def findById(id:Int):Option[User]={users.get(id)}
  def findAll=users.values
}