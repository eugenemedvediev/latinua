package nl.medvediev.latinua

import nl.medvediev.latinua.processor.Processor

@main def latinua(line: String): Unit = {
  val result = Processor.process(line)
  println(result)
}
