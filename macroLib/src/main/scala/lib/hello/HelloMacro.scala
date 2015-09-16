package lib.hello

import java.util.Date

import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros

object HelloMacro {

  def sayHello: String = macro sayHelloMacroImpl

  def sayHelloMacroImpl(c: Context): c.Tree = {
    import c.universe._

    val now = new Date().toString

    q"""
        "Hi! This code was compiled at " +
        $now
     """
  }

}
