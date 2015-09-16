package lib.blackOrWhite

import scala.reflect.macros.whitebox.{Context => WhiteBoxContext}
import scala.language.experimental.macros

object WhiteBoxMacro {

  def getValueFromWhiteBox[A](value: A): Option[A] = macro getValueMacroImpl[A]

  def getValueMacroImpl[A: c.WeakTypeTag](c: WhiteBoxContext)(value: c.Tree) = {
    import c.universe._
    q"${Some(value)}"
  }

}
