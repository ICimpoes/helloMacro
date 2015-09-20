package app.runtimeException

import lib.runtimeException.RuntimeExMacro

object RuntimeExApp extends App {

  RuntimeExMacro.throwRuntimeException(new Exception("Exception Message"))

}
