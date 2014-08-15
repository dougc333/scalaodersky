import scala.language.postfixOps
import scala.util._
import scala.util.control.NonFatal
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.async.Async.{async, await}
import scala.io.Source
import nodescala.NodeScala.Request
/** Contains basic data types, data structures and `Future` extensions.
 */
package object nodescala {

  /** Adds extensions methods to the `Future` companion object.
   */
  implicit class FutureCompanionOps[T](val f: Future.type) extends AnyVal {

    /** Returns a future that is always completed with `value`.
     */
    def always[T](value: T): Future[T] ={
      val p = Promise[T]()
      p.success(value)
      p.future
    }

    /** Returns a future that is never completed.
     *
     *  This future may be useful when testing if timeout logic works correctly.
     */
    def never[T]: Future[T] = Promise[T].future

    /** Given a list of futures `fs`, returns the future holding the list of values of all the futures from `fs`.
     *  The returned future is completed only once all of the futures in `fs` have been completed.
     *  The values in the list are in the same order as corresponding futures `fs`.
     *  If any of the futures `fs` fails, the resulting future also fails.
     */
    def all[T](fs: List[Future[T]]): Future[List[T]] = {
      fs.foldRight(Future.always(List[T]())){
        (f,acc)=>
         for(tail<-acc; head<-f) yield head::tail
      }
    }

    /** Given a list of futures `fs`, returns the future holding the value of the future from `fs` that completed first.
     *  If the first completing future in `fs` fails, then the result is failed as well.
     *
     *  E.g.:
     *
     *      Future.any(List(Future { 1 }, Future { 2 }, Future { throw new Exception }))
     *
     *  may return a `Future` succeeded with `1`, `2` or failed with an `Exception`.
     */
    def any[T](fs: List[Future[T]]): Future[T] = {
      val p = Promise[T]()
      for{f<-fs} f.onComplete {
        p.tryComplete(_)}
      p.future
    }
    /** Returns a future with a unit value that is completed after time `t`.
     */
    def delay(t: Duration): Future[Unit] = Future{
      try{
        blocking{
          Await.result(Future.never,t)
        }
      }
    }

        
    /** Completes this future with user input.
     */
    def userInput(message: String): Future[String] = Future {
      println("calling userInput")
      readLine(message)
    }

    /** Creates a cancellable context for an execution and runs it.
     */
    def run()(f: CancellationToken => Future[Unit]): Subscription = {
      println("calling run")
      val cts = CancellationTokenSource()
      f(cts.cancellationToken)
      cts
    }

  }

  /** Adds extension methods to future objects.
   */
  implicit class FutureOps[T](val f: Future[T]) extends AnyVal {

    /** Returns the result of this future if it is completed now.
     *  Otherwise, throws a `NoSuchElementException`.
     *  
     *  Note: This method does not wait for the result.
     *  It is thus non-blocking.
     *  However, it is also non-deterministic -- it may throw or return a value
     *  depending on the current state of the `Future`.
     */
    def now: T = {
      try{
        Await.result(f,0 nanos)
      }catch{
        case t: TimeoutException => throw new NoSuchElementException
      }
    }

    /** Continues the computation of this future by taking the current future
     *  and mapping it into another future.
     * 
     *  The function `cont` is called only after the current future completes.
     *  The resulting future contains a value returned by `cont`.
     */
    def continueWith[S](cont: Future[T] => S): Future[S] = {
      println("continueWith")
      val p = Promise[S]()
      
      f onComplete {
        case _ => 
        try{
         p.success(cont(f)) 
        }catch{
          case NonFatal(t) => p.failure(t)
        }
      }
      p.future
    }

    /** Continues the computation of this future by taking the result
     *  of the current future and mapping it into another future.
     *  
     *  The function `cont` is called only after the current future completes.
     *  The resulting future contains a value returned by `cont`.
     */
    def continue[S](cont: Try[T] => S): Future[S] = {
      println("continue")
      val p =promise[S]
      f.onComplete(
        result=>p.complete(Try(cont(result)))    
      )
      p.future
    }

  }

  /** Subscription objects are used to be able to unsubscribe
   *  from some event source.
   */
  trait Subscription {
    def unsubscribe(): Unit
  }

  object Subscription {
    /** Given two subscriptions `s1` and `s2` returns a new composite subscription
     *  such that when the new composite subscription cancels both `s1` and `s2`
     *  when `unsubscribe` is called.
     */
    def apply(s1: Subscription, s2: Subscription) = new Subscription {
      def unsubscribe() {
        println("unsubscribe")
        s1.unsubscribe()
        s2.unsubscribe()
      }
    }
  }

  /** Used to check if cancellation was requested.
   */
  trait CancellationToken {
    def isCancelled: Boolean
    def nonCancelled = !isCancelled
  }

  /** The `CancellationTokenSource` is a special kind of `Subscription` that
   *  returns a `cancellationToken` which is cancelled by calling `unsubscribe`.
   *  
   *  After calling `unsubscribe` once, the associated `cancellationToken` will
   *  forever remain cancelled -- its `isCancelled` will return `false.
   */
  trait CancellationTokenSource extends Subscription {
    def cancellationToken: CancellationToken
  }

  /** Creates cancellation token sources.
   */
  object CancellationTokenSource {
    /** Creates a new `CancellationTokenSource`.
     */
    def apply(): CancellationTokenSource = new CancellationTokenSource{
      //println("new CancellationTokenSource")
      val p = Promise[Unit]()
      def cancellationToken = new CancellationToken{
        def isCancelled:Boolean = p.future.value !=None
      }
      def unsubscribe():Unit={
        p.trySuccess(())
      }
    }
  }
  
  object Controller {
    lazy val stream = Source.fromFile("/home/dc/scalaodersky/nodescala/src/main/scala/nodescala/test.html").getLines.toStream
    def handle(r: Request): Iterator[String] = {
      try {
        println("controller handle")
        stream.iterator
      }catch {
        case e: Throwable => {
          println("error!")
          println(e)
          List(e.toString).iterator
        }
      }
    }
  }

}

