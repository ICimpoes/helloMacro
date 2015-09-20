package lib.blackOrWhite

import scala.language.experimental.macros
import scala.reflect.macros.blackbox.{Context => BlackBoxContext}

object BlackBoxMacro {

  def getValueFromBlackBox[A](value: A): Option[A] = macro getValueMacroImpl[A]

  def getValueMacroImpl[A: c.WeakTypeTag](c: BlackBoxContext)(value: c.Expr[A]) = {
    import c.universe._
    q"${Some(value)}"
  }

}
