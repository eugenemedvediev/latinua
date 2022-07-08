package nl.medvediev.latinua

import nl.medvediev.latinua.processor.Processor
import mainargs.{main, arg, ParserForMethods, Flag}
import mainargs.Leftover

object Main {
  @main
  def run(
      @arg(short = 'r', doc = "Transcode line from latin to ukrainian") reverse: Flag,
      line: Leftover[String]
  ): Unit = {
    val result =
      if (reverse.value) Processor.processReverse(line.value.mkString(" "))
      else Processor.process(line.value.mkString(" "))
    println(result)
  }

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)
}
