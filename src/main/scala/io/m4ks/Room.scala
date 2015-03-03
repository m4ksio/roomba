package io.m4ks

/**
 * Created by m4ks on 03/03/15.
 */
case class Room(width: Int, height: Int) {

  if (width <= 0) {
    throw new IllegalArgumentException("Width must be positive")
  }

  if (height <= 0) {
    throw new IllegalArgumentException("Height must be positive")
  }

  def isValidPosition(p:Position): Boolean = {
    p.x >= 0 && p.x < width && p.y >= 0 && p.y < height
  }

}
