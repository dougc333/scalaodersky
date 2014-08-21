package com.example.futurepromises

import scala.concurrent.{Future,Promise, Await}
import scala.util.{Try,Success,Failure}
import scala.concurrent.duration._
import java.io._
import scala.concurrent.ExecutionContext.Implicits.global




case class TaxCut(reduction:Int)

object TestFuturePromiseTaxCut {
  
  def main(args:Array[String]){
    println("start TestFuturePromiseTaxCut")
    val taxcut = Promise[TaxCut]()
    val taxcut2:Promise[TaxCut] = Promise()
    val taxcutF:Future[TaxCut] = taxcut.future
    //set the promise
    taxcut.success(TaxCut(20))
    //read the promise
    taxcutF onSuccess {case x=>println(x)}
//    Await.ready(taxcutF, 3 seconds)    
  }
  
  
}

