package io.m4ks

/**
 * Created by m4ks on 03/03/15.
 */
case class Position(x: Int, y:Int) {
  override def toString: String = x + ", " + y

  def inDirection(direction:Direction.Direction):Position = {
    direction match {
      case Direction.N => new Position(x, y+1)
      case Direction.S => new Position(x, y-1)
      case Direction.W => new Position(x-1, y)
      case Direction.E => new Position(x+1, y)
    }
  }
}
