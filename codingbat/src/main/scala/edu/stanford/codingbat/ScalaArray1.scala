package edu.stanford.codingbat


//note to self: these exercises taught me:
//1) concatenate arrays using ++ for arrays vs ::: for list
//size and length are same for all scala collection classes, array is collection class unlike java
//access array elements using (). didn't use apply cause it is too much typing
//use split for rotating arrays, don't do a recursive function w/accumulator
//using vals to hold intermediate state
//dont need tmp value to hold swap b/c take/drop interface
class ScalaArray1 {
	
//Given an array of ints, return true if 6 appears as either the first or last element in the array. The array will be length 1 or more. 

//firstLast6({1, 2, 6}) → true
//firstLast6({6, 1, 2, 3}) → true
//firstLast6({13, 6, 1, 2, 3}) → false
  //Scala array supports both length and size, is this true for all scala collection classes? Yes. Is there a correct style answer? 
def firstLast6(nums:Array[Int]):Boolean = {
	if(nums(0)==6 || nums(nums.size-1)==6) true
	else
	 false
}
	


//Given an array of ints, return true if the array is length 1 or more, and the first element and the last element are equal. 

//sameFirstLast({1, 2, 3}) → false
//sameFirstLast({1, 2, 3, 1}) → true
//sameFirstLast({1, 2, 1}) → true
// seems like a dumb idiom array(size-1) for the index to get the last element or conversely a(0) to get the first element instead of a(1)
def sameFirstLast(nums:Array[Int]):Boolean = {
  if( nums.length > 1 && nums(nums.size-1)==nums(0) ) true 
  else 
    false
}



//Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}. 
//makePi() → {3, 1, 4}
def makePi():Array[Int] ={
  Array(3,1,4) 
}


//Given 2 arrays of ints, a and b, return true if they have the same first element or they have the same last element. 
//Both arrays will be length 1 or more. 

//commonEnd({1, 2, 3}, {7, 3}) → true
//commonEnd({1, 2, 3}, {7, 3, 2}) → false
//commonEnd({1, 2, 3}, {1, 3}) → true
def commonEnd(a:Array[Int], b:Array[Int]):Boolean= {
  if(a(0)==b(0) || a(a.size-1)==b(b.size-1)) true
  else false
}


//Given an array of ints length 3, return the sum of all the elements. 

//sum3({1, 2, 3}) → 6
//sum3({5, 11, 2}) → 18
//sum3({7, 0, 0}) → 7

def sum3(nums:Array[Int]):Int ={
  nums.foldLeft(0)( _ + _)
}


//Given an array of ints length 3, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}. 
//note to self: generalize this  problem to rotate n 
//rotateLeft3({1, 2, 3}) → {2, 3, 1}
//rotateLeft3({5, 11, 9}) → {11, 9, 5}
//rotateLeft3({7, 0, 0}) → {0, 0, 7}
def rotateLeft3(nums:Array[Int]):Array[Int]= {
  val splitArray = nums.splitAt(2)
  splitArray._2++splitArray._1
}

//should be doable w/foldleft also
//recursion using accumulator as empty array start at index and keep on accumulating till empty
//this is dumb...from http://aperiodic.net/phil/scala/s-99/p19.scala
def rotate(n:Int, nums:Array[Int]):Array[Int] = {
  val nBounded = if(nums.isEmpty) 0 else (n % nums.size)
  if(nBounded < 0) rotate(nBounded+nums.size, nums)
  else (nums drop nBounded) ++ (nums take nBounded)
}

//first do no return, do list split and concatenate
//(1,2,3,4,5) rotate left 1: 2,3,4,5,1
//(1,2,3,4,5) rotate left 2: 3,4,5,1,2
//(1,2,3,4,5) rotate left 3: 4,5,1,2,3
def rotateList(n:Int, arr:Array[Int]):Array[Int] =  {
  val splitArray = arr.splitAt(n)
  splitArray._2++splitArray._1
}

//Given an array of ints length 3, return a new array with the elements in reverse order, so {1, 2, 3} becomes {3, 2, 1}. 

//reverse3({1, 2, 3}) → {3, 2, 1}
//reverse3({5, 11, 9}) → {9, 11, 5}
//reverse3({7, 0, 0}) → {0, 0, 7}
def reverse3(nums:Array[Int]):Array[Int] ={
  nums.reverse
}


//Given an array of ints length 3, figure out which is larger 
//between the first and last elements in the array, 
//and set all the other elements to be that value. 
//Return the changed array. 

//maxEnd3({1, 2, 3}) → {3, 3, 3}
//maxEnd3({11, 5, 9}) → {11, 11, 11}
//maxEnd3({2, 11, 3}) → {3, 3, 3}
def maxEnd3(nums:Array[Int]):Array[Int]= {
  if(nums(nums.size-1)>nums(0)) nums.map(x=>nums(nums.size-1)) 
  else 
    nums.map(x=>nums(0))
}

//maxEnd3({1, 2, 3}) → {3, 3, 3}
//maxEnd3({11, 5, 9}) → {11, 11, 11}
//maxEnd3({2, 11, 3}) → {3, 3, 3}
def maxEnd3Alt(nums:Array[Int]):Array[Int]= {
 val largest = List(nums(0),nums(nums.size-1)).max
 nums.map(x=>largest)
}

//Given an array of ints, return the sum of the first 2 elements in the array. 
//If the array length is less than 2, just sum up the elements that exist, returning 0 if the array is length 0. 

//sum2({1, 2, 3}) → 3
//sum2({1, 1}) → 2
//sum2({1, 1, 1, 1}) → 2
def sum2(nums:Array[Int]):Int ={
  if(nums.size<=2) nums.sum
  else
    nums(0)+nums(1)
}
//Given 2 int arrays, a and b, each length 3, return a new array length 2 containing their middle elements. 

//middleWay({1, 2, 3}, {4, 5, 6}) → {2, 5}
//middleWay({7, 7, 7}, {3, 8, 0}) → {7, 8}
//middleWay({5, 2, 9}, {1, 4, 5}) → {2, 4}
def middleWay(a:Array[Int], b:Array[Int]):Array[Int] ={
  Array(a(1),b(1))
}





//Given an array of ints, return a new array length 2 containing the first and last elements from the original array. 
//The original array will be length 1 or more. 

//makeEnds({1, 2, 3}) → {1, 3}
//makeEnds({1, 2, 3, 4}) → {1, 4}
//makeEnds({7, 4, 6, 2}) → {7, 2}
def makeEnds(nums:Array[Int]):Array[Int]= {
  Array(nums(0), nums(nums.size-1))
}



//Given an int array length 2, return true if it contains a 2 or a 3. 

//has23({2, 5}) → true
//has23({4, 3}) → true
//has23({4, 5}) → false
def has23(nums:Array[Int]):Boolean ={
  nums.contains(2) || nums.contains(3)
}


//Given an int array length 2, return true if it does not contain a 2 or 3. 

//no23({4, 5}) → true
//no23({4, 2}) → false
//no23({3, 5}) → false
def no23(num:Array[Int]):Boolean ={
  num.contains(2) && num.contains(3)
}


//Given an int array, return a new array with double the length where its last element 
//is the same as the original array, 
//and all the other elements are 0. The original array will be length 1 or more.
//Note: by default, a new int array contains all 0's. 

//makeLast({4, 5, 6}) → {0, 0, 0, 0, 0, 6}
//makeLast({1, 2}) → {0, 0, 0, 2}
//makeLast({3}) → {0, 3}
def makeLast(nums:Array[Int]):Array[Int] ={
  val b = nums++nums.map(x=>0)
  b(b.size-1)=b(0)
  b
}


//Given an int array, return true if the array contains 2 twice, or 3 twice. The array will be length 0, 1, or 2. 

//double23({2, 2}) → true
//double23({3, 3}) → true
//double23({2, 3}) → false
def double23(nums:Array[Int]):Boolean ={
  (nums.count(x=>x==2) ==2) || (nums.count(x=>x==3)==2)
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

//fix23({1, 2, 3}) → {1, 2, 0}
//fix23({2, 3, 5}) → {2, 0, 5}
//fix23({1, 2, 1}) → {1, 2, 1}
//how to set the elem to a value? 
def fix23(nums:Array[Int]):Array[Int]= {
  //not correct just to pass compiler errors for other tests
 return Array(10)  
}



//Start with 2 int arrays, a and b, of any length. Return how many of the arrays have 1 as their first element. 

//start1({1, 2, 3}, {1, 3}) → 2
//start1({7, 2, 3}, {1}) → 1
//start1({1, 2}, {}) → 1
def start1(a:Array[Int], b:Array[Int]):Int= {
  val list =List(a,b)
  //doesnt work in interp
  list.count(x=>x(0)==1)
}



//Start with 2 int arrays, a and b, each length 2. Consider the sum of the values in each array. Return the array which has the largest sum. In event of a tie, return a. 

//biggerTwo({1, 2}, {3, 4}) → {3, 4}
//biggerTwo({3, 4}, {1, 2}) → {3, 4}
//biggerTwo({1, 1}, {1, 2}) → {1, 2}
def biggerTwo(a:Array[Int], b:Array[Int]):Array[Int] = {
  if( (b.sum==a.sum) || (b.sum<a.sum)) a 
  else 
    b 
}



//Given an array of ints of even length, return a new array length 2 containing the middle two elements 
//from the original array. The original array will be length 2 or more. 

//makeMiddle({1, 2, 3, 4}) → {2, 3}
//makeMiddle({7, 1, 2, 3, 4, 9}) → {2, 3}
//makeMiddle({1, 2}) → {1, 2}
def makeMiddle(nums:Array[Int]):Array[Int] ={
  Array(nums(nums.size/2))++Array(nums(nums.size/2 + 1)) 
}


//Given 2 int arrays, each length 2, return a new array length 4 containing all their elements. 

//plusTwo({1, 2}, {3, 4}) → {1, 2, 3, 4}
//plusTwo({4, 4}, {2, 2}) → {4, 4, 2, 2}
//plusTwo({9, 2}, {3, 4}) → {9, 2, 3, 4}
def plusTwo(a:Array[Int], b:Array[Int]):Array[Int]= {
 a++b	  
}



//Given an array of ints, swap the first and last elements in the array. Return the modified array. The array length will be at least 1. 

//swapEnds({1, 2, 3, 4}) → {4, 2, 3, 1}
//swapEnds({1, 2, 3}) → {3, 2, 1}
//swapEnds({8, 6, 7, 9, 5}) → {5, 6, 7, 9, 8}
def swapEnds(nums:Array[Int]):Array[Int]= {
  //val tmp = nums(0) note to self, we dont need a tmp cause of the drop/take api
   nums.takeRight(1)++nums.drop(1).dropRight(1)++nums.take(1)
}


//Given an array of ints of odd length, return a new array length 3 containing the elements from the middle of the array. The array length will be at least 3. 

//midThree({1, 2, 3, 4, 5}) → {2, 3, 4}
//midThree({8, 6, 7, 5, 3, 0, 9}) → {7, 5, 3}
//midThree({1, 2, 3}) → {1, 2, 3}
//NOTE TO SELF, GENERALIZE FOR N COPIES
def midThree(nums:Array[Int]):Array[Int] ={
  Array(nums(nums.size/2))++Array(nums(nums.size/2))++Array(nums(nums.size/2))
}



//Given an array of ints of odd length, look at the first, last, and middle values in the array and return the largest. 
//The array length will be a least 1. 

//maxTriple({1, 2, 3}) → 3
//maxTriple({1, 5, 3}) → 5
//maxTriple({5, 2, 3}) → 5
def maxTriple(nums:Array[Int]):Int ={
  List(nums(0),nums(nums.size/2),nums(nums.size)).max
}


//Given an int array of any length, return a new array of its first 2 elements. If the array is smaller than length 2, use whatever elements are present. 

//frontPiece({1, 2, 3}) → {1, 2}
//frontPiece({1, 2}) → {1, 2}
//frontPiece({1}) → {1}
def frontPiece(nums:Array[Int]):Array[Int]= {
  if(nums.size<2) nums
  else 
    Array(nums(0))++Array(nums(1))
}


//We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1. 
//Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array. 

//unlucky1({1, 3, 4, 5}) → true
//unlucky1({2, 1, 3, 4, 5}) → true
//unlucky1({1, 1, 1}) → false
def unlucky1(nums:Array[Int]):Boolean ={
  if( (nums(0)==1 && nums(1)==1) || (nums(nums.size-1)==1 && nums(nums.size-2)==1) ) true
  else 
    false
}

//Given 2 int arrays, a and b, return a new array length 2 containing, as much as will fit, 
//the elements from a followed by the elements from b. The arrays may be any length, including 0, but there will be 2 or more elements available between the 2 arrays. 

//make2({4, 5}, {1, 2, 3}) → {4, 5}
//make2({4}, {1, 2, 3}) → {4, 1}
//make2({}, {1, 2}) → {1, 2}
def make2(a:Array[Int], b:Array[Int]):Array[Int]= {
  a++b 
}



//Given 2 int arrays, a and b, of any length, return a new array with the first element of each array. 
//If either array is length 0, ignore that array. 

//front11({1, 2, 3}, {7, 9, 8}) → {1, 7}
//front11({1}, {2}) → {1, 2}
//front11({1, 7}, {}) → {1}
def front11(a:Array[Int], b:Array[Int]):Array[Int]= {
  Array(a.head) ++ Array(b.head) //no diff if we use (0), no exception
}

}
