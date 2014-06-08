package patmat
import patmat.Huffman._


object decode {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet");$skip(60); 
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5);System.out.println("""t1  : patmat.Huffman.Fork = """ + $show(t1 ));$skip(54); 
  val tree1=createCodeTree(List('a','a','b','b','b'));System.out.println("""tree1  : patmat.Huffman.CodeTree = """ + $show(tree1 ));$skip(27); 
  println("tree1:"+tree1);$skip(29); ;
  val listBits = "ab".toList;System.out.println("""listBits  : List[Char] = """ + $show(listBits ));$skip(13); val res$0 = 
  weight(t1);System.out.println("""res0: Int = """ + $show(res$0));$skip(537); 
 def decode1(tree: CodeTree, bits: List[Bit]): List[Char] = {
     def innerDecode(innerTree: CodeTree, bits: List[Bit], acc: List[Char]): List[Char] = innerTree match {
      case Leaf(char, _)           => innerDecode(tree, bits, char :: acc)
      case Fork(left, right, _, _) => bits match {
        case List()  => acc
        case head :: tail => head match {
          case 0 => innerDecode(left, tail, acc)
          case 1 => innerDecode(right, tail, acc)
        }
      }
    }
    innerDecode(tree, bits, List()).reverse
  };System.out.println("""decode1: (tree: patmat.Huffman.CodeTree, bits: List[patmat.Huffman.Bit])List[Char]""");$skip(25); val res$1 = 
   decode1(t1,List(0,1));System.out.println("""res1: List[Char] = """ + $show(res$1));$skip(26); val res$2 = 
   encode(t1)("a".toList);System.out.println("""res2: List[patmat.Huffman.Bit] = """ + $show(res$2));$skip(26); val res$3 = 
   encode(t1)("b".toList);System.out.println("""res3: List[patmat.Huffman.Bit] = """ + $show(res$3));$skip(29); val res$4 = 
   encode(t1)("aaaa".toList);System.out.println("""res4: List[patmat.Huffman.Bit] = """ + $show(res$4));$skip(29); val res$5 = 
   encode(t1)("bbbb".toList);System.out.println("""res5: List[patmat.Huffman.Bit] = """ + $show(res$5));$skip(26); val res$6 = 
   encode(t1)("e".toList);System.out.println("""res6: List[patmat.Huffman.Bit] = """ + $show(res$6))}
   
}
