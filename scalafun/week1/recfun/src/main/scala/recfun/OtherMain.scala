package recfun

class OtherMain {

}

 object pascal extends (Int=>Int){
    def apply(c: Int, r: Int):Int={
      if ( c==0 || c==r) 1
      else
      apply(c-1,r-1) + apply(c,r-1)
    }
    
  }
