object books {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet")
  
  case class Book(title:String,authors:List[String]);$skip(538); 
  
  var books:List[Book] = List(
  Book(title="Scala Book", authors = List("Odersky", "George", "Sam")),
  Book(title="Structure of Computer Programs", authors = List("Abelson", "Harald")),
  Book(title="Intro to functional programming", authors = List("Bird", "George", "Sam")),
  Book(title="Effective Java", authors = List("Bloch")),
  Book(title="Java Puzzlers", authors = List("Bloch", "George", "Sam")),
  Book(title="Scala more", authors = List("Odersky, George, Sam"))
  );System.out.println("""books  : List[books.Book] = """ + $show(books ));$skip(120); val res$0 = 
  
  //find titles of books where author is odersky
  for (b<-books; a<-b.authors if a startsWith "Bird") yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(184); val res$1 = 
  
 //all authors who have written at least 2 books; still not as easy as sql
 for{
   b1<-books
   b2<-books
   if b1!=b2
   a1<-b1.authors
   a2<-b2.authors
   if a1==a2
 } yield a1;System.out.println("""res1: List[String] = """ + $show(res$1))}
 
 
 
 
 
}
