package lib.quasiquotes

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Quasiquotes {

  def isTypeOf[A](a: Any): Boolean = macro isTypeOfMacroImpl[A]

  def isTypeOfMacroImpl[A: c.WeakTypeTag](c: blackbox.Context)(a: c.Expr[Any]) = {
    import c.universe._

    val typeA = weakTypeOf[A]
    val caseCause1 = cq"""_ : $typeA => true"""
    val default = cq"""_ => false"""
 
    val cases = List(caseCause1, default)

    val result = q"""
       $a match { case ..$cases }
     """
    println(showCode(result))

    result

  }


}
