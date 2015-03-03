package io.m4ks

/**
 * Created by m4ks on 03/03/15.
 */
object Main {

  def main (args: Array[String]) {

    val dirts = List(DirtPile(1, 1), DirtPile(2, 2), DirtPile(3, 3), DirtPile(4, 4))

    val room = new DirtyRoom(5, 5, dirts)

    val directions = List(
      Direction.N,
      Direction.N,
      Direction.N,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.E,
      Direction.W,
      Direction.W,
      Direction.W,
      Direction.W,
      Direction.W,
      Direction.W,
      Direction.W,
      Direction.E
    )

    val roomba: Roomba = new  Roomba(room, Position(0, 0))

    directions.foreach(roomba.move)

    println(roomba.position)

    println(roomba.dirtPiles.size)



  }

}
