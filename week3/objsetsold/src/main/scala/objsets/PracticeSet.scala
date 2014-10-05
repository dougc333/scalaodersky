package objsets

abstract class PracticeSet {
  def contains(tweet: Tweet): Boolean
  def incl(tweet: Tweet): PracticeSet
  def remove(tweet: Tweet): PracticeSet
  def foreach(f: Tweet => Unit): Unit
  //hw added
  def filter(p: Tweet => Boolean): TweetSet = filterAcc(p,new Empty)
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet
  def union(that: PracticeSet): PracticeSet
  def mostRetweeted:Tweet
  def mostRetweetedAcc(acc:Tweet):Tweet
//  def descendingByRetweet: TweetList
}

class EmptyPS extends PracticeSet{
  def contains(tweet: Tweet): Boolean=false
  def incl(tweet: Tweet): PracticeSet={println("EmptyPS incl");new NonEmptyPS(tweet,new EmptyPS, new EmptyPS).incl(tweet)}
  def remove(tweet: Tweet): PracticeSet={
    new EmptyPS
  }
  def foreach(f: Tweet => Unit): Unit=Nil 
  override def toString()="."
  //hw added
  def union(that: PracticeSet):PracticeSet=that
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet=acc
  def mostRetweeted: Tweet = throw new NoSuchElementException("Empty.mostRetweeted")
  def mostRetweetedAcc(acc:Tweet):Tweet=acc
}

class NonEmptyPS(elem:Tweet, left:PracticeSet,right:PracticeSet) extends PracticeSet{
  def contains(tweet: Tweet): Boolean={
    if (elem.text==tweet.text) true 
    else if (tweet.text<elem.text) left.contains(tweet) 
    else if(tweet.text>elem.text) right.contains(tweet)
    else false
    }
  
  def incl(tweet: Tweet): PracticeSet={
    //println("NonEmptyPS incl"+" tweet.text:"+tweet.text+" elem.text:"+elem.text)
    if(this.contains(tweet) || tweet.text==elem.text) {
      //println("return this");
      return this
      }
    else if(tweet.text<elem.text) {
      //println("tweet.text<elem.text");
      new NonEmptyPS(elem,left.incl(tweet),right)
      }
    else {
    //println("tweet.text>elem.text");
    new NonEmptyPS(elem,left,right.incl(tweet))
    }
  }
  
  def remove(tweet: Tweet): PracticeSet={
    if(tweet.text<elem.text) new NonEmptyPS(tweet,left.remove(tweet),right)
    else if(tweet.text>elem.text) new NonEmptyPS(tweet,left,right.remove(tweet))
    else //remove and union wo the elem
      left.union(right)
  }
  
  def foreach(f: Tweet => Unit): Unit={
    left.foreach(f)
    right.foreach(f)
    f(elem)
  }

  override def toString()="{" + elem+left+right+"}"
  //hw added
  def union(that: PracticeSet):PracticeSet={
    //left.union(right.union(that)).incl(elem) //??? not clear, from lecture
    ((left union right) union that) incl (elem)
  }

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet={
    right.filterAcc(p, left.filterAcc(p, if (p(elem)) acc.incl(elem) else acc))
  }
  
  def mostRetweeted: Tweet = mostRetweetedAcc(elem)
  def mostRetweetedAcc(acc:Tweet):Tweet={
    right.mostRetweetedAcc(left.mostRetweetedAcc( if(elem.retweets>acc.retweets) elem else acc))
  }

}