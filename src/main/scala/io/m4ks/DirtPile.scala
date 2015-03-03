package io.m4ks

/**
 * Created by m4ks on 03/03/15.
 */
case class DirtPile(position:Position)
object DirtPile {
  def apply(x:Int, y:Int):DirtPile = DirtPile(Position(x, y))

}
