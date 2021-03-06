package simulations

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CircuitSuite extends CircuitSimulator with FunSuite {
  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5
  
  test("andGate example") {
    val in1, in2, out = new Wire
    andGate(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    assert(out.getSignal === false, "false AND false = false")
 
    in1.setSignal(true)
    in2.setSignal(false)
    run
    assert(out.getSignal === false, "true AND false = false")
  
    in1.setSignal(true)
    in2.setSignal(true)
    run
    assert(out.getSignal === true, "true AND true = true")
    
  }

  //
  // to complete with tests for orGate, demux, ...
  //
  test("or gate example"){
    val in1,in2,out = new Wire
    orGate(in1,in2,out)
    in1.setSignal(true)
    in2.setSignal(true)
    run
    assert(out.getSignal == true, "true or true = true")
    
    in1.setSignal(true)
    in2.setSignal(false)
    run
    assert(out.getSignal == true, "true or false = true")
    
    in1.setSignal(false)
    in2.setSignal(true)
    run
    assert(out.getSignal == true, "false or true = true")
    
    in1.setSignal(false)
    in2.setSignal(false)
    run
    assert(out.getSignal == false, "false or false = false")
    
  }
  
  test("or2 gate"){
    val in1,in2,out = new Wire
    orGate2(in1,in2,out)
    in1.setSignal(true)
    in2.setSignal(true)
    run
    assert(out.getSignal==true,"true or2gate true = true")
    
    in1.setSignal(true)
    in2.setSignal(false)
    run
    assert(out.getSignal==true,"true or2gate false = true")

    in1.setSignal(false)
    in2.setSignal(true)
    run
    assert(out.getSignal==true,"false or2gate true = true")
    
    in1.setSignal(false)
    in2.setSignal(false)
    run
    assert(out.getSignal==false,"false or2gate false = false")
    
    
  }
  
  //test base case with no selectors, output=input
  test("demux base case"){
    val in,out = new Wire
    in.setSignal(true)
    demux(in,Nil,List(out))
    run
    //println("demux: input:"+in.getSignal+" out:"+out.getSignal)
    assert(out.getSignal==true)
    in.setSignal(false)
    demux(in,Nil,List(out))
    run
    assert(out.getSignal===false)
  }
  
  
  test("demux recursive case"){
    val s,in,out0,out1 = new Wire
    in.setSignal(true)
    s.setSignal(true)
    demux(in,List(s),List(out0,out1))
    run
    println(out0.getSignal)
    
  }
}
