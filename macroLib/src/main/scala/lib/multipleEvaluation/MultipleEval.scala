package lib.multipleEvaluation

import scala.reflect.macros.blackbox

object MultipleEval {

  def min(x: Int, y: Int) = macro minMacroImpl

  def minMacroImpl(c :blackbox.Context)(x: c.Expr[Int], y: c.Expr[Int]) = {
    import c.universe._
    q""
  }

}
