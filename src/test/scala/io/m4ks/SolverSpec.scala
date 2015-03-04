package io.m4ks

import io.m4ks.data.Direction
import io.m4ks.data.Direction.Direction
import io.m4ks.data.{Position, DirtPile, Direction}
import io.m4ks.interface.{IRoomba, IDirtyRoom, ISolverDataSource}
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by m4ks on 03/03/15.
 */
class SolverSpec extends FlatSpec with Matchers {

  object Solver extends Solver {

    val roombaMoves = scala.collection.mutable.ArrayBuffer[Direction.Direction]()

    override def getRoomba(room: IDirtyRoom, startingPosition: Position): IRoomba = {

      new Roomba(room, startingPosition) {

        override def move(direction: Direction): Unit = {
          roombaMoves += direction
          super.move(direction)
        }
      }
    }

    override def getDirtyRoom(width: Int, height: Int, dirtPiles: List[DirtPile]): IDirtyRoom = super.getDirtyRoom(width, height, dirtPiles)
  }

  "Solver" should "pass all data and move Roomba around" in {

    val directions: List[Direction.Value] = List(
      Direction.N,
      Direction.N,
      Direction.N,
      Direction.N,
      Direction.N
    )
    val data = SolverData(5, 5, Position(0, 0), List(), directions)

    val result: SolverResult = Solver.solve(data)

    Solver.roombaMoves shouldEqual directions

    result.endPosition shouldEqual Position(0, 4)

  }



}
