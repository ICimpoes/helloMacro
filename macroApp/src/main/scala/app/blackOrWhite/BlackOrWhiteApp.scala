package app.blackOrWhite

import lib.blackOrWhite.{WhiteBoxMacro, BlackBoxMacro}

object BlackOrWhiteApp extends App{

  val a: Some[String] = BlackBoxMacro.getValueFromWhiteBox("value")

  val b: Some[String] = WhiteBoxMacro.getValueFromWhiteBox("value")

}
