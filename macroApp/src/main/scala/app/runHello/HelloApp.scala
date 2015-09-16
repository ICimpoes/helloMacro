package app.runHello

import java.util.Date

import lib.hello.{HelloMacro, HelloMethod}

object HelloApp extends App {

  println(new Date().toString)

  println(s"Method - ${HelloMethod.sayHello}")

  println(s"Macro - ${HelloMacro.sayHello}")

}
