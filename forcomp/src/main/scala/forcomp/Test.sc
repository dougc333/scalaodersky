package forcomp

object Test1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  "asdfasdSDFSFsd".filter (x=>x.isUpper)          //> res0: String = SDFSF
  "asdfFsdf".map(x=>x.isUpper)                    //> res1: scala.collection.immutable.IndexedSeq[Boolean] = Vector(false, false, 
                                                  //| false, false, true, false, false, false)
  "asdfSDFSdf".groupBy(x=>x.isUpper)              //> res2: scala.collection.immutable.Map[Boolean,String] = Map(false -> asdfdf, 
                                                  //| true -> SDFS)
 // "asdfasdfDFSDF".foldLeft(x=>x.isUpper)
  
}
  
 