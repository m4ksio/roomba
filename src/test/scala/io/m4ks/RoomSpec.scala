/**
 * Created by m4ks on 03/03/15.
 */
package io.m4ks

import org.scalatest._

import scala.collection.mutable.Stack

class RoomSpec extends FlatSpec with Matchers {

  "Room" should "throw IllegalArgumentException with non-positive dimensions" in {
    an [IllegalArgumentException] should be thrownBy Room(-1, 5)
    an [IllegalArgumentException] should be thrownBy Room(-5, 0)
    an [IllegalArgumentException] should be thrownBy Room(0, 0)
  }

  it should "return valid for position inside its rectangle" in {
    val room: Room = Room(4, 4)
    room.isValidPosition(Position(2,2)) shouldEqual true
    room.isValidPosition(Position(0,0)) shouldEqual true
    room.isValidPosition(Position(3,1)) shouldEqual true
  }

  it should "return invalid for position with x greater or equal to width" in {
    val room: Room = Room(4, 4)
    room.isValidPosition(Position(5,2)) shouldEqual false
    room.isValidPosition(Position(4,0)) shouldEqual false
    room.isValidPosition(Position(7,1)) shouldEqual false
  }

  it should "return invalid for position with y greater or equal to height" in {
    val room: Room = Room(4, 4)
    room.isValidPosition(Position(1,7)) shouldEqual false
    room.isValidPosition(Position(1,8)) shouldEqual false
    room.isValidPosition(Position(2,4)) shouldEqual false
  }

  it should "always return invalid for position with negative coordinates" in {
    val room = Room(5, 5)
    room.isValidPosition(Position(-1, -1)) shouldBe false
    room.isValidPosition(Position(-1, 1)) shouldBe false
    room.isValidPosition(Position(1, -1)) shouldBe false
  }
}
