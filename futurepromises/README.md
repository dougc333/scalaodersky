practice future/promises


Futures; declare a function to return a future value. 
the client which asks for a future result has to do something with the future value. Bad design to block on this, better to submit a function to run when the result is ready. 
Client I/F: onComplete to run on future result. 
onComplete is a callback of type Try[T]=>U. Callback Try[T]=>U applied to types of Success[T]
or Failure[T] if future doesnt complete successfully. 

problem with this simple model is you cant guarantee order of callbacks and callbacks only return a value. 



http://mauricio.github.io/2014/05/01/scala-promises-futures-memcached-and-netty-having-fun.html



