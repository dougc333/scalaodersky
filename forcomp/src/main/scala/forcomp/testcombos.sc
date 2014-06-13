package forcomp

object testcombos {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

val chars = 'a' to 'z'                            //> chars  : scala.collection.immutable.NumericRange.Inclusive[Char] = NumericRa
                                                  //| nge(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, 
                                                  //| y, z)
val perms = chars.flatMap({x=>Seq("%c".format(x))})
                                                  //> perms  : scala.collection.immutable.IndexedSeq[String] = Vector(a, b, c, d, 
                                                  //| e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
//val perms1 = chars.Map()
//val perms = chars flatMap { a =>chars flatMap { b =>
 //   if (a != b) Seq("%c%c".format(a, b))
 //   else Seq()
 // }
//}

}