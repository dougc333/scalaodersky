package edu.stanford

class ScalaRecursion1 {

  
//dont use if/then statements. Use match statements to break up base case and inductive step  
  
//Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. Compute the result recursively (without loops). 

//factorial(1) → 1
//factorial(2) → 2
//factorial(3) → 6
def factorial(n:Int):Int = n match{
  case 0 => 1
  case _ => n*factorial(n-1)
}




//We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication). 

//bunnyEars(0) → 0
//bunnyEars(1) → 2
//bunnyEars(2) → 4	
//base case requires a return of Int type,either pick 0 or 2. Base case can be 0, return 0 or 2 return 2. 
 def bunnyEars(bunnies:Int):Int= bunnies match {
   case 0 => 0
   case _ => 2 + bunnyEars(bunnies-1)
 }


//The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition. 
//The first two values in the sequence are 0 and 1 (essentially 2 base cases). 
//Each subsequent value is the sum of the previous two values, 
//so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. 
//Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence. 

//fibonacci(0) → 0
//fibonacci(1) → 1
//fibonacci(2) → 1
 def fibonacci(n:Int):Int = n match{ 
   case 0 => 0
   case 1 => 1
   case _ => fibonacci(n-1) + fibonacci(n-2)   
 }


//We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears. 
 //The even bunnies (2, 4, ..) 
 //we'll say have 3 ears, because they each have a raised foot. 
 //Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication). 

//bunnyEars2(0) → 0
//bunnyEars2(1) → 2
//bunnyEars2(2) → 5
 def bunnyEars2(bunnies:Int):Int = bunnies match{
   case 0 =>0
   case _ => if(bunnies%2==0) 3+bunnyEars2(bunnies-1) else 2+bunnyEars2(bunnies-1)
 }



//We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows. 
//assume adding one block per row
//triangle(0) → 1
//triangle(1) → 2
//triangle(2) → 3http://codingbat.com/prob/p135988
//dont understand how to build these....
def triangle(rows:Int):Int = rows match{
  case 0 => 1
  case 1=> 2
  case _ => triangle(rows-1)+1
}



//Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 

//sumDigits(126) → 9
//sumDigits(49) → 13
//sumDigits(12) → 3
def sumDigits(n:Int):Int = n match {
  case _ => if (n < 10) n else {n%10 + sumDigits(n/10)} 
}


//Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2. (no loops). 
//Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 
//removes the rightmost digit (126 / 10 is 12). 

//count7(717) → 2
//count7(7) → 1
//count7(123) → 0
def count7(n:Int):Int = n match{
  case _ => if (n<10 && n==7) 1 else if(n<10 && n!=7) 0 else if ((n%10)==7) 1+count7(n/10) else count7(n/10)
}

//Given a non-negative int n, compute recursively (no loops) 
//the count of the occurrences of 8 as a digit, 
//except that an 8 with another 8 immediately to its left counts double, 
//so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
//while divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 

//count8(8) → 1
//count8(818) → 2
//count8(8818) → 4
def count8(n:Int):Int = n match{
  case _ => if(n<10 && n==8) 1 else if(n<10 && n!=8) 0 else if(n/10 ==8) 1+count8(n/10) else count8(n/10)
}


//Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared). 

//powerN(3, 1) → 3
//powerN(3, 2) → 9
//powerN(3, 3) → 27
def powerN(base:Int, n:Int):Int= n match{
  case 0 => 1
  case _ => base* powerN(base,n-1)
}


//Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string. 

//countX("xxhixx") → 4
//countX("xhixhix") → 3
//countX("hi") → 0
def countX(str:String):Int= ???



//Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string. 

//countHi("xxhixx") → 1
//countHi("xhixhix") → 2
//countHi("hi") → 1
def countHi(str:String):Int = ???


//Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars. 

//changeXY("codex") → "codey"
//changeXY("xxhixx") → "yyhiyy"
//changeXY("xhixhix") → "yhiyhiy"
def changeXY(str:String):String = ???


//Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14". 

//changePi("xpix") → "x3.14x"
//changePi("pipi") → "3.143.14"
//changePi("pip") → "3.14p"
def changePi(str:String):String = ???


//Given a string, compute recursively a new string where all the 'x' chars have been removed. 

//noX("xaxb") → "ab"
//noX("abc") → "abc"
//noX("xx") → ""
def noX(str:String):String = ???


//Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

//array6({1, 6, 4}, 0) → true
//array6({1, 4}, 0) → false
//array6({6}, 0) → true
def array6(nums:Array[Int], index:Int):Boolean = ???


//Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

//array11({1, 2, 11}, 0) → 1
//array11({11, 11}, 0) → 2
//array11({1, 2, 3, 4}, 0) → 0
def array11(nums:Array[Int], index:Int):Int = ???


//Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

//array220({1, 2, 20}, 0) → true
//array220({3, 30}, 0) → true
//array220({3}, 0) → false
def array220(nums:Array[Int], index:Int):Boolean = ???


//Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*". 

//allStar("hello") → "h*e*l*l*o"
//allStar("abc") → "a*b*c"
//allStar("ab") → "a*b"
def allStar(str:String):String = ???



//Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*". 

//pairStar("hello") → "hel*lo"
//pairStar("xxyy") → "x*xy*y"
//pairStar("aaaa") → "a*a*a*a"
def pairStar(str:String):String = ???


//Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string. 

//endX("xxre") → "rexx"
//endX("xxhixx") → "hixxxx"
//endX("xhixhix") → "hihixxx"
def endX(str:String):String = ???

//We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string. 

//countPairs("axa") → 1
//countPairs("axax") → 2
//countPairs("axbx") → 1
def countPairs(str:String):Int = ???


//Count recursively the total number of "abc" and "aba" substrings that appear in the given string. 

//countAbc("abc") → 1
//countAbc("abcxxabc") → 2
//countAbc("abaxxaba") → 2
def countAbc(str:String):Int = ???


//Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap. 

//count11("11abc11") → 2
//count11("abc11x11x11") → 3
//count11("111") → 1
def count11(str:String):Int = ???

//Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza". 

//stringClean("yyzzza") → "yza"
//stringClean("abbbcdd") → "abcd"
//stringClean("Hello") → "Helo"
def stringClean(str:String):String = ???


//Given a string, compute recursively the number of times lowercase "hi" appears in the string, however do not count "hi" that have an 'x' immedately before them. 

//countHi2("ahixhi") → 1
//countHi2("ahibhi") → 2
//countHi2("xhixhi") → 0
def countHi2(str:String):Int = ???


//Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)". 

//parenBit("xyz(abc)123") → "(abc)"
//parenBit("x(hello)") → "(hello)"
//parenBit("(xy)1") → "(xy)"
def parenBit(str:String):String = ???


//Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them. 

//nestParen("(())") → true
//nestParen("((()))") → true
//nestParen("(((x))") → false
def nestParen(str:String):Boolean = ???


//Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping. 

//strCount("catcowcat", "cat") → 2
//strCount("catcowcat", "cow") → 1
//strCount("catcowcat", "dog") → 0
def strCount(str:String, sub:String):Int = ???


//Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative. 

//strCopies("catcowcat", "cat", 2) → true
//strCopies("catcowcat", "cow", 2) → false
//strCopies("catcowcat", "cow", 1) → true
def strCopies(str:String, sub:String, n:Int):Boolean = ???


//Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length. 

//strDist("catcowcat", "cat") → 9
//strDist("catcowcat", "cow") → 3
//strDist("cccatcowcatxx", "cat") → 9
def strDist(str:String, sub:String):Int = ???  
  
}