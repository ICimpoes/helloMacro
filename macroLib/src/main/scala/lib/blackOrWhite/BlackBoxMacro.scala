package lib.blackOrWhite

import scala.reflect.macros.blackbox.{Context => BlackBoxContext}
import scala.language.experimental.macros

object BlackBoxMacro {

  def getValueFromBlackBox[A](value: A): Option[A] = macro getValueMacroImpl[A]

  def getValueMacroImpl[A: c.WeakTypeTag](c: BlackBoxContext)(value: c.Tree) = {
    import c.universe._
    q"${Some(value)}"
  }

}
