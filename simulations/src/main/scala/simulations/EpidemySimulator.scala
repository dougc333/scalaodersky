package simulations

import math.random

class EpidemySimulator extends Simulator {

  def randomBelow(i: Int) = (random * i).toInt

  protected[simulations] object SimConfig {
    val population: Int = 300
    val roomRows: Int = 8
    val roomColumns: Int = 8

    // to complete: additional parameters of simulation
    val prevalenceRate: Double = 0.01
    val transmissibilityRate: Double = 0.4
  }

  import SimConfig._
 val numInitiallySick = (prevalenceRate * population).toInt
 val numHealthy = (population - numInitiallySick).toInt

 println("numInitiallySick:"+numInitiallySick)
 println("numHealthy:"+numHealthy)
 
  val persons: List[Person] =
    List.fill(numInitiallySick)(new Person(0) { infect() }) ++ List.fill(numHealthy)(new Person(0))
    
    // to complete: construct list of persons
def findPeopleByRowCol(r: Int, c: Int): List[Person] =
    persons filter ((p) => (r, c) == (p.row, p.col))

  def deadOrSick(p: Person) = p.dead || p.sick
  
  
  
  
  class Person (val id: Int) {
    var infected = true
    var sick = false
    var immune = false
    var dead = false

    // demonstrates random number generation
    var row: Int = randomBelow(roomRows)
    var col: Int = randomBelow(roomColumns)

    //
    // to complete with simulation logic
    //
    def moveNextRoom() {
      val nextCandidates: List[(Int, Int)] =
        List((1, 0), (0, 1), (-1, 0), (0, -1))
          .filter { case (r, c) =>
            !(findPeopleByRowCol(r + row, c + col).exists(deadOrSick)) }

      if(!nextCandidates.isEmpty) {
        val (dx, dy) = nextCandidates(randomBelow(nextCandidates.size))
        row = (row + roomRows + dx) % roomRows
        col = (col + roomColumns + dy) % roomColumns
      }
    }

    def infectInRoom() {
      val peopleInCurrentRoom = findPeopleByRowCol(row, col)
      if(peopleInCurrentRoom.exists((p) => p.infected) && !infected) {
        if(random <= transmissibilityRate) infect()
      }
    }

    def setupNextMovement() {
      afterDelay(1 + randomBelow(4)) {
        if(!dead) {
          moveNextRoom()
          if(!infected && !immune) {
            infectInRoom()
          }
          setupNextMovement()
        }
      }
    }
    def infect() {
      infected = true
      afterDelay(6) { sick = true }
     // afterDelay(14) { if (randomBelow(4) == 0) { dead = true } }
     // afterDelay(16) { if(!dead) { sick = false ; immune = true } }
     // afterDelay(18) {
     //   if(!dead && immune) {
     //     immune = false
     //     infected = false
     //   }
     // }
    }
  }
}
