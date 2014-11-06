
import java.io.{FileWriter,File,PrintWriter}
import org.scalatest.FunSuite
import edu.stanford._
import edu.stanford.codingbat._



class ScalaArray1Suite extends FunSuite{
  val t = new ScalaArray1
  
//firstLast6({1, 2, 6}) == true
//firstLast6({6, 1, 2, 3}) == true
//firstLast6({13, 6, 1, 2, 3}) == false
//Scala array supports both length and size, is this true for all scala collection classes? Yes. Is there a correct style answer? 
 test("testing firstLast6") {
  assert(t.firstLast6(Array(1, 2, 6)) == true)
  assert(t.firstLast6(Array(6, 1, 2, 3)) == true)
  assert(t.firstLast6(Array(13, 6, 1, 2, 3)) == false)
}
	


//Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal. 

//sameFirstLast({1, 2, 3}) == false
//sameFirstLast({1, 2, 3, 1}) == true
//sameFirstLast({1, 2, 1}) == true
// seems like a dumb idiom array(size-1) for the index to get the last element or conversely a(0) to get the first element instead of a(1)
test("testing sameFirstLast") {
  assert(t.sameFirstLast(Array(1, 2, 3)) == false)
  assert(t.sameFirstLast(Array(1, 2, 3, 1)) == true)
  assert(t.sameFirstLast(Array(1, 2, 1)) == true)
}



//Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}. 
//makePi() == {3, 1, 4}
 test("testing makePi") {
  assert(t.makePi() == Array(3, 1, 4))
}


//Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. 
//Both arrays will be length 1 or more. 

//commonEnd({1, 2, 3}, {7, 3}) == true
//commonEnd({1, 2, 3}, {7, 3, 2}) == false
//commonEnd({1, 2, 3}, {1, 3}) == true
 test("testing commonEnd") {
  assert(t.commonEnd(Array(1, 2, 3), Array(7, 3)) == true)
  assert(t.commonEnd(Array(1, 2, 3), Array(7, 3, 2)) == false)
  assert(t.commonEnd(Array(1, 2, 3), Array(1, 3)) == true)
}


//Given an array of ints length 3, return the sum of all the elements. 

//sum3({1, 2, 3}) == 6
//sum3({5, 11, 2}) == 18
//sum3({7, 0, 0}) == 7

