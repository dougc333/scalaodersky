package com.example.futurepromises

import java.io._


object Hello{
  def main(args:Array[String]){
    println("asdfsadf")
    try{
    val bw = new BufferedWriter(new FileWriter("/home/dc/testscalawrite.txt"))
    bw.write("this is a test file")
    bw.close()
    }catch{
      case _ :Throwable => println("saw exception")
    }
  }


}
