package lib.hello

import java.util.Date

import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context

object HelloMacro {

  def sayHello: String = macro sayHelloMacroImpl

  //Must be public
  def sayHelloMacroImpl(c: Context): c.Tree = {
    import c.universe._

    val now = new Date().toString

    q"""
        "Hi! This code was compiled at " +
        $now
     """
  }

}
