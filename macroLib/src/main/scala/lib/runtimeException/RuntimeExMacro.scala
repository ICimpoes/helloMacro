package lib.runtimeException

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object RuntimeExMacro {

  /**
   * next -> [[lib.quasiquotes.Quasiquotes]]
   */
  def throwRuntimeException(ex: Exception): Unit = macro throwExMacroImpl

  def throwExMacroImpl(c: blackbox.Context)(ex: c.Expr[Exception]) = {
    import c.universe._

    q"""
       throw $ex
     """
  }

}
