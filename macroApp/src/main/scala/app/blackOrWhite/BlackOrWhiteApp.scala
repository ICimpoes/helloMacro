package app.blackOrWhite

import lib.blackOrWhite.{BlackBoxMacro, WhiteBoxMacro}

object BlackOrWhiteApp extends App{

  //These ones don't compile
  //val blackOption: Some[String] = BlackBoxMacro.getValueFromBlackBox("value")
  //val blackOption: Option[Int] = BlackBoxMacro.getValueFromBlackBox[Int]("value")

  val blackOption: Option[String] = BlackBoxMacro.getValueFromBlackBox("value")

  val whiteOption: Some[String] = WhiteBoxMacro.getValueFromWhiteBox("value")

  println(blackOption)
  println(whiteOption)

}
