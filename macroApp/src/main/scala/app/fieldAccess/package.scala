package app

package object fieldAccess {

  case class TestClass(a: String, b: Int, c: Option[Int] = None) {
    def method = "method"
    val value = "value"
  }
}
