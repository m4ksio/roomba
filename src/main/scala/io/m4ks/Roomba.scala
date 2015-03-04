package io.m4ks

import io.m4ks.data.{Position, DirtPile, Direction}
import io.m4ks.interface.{IRoomba, IDirtyRoom}

import scala.collection.mutable.ListBuffer

class Roomba(room:IDirtyRoom, startingPosition:Position) extends IRoomba {

  if (!room.isValidPosition(startingPosition)) {
    throw new IllegalArgumentException("Position [{},{}] is not valid!".format(startingPosition))
  }

  val _dirtPiles = ListBuffer[DirtPile]()
  private var _position:Position = startingPosition
  hoover(_position)

  private def hoover(p:Position) = {
    room.hoover(_position) foreach( _dirtPiles += _)
  }

  override def move(direction:Direction.Direction): Unit = {
    val proposedPosition = _position.inDirection(direction)
    if (room.isValidPosition(proposedPosition)) {
      _position = proposedPosition
    }
    hoover(_position)
  }

  override def position = _position

  override def getDirtPile:List[DirtPile] = {
    _dirtPiles.toList
  }

}
