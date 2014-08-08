package simulations

import common._

class Wire {
  private var sigVal = false
  private var actions: List[Simulator#Action] = List()

  def getSignal: Boolean = sigVal
  
  def setSignal(s: Boolean) {
    if (s != sigVal) {
      sigVal = s
      actions.foreach(action => action())
    }
  }

  def addAction(a: Simulator#Action) {
    actions = a :: actions
    a()
  }
}

abstract class CircuitSimulator extends Simulator {

  val InverterDelay: Int
  val AndGateDelay: Int
  val OrGateDelay: Int

  def probe(name: String, wire: Wire) {
    wire addAction {
      () => afterDelay(0) {
        println(
          "  " + currentTime + ": " + name + " -> " +  wire.getSignal)
      }
    }
  }

  def inverter(input: Wire, output: Wire) {
    def invertAction() {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) { output.setSignal(!inputSig) }
    }
    input addAction invertAction
  }

  def andGate(a1: Wire, a2: Wire, output: Wire) {
    def andAction() {
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(AndGateDelay) { output.setSignal(a1Sig & a2Sig) }
    }
    a1 addAction andAction
    a2 addAction andAction
  }

  //
  // to complete with orGates and demux...
  //

  def orGate(a1: Wire, a2: Wire, output: Wire) {
    def orAction(){
      val a1Sig = a1.getSignal
      val a2Sig = a2.getSignal
      afterDelay(OrGateDelay) {output.setSignal(a1Sig || a2Sig)}
    }
    a1 addAction orAction
    a2 addAction orAction
  }
  
  //
  //~(a||b)==(~A)&&(~B)
  //
  def orGate2(a1: Wire, a2: Wire, output: Wire) {
      val a3,a4,a5=new Wire
      inverter(a1,a3)
      inverter(a2,a4)
      andGate(a3,a4,a5)
      inverter(a5,output)
  }

  // demux test case: 
  // base case: 0 in list 
  // 
  def demux(in: Wire, c: List[Wire], out: List[Wire]) {
    c match{
      case Nil => Nil; println("what is base case with 0 wires?")
      case x::xs => println("x:"+x+" xs:"+xs)
        val a,b,c = new Wire
        val splitList = out.splitAt(out.size/2)
        inverter(x,c)
        andGate(in,x,a)
        andGate(in,c,b)
        demux(a,xs,splitList._1)
        demux(b,xs,splitList._2)
    }
    
  }

}

object Circuit extends CircuitSimulator {
  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5

  def andGateExample {
    val in1, in2, out = new Wire
    andGate(in1, in2, out)
    probe("in1", in1)
    probe("in2", in2)
    probe("out", out)
    in1.setSignal(false)
    in2.setSignal(false)
    run

    in1.setSignal(true)
    run

    in2.setSignal(true)
    run
  }

  //
  // to complete with orGateExample and demuxExample...
  // and why do we need this? 
}

object CircuitMain extends App {
  // You can write tests either here, or better in the test class CircuitSuite.
  // what is the point of this code vs. the unit tests? This is functional for delay? 
  Circuit.andGateExample
}
