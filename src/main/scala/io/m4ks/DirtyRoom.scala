/**
 * Created by m4ks on 03/03/15.
 */
package io.m4ks

import io.m4ks.data.{Position, DirtPile}
import io.m4ks.interface.IDirtyRoom

class DirtyRoom(width: Int, height:Int, dirtPiles:List[DirtPile]) extends RectangleRoom(width, height) with IDirtyRoom {

  private val dirtsMap = scala.collection.mutable.HashMap[Position, DirtPile]()

  dirtPiles.foreach(dp => {
    if (!isValidPosition(dp.position)) {
      throw new IllegalArgumentException(s"DirtPile at [${dp.position}] has invalid position")
    }
    dirtsMap(dp.position) = dp
  })

  def hoover(position:Position):Option[DirtPile] = {
    dirtsMap.remove(position)
  }


}
