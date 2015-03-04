package io.m4ks.interface

import io.m4ks.SolverData

/**
 * Created by m4ks on 04/03/15.
 */
trait ISolverDataSource {

  def get():SolverData
}
