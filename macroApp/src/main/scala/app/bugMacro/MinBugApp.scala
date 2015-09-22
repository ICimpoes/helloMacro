package app.bugMacro

import lib.bugMacro.MinBugMacro

object MinBugApp extends App {

  var varX = 0
  var varY = 0

  def x = { varX += 1; varX }
  def y = { varY += 1; varY }

  MinBugMacro.printlnMin(x, y)

}
