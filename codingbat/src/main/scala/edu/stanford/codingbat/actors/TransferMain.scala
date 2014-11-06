package edu.tanford.codingbat.actors

import akka.actor.Actor
import akka.actor.Props
import akka.event.LoggingReceive

class TransferMain extends Actor{
  val accountA = context.actorOf(Props[BankAccount], "accountA")
  val accountB = context.actorOf(Props[BankAccount], "accountB")
  
  accountA ! BankAccount.Deposit(100)
  
  def receive = LoggingReceive{
    case BankAccount.Done => transfer(50)
  }
  
  def transfer(amount:BigInt):Unit={
    val transaction = context.actorOf(Props[WireTransfer],"transfer")
    transaction ! WireTransfer.transfer(accountA, accountB, amount)
    context.become(LoggingReceive{
      case WireTransfer.Done=>
        println(""success)
        context.stop(self)
    })
  }
}