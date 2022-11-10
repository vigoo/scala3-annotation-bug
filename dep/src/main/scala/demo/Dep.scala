package demo

// NOTE: if the definition is here instead of Base.scala, it works
//@evolutionSteps("x")
//final case class Record(a: String, b: Int)


@main def run() = {
  val schema: Schema = DeriveSchema.gen[Record]
  println(schema)
}

