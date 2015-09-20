package lib.lifting

import scala.reflect.runtime.universe._

case class Person(name: String, age: Int)

object Person {
  implicit val lift = Liftable[Person] { person =>
    q"_root_.lib.lifting.Person(${person.name}, ${person.age})"
  }

  implicit val unlift = Unliftable[Person] {
    case q"_root_.lib.lifting.Person(${name: String}, ${age: Int})" => Person(name, age)
  }
}