package nl.medvediev.latinua

import nl.medvediev.latinua.processor.Processor

object Main:

  def main(args: Array[String]): Unit =
    val result = Processor.processReverse(args.mkString(" "))
    println(result)
