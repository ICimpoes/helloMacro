import scala.reflect.runtime.universe._
val q = q"1 + 1"
val C =
  q"""Class C(y: Int) {
     def plusY(x: Int): Int = x + y
     }"""
showRaw(C)
showRaw(q)
//
//--------------------
showRaw(reify{def xPlus1(x: Int) = x + 1}.tree)

//val q"i am $what" = q"i am { a quasiquote }"
//
//showRaw(q"List[Int]")
//showRaw(tq"List[Int]")
//
//showRaw(pq"List(a, b)")
//showRaw(q"List(a, b)")


showRaw(reify{val now = "a"; s"Hi now is $now"}.tree)


scala.Some.apply[Int](5) match {
  case _ => println("unknown")
}


showRaw(reify{val s1 = "s1"
  val s2 = "s2"
print(s"$s2 + $s1")}.tree)