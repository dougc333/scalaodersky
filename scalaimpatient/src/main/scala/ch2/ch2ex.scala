object ch2ex extends Application{

  def p1signum(a:Int):Int={
    if(a>0) 1 
    else if(a<0) -1
    else 0
  }

  def p4Loop(a:Int):Unit={ 
    if(a==0){
      print(a)
    }else{
      print(a)
      p4Loop(a-1)
    }
  }

  def p4LoopFor(a:Int):Unit={
    for(i<-0 to a){
      print(i)
    }
  }
 
  def p4LoopForInc()={
    for(i)
  }
  //type is Unit, val is ()
  val a= {}

  println("asdf")
  println("test p1signum")
     println(p1signum(-100));
     println(p1signum(100));
     println(p1signum(0))
  println("test empty block")
     println(a)
  println("test p4loop")   
     println(p4Loop(3))
     println(p4LoopFor(3))
    
}