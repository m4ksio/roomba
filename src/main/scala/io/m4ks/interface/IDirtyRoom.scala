package io.m4ks.interface

import io.m4ks.data.{Position, DirtPile}

/**
 * Created by m4ks on 04/03/15.
 */
trait IDirtyRoom extends IRoom {

  def hoover(position:Position):Option[DirtPile]

}
