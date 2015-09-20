import scala.reflect.runtime.universe._

import lib.lifting.Person

val person = Person("Bob", 18)

val q"lib.lifting.Person ($name, $age)" = q"$person"