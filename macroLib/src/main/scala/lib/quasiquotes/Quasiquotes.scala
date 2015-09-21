package lib.quasiquotes

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Quasiquotes {

  def compare(a: Any, b: Any): Unit = macro compareMacroImpl

  def compareMacroImpl(c: blackbox.Context)(a: c.Expr[Any], b: c.Expr[Any]) = {
    import c.universe._

    val intType = tq"Int"
    val pattern = pq"(x: $intType, y: $intType)"
    val gtCase = cq"""$pattern if (x > y) => println(x + " > " + y)"""
    val eCase = cq"""$pattern if (x == y) => println(x + " == " + y)"""
    val ltCase = cq"""$pattern if (x < y) => println(x + " < " + y)"""

    val cases = List(gtCase, eCase, ltCase)

    //it's like String interpolation, but we're not building a string, we're building AST
    val result = q"""
       ($a, $b) match { case ..$cases }
     """
    println(showCode(result))

    result

  }


}
