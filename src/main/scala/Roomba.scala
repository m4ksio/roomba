import scala.collection.mutable.{ListBuffer, MutableList}


class Roomba(room:Room, private var x:Int, private var y:Int) {

  val dirtPiles = ListBuffer[DirtPile]()

  def setPosition(x:Int, y:Int) = {
    this.x = x
    this.y = y
  }

  def pickup(dirtPile:DirtPile) = {
    dirtPiles += dirtPile
  }

}
