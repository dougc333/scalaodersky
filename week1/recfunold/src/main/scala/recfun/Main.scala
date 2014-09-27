package recfun
import common._
import java.io.File

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1, create a tuple2 and test with this
   * Java way
  def pascal(c: Int, r: Int): Int = {
     if(c<0 || r<0 || c>r) {
       return 0
     }else if(c==0 || c==r){
       return 1; //problem is the call if you get rid of the return 
     }
     pascal(c-1,r-1) + pascal(c,r-1)     
  }
  */
  
  //not supposed to use return in scala style 
  def pascal(c:Int,r:Int):Int={
    if ( c==0 || c==r) 1
    else
      pascal(c-1,r-1) + pascal(c,r-1)
  }

  
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance(chars: List[Char], counter: Int): Boolean = 
      chars match {
        case Nil => counter == 0
        case head :: tail => {
          head match {
            case '(' => balance(tail, counter + 1)
            case ')' => if (counter - 1 < 0) false else balance(tail, counter - 1)
            case _ => balance(tail, counter)
          }
        }
      }
    
    balance(chars, 0)
  }
  

  /**
   * Exercise 3
   */
  def countChange(amount: Int, list: List[Int]): Int = {
   	def countChange(amount:Int,list:List[Int]):Int={
	 // println("amount:"+ amount+ "list:"+list)
	  if (amount==0) 1 
	  else if(amount<0) 0
	  else if(list.isEmpty) 0 
	  else countChange(amount-list.head,list)+countChange(amount,list.tail)
   	}
	countChange(amount,list)
  }
  
  
  def subsets(){
    
  }
  
  def combination(){
    
  }
  
  /*
   * Additional practice, factorial
   */
  def factorial(n:Int):Int={
    if(n==0) 1
    else 
      n*factorial(n-1)
  }
  
  /* subset sum, permute, finding all subets of a string
   * ok this is cool but we dont see this much in real code
   * would be better to test iterating through collections doing test and accum
   */
   
  /*
   * recursive file/direcory listing
   * is this really scalish? 
   */
  def fileListing(startDir:File){
    if(startDir.isDirectory){
      val listFiles = startDir.listFiles()
      for(file<-listFiles){
        if(file.isDirectory()) fileListing(file)
      }
    }else{
      print("file:"+startDir)
    }
  }

  //does it make sense to do a foldLeft on filelisting? 
  def fileListingFoldLeft(file:File){
    
  }
  
  
 }
