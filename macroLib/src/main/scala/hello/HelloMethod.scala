package hello

import java.util.Date

object HelloMethod {

  def sayHello: String = {
    val now = new Date().toString
    s"Hello, it's $now"
  }

}
