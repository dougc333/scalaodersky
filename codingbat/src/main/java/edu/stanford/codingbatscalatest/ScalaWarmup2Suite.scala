package edu.stanford.codingbatscalatest

class ScalaWarmup2Suite extends FunSuite{
  val t = new ScalaWarmup2
  
  test("ScalaWarmup2Test"){
    println("testing ScalaWarmup2.....")
  }
   
  
  
  //Given a string and a non-negative int n, return a larger string that is n copies of the original string. 

  //stringTimes("Hi", 2) → "HiHi"
  //stringTimes("Hi", 3) → "HiHiHi"
  //stringTimes("Hi", 1) → "Hi"
  test(" test stringTimes"){
   assert(t.stringTimes("Hi", 2) == "HiHi")  
   assert(t.stringTimes("Hi", 3) == "HiHiHi")
   assert(t.stringTimes("Hi", 1)== "Hi")
  }


//Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front; 

//frontTimes("Chocolate", 2) → "ChoCho"
//frontTimes("Chocolate", 3) → "ChoChoCho"
//frontTimes("Abc", 3) → "AbcAbcAbc"
  test("test frontTimes") {
    assert(t.frontTimes("Chocolate", 2)== "ChoCho")
    assert(t.frontTimes("Chocolate", 3) == "ChoChoCho")
    assert(t.frontTimes("Abc", 3) == "AbcAbcAbc")
  }



//Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx". 

//countXX("abcxx") → 1
//countXX("xxx") → 2
//countXX("xxxx") → 3
 test("testing countXX") {
   assert(t.countXX("abcxx") == 1)
   assert(t.countXX("xxx") == 2)
   assert(t.countXX("xxxx") == 3)
 }



//Given a string, return true if the first instance of "x" in the string is immediately followed by another "x". 

//doubleX("axxbb") → true
//doubleX("axaxax") → false
//doubleX("xxxxx") → true
 test("testing doubleX"){
  assert(t.doubleX("axxbb") == true)
  assert(t.doubleX("axaxax") == false)
  assert(t.doubleX("xxxxx") == true)
}


//Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo". 

//stringBits("Hello") → "Hlo"
//stringBits("Hi") → "H"
//stringBits("Heeololeo") → "Hello"

