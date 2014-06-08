package patmat
import patmat.Huffman._


object decode {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
                                                  //> t1  : patmat.Huffman.Fork = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  val tree1=createCodeTree(List('a','a','b','b','b'))
                                                  //> tree1  : patmat.Huffman.CodeTree = Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  println("tree1:"+tree1);                        //> tree1:Fork(Leaf(a,2),Leaf(b,3),List(a, b),5)
  val listBits = "ab".toList                      //> listBits  : List[Char] = List(a, b)
  weight(t1)                                      //> res0: Int = 5
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
  }                                               //> decode1: (tree: patmat.Huffman.CodeTree, bits: List[patmat.Huffman.Bit])List
                                                  //| [Char]
   decode1(t1,List(0,1))                          //> res1: List[Char] = List(a, b)
   encode(t1)("a".toList)                         //> res2: List[patmat.Huffman.Bit] = List(0)
   encode(t1)("b".toList)                         //> res3: List[patmat.Huffman.Bit] = List(1)
   encode(t1)("aaaa".toList)                      //> res4: List[patmat.Huffman.Bit] = List(0, 0, 0, 0)
   encode(t1)("bbbb".toList)                      //> res5: List[patmat.Huffman.Bit] = List(1, 1, 1, 1)
   encode(t1)("e".toList)                         //> res6: List[patmat.Huffman.Bit] = List(1)
   
}