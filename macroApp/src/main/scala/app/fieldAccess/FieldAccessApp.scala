package app.fieldAccess

import lib.fieldAccess.FieldAccessMacro
import lib.lifting.Person

/**
 * next -> https://github.com/milessabin/shapeless/blob/master/core/src/main/scala/shapeless/generic.scala
 * next -> http://wix.github.io/accord/
 */

object FieldAccessApp extends App {

  val person = Person("OldBob", 118)
  val testInstance = TestClass("aa", 1)

  FieldAccessMacro.accessField(person, "age")
  FieldAccessMacro.accessField(person, "name")
  FieldAccessMacro.accessField(testInstance, "a")
  FieldAccessMacro.accessField(testInstance, "c")

  // These ones don't compile
//  FieldAccessMacro.accessField(person, "asdasda")
//  FieldAccessMacro.accessField(testInstance, "method")
//  FieldAccessMacro.accessField(testInstance, "value")

}
