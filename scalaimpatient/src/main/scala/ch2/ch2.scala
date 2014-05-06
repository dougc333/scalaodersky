class ch2{

  def p1signum(a:Int):Int={
    if(a>0) 1 
    else if(a<0) -1
    else 0
  }

  def p4Loop(a:Int):Unit={ 
    if(a==0){
      println(a)
    }else{
      println(a)
      p4Loop(a-1)
    }
  }

  def p4LoopFor(a:Int):Unit={
    for(i<-0 to a){
      println(a)
    }
  }

  def main(){ 
     //we should use a unit test, so much work to go to another directory
     println(p1signum(-100));
     println(p1signum(100));
     println(p1signum(0))
  }

}