 test("testing stringBits"){
   assert(t.stringBits("Hello") == "Hlo")
   assert(t.stringBits("Hi") == "H")
   assert(t.stringBits("Heeololeo") == "Hello")
 }


//Given a non-empty string like "Code" return a string like "CCoCodCode". 

//stringSplosion("Code") → "CCoCodCode"
//stringSplosion("abc") → "aababc"
//stringSplosion("ab") → "aab"
 test("testing stringSplosion") {
   assert(t.stringSplosion("Code") == "CCoCodCode")
   assert(t.stringSplosion("abc") == "aababc")
   assert(t.stringSplosion("ab") == "aab")
 }

//Given a string, return the count of the number of times that a substring length 2 appears in the string and also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring). 

//last2("hixxhi") → 1
//last2("xaxxaxaxx") → 1
//last2("axxxaaxx") → 2
 test( "testing last2") {
   assert(t.last2("hixxhi") == 1)
   assert(t.last2("xaxxaxaxx") == 1)
   assert(t.last2("axxxaaxx") == 2)
 }


//Given an array of ints, return the number of 9's in the array. 

//arrayCount9({1, 2, 9}) → 1
//arrayCount9({1, 9, 9}) → 2
//arrayCount9({1, 9, 9, 3, 9}) → 3
 test("testing arrayCount9") {
   assert(t.arrayCount9(Array(1, 2, 9)) == 1)
   assert(t.arrayCount9(Array(1, 9, 9)) == 2)
   assert(t.arrayCount9(Array(1, 9, 9, 3, 9)) == 3)
 }


//Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.

//arrayFront9({1, 2, 9, 3, 4}) → true
//arrayFront9({1, 2, 3, 4, 9}) → false
//arrayFront9({1, 2, 3, 4, 5}) → false
 test("testing arrayFront9") {
  assert(t.arrayFront9(Array(1, 2, 9, 3, 4)) == true)
  assert(t.arrayFront9(Array(1, 2, 3, 4, 9)) == false)
  assert(t.arrayFront9(Array(1, 2, 3, 4, 5)) == false)
}

//Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere. 

//array123({1, 1, 2, 3, 1}) → true
//array123({1, 1, 2, 4, 1}) → false
//array123({1, 1, 2, 1, 2, 3}) → true
 test("testing array123") {
   assert(t.array123(Array(1, 1, 2, 3, 1)) == true)
   assert(t.array123(Array(1, 1, 2, 4, 1)) == false)
   assert(t.array123(Array(1, 1, 2, 1, 2, 3)) == true)
 }


//Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings. 

//stringMatch("xxcaazz", "xxbaaz") → 3
//stringMatch("abc", "abc") → 2
//stringMatch("abc", "axc") → 0
 test("testing stringMatch"){
   assert(t.stringMatch("xxcaazz", "xxbaaz") == 3)
   assert(t.stringMatch("abc", "abc") == 2)
   assert(t.stringMatch("abc", "axc") == 0)
 
 }


//note to self: make more of these types of problems where you remove elements
//to test reduce funcctions
//Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed. 

//stringX("xxHxix") → "xHix"
//stringX("abxxxcd") → "abcd"
//stringX("xabxxxcdx") → "xabcdx"
 test("testing stringX"){
   assert(t.stringX("xxHxix") == "xHix")
   assert(t.stringX("abxxxcd") == "abcd")
   assert(t.stringX("xabxxxcdx") == "xabcdx")
 }

//Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 

//altPairs("kitten") → "kien"
//altPairs("Chocolate") → "Chole"
 test("testing altPairs"){
    assert(t.altPairs("kitten") == "kien")
    assert(t.altPairs("Chocolate") == "Chole")
 }



//Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap. 

//stringYak("yakpak") → "pak"
//stringYak("pakyak") → "pak"
//stringYak("yak123ya") → "123ya"

//common to use a regex for an extractor then  separate the string into a match and not match
//parts from scaladocs: http://www.scala-lang.org/api/current/index.html#scala.util.matching.Regex
//add more problems with start match end in groups
  test("test stringYak"){
    assert(t.stringYak("yakpak") == "pak")
    assert(t.stringYak("pakyak") == "pak")
    assert(t.stringYak("yak123ya") == "123ya")
  } 


//Given an array of ints, return the number of times that two 6's are next to each other 
//in the array. Also count instances where the second "6" is actually a 7. 

//array667({6, 6, 2}) → 1
//array667({6, 6, 2, 6}) → 1
//array667({6, 7, 2, 6}) → 1
  test("testing array667"){
    assert(t.array667(Array(6, 6, 2)) == 1)
    assert(t.array667(Array(6, 6, 2, 6)) == 1)
    assert(t.array667(Array(6, 7, 2, 6)) == 1)
  }



//Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. Return true if the array does not contain any triples. 

//noTriples({1, 1, 2, 2, 1}) → true
//noTriples({1, 1, 2, 2, 2, 1}) → false
//noTriples({1, 1, 1, 2, 2, 2, 1}) → false
 test("testing noTriples"){
   assert(t.noTriples(Array(1, 1, 2, 2, 1)) == true)
   assert(t.noTriples(Array(1, 1, 2, 2, 2, 1)) == false)
   assert(t.noTriples(Array(1, 1, 1, 2, 2, 2, 1)) == false)
 }



//Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, 
//followed by the value plus 5, followed by the value minus 1. 
//Additionally the 271 counts even if the "1" differs by 2 or less from the correct value. 

//has271({1, 2, 7, 1}) → true
//has271({1, 2, 8, 1}) → false
//has271({2, 7, 1}) → true
 test("testing has271"){
   assert(t.has271(Array(1, 2, 7, 1)) == true)
   assert(t.has271(Array(1, 2, 8, 1)) == false)
   assert(t.has271(Array(2, 7, 1)) == true)
 }

//NOTE TO SELF> Using these tuples or subarrays in collections is very powerful technique as we see from these examples because
//it eliminates the need to create short for loops to test these short data structures. You can type them inline instead of multiple lines 
//for testing


//given an array of ints compute the partial sums of an arbitrary length of a list of ints. 
//a partial sum is taking the sum of the first element then the sum of the first and second element then of the first 3 elements, etc...

//List(1,2,3) -> List(1,3,5)
//List(1,2,3,4)->List(1,3,5,10)

//scan always starts at start? 
 test("testing partialSum"){
   assert(t.partialSum(List(1,2,3))==List(1,3,5))
  }
  
  
}