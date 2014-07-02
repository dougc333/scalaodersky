package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._


@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) { case (block, move) => move match {
        case Left => block.left
        case Right => block.right
        case Up => block.up
        case Down => block.down
      }
    }
  }

  trait SimpleLevel extends SolutionChecker{
    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right,Down,Right)
  }
  
  trait Level1 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }
  
  test("terrain function level 1") {
    new Level1 {
//      println(terrain(Pos(0,0)))
//      println(terrain(Pos(4,11)))
//      println(terrain(Pos(1,1)))
//      println(terrain(Pos(4,7)))
//      println(terrain(Pos(6,1)))
      
      assert(terrain(Pos(0,0)), "0,0")
      assert(!terrain(Pos(4,11)), "4,11")
      assert(terrain(Pos(1,1)), "1,1")
      assert(terrain(Pos(4,7)), "4,7")
      assert(!terrain(Pos(6,1)), "6,1")

    }
  }

  
  test("findChar level 1") {
    new Level1 {
    //  println("startPos:"+startPos)
    //  println("goal:"+goal)
      assert(startPos == Pos(1,1))
      assert(goal == Pos(4,7))
      //should be Pos(0,1)
      val foo = findChar('-', Vector(Vector('o','o'),Vector('-','o')))
      //println("foo:"+foo)
      assert(foo==Pos(1,0))
      //out of bounds should be Pos(-1,-1) 
      val foo1 = findChar('A', Vector(Vector('o','o'),Vector('-','o')))
      //println("foo1:"+foo1)
      assert(foo1==Pos(-1,-1))
    }
  }
  
  test("isStanding") {
    new Level1 {
      val position1 = startPos
      val position2 = startPos
      val standingBlock = new Block(startPos,startPos)
     // println(testStartBlock.isStanding)
     // println(testStartBlock.down.isStanding)
      assert(standingBlock.isStanding == true)
      assert(standingBlock.down.isStanding == false)
      assert(standingBlock.up.isStanding == false)
      assert(standingBlock.left.isStanding == false)
      assert(standingBlock.right.isStanding == false)

      val notStandingBlock: Block = new Block(Pos(0,0), Pos(0,1))
      assert(notStandingBlock.isStanding == false)
      assert(notStandingBlock.down.isStanding == false)
      assert(notStandingBlock.up.isStanding == false)
      assert(notStandingBlock.left.isStanding == true)
      assert(notStandingBlock.right.isStanding == false)
    }
  }
  
  
  test("optimal solution for level 1") {
    new Level1 {
      val boo=newNeighborsOnly(
      Set( (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
           (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
         ).toStream,
      Set(Block(Pos(1,2),Pos(1,3)), Block(Pos(1,1),Pos(1,1)))
   )
     // println(boo)
      //println(solve(solution))
     // println("goal:"+goal)
     // println(Block(goal,goal))
      assert(solve(solution) == Block(goal, goal))
      
    }
  }
  
  test("isLegal") {
    new Level1 {
      val position1 = startPos
      val position2 = startPos
      val testStartBlock: Block = new Block(position1, position2)
      assert(testStartBlock.isLegal == true)
      assert(testStartBlock.down.isLegal == true)

    }
  }
  
  test("neighbors") {
    new Level1 {
      assert(startBlock.neighbors == List((Block(Pos(1,-1),Pos(1,0)),Left), (Block(Pos(1,2),Pos(1,3)),Right), (Block(Pos(-1,1),Pos(0,1)),Up), (Block(Pos(2,1),Pos(3,1)),Down)))

    }
  }

  test("legal neighbors") {
    new Level1 {
      assert(startBlock.legalNeighbors == List((Block(Pos(1,2),Pos(1,3)),Right), (Block(Pos(2,1),Pos(3,1)),Down)))
    }
  }

  test("done"){
    new Level1 {
      val legalBlock = new Block(Pos(1,2),Pos(1,3))
      val illegalBlock =  new Block(Pos(-1,-1),Pos(-1,-1))

      assert(done(startBlock) == false)
      assert(done(legalBlock) == false)
      assert(done(illegalBlock) == false)
//      assert(done(endBlock) == true)

    }
  }
  
  
  test("neighbors with history"){
    new Level1 {

    assert(neighborsWithHistory(
        Block(Pos(1,1),Pos(1,1)), List()).toSet ==
        Set(
          (Block(Pos(1,2),Pos(1,3)), List(Right)),
          (Block(Pos(2,1),Pos(3,1)), List(Down))
        ))

    assert(neighborsWithHistory(
         Block(Pos(1,1),Pos(1,1)), List(Left,Up)).toSet ==
        Set(
            (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
             (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
            ))

    assert(neighborsWithHistory(
                Block(Pos(1,2),Pos(1,3)), List(Right)).toSet ==
                 Set(
                      (Block(Pos(2,2),Pos(2,3)), List(Down,Right)),
                      (Block(Pos(1,4),Pos(1,4)), List(Right,Right)),
                      (Block(Pos(1,1),Pos(1,1)), List(Left,Right))
                    ))


    }

  }

 test("new neighbors only"){
    new Level1 {

      assert(newNeighborsOnly(
        Set(
          (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
          (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
        ).toStream,
        Set(Block(Pos(1,2),Pos(1,3)), Block(Pos(1,1),Pos(1,1)))) ==
        Set(
          (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
        ).toStream)

    }

  }
 
 test("optimal solution length for level 1") {
    new Level1 {
   //   println("soln level1"+solution.length)
   //   println("soln level1"+optsolution.length)
   //   println("soln level1"+solution)
   //   println("soln level1"+optsolution)

      assert(solution.length == optsolution.length)
    }
  }
  
 test("optimal solution"){
    new SimpleLevel {
    //	println(solution.length)
    //	println(optsolution.length)
    //	println(solution)
   // 	println(optsolution)
//      assert(solution.length == optsolution.length)
//      assert(solution == optsolution)

    }

  } 
 
  /**
  test("neighborsWithHistory"){
    new Level1{
      val foo = neighborsWithHistory(Block(Pos(1,1),Pos(1,1)),List(Left,Up))
      println("neighborsWithHistory:"+foo)
    }
  }
  
  
  
  

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }
  */
}
