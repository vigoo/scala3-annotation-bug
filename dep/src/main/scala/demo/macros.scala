package demo

import scala.quoted._
import scala.deriving.Mirror
import scala.compiletime.{erasedValue, summonInline, constValueTuple}

case class Schema(annotations: List[Any])

// Originally from zio-schema, stripped down version that only captures the annotations to reproduce the issue
object DeriveSchema {

  transparent inline def gen[T]: Schema = ${ deriveSchema[T] }

  def deriveSchema[T: Type](using ctx: Quotes): Expr[Schema] = {
    import ctx.reflect._

    val typeRepr = TypeRepr.of[T]
    val annotationExprs = TypeRepr.of[T].typeSymbol.annotations.map(_.asExpr)
//    val annotations = '{List.empty}
    val annotations = '{List(${Expr.ofSeq(annotationExprs)})} // NOTE: if this line is just an empty list it does not crash

    '{
      Schema($annotations)
    }
  }
}
