package edu.stanford

import scala.collection.immutable.StringOps

object ScalaWarmup2 {

//Given a string and a non-negative int n, return a larger string that is n copies of the original string. 

//stringTimes("Hi", 2) → "HiHi"
//stringTimes("Hi", 3) → "HiHiHi"
//stringTimes("Hi", 1) → "Hi"
def stringTimes(str:String, n:Int):String ={
  str*(n)
}


//Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front; 

//frontTimes("Chocolate", 2) → "ChoCho"
//frontTimes("Chocolate", 3) → "ChoChoCho"
//frontTimes("Abc", 3) → "AbcAbcAbc"
def frontTimes(str:String, n:Int):String ={
  def testMe:StringOps = new StringOps(str)
  if(testMe.length>=3){
     testMe.take(3)*(n)
  }
  else
    testMe*(n)
}



//Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx". 

//countXX("abcxx") → 1
//countXX("xxx") → 2
//countXX("xxxx") → 3
def countXX(str:String):Int ={
  new StringOps(str).sliding(2).count(x=>x=="xx")
}



//Given a string, return true if the first instance of "x" in the string is immediately followed by another "x". 

//doubleX("axxbb") → true
//doubleX("axaxax") → false
//doubleX("xxxxx") → true
def doubleX(str:String):Boolean ={
  val testMe:Seq[Char]=str //can probably remove this and should be able to infer seq from splitAt method which doesnt exist in StringOps
  testMe.splitAt(str.indexOf('x'))._2.startsWith("xx")
}


//Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo". 

//stringBits("Hello") → "Hlo"
//stringBits("Hi") → "H"
//stringBits("Heeololeo") → "Hello"

def stringBits(str:String):String ={
  str.indices.map(x=>x%2==0).zip(str).filter(x=>x._1==true).map(x=>x._2).mkString
}


//Given a non-empty string like "Code" return a string like "CCoCodCode". 

//stringSplosion("Code") → "CCoCodCode"
//stringSplosion("abc") → "aababc"
//stringSplosion("ab") → "aab"
def stringSplosion(str:String):String ={
  val sb = new StringBuffer()
  for(i<-0 to str.length){
      sb.append(str.substring(0,i))
  }
  sb.toString()
}






//Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring). 

//last2("hixxhi") → 1
//last2("xaxxaxaxx") → 1
//last2("axxxaaxx") → 2
def last2(str:String):Int =  {
  //pattern match on last 2 chars in string
  str.sliding(2).count(x=>x==str.takeRight(2))
}


//Given an array of ints, return the number of 9's in the array. 

//arrayCount9({1, 2, 9}) → 1
//arrayCount9({1, 9, 9}) → 2
//arrayCount9({1, 9, 9, 3, 9}) → 3
def arrayCount9(nums:Array[Int]):Int ={
  nums.count(_==9)
}


//Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.

//arrayFront9({1, 2, 9, 3, 4}) → true
//arrayFront9({1, 2, 3, 4, 9}) → false
//arrayFront9({1, 2, 3, 4, 5}) → false
def arrayFront9(nums:Array[Int]):Boolean= {
  nums.take(4).contains(9)
}

//Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere. 

//array123({1, 1, 2, 3, 1}) → true
//array123({1, 1, 2, 4, 1}) → false
//array123({1, 1, 2, 1, 2, 3}) → true
def array123(nums:Array[Int]):Boolean ={
  nums.containsSlice(Array(1,2,3))
}


//Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings. 

//stringMatch("xxcaazz", "xxbaaz") → 3
//stringMatch("abc", "abc") → 2
//stringMatch("abc", "axc") → 0
def stringMatch(a:String, b:String):Int ={
   val sets = a.sliding(2)
}


//note to self: make more of these types of problems where you remove elements
//to test reduce funcctions
//Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed. 

//stringX("xxHxix") → "xHix"
//stringX("abxxxcd") → "abcd"
//stringX("xabxxxcdx") → "xabcdx"
public String stringX(String str) ={
  val strSeq:Seq[Char]  = str
  
}

Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 

altPairs("kitten") → "kien"
altPairs("Chocolate") → "Chole"
public String altPairs(String str) {
	  
}



Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap. 

stringYak("yakpak") → "pak"
stringYak("pakyak") → "pak"
stringYak("yak123ya") → "123ya"

public String stringYak(String str) {
	  
}


Given an array of ints, return the number of times that two 6's are next to each other in the array. Also count instances where the second "6" is actually a 7. 

array667({6, 6, 2}) → 1
array667({6, 6, 2, 6}) → 1
array667({6, 7, 2, 6}) → 1
public int array667(int[] nums) {
	  
}



Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples. 

noTriples({1, 1, 2, 2, 1}) → true
noTriples({1, 1, 2, 2, 2, 1}) → false
noTriples({1, 1, 1, 2, 2, 2, 1}) → false
public boolean noTriples(int[] nums) {
	  
}



//Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value. 

//has271({1, 2, 7, 1}) → true
//has271({1, 2, 8, 1}) → false
//has271({2, 7, 1}) → true
def has271(nums:Array[Int]):Boolean {
  //do with scan
  //good problem
  
}


//given an array of ints compute the partial sums of an arbitrary length of a list of ints. 
//a partial sum is taking the sum of the first element then the sum of the first and second element then of the first 3 elements, etc...

//List(1,2,3) -> List(1,3,5)
//List(1,2,3,4)->List(1,3,5,10)

def partialSum(a:List[Int]):List[Int]={
   a.scan(0)(_+_)
}







  
}