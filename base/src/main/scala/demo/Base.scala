package demo

import scala.annotation.StaticAnnotation

final case class testAnnotation(steps: String) extends StaticAnnotation

@testAnnotation("x")
final case class Record(a: String, b: Int)
