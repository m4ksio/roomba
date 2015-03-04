/**
 * Created by m4ks on 03/03/15.
 */
package io.m4ks

import io.m4ks.data.{Position, DirtPile}
import org.scalatest._

class DirtyRoomSpec extends FlatSpec with Matchers {

  "DirtyRoom" should "accept DirtPiles with valid coordinates" in {
    val room: DirtyRoom = new DirtyRoom(5, 5, List(DirtPile(0, 0), DirtPile(1, 1), DirtPile(2, 2)))
    room shouldNot be(null)
  }

  it should "throw IllegalArgumentException with DirtPiles with invalid coordinates" in {
    an [IllegalArgumentException] should be thrownBy new DirtyRoom(4, 4, List(DirtPile(-1, 5)))
  }

  it should "throw IllegalArgumentException if any of  DirtPiles has invalid coordinates" in {
    an [IllegalArgumentException] should be thrownBy new DirtyRoom(4, 4, List(DirtPile(0, 0), DirtPile(-1, 5), DirtPile(1, 1)))
  }

  "Hoovering" should "return DirtPile if position matches, but only once" in {
    val dirtPosition = Position(1,1)
    val room: DirtyRoom = new DirtyRoom(5, 5, List(DirtPile(dirtPosition)))
    room.hoover(dirtPosition) shouldBe Some(DirtPile(dirtPosition))

    room.hoover(dirtPosition) shouldBe None
  }

  it should "return None if position does not match" in {
    val dirtPosition = Position(1,1)
    val room: DirtyRoom = new DirtyRoom(5, 5, List())
    room.hoover(dirtPosition) shouldBe None
  }


}
