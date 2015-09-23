package lib.fieldAccess

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object FieldAccessMacro {

  def accessField[A](obj: A, fieldName: String): Unit = macro accessFieldMacroImpl[A]

  def accessFieldMacroImpl[A: c.WeakTypeTag](c: blackbox.Context)(obj: c.Expr[A], fieldName: c.Expr[String]) = {
    import c.universe._

    val tpA = weakTypeOf[A]

    val Literal(Constant(name: String)) = fieldName.tree

    val result = tpA.decls.find { field => field.isMethod && field.asMethod.isCaseAccessor && field.name == TermName(name) }

    result.fold[c.Tree]( c.abort(c.enclosingPosition, s"No such field $name") ){
      _ => q"""println($obj.${TermName(name)})"""
    }

  }
}
