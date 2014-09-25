package recfun
import common._

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
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
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
	  println("amount:"+ amount+ "list:"+list)
	  if (amount==0) 1 
	  else if(amount<0) 0
	  else if(list.isEmpty) 0 
	  else countChange(amount-list.head,list)+countChange(amount,list.tail)
   	}
	countChange(amount,list)
  }
    
}
