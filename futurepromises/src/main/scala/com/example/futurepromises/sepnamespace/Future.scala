package com.example.futurepromises.sepnamespace


import scala.util.{Try,Success,Failure}
import scala.concurrent.ExecutionContext
import scala.collection.mutable.ArrayBuffer
import scala.util.control.NonFatal



trait Future[T]{
  def isCompleted:Boolean
  def value:Option[Try[T]]

  def flatMap[S](f:(T)=>Future[S])(implicit executor:ExecutionContext):Future[S]
  def map[S](f:(T)=>S)(implicit executor:ExecutionContext):Future[S]

  def castTo[S](implicit executor:ExecutionContext):Future[S] = this.map(x=>x.asInstanceOf[S])

  def foreach[U](f:(T)=>U)(implicit executor:ExecutionContext):Unit = map(f)

  def onComplete[U](f:(Try[T])=>U)(implicit executor:ExecutionContext):Unit
  
  def onFailure[U](pf:PartialFunction[Throwable,U])(implicit executor:ExecutionContext)= 
  onComplete{
    case Failure(e)=>pf.apply(e)
    case _ =>
  }

  def onSuccess[U](pf:PartialFunction[T,U])(implicit executor:ExecutionContext):Unit=onComplete{
    case Success(v) => pf.apply(v)
    case _ =>
  }


}



class DefaultFuture[T] extends Future[T] {
  class FutureCallback(val function:(Try[T])=>Any,val context:ExecutionContext)
  //ivars
  @volatile private var result:Try[T] = null
  private val callbacks = new ArrayBuffer[FutureCallback]()
  
  def isCompleted:Boolean = result!=null
  def value:Option[Try[T]] = if(this.isCompleted){
    Some(result)
  }else{
    None
  }
  def complete(value:Try[T]){
    if(value==null){
     throw new IllegalArgumentException("a futreu cant be completed with null")
    }
    synchronized{
     if(!this.isCompleted){
       result=value
       fireCallbacks()
     }
    }
  }

  override def onComplete[U](f:(Try[T])=>U)(implicit executor:ExecutionContext):Unit = {
    val callback = new FutureCallback(f,executor)
    this.synchronized {
      if(this.isCompleted){
        fireCallback(callback)
      }else{
	callbacks +=callback
      }
    }

  }

  private def fireCallbacks(){
    callbacks.foreach(fireCallback)
    callbacks.clear()
  }
  private def fireCallback(callback:FutureCallback){
    callback.context.execute(new Runnable{
      def run() = callback.function(result)
    })
  }


  def map[S](f:(T)=>S)(implicit executor:ExecutionContext):Future[S] = {
    val p = DefaultPromise[S]()
    onComplete{
      v=>p complete (v map f)
    }
    p.future
  }

  def flatMap[S](f:(T)=>Future[S])(implicit executor:ExecutionContext):Future[S] = {
    val p = DefaultPromise[S]()
    onComplete{
      case Success(v)=>
       try{
         f(v).onComplete(p.complete)
       }catch{
         case NonFatal(exception)=>p.failure(exception)
       }
       case Failure(exception)=>p.failure(exception)
    }
    p.future
  }
  

}
