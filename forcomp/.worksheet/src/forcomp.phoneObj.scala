package forcomp
import scala.io._
import forcomp.Anagrams._


object phoneObj {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(123); 
  println("Welcome to the Scala worksheet");$skip(110); 
  
   val mn = Map('2'->"ABC",'3'->"DEF",'4'->"GHI",'5'->"JKL",'6'->"MNO",'7'->"PQRS",'8'->"TUV",'9'->"WXYZ");System.out.println("""mn  : scala.collection.immutable.Map[Char,String] = """ + $show(mn ));$skip(66); 
  
   val test = for((digit,str)<-mn) yield print("digit:"+digit);System.out.println("""test  : scala.collection.immutable.Iterable[Unit] = """ + $show(test ));$skip(60); 
   val test1 = for((digit,str)<-mn) yield print("str:"+str);System.out.println("""test1  : scala.collection.immutable.Iterable[Unit] = """ + $show(test1 ));$skip(30); 
   
   val s = "asdfasdfasdf";System.out.println("""s  : String = """ + $show(s ));$skip(48); 
   val splitMe=for(ch<-s) yield print("ch:"+ch);System.out.println("""splitMe  : scala.collection.immutable.IndexedSeq[Unit] = """ + $show(splitMe ));$skip(86); 
   val charCode:Map[Char,Char]=
      for((digit,str)<-mn; ltr<-str) yield ltr->digit;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(75); 
  
  
  def wordCode(word:String)={
     word.toUpperCase map charCode
  };System.out.println("""wordCode: (word: String)String""");$skip(34); val res$0 = 
  
  wordCode("Java".toUpperCase);System.out.println("""res0: String = """ + $show(res$0));$skip(69); 
  
    val in = Source.fromFile("/home/dc/Downloads/linuxwords.txt");System.out.println("""in  : scala.io.BufferedSource = """ + $show(in ));$skip(83); 
  //val
  val words=in.getLines.toList.filter(word=>word forall (ch=>ch.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(92); 
  
  val wordsForNum:Map[String,Seq[String]]=words groupBy wordCode  withDefaultValue Seq();System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(254); 
  def encode(number:String):Set[List[String]]={
    if(number.isEmpty) Set(List())
    else
     for{
        split<-1 to number.length
        word<-wordsForNum(number take split)
        rest<-encode(number drop split)
     }yield word::rest
  }.toSet;System.out.println("""encode: (number: String)Set[List[String]]""");$skip(26); val res$1 = 
  
  encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1))}
//  translate("7225247386") foreach println

}
