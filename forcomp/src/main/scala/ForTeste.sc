object ForTeste {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  List(1,2,3,4,5).map(x=>println(x))              //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| res0: List[Unit] = List((), (), (), (), ())
  
  for(x<-List(1,2,3,4,5)) yield println(x)        //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| res1: List[Unit] = List((), (), (), (), ())


}