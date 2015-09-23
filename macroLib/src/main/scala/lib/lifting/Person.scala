package lib.lifting

import scala.reflect.runtime.universe._

case class Person(name: String, age: Int)

/**
 * next -> [[lib.fieldAccess.FieldAccessMacro]]
 */
object Person {

  //Not a tree into a tree
  //It’s important to start with _root_ as otherwise there will still be a chance of name collision if 'lib' gets redefined at use-site of the macro.
  implicit val lift = Liftable[Person] { person =>
    q"_root_.lib.lifting.Person(${person.name}, ${person.age})"
  }

  implicit val unlift = Unliftable[Person] {
    case q"_root_.lib.lifting.Person(${name: String}, ${age: Int})" => Person(name, age)
  }
}