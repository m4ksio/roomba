package io.m4ks

/**
 * Created by m4ks on 04/03/15.
 */

import java.io.BufferedReader

import io.m4ks.data.{Position, DirtPile, Direction}
import io.m4ks.interface.ISolverDataSource

import scala.io.Source

object InputFileReader extends ISolverDataSource {

  def get():SolverData = {

    val reader: BufferedReader = Source.fromFile("input.txt").bufferedReader()

    var width = 0
    var height = 0
    var startX = 0
    var startY = 0

    val dirtPiles = scala.collection.mutable.ArrayBuffer[Position]()

    val directions = scala.collection.mutable.ArrayBuffer[Direction.Direction]()

    var lineNumber = 1
    val firstLine = reader.readLine()
    try {
      val d = firstLine.split(" ").map(_.toInt)
      if (d.size != 2) {
        throw new NumberFormatException
      }

      width = d(0)
      height = d(1)
    } catch {
      case nfe: NumberFormatException => throw new IllegalStateException("First line with room dimensions has invalid format!")
      case npe: NullPointerException => throw new IllegalStateException("Cannot read first line")
    }

    lineNumber += 1
    var line = reader.readLine()
    try {
      val d = line.split(" ").map(_.toInt)
      if (d.size != 2) {
        throw new NumberFormatException
      }
      startX = d(0)
      startY = d(1)
    } catch {
      case nfe: NumberFormatException => throw new IllegalStateException("Second line with starting position has invalid format!")
      case npe: NullPointerException => throw new IllegalStateException("Cannot read second line")
    }

    var readDirts = true
    while (readDirts) {
      try {
        lineNumber += 1
        line = reader.readLine()
        val d = line.split(" ").map(_.toInt)
        if (d.size != 2) {
          throw new NumberFormatException
        }
        dirtPiles += Position(d(0),d(1))

      } catch {
        case npe: NullPointerException => throw new IllegalStateException(s"Cannot read ${lineNumber} line and no direction line encountered")
        case nfe: NumberFormatException => {
          if (line.matches("[NSWE]*")) {
            line.toCharArray.foreach { c =>
              directions += (c match {
                case 'N' => Direction.N
                case 'E' => Direction.E
                case 'S' => Direction.S
                case 'W' => Direction.W
              })
            }
            readDirts = false
          } else {
            throw new IllegalStateException(s"Unknown line format at line ${lineNumber}")
          }
        }
      }

    }


    SolverData(width, height, Position(startX, startY), dirtPiles.map(DirtPile(_)).toList, directions.toList)
  }

}