 test("testing sum3"){
  assert(t.sum3(Array(1, 2, 3)) == 6)
  assert(t.sum3(Array(5, 11, 2)) == 18)
  assert(t.sum3(Array(7, 0, 0)) == 7)
}


//Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}. 
//note to self: generalize this  problem to rotate n 
//rotateLeft3({1, 2, 3}) == {2, 3, 1}
//rotateLeft3({5, 11, 9}) == {11, 9, 5}
//rotateLeft3({7, 0, 0}) == {0, 0, 7}
 test("testing rotateLeft3") {
  assert(t.rotateLeft3(Array(1, 2, 3)) == Array(2, 3, 1))
  assert(t.rotateLeft3(Array(5, 11, 9)) == Array(11, 9, 5))
  assert(t.rotateLeft3(Array(7, 0, 0)) == Array(0, 0, 7))
}




//Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}. 

//reverse3({1, 2, 3}) == {3, 2, 1}
//reverse3({5, 11, 9}) == {9, 11, 5}
//reverse3({7, 0, 0}) == {0, 0, 7}
 test("testing reverse3") {
  assert(t.reverse3(Array(1, 2, 3)) == Array(3, 2, 1))
  assert(t.reverse3(Array(5, 11, 9)) == Array(9, 11, 5))
  assert(t.reverse3(Array(7, 0, 0)) == Array(0, 0, 7))
  
}


//Given an array of ints length 3, figure out which is larger between the first and last elements in the array, and set all the other elements to be that value. Return the changed array. 

//maxEnd3({1, 2, 3}) == {3, 3, 3}
//maxEnd3({11, 5, 9}) == {11, 11, 11}
//maxEnd3({2, 11, 3}) == {3, 3, 3
 test("testing maxEnd3") {
  assert(t.maxEnd3(Array(1, 2, 3)) == Array(3, 3, 3))
  assert(t.maxEnd3(Array(11, 5, 9)) == Array(11, 11, 11))
  assert(t.maxEnd3(Array(2, 11, 3)) == Array(3, 3, 3))
}


//Given an array of ints, return the sum of the first 2 elements in the array. 
//If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0. 

//sum2({1, 2, 3}) == 3
//sum2({1, 1}) == 2
//sum2({1, 1, 1, 1==) == 2
 test("testing sum2") {
  assert(t.sum2(Array(1, 2, 3)) == 3)
  assert(t.sum2(Array(1, 1)) == 2)
  assert(t.sum2(Array(1, 1, 1, 1)) == 2)
}
//Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements. 

//middleWay({1, 2, 3}, {4, 5, 6}) == {2, 5}
//middleWay({7, 7, 7}, {3, 8, 0}) == {7, 8}
//middleWay({5, 2, 9}, {1, 4, 5}) == {2, 4}
 test("testing middleWay") {
  assert( t.middleWay(Array(1, 2, 3), Array(4, 5, 6)) == Array(2, 5) )
//  assert(t.middleWay(Array(7, 7, 7), Array(3, 8, 0)) == Array(7, 8) )
//  assert(t.middleWay(Array(5, 2, 9), Array(1, 4, 5)) == Array(2, 4)))
}





//Given an array of ints, return a new array length 2 containing the first and last elements from the original array. 
//The original array will be length 1 or more. 

//makeEnds({1, 2, 3}) == {1, 3}
//makeEnds({1, 2, 3, 4}) == {1, 4}
//makeEnds({7, 4, 6, 2}) == {7, 2}
 test("testing makeEnds") {
  assert(t.makeEnds(Array(1, 2, 3)) == Array(1, 3))
  assert(t.makeEnds(Array(1, 2, 3, 4)) == Array(1, 4))
  assert(t.makeEnds(Array(7, 4, 6, 2)) == Array(7, 2))
}



//Given an int array length 2, return true if it contains a 2 or a 3. 

//has23({2, 5}) == true
//has23({4, 3}) == true
//has23({4, 5}) == false
 test("testing has23") {
  assert(t.has23(Array(2, 5)) == true)
  assert(t.has23(Array(4, 3)) == true)
  assert(t.has23(Array(4, 5)) == false)
}


//Given an int array length 2, return true if it does not contain a 2 or 3. 

//no23({4, 5}) == true
//no23({4, 2}) == false
//no23({3, 5}) == false
 test("testing no23") {
  assert(t.no23(Array(4, 5)) == true)
  assert(t.no23(Array(4, 2)) == false)
  assert(t.no23(Array(3, 5)) == false)
  
}


//Given an int array, return a new array with double the length where its last element is the same as the original array, 
//and all the other elements are 0. The original array will be length 1 or more. Note: by default, a new int array contains all 0's. 

//makeLast({4, 5, 6}) == {0, 0, 0, 0, 0, 6}
//makeLast({1, 2}) == {0, 0, 0, 2}
//makeLast({3}) == {0, 3}
 test("testing makeLast") {
  assert(t.makeLast(Array(4, 5, 6)) == Array(0, 0, 0, 0, 0, 6))
  assert(t.makeLast(Array(1, 2)) == Array(0, 0, 0, 2))
  assert(t.makeLast(Array(3)) == Array(0, 3))
}


//Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2. 

//double23({2, 2}) == true
//double23({3, 3}) == true
//double23({2, 3}) == false
 test("testing double23") {
  assert(t.double23(Array(2, 2)) == true)
  assert(t.double23(Array(3, 3)) == true)
  assert(t.double23(Array(2, 3)) == false)
  
}


//note to self. what does reduce right do?
//scala> val a=Array(1,2,3,4,5,6)
//a: Array[Int] = Array(1, 2, 3, 4, 5, 6)

//scala> a.reduceRight((elem,result)=> {println("elem:"+elem+" result:"+result);100})
//elem:5 result:6
//elem:4 result:100
//elem:3 result:100
//elem:2 result:100
//elem:1 result:100
//res58: Int = 100

//we can use the above to look at pairs of elements in the array by replacing the 100 with elem

//scala> a.reduceRight((elem,result)=> {println("elem:"+elem+" result:"+result);elem})
//elem:5 result:6
//elem:4 result:5
//elem:3 result:4
//elem:2 result:3
//elem:1 result:2
//res60: Int = 1


//Given an int array length 3, if there is a 2 in the array immediately followed by a 3, set the 3 element to 0. Return the changed array. 

//fix23({1, 2, 3}) == {1, 2, 0}
//fix23({2, 3, 5}) == {2, 0, 5}
//fix23({1, 2, 1}) == {1, 2, 1}
//can use binary ops to do this?  
 test("testing fix23") {
  assert(t.fix23(Array(1, 2, 3)) == Array(1, 2, 0))
  assert(t.fix23(Array(2, 3, 5)) == Array(2, 0, 5))
  assert(t.fix23(Array(1, 2, 1)) == Array(1, 2, 1))
}





//Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element. 

//start1({1, 2, 3}, {1, 3}) == 2
//start1({7, 2, 3}, {1}) == 1
//start1({1, 2}, {}) == 1
 test("testing start1") {
  assert(t.start1(Array(1, 2, 3), Array(1, 3)) == 2)
  assert(t.start1(Array(7, 2, 3), Array(1)) == 1)
  assert(t.start1(Array(1, 2), Array()) == 1)
}



//Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array. Return the array which has the largest sum. In event of a tie, return a. 

//biggerTwo({1, 2}, {3, 4}) == {3, 4}
//biggerTwo({3, 4}, {1, 2}) == {3, 4}
//biggerTwo({1, 1}, {1, 2}) == {1, 2}
 test("testing biggerTwo") {
  assert(t.biggerTwo(Array(1, 2), Array(3, 4)) == Array(3, 4))
  assert(t.biggerTwo(Array(3, 4), Array(1, 2)) == Array(3, 4))
  assert(t.biggerTwo(Array(1, 1), Array(1, 2)) == Array(1, 2))
}



//Given an array of ints of even length, return a new array length 2 containing the middle two elements 
//from the original array. The original array will be length 2 or more. 

//makeMiddle({1, 2, 3, 4}) == {2, 3}
//makeMiddle({7, 1, 2, 3, 4, 9}) == {2, 3}
//makeMiddle({1, 2}) == {1, 2}
 test("testing makeMiddle") {
  assert(t.makeMiddle(Array(1, 2, 3, 4)) == Array(2, 3))
  assert(t.makeMiddle(Array(7, 1, 2, 3, 4, 9)) == Array(2, 3))
  assert(t.makeMiddle(Array(1, 2)) == Array(1, 2))
}


//Given 2 int arrays, each length 2, return a new array length 4 containing all their elements. 

//plusTwo({1, 2}, {3, 4}) == {1, 2, 3, 4}
//plusTwo({4, 4}, {2, 2}) == {4, 4, 2, 2}
//plusTwo({9, 2}, {3, 4}) == {9, 2, 3, 4}
 test(" testing plusTwo") {
 assert(t.plusTwo(Array(1, 2), Array(3, 4)) == Array(1, 2, 3, 4))
 assert(t.plusTwo(Array(4, 4), Array(2, 2)) == Array(4, 4, 2, 2))
 assert(t.plusTwo(Array(9, 2), Array(3, 4)) == Array(9, 2, 3, 4))
}



//Given an array of ints, swap the first and last elements in the array. Return the modified array. The array length will be at least 1. 

//swapEnds({1, 2, 3, 4}) == {4, 2, 3, 1}
//swapEnds({1, 2, 3}) == {3, 2, 1}
//swapEnds({8, 6, 7, 9, 5}) == {5, 6, 7, 9, 8}
 test("testing swapEnds") {
  //val tmp = nums(0) note to self, we dont need a tmp cause of the drop/take api
   assert(t.swapEnds(Array(1, 2, 3, 4)) == Array(4, 2, 3, 1))
   assert(t.swapEnds(Array(1, 2, 3)) == Array(3, 2, 1))
   assert(t.swapEnds(Array(8, 6, 7, 9, 5)) == Array(5, 6, 7, 9, 8))
}


//Given an array of ints of odd length, return a new array length 3 containing the elements from the middle of the array. The array length will be at least 3. 

//midThree({1, 2, 3, 4, 5}) == {2, 3, 4}
//midThree({8, 6, 7, 5, 3, 0, 9}) == {7, 5, 3}
//midThree({1, 2, 3}) == {1, 2, 3}
//NOTE TO SELF, GENERALIZE FOR N COPIES
 test("testing midThree") {
  assert(t.midThree(Array(1, 2, 3, 4, 5)) == Array(2, 3, 4))
  assert(t.midThree(Array(8, 6, 7, 5, 3, 0, 9)) == Array(7, 5, 3))
  assert(t.midThree(Array(1, 2, 3)) == Array(1, 2, 3))
}



//Given an array of ints of odd length, look at the first, last, and middle values in the array and return the largest. 
//The array length will be a least 1. 

//maxTriple({1, 2, 3}) == 3
//maxTriple({1, 5, 3}) == 5
//maxTriple({5, 2, 3}) == 5
 test("testing maxTriple") {
  assert(t.maxTriple(Array(1, 2, 3)) == 3)
  assert(t.maxTriple(Array(1, 5, 3)) == 5)
  assert(t.maxTriple(Array(5, 2, 3)) == 5)
}


//Given an int array of any length, return a new array of its first 2 elements. If the array is smaller than length 2, use whatever elements are present. 

//frontPiece({1, 2, 3}) == {1, 2}
//frontPiece({1, 2}) == {1, 2}
//frontPiece({1}) == {1}
 test("testing frontPiece") {
  assert(t.frontPiece(Array(1, 2, 3)) == Array(1, 2))
  assert(t.frontPiece(Array(1, 2)) == Array(1, 2))
  assert(t.frontPiece(Array(1)) == Array(1))
}


//We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1. 
//Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array. 

//unlucky1({1, 3, 4, 5}) == true
//unlucky1({2, 1, 3, 4, 5}) == true
//unlucky1({1, 1, 1}) == false
 test("testing unlucky1") {
  assert(t.unlucky1(Array(1, 3, 4, 5)) == true)
  assert(t.unlucky1(Array(2, 1, 3, 4, 5)) == true)
  assert(t.unlucky1(Array(1, 1, 1)) == false)
}

//Given 2 int arrays, a and b, return a new array length 2 containing, as much as will fit, 
//the elements from a followed by the elements from b. The arrays may be any length, including 0, but there will be 2 or more elements available between the 2 arrays. 

//make2({4, 5}, {1, 2, 3}) == {4, 5}
//make2({4}, {1, 2, 3}) == {4, 1}
//make2({}, {1, 2}) == {1, 2}
 test("testing make2") {
  assert(t.make2(Array(4, 5), Array(1, 2, 3)) == Array(4, 5))
  assert(t.make2(Array(4), Array(1, 2, 3)) == Array(4, 1))
  assert(t.make2(Array(), Array(1, 2)) == Array(1, 2))
}


//Given 2 int arrays, a and b, of any length, return a new array with the first element of each array. 
//If either array is length 0, ignore that array. 

//front11({1, 2, 3}, {7, 9, 8}) == {1, 7}
//front11({1}, {2}) == {1, 2}
//front11({1, 7}, {}) == {1}
 test("testing front11") {
  assert(t.front11(Array(1, 2, 3), Array(7, 9, 8)) == Array(1, 7))
  assert(t.front11(Array(1), Array(2)) == Array(1, 2))
  assert(t.front11(Array(1, 7), Array()) == Array(1))
}

}
