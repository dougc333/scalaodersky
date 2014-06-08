package patmat
import patmat.Huffman._


object decode {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet");$skip(60); 
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : patmat.Huffman.Fork = """ + $show(t1 ));$skip(54); 
  val tree1=createCodeTree(List('a','a','b','b','b'));System.out.println("""tree1  : patmat.Huffman.CodeTree = """ + $show(tree1 ));$skip(27); 
  println("tree1:"+tree1);$skip(29); ;
  val listBits = "ab".toList;System.out.println("""listBits  : List[Char] = """ + $show(listBits ));$skip(13); val res$0 = 
  weight(t1);System.out.println("""res0: Int = """ + $show(res$0));$skip(791); 
  // decode1(t1,List(0,1))
  // encode(t1)("a".toList)
  // encode(t1)("b".toList)
  // encode(t1)("aaaa".toList)
  // encode(t1)("bbbb".toList)
  // encode(t1)("e".toList)
   //
   def encodeTest(tree:CodeTree,text:List[Char]):Unit={
     def encodeTestAcc(tree:CodeTree, testChar:Char)= tree match{
        case Leaf(ch:Char,weight:Int) => println("leaf")
        case Fork(left:CodeTree,right:CodeTree,testChar: List[Char], weight: Int)=>{
          if(chars(left).contains(testChar)){
            println("testChar left tree:"+testChar)
          }else if(chars(right).contains(testChar)){
            println("testChar right tree:"+testChar);
          }
        }
        case _ =>println("error neither fork leaf");
     }
     for(tc<-text){
     encodeTestAcc(tree, tc)
     }
   };System.out.println("""encodeTest: (tree: patmat.Huffman.CodeTree, text: List[Char])Unit""");$skip(41); 
   
   encodeTest(Leaf('a',1),List('a'))}
   
}
