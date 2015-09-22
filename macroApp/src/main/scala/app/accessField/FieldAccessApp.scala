package app.accessField

import lib.fieldAccess.FieldAccessMacro
import lib.lifting.Person

object FieldAccessApp extends App {

  implicit class rich[T](val a: T) {
    def getByFieldName(fieldName: String) = {
      FieldAccessMacro.accessField(person, fieldName)
    }
  }

  val person = Person("OldBob", 118)

  person.getByFieldName("name")

}
