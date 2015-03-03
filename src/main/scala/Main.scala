/**
 * Created by m4ks on 02/03/15.
 */
object Main {

  def main (args: Array[String]) {

    println("abc")

    val room: Room = Room(5, 5)

    val dirt = List(DirtPile(1, 1), DirtPile(2, 2), DirtPile(3, 3), DirtPile(4, 4), DirtPile(5, 5))

    val directions = List(Direction.N, Direction.N, Direction.N)

    val roomba: Roomba = new  Roomba(room, 0, 0)




  }

}
