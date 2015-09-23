package app.compComm

import lib.compComm.CompMacro

object CompApp extends App {

  CompMacro.warn
  CompMacro.mustBePositive(0)
}
