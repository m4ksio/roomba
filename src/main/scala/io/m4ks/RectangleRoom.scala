package io.m4ks

import io.m4ks.data.Position
import io.m4ks.interface.IRoom

/**
 * Created by m4ks on 03/03/15.
 */
case class RectangleRoom(width: Int, height: Int) extends IRoom {

  if (width <= 0) {
    throw new IllegalArgumentException("Width must be positive")
  }

  if (height <= 0) {
    throw new IllegalArgumentException("Height must be positive")
  }

  override def isValidPosition(p:Position): Boolean = {
    p.x >= 0 && p.x < width && p.y >= 0 && p.y < height
  }

}
