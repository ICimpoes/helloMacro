package lib.fieldAccess

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object FieldAccessMacro {

  def accessField[A](obj: A, fieldName: String): Unit = macro accessFieldMacroImpl[A]

  def accessFieldMacroImpl[A: c.WeakTypeTag](c: blackbox.Context)(obj: c.Expr[A], fieldName: c.Expr[String]) = {
    import c.universe._

    val tpA = weakTypeOf[A]

    val Literal(Constant(s: String)) = reify{fieldName.splice}.tree

    val result = tpA.decls.find { field => field.isMethod && field.asMethod.isCaseAccessor && field.name == TermName(s) }

    val a = result.fold[c.Tree]( q"""println("No such field " + $s)""" ){ _ => q"""println($obj.${TermName(s)})""" }

    println(showCode(a))
    println(showRaw(a))

    a

  }
}
