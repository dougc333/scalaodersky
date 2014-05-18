package objsets

abstract class PracticeSet {
  def contains(tweet: Tweet): Boolean
  def incl(tweet: Tweet): PracticeSet
  def remove(tweet: Tweet): PracticeSet
  def foreach(f: Tweet => Unit): Unit
}

class EmptyPS extends PracticeSet{
  def contains(tweet: Tweet): Boolean=false
  def incl(tweet: Tweet): PracticeSet=new NonEmptyPS(tweet,new EmptyPS, new EmptyPS).incl(tweet)
  def remove(tweet: Tweet): PracticeSet={
    new EmptyPS
  }
  def foreach(f: Tweet => Unit): Unit=Nil 

  override def toString()="."
}

class NonEmptyPS(elem:Tweet, left:PracticeSet,right:PracticeSet) extends PracticeSet{
  def contains(tweet: Tweet): Boolean={
    if (elem.text==tweet.text) true 
    else if (tweet.text<elem.text) left.contains(tweet) 
    else if(tweet.text>elem.text) right.contains(tweet)
    else false
    }
  def incl(tweet: Tweet): PracticeSet={
    if(this.contains(tweet) || tweet.text==elem.text) return this
    else if(tweet.text<elem.text) new NonEmptyPS(elem,left.incl(tweet),right)
    else new NonEmptyPS(elem,left,right.incl(tweet))
  }
  def remove(tweet: Tweet): PracticeSet={
    
  }
  def foreach(f: Tweet => Unit): Unit={
    
  }

  override def toString()="{" + elem+left+right+"}"
  
  
}