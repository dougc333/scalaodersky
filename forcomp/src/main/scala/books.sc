object books {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  case class Book(title:String,authors:List[String])
  
  var books:List[Book] = List(
  Book(title="Scala Book", authors = List("Odersky", "George", "Sam")),
  Book(title="Structure of Computer Programs", authors = List("Abelson", "Harald")),
  Book(title="Intro to functional programming", authors = List("Bird", "George", "Sam")),
  Book(title="Effective Java", authors = List("Bloch")),
  Book(title="Java Puzzlers", authors = List("Bloch", "George", "Sam")),
  Book(title="Scala more", authors = List("Odersky, George, Sam"))
  )                                               //> books  : List[books.Book] = List(Book(Scala Book,List(Odersky, George, Sam))
                                                  //| , Book(Structure of Computer Programs,List(Abelson, Harald)), Book(Intro to 
                                                  //| functional programming,List(Bird, George, Sam)), Book(Effective Java,List(Bl
                                                  //| och)), Book(Java Puzzlers,List(Bloch, George, Sam)), Book(Scala more,List(Od
                                                  //| ersky, George, Sam)))
  
  //find titles of books where author is odersky
  for (b<-books; a<-b.authors if a startsWith "Bird") yield b.title
                                                  //> res0: List[String] = List(Intro to functional programming)
  
 //all authors who have written at least 2 books; still not as easy as sql
 for{
   b1<-books
   b2<-books
   if b1!=b2
   a1<-b1.authors
   a2<-b2.authors
   if a1==a2
 } yield a1                                       //> res1: List[String] = List(George, Sam, George, Sam, George, Sam, George, Sam
                                                  //| , Bloch, George, Sam, George, Sam, Bloch)
 
 
 
 
 
}