/**
 * Created by m4ks on 02/03/15.
 */
case class Room(width: Int, height: Int) {

  def isValidPosition(x: Int, y:Int): Boolean = {
    x >= 0 && x <= width && y >= 0 && y <= height
  }

}
