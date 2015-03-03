package io.m4ks

import scala.collection.mutable.ListBuffer

class Roomba(room:DirtyRoom, startingPosition:Position) {

  if (!room.isValidPosition(startingPosition)) {
    throw new IllegalArgumentException("Position [{},{}] is not valid!".format(startingPosition))
  }

  val dirtPiles = ListBuffer[DirtPile]()
  private var _position:Position = startingPosition

  def move(direction:Direction.Direction): Unit = {
    val proposedPosition = _position.inDirection(direction)
    if (room.isValidPosition(proposedPosition)) {
      _position = proposedPosition
    }
    room.hoover(_position) foreach( dirtPiles += _)
  }

  def position = _position

}
