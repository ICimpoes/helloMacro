package lib.ast

import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros

object ASTMacro {

  def swapPrint(string1: String, string2: String): Unit = macro printMacroImpl

  //Must be public
  def printMacroImpl(c: Context)(string1: c.Expr[String], string2: c.Expr[String]) = {
    import c.universe._

    val Literal(Constant(s1: String)) = string1.tree
    val Literal(Constant(s2: String)) = string2.tree

    q"print($s2 + $s1)"
  }

}
