package objsets

abstract class PracticeList {
  //a list allows duplicates vs set
  type List= Int=>Boolean
  
  def contains():Boolean
  def map():List
  def size():Int
//  def filter(p(x:Int)=>Boolean):List
  def head():Int
  def max:Int
}