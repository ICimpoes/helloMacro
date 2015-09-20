package app.quasiquotes

import lib.quasiquotes.Quasiquotes

object QuasiquotesApp extends App {

  println(Quasiquotes.isTypeOf[Int](1))

}
