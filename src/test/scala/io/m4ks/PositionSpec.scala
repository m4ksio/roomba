package io.m4ks

import io.m4ks.data.{Position, Direction}
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by m4ks on 03/03/15.
 */
class PositionSpec extends FlatSpec with Matchers {

  "Position" should "increase Y for North direction" in {
    Position(0, 0).inDirection(Direction.N) shouldBe Position(0, 1)
  }

  it should "decrease Y for South direction" in {
    Position(0, 0).inDirection(Direction.S) shouldBe Position(0, -1)
  }

  it should "decrease X for West direction" in {
    Position(0, 0).inDirection(Direction.W) shouldBe Position(-1, 0)
  }

  it should "increase X for East direction" in {
    Position(0, 0).inDirection(Direction.E) shouldBe Position(1, 0)
  }

}
