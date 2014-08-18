package com.example.futurepromises

import org.apache.hadoop.fs._
import org.apache.hadoop.conf._
import scala.concurrent._
import java.io._
import org.apache.hadoop.fs.Path
import ExecutionContext.Implicits.global


//futures and promises
object TestHDFS {
  
  //future for read from hdfs
  def readHDFS()={
    val testFile = Future{
       val path = new Path("hdfs://user/dc/testfile.txt")
       val localFile =scala.io.Source.fromFile("/home/dc/testfile.txt").mkString
       println("localFile:"+localFile)       
    }
  }

  def readHDFSBlocking={
      println("in hdfsblocking")
      val conf = new Configuration()
      println("conf created adding files")
      conf.addResource("/usr/lib/hadoop/etc/hadoop/core-site.xml")
      println("added core-site.xml")
      conf.addResource("/usr/lib/hadoop/etc/hadoop/hdfs-site.xml")
      println("added hdfs-site.xml")
      val fileSystem = org.apache.hadoop.fs.FileSystem.get(conf)
      val homeDir =  fileSystem.getHomeDirectory()
      println("homeDir:"+homeDir)
      val path = new Path("hdfs://user/dc")
      val fs = path.getFileSystem(conf)
      println("fs.uri:"+fs.getUri())
      println("fs.workingDirectory:"+fs.getWorkingDirectory())
      println("fs homeDirectory:"+fs.getHomeDirectory())
      val filestatus = fs.getFileStatus(new Path("/user/user/dc/testfile.txt"))
      println("filestatus path:"+filestatus.getPath())
      //val files = fs.listFiles(fs.getWorkingDirectory,true)
      
      fileSystem.close()
      fs.close()
  }

  def readFilesLocal() = {
    val file1 = Future{
      val f1 = scala.io.Source.fromFile("/home/dc/testfile.txt").mkString
      println("f1:"+f1)
      
    }

    //what is difference between recover and onComplete?
    //oncomplete is chained into onSuccess  
    file1.recover{
       case e:FileNotFoundException=> println("filenot found")
       case _ => println("other exception")
    }.onSuccess{
       case _ =>println("file read in...")
    }
  }

  //promises for write to hdfs 
  def writeHDFS()={
    
  }
  
  def main(args:Array[String]){ 
    readFilesLocal
    readHDFSBlocking
    //readHDFS
    //writeHDFS 
  }

}
