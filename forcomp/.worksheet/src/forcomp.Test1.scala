package forcomp

object Test1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  println("Welcome to the Scala worksheet");$skip(41); val res$0 = 
  "asdfasdSDFSFsd".filter (x=>x.isUpper);System.out.println("""res0: String = """ + $show(res$0));$skip(31); val res$1 = 
  "asdfFsdf".map(x=>x.isUpper);System.out.println("""res1: scala.collection.immutable.IndexedSeq[Boolean] = """ + $show(res$1));$skip(37); val res$2 = 
  "asdfSDFSdf".groupBy(x=>x.isUpper)
 // "asdfasdfDFSDF".foldLeft(x=>x.isUpper)
  type Occurrences = List[(Char, Int)];System.out.println("""res2: scala.collection.immutable.Map[Boolean,String] = """ + $show(res$2));$skip(139); 
  val s = scala.collection.mutable.Set.empty[(Char,Int)];System.out.println("""s  : scala.collection.mutable.Set[(Char, Int)] = """ + $show(s ));$skip(19); 
  val s1 = ('a',1);System.out.println("""s1  : (Char, Int) = """ + $show(s1 ));$skip(8); val res$3 = 
  s+=s1;System.out.println("""res3: forcomp.Test1.s.type = """ + $show(res$3));$skip(587); 
  def foo(o:Occurrences):Unit={
    val listOfSets=new Array[scala.collection.mutable.Set[(Char,Int)]](o.length)
    var counter=0;
    for(i<-o){
     println ("pair:"+i.toString)
     val s = scala.collection.mutable.Set.empty[(Char,Int)]
     for(j<-1 to i._2){
      s+=Tuple2(i._1,j)
      println("adding:"+s.toString)
     }
     println("counter:"+counter);
     listOfSets(counter)=s
     listOfSets(1)=scala.collection.mutable.Set(('d',3),('e',3))
     counter+=1
     println("len:"+listOfSets.length)
     print("listOfSets:"+listOfSets(0)+","+listOfSets(1))
     
    }
  };System.out.println("""foo: (o: forcomp.Test1.Occurrences)Unit""");$skip(29); 
  foo(List(('a',2),('b',2)))}
                                                  
                                                  
                                                  
}
  
 