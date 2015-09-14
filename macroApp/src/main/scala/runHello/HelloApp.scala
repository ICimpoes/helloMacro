package runHello

import hello.{HelloMacro, HelloMethod}

object HelloApp extends App{

  println(s"Method - ${HelloMethod.sayHello}")

  println(s"Macro - ${HelloMacro.sayHello}")

}
