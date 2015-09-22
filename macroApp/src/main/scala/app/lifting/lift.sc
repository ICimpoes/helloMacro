import lib.lifting.Person

import scala.reflect.runtime.universe._

val person = Person("Bob", 18)
val q"_root_.lib.lifting.Person ($name, $age)" = q"$person"
