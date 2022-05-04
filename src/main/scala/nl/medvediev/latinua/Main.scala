package nl.medvediev.latinua

@main def hello(line: String): Unit = {
  val result = Processor.process(line)
  println(result)
}
