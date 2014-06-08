package forcomp

object Test1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  "asdfasdSDFSFsd".filter (x=>x.isUpper)          //> res0: String = SDFSF
  "asdfFsdf".map(x=>x.isUpper)                    //> res1: scala.collection.immutable.IndexedSeq[Boolean] = Vector(false, false, 
                                                  //| false, false, true, false, false, false)
  "asdfSDFSdf".groupBy(x=>x.isUpper)              //> res2: scala.collection.immutable.Map[Boolean,String] = Map(false -> asdfdf, 
                                                  //| true -> SDFS)
 // "asdfasdfDFSDF".foldLeft(x=>x.isUpper)
  type Occurrences = List[(Char, Int)]
  val s = scala.collection.mutable.Set.empty[(Char,Int)]
                                                  //> s  : scala.collection.mutable.Set[(Char, Int)] = Set()
  val s1 = ('a',1)                                //> s1  : (Char, Int) = (a,1)
  s+=s1                                           //> res3: forcomp.Test1.s.type = Set((a,1))
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
  }                                               //> foo: (o: forcomp.Test1.Occurrences)Unit
  foo(List(('a',2),('b',2)))                      //> pair:(a,2)
                                                  //| adding:Set((a,1))
                                                  //| adding:Set((a,1), (a,2))
                                                  //| counter:0
                                                  //| len:2
                                                  //| listOfSets:Set((a,1), (a,2)),Set((e,3), (d,3))pair:(b,2)
                                                  //| adding:Set((b,1))
                                                  //| adding:Set((b,1), (b,2))
                                                  //| counter:1
                                                  //| len:2
                                                  
                                                  
                                                  
}
  
 