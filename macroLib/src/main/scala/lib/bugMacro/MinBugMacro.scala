package lib.bugMacro

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object MinBugMacro {

  def printlnMin(x: Int, y: Int): Unit = macro minMacroImpl

  /**
   * next -> [[lib.compComm.CompMacro]]
   */
  def minMacroImpl(c: blackbox.Context)(x: c.Expr[Int], y: c.Expr[Int]) = {
    import c.universe._
    q"""
       println(
          if ($x <= $y)
            "x = " + $x
          else
            "y = " + $y)

       println("x = " + $x + "; y = " + $y)
      """
  }

}
