package codingbat

import java.io.{FileWriter,File,PrintWriter}
import org.scalatest.FunSuite
import edu.stanford.codingbat.ScalaWarmup1

//no need to import scalatest?

class ScalaWarmup1Suite extends FunSuite {
  val t = new ScalaWarmup1
  
  test("simple test"){
    assert(true)
  }
  
  test("test sleepIn"){
    assert(t.sleepIn(false,false)==true)
    assert(t.sleepIn(true,false)==false)
    assert(t.sleepIn(false,true)==true)
    
  }
  
  test("test monkeyTrouble"){
	assert(t.monkeyTrouble(true,true)==true)
	assert(t.monkeyTrouble(false,false)==true)
    assert(t.monkeyTrouble(true,false)==false)
  }

  test("test sumDouble"){
    assert(t.sumDouble(1,2)==3)
    assert(t.sumDouble(2,3)==5)
    assert(t.sumDouble(2,2)==8)
  }
  
  test("test diff21"){
    assert(t.diff21(19)==2)
    assert(t.diff21(10)==11)
    assert(t.diff21(21)==0)
  }
  
  test("test parrotTrouble"){
    assert(t.parrotTrouble(true,6)==true)
    assert(t.parrotTrouble(true,7)==false)
    assert(t.parrotTrouble(false,6)==false)
  }
  
  test("test makes10"){
    assert(t.makes10(9,10)==true)
    assert(t.makes10(9,9)==false)
    assert(t.makes10(1,9)==true)
  }
  
  test("test nearHunderd"){
    assert(t.nearHundred(93)==true)
    assert(t.nearHundred(90)==true)
    assert(t.nearHundred(89)==false)
  }
  
  test("test posNeg"){
    assert(t.posNeg(1,-1,false)==true)
    assert(t.posNeg(-1,1,false)==true)
    assert(t.posNeg(-4,-5,true)==true)
  }
  
  test("test notString"){
    assert(t.notString("candy")=="not candy")
    assert(t.notString("x")=="not x")
    assert(t.notString("not bad")=="not bad")
    
  }
  
  test("test missingChar"){
    assert(t.missingChar("kitten",1)=="ktten")
    assert(t.missingChar("kitten",0)=="itten")
    assert(t.missingChar("kitten",4)=="kittn")
  }
  
  test("test frontBack"){
    assert(t.frontBack("code")=="eodc")
    assert(t.frontBack("a")=="a")
    assert(t.frontBack("ab")=="ba")
  }
  
  test("test front3"){
    assert(t.front3("Java")=="JavJavJav")
    assert(t.front3("Chocolate")=="ChoChoCho")
    assert(t.front3("abc")=="abcabcabc")
  }
  
  test("test backAround"){
    assert(t.backAround("cat")=="tcatt")
    assert(t.backAround("Hello")=="oHelloo")
    assert(t.backAround("a")=="aaa")
  }
  
  test("test or35"){
    assert(t.or35(3)==true)
    assert(t.or35(10)==true)
    assert(t.or35(8)==false)
 }
  
 test("test front22"){
    assert(t.front22("kitten")=="kikittenki")
    assert(t.front22("Ha")=="HaHaHa")
    assert(t.front22("abc")=="ababcab")   
 }
  
 test("test startHi"){
    assert(t.startHi("hi there")==true) 
    assert(t.startHi("hi")==true) 
    assert(t.startHi("hello hi")==false)   
 }
 
 test("test icyHot"){
   assert(t.icyHot(120,-1)==true)
   assert(t.icyHot(-1,120)==true)
   assert(t.icyHot(2,120)==false)
 }
 
 test("test in1020"){
   assert(t.in1020(12,99)==true)
   assert(t.in1020(21,12)==true)
   assert(t.in1020(8,99)==false)
 }
 
 test("test hasTeen"){
   assert(t.hasTeen(13,20,10)==true)
   assert(t.hasTeen(20,19,10)==true)
   assert(t.hasTeen(20,10,13)==true)
 }
 
 test("test loneTeen"){
   assert(t.loneTeen(13,99)==true)
   assert(t.loneTeen(21,19)==true)
   assert(t.loneTeen(13,13)==false)
 }
 
 test("test delDel"){
   assert(t.delDel("adelbc")=="abc")
   assert(t.delDel("adelHello")=="aHello")
   assert(t.delDel("adedbc")=="adedbc")
 }
 
 test("test mixStart"){
   assert(t.mixStart("mix snacks")==true)   
   assert(t.mixStart("pix snacks")==true)
   assert(t.mixStart("piz snacks")==false)
 }
 
 test("test startOz"){
   assert(t.startOz("ozymandias")=="oz")
   assert(t.startOz("bzoo")=="z")
   assert(t.startOz("oxx")=="o")   
 }
 
 test("test intMax"){
   assert(t.intMax(1,2,3)==3)
   assert(t.intMax(1,3,2)==3)
   assert(t.intMax(3,2,1)==3)
 }
 
 test("test close10"){
   assert(t.close10(8,13)==8)
   assert(t.close10(13,8)==8)
   assert(t.close10(13,7)==0)
 }
 
 test("test in3050"){
   assert(t.in3050(30,31)==true)
   assert(t.in3050(30,41)==false)
   assert(t.in3050(40,50)==true)
 }
 
 test("test max1020"){
   assert(t.max1020(11,19)==19)
   assert(t.max1020(19,11)==19)
   assert(t.max1020(11,9)==11)
 }
 
 test("test stringE"){
   assert(t.stringE("Hello")==true)
   assert(t.stringE("Heelle")==true)
   assert(t.stringE("Heelele")==false)
 }
 
 test("test lastDigit"){
   assert(t.lastDigit(7,17)==true)
   assert(t.lastDigit(6,17)==false)
   assert(t.lastDigit(3,113)==true)
 }
 
 test("test endUp"){
   assert(t.endUp("Hello")=="HeLLO")
   assert(t.endUp("hi there")=="hi thERE")
   assert(t.endUp("hi")=="HI")
 }
 
 test("test everyNth"){
   assert(t.everyNth("Miracle",2)=="Mrce")
   assert(t.everyNth("abcdefg",2)=="aceg")
   assert(t.everyNth("abcdefg",3)=="adg")
 }
}