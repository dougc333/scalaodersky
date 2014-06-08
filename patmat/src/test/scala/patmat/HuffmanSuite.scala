package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val t3 = List('d','d','d','d','a','a','b','b','b')
    val t4=List('a','a','b','b','b')
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("times"){
    new  TestTrees{
      assert( times(List('a','b','c','a')) == List(('a',2), ('b',1), ('c',1)) )
    }
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("singleton"){
    new TestTrees{
     assert(singleton(List(t1))==true)
     assert(singleton(List(t1,t2))==false)
    }
  }

    test("singleton2"){
    new TestTrees{
     assert(singleton2(List(t1))==true)
     assert(singleton2(List(t1,t2))==false)
    }
  }

  test("until t1 functional"){
    new TestTrees{
      val u1 = until(singleton,combine)(List(t1))
      assert(u1==t1)
    }
  }  

  test("untilt1 w List chars"){
    new TestTrees{
      val u1 = until(singleton,combine)(makeOrderedLeafList(times(t4)))
      assert(u1==t1)
    }
  }  

  test("untilt2 w List chars"){
    new TestTrees{
      val u2 = until(singleton,combine)(makeOrderedLeafList(times(t3)))
    //  println("u2:"+u2)
      assert(u2==Fork(Leaf('d',4),Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5),List('d', 'a', 'b'),9)) 
    }
  } 
  
 //tree in variable t2. not sure which one is correct
  test("untilt2 w List chars w combine2"){
    new TestTrees{
      val u2 = until(singleton,combine2)(makeOrderedLeafList(times(t3)))
  //    println("u2:"+u2)
      assert(u2==Fork(Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5),Leaf('d',4),List('a', 'b', 'd'),9)) 
    }
  }  

  test("untilt2 w List chars w combine1"){
    new TestTrees{
      val u2 = until(singleton,combine1)(makeOrderedLeafList(times(t3)))
      println("u2:"+u2)
      assert(u2==Fork(Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5),Leaf('d',4),List('a', 'b', 'd'),9)) 
    }
  }  

  
  
  test("createCodeTree"){
    new TestTrees{
      assert(createCodeTree(List('a','a','b','b','b'))===t1)
    }
  }
  
  test("combine of some leaf list1") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("combine of some leaf list2") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("encode"){
    val e=encode(Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5))(List('b', 'a', 'b', 'a', 'b', 'a'))
    assert(e===List(1,0,1,0,1,0))
  }
  test("encode1"){
    val e=encode(Leaf('a',2))(List('b', 'a', 'b', 'a', 'b', 'a'))
    assert(e===List())
  }
  test("encode2"){
    val e=encode(Leaf('b',2))(List('b', 'a', 'b', 'a', 'b', 'a'))
    assert(e===List())
  }
  
  
  test("decode"){
   val d = decode(Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5),List(0,1,0,1,0,1)) 
   assert(d===List('b', 'a', 'b', 'a','b', 'a'))
  }
  
  
  test("test french secret"){
    val decodeSecret = decodedSecret
    //println("decodedSecret:"+decodedSecret);
    assert (decodedSecret==List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }
  
  test("convert"){
    val c = convert(Fork(Leaf('a',2),Leaf('b',3),List('a', 'b'),5))
    assert(c===List(('b',List(1)), ('a',List(0))))
  }
  
  test("convert1"){
    val c1 = convert(Leaf('a',2))
    assert(c1===List(('a',List())))
  }
  test("convert2"){
    new TestTrees{
      val c1 = convert(t2)
      assert(c1===List(('d',List(1)), ('b',List(0, 1)), ('a',List(0, 0))))
    }
  }
  
  
  
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
