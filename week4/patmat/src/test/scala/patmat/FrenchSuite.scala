package patmat

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import patmat.Huffman._
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
object FrenchSuite extends FunSuite {
  
  test("french decode") {
    val ds = decodedSecret
    println(ds)
  }
  

}
