package io.m4ks

/**
 * Created by m4ks on 03/03/15.
 */
object Main {

  def main (args: Array[String]) {

    val solver = new Solver()

    val result: SolverResult = solver.solve(InputFileReader.get())

    println(s"${result.endPosition.x} ${result.endPosition.y}")
    println(result.dirtCount)

  }

}
