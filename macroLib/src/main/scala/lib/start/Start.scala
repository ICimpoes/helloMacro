package lib.start

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Start {

  /**
   * next -> [[lib.ast.ASTMacro]]
   */
  def defMacro(par: String) = macro defMacroImpl

  //Must be public
  //c - context argument that contains information collected by the compiler at the call side
  def defMacroImpl(c: blackbox.Context)(par: c.Expr[String]) = ???

}
