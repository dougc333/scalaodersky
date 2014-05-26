package objsets

object Test extends Application{

  val t1 = new Tweet("a","tweet text for user a",0)
  val t2 = new Tweet("b","tweet text for user b",5)
  val t4 = new Tweet("a","second tweet text for user a",10)
  val t5 = new Tweet("b","second tweet text for user b",100)
  
  val ps1 = new EmptyPS()
  val ps2 = ps1.incl(t1)
  println("ps1"+ps1.toString)
  
  println("ps2:"+ps2.toString)
  val ps3 = ps2.incl(t2)
  println("ps3"+ps3.toString)
  println("ps3 contains t1"+ps3.contains(t1))
  println("ps3 contains t2"+ps3.contains(t2))
  println("test foreach---------------------------")
  ps3.foreach(println _)
  //
  val t3 = new Tweet("c","tweet text for user c",17)
  val ps4=new EmptyPS()
  val ps5 = ps4.incl(t3)
  val ps6= ps3.union(ps5)
  println("union: "+ps6.toString())
  println("----test remove-------------------------")
  val ps7 = ps3.remove(t3)
  println(ps7.toString())
   trait TestSet1 {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)
  }
  new TestSet1{
    println("----most retweeted------------------------")
    val set8 = (new EmptyPS).incl(t1).incl(t2).incl(t3).incl(t4).incl(t5)
    println("mostRetweeted:"+set8.mostRetweeted.toString)
  }

  new TestSet1{
    println("----filter test------------------------")
    println("set5:"+set5.toString())
    val set6 = set5.filter(tw=>tw.user=="a")
    println("set6:"+set6.toString())
    val set7 = (new EmptyPS).incl(t1).incl(t2).incl(t3).incl(t4).incl(t5)
    println("before filtering set7:"+set7.toString)
    println("++++++++++++++++++")
    println("after filtering set7:"+set7.filter(tw=>tw.user=="b"))
    
  }
  
}