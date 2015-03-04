package io.m4ks

import io.m4ks.data.{Position, DirtPile, Direction}
import io.m4ks.interface.IDirtyRoom
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

/**
 * Created by m4ks on 03/03/15.
 */
class RoombaSpec extends FlatSpec with Matchers with BeforeAndAfterEach {

  class TestDirtyRoom extends IDirtyRoom {

    private val room = RectangleRoom(5, 5)
    val validatedPosition = scala.collection.mutable.ArrayBuffer[Position]()
    val hooveredPosition = scala.collection.mutable.ArrayBuffer[Position]()

    override def hoover(position: Position): Option[DirtPile] = {
      hooveredPosition += position
      None
    }

    override def isValidPosition(p: Position): Boolean = {
      validatedPosition += p
      room.isValidPosition(p)
    }
  }

  var room:TestDirtyRoom = _
  val startingPosition: Position = Position(0, 0)
  var roomba:Roomba = _

  override protected def beforeEach(): Unit = {
    room = new TestDirtyRoom()
    roomba = new Roomba(room, startingPosition)
  }

  "Roomba" should "refuse invalid initial position" in {
    room = new TestDirtyRoom()
    an [IllegalArgumentException] should be thrownBy new Roomba(room, Position(-1, -1))
    room.validatedPosition shouldEqual List(Position(-1,-1))
  }

  it should "check its initial position" in {
    roomba shouldNot be(null)
    room.validatedPosition shouldEqual List(startingPosition)
  }

  it should "validate new position before moving" in {
    val firstMoveDirection: Direction.Value = Direction.S

    roomba.move(firstMoveDirection)
    room.validatedPosition shouldEqual List(startingPosition, Position(0,-1))
  }

  it should "hover any position it enters" in {
    roomba.move(Direction.N)
    room.hooveredPosition.contains(Position(0,1)) shouldBe true
    room.validatedPosition shouldEqual List(startingPosition, Position(0,1))

    roomba.move(Direction.N)
    room.hooveredPosition.contains(Position(0,2)) shouldBe true
    room.validatedPosition shouldEqual List(startingPosition, Position(0,1), Position(0,2))
  }

  it should "hoover starting position" in {
    room.hooveredPosition shouldEqual List(startingPosition)
  }

  it should "keep every DirtPile hovered" in {

    object room extends TestDirtyRoom {

      val dirts = scala.collection.mutable.HashMap[Position, DirtPile]()
      val hooveredDirts = scala.collection.mutable.ArrayBuffer[DirtPile]()

      //every field containt a dirt pile, nonremovable
      for (i <- 0 to 4; j <- 0 to 4) {
        dirts.put(Position(i, j), DirtPile(Position(i, j)))
      }

      override def hoover(position: Position): Option[DirtPile] = {
        super.hoover(position)
        val hoovered = dirts.get(position)
        hoovered.foreach(hooveredDirts += _)
        hoovered
      }
    }
    roomba = new Roomba(room, startingPosition)

    roomba.move(Direction.N)
    room.hooveredDirts shouldEqual List(DirtPile(startingPosition), DirtPile(0, 1))

    roomba.move(Direction.E)
    room.hooveredDirts shouldEqual List(DirtPile(startingPosition), DirtPile(0, 1), DirtPile(1,1))

    roomba.move(Direction.W)
    room.hooveredDirts shouldEqual List(DirtPile(startingPosition), DirtPile(0, 1), DirtPile(1,1), DirtPile(0, 1))

    roomba._dirtPiles shouldEqual room.hooveredDirts
  }


}
