package app.ast

import lib.ast.ASTMacro

object ASTApp extends App {

  ASTMacro.swapPrint("a", "b")
  println()
  ASTMacro.swapPrint("prefix", "suffix")

}
