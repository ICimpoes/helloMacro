package app.blackOrWhite

import lib.blackOrWhite.{WhiteBoxMacro, BlackBoxMacro}

object BlackOrWhiteApp extends App{

  //This one doesn't compile
  //val blackOption: Some[String] = BlackBoxMacro.getValueFromBlackBox("value")

  val blackOption: Option[String] = BlackBoxMacro.getValueFromBlackBox("value")

  val whiteOption: Some[String] = WhiteBoxMacro.getValueFromWhiteBox("value")

  println(blackOption)
  println(whiteOption)

}
