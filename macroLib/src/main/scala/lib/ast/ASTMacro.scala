package lib.ast

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object ASTMacro {

  def swapPrint(string1: String, string2: String): Unit = macro printMacroImpl

  //Must be public
  def printMacroImpl(c: blackbox.Context)(string1: c.Expr[String], string2: c.Expr[String]) = {
    import c.universe._

    val Literal(Constant(s1: String)) = string1.tree
    val Literal(Constant(s2: String)) = string2.tree

    Apply(Ident(TermName("print")), List(Apply(Select(Literal(Constant(s2)), TermName("$plus")), List(Literal(Constant(s1))))))
  }

}
