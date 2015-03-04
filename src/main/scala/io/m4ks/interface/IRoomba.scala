package io.m4ks.interface

import io.m4ks.data.{Position, DirtPile, Direction}

import scala.collection.mutable.ListBuffer

/**
 * Created by m4ks on 04/03/15.
 */
trait IRoomba {
  def position:Position

  def getDirtPile:List[DirtPile]

  def move(direction:Direction.Direction)
}
