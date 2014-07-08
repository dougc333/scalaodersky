package lectureexamples

class MyList {
  type U
  type T
  
  //map returns a list and applies a function type to each element in the collection defined as T=>U
  def map[U](f:T=>U):List[U]=this match{
    case x::xs =>f(x) :: xs.map(f)
    case Nil=>Nil
  }
  
  
  //flatMapp returns a list and applies a function type T=>List[U], ?? returns an iterator I thought. This is only for list? 
    def flatMap[U](f:T=>List[U]):List[U]=MyList match{
    case x::xs =>f(x) :: xs.flatMap(f)
    case Nil=>Nil
  }
      
              
}