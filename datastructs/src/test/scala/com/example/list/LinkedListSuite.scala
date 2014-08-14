package com.example.list

import java.io.{FileWriter,File,PrintWriter}
import org.scalatest.FunSuite
import scala.collection.mutable.ListBuffer


class LinkedListSuite extends FunSuite {
  test("test"){
     val list =LinkedList(1,2,3)
     println(list.size)
  }
  
  test("test foreach"){
    val items = new ListBuffer[Int]()
    LinkedList(1,2,3).forEach(x=> items+=x)
    println("items(0):"+items(0))
    println("items(1):"+items(1))
    println("items(2):"+items(2))
    println("items.sum:"+items.sum); 
  }
   
  test("test cons"){
    val testCons = 1::2::3::Empty
    testCons.map(x=>println("cons list:"+x))
  }
  
  test("test map"){
    val list = LinkedList(1,2,3)
    val testMap = list.map(x=>x+5)
    testMap.map(x=>println("testmap:"+x))
    
  }
    
  
  test("test reverse"){
    val list = LinkedList(1,2,3,4)
    list.map(x=>println("list:"+x))
    val rev = list.reverse()
    rev.map(x=>println("rev:"+x)) 
  }
  
  test("test foldRight"){
    val list = LinkedList(1,2,3)
    val result =  list.foldRight(0)((x,acc)=>x+acc)
    println("foldRight result:"+result)
    assert(result==6)
  }
  
  test("test filter"){
    val list = LinkedList(1,2,3,4,5,6,7,8)
    //note to self make sure to put parenthesis around (x%2)
    val filteredList = list.filter(x=>(x%2)==0)
    filteredList.map(x=>println("test filter:"+x))  
  }
  
  test("test foldLeft"){
    val list = LinkedList(4,5,6)
    val result = list.foldLeft(0)((acc,x)=>x+acc)
    println("foldLeft result:"+result)
    assert(result==15)
  }
  
  test("test find"){
    val list = LinkedList(1,2,3,4,5,6)
    val findMe = list.find(x=>x==1)
    findMe.map(x=>println("test find should see 1:"+x))
  }
  
  
  
}
