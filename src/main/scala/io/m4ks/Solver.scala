package io.m4ks

import io.m4ks.data.{Position, DirtPile, Direction}
import io.m4ks.interface.{IRoomba, IDirtyRoom}

/**
 * Created by m4ks on 04/03/15.
 */
case class SolverData(roomWidth: Int, roomHeight:Int, startingPosition:Position, dirtPiles:List[DirtPile], directions:List[Direction.Direction])
case class SolverResult(endPosition:Position, dirtCount:Int)

class Solver extends {

  def getDirtyRoom(width:Int, height:Int, dirtPiles:List[DirtPile]): IDirtyRoom = {
    new DirtyRoom(width, height, dirtPiles)
  }

  def getRoomba(room:IDirtyRoom, startingPosition:Position): IRoomba = {
    new Roomba(room, startingPosition)
  }

  def solve(sd:SolverData):SolverResult = {
    
    val room:IDirtyRoom = getDirtyRoom(sd.roomWidth, sd.roomHeight, sd.dirtPiles)
    val roomba:IRoomba = getRoomba(room, sd.startingPosition)

    sd.directions.foreach(roomba.move)

    SolverResult(roomba.position, roomba.getDirtPile.size)
  }
}
