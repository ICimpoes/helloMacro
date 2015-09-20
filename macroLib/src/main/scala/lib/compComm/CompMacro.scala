package lib.compComm

import scala.reflect.macros.blackbox
import scala.language.experimental.macros

object CompMacro {

  def mustBePositive(x: Int): Unit = macro abortMacroImpl

  def warn: Unit = macro warnMacroImpl


  def abortMacroImpl(c: blackbox.Context)(x: c.Expr[Int]): c.Tree = {
    import c.universe._

    val Literal(Constant(i: Int)) = x.tree
    if (i < 0) c.abort(c.enclosingPosition, s"$i must be Positive")
    q""
  }

  def warnMacroImpl(c: blackbox.Context): c.Tree = {
    import c.universe._

    c.warning(c.enclosingPosition, "WARNING!")
    q""
  }



}
