package io.m4ks.interface

import io.m4ks.data.Position

/**
 * Created by m4ks on 04/03/15.
 */
trait IRoom {
  def isValidPosition(p:Position): Boolean
}
