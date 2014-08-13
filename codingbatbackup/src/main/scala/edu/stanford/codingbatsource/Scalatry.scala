
// try/catch block scala notes
// catch is case statements b/c partial function ? cant find the scaladoc on this
// catch is a pattern match vs. if then statements
// finally same as java
//
object Scalatry extends App{

 def main(args:Array[String]){
    try{
       foo()
       println("you should never see this!!!!")
    }catch{
      case e:Exception => println("exception "+e)
    } finally{
      println("finally always executes whether the catch block runs or not")
    }
 } 
 
  def foo(){
    throw new IllegalStateException("illegal state exception in foo")
  }
} 
