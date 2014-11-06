
// a partial function is a function which only applies to certain inputs to the function
// a function type like x=>x isn't a partial function because this refers to all inputs x. 
// a pattern matching function like {case a=> a>0 && a<10} is a partial function 
// because it refers to all a's in a range 
// partial functions are used as arguments to a set of collection operations like collect, andThen, applyOrElse, lift,
// orElse, runWith, andThen, collectFirst

class PartialFunction {
  
  // use a partial function to add "o" to the end of strings and 
  // add 1 to integers and add 10 to floats
  //List(1,2,3,"foo")-> List(2,3,4,"fooo")
  //List(1,2,3,24.5,"test")=>List(2,3,4,34.5,"testo")
  def eliminateFoo(list:List[Any]):List[Any]={
    list.collect{
      case i: Int=>i+1
      case f: Float =>f+10
      case s: String =>s+"o"
    }
  }


//hey.. these below arent partial functions. you need a case statement
//to match inputs  
  //you can compose a new function from a set of existing functions 
  //similar to object composition in Java
  //to apply a function you have to call map. We can define the order
  //of application of a function using the scala partial function method
  //andThen on lists. Create a set of partial functions, 
  //add 1 to a number, square the number, divide by 2, use 
  //andthen to apply the 3 functions in sequence. Alternatively you can
  //call map 3 times. 
  def testAndThen(num:Int):Int={
    //num andThen addOne andThen square andThen divideBy2
    10
  } 
  
  def addOne(num:Int):Int={
    num+1
  }
  def square(num:Int):Int={
    num*num
  }
  def divideBy2(num:Int):Int={
    num/2
  }
  
   
  
}
