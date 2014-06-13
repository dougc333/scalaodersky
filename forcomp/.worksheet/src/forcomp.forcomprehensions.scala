package forcomp

object forcomprehensions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(87); 
  println("Welcome to the Scala worksheet");$skip(149); 

  //for comprehension
   //   for {i <- generator
   //  if guard
  //   j = assignment } yield result

  val mmm=Map(1->"one",2->"two",3->"three");System.out.println("""mmm  : scala.collection.immutable.Map[Int,String] = """ + $show(mmm ));$skip(80); 
  val testIt = for((key,value)<-mmm) yield println("key:"+key+ " value:"+value);System.out.println("""testIt  : scala.collection.immutable.Iterable[Unit] = """ + $show(testIt ));$skip(179); 

  //filtering in for comprehensions; note there is no else available. only an if
  val testItFilter = for((key,value)<-mmm if(key==2)) yield println("key:"+key+ " value:"+value);System.out.println("""testItFilter  : scala.collection.immutable.Iterable[Unit] = """ + $show(testItFilter ));$skip(195); 
  
  //nested loops in for comprehensions; how many can you nest?
  //combining 2 lists, sequences, 2 objects with iterators. Don't need to use the length of the object
  val iList = List(1,2,3);System.out.println("""iList  : List[Int] = """ + $show(iList ));$skip(26); 
  val jList = List(4,5,6);System.out.println("""jList  : List[Int] = """ + $show(jList ));$skip(50); 
  val combo = for(i<-iList; j<-jList) yield (i,j);System.out.println("""combo  : List[(Int, Int)] = """ + $show(combo ))}


}
