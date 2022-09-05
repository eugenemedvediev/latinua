import nl.medvediev.latinua.processor.Processor
import scala.io.Source
class ProcessorExperimentSuite extends munit.FunSuite {
  test("get reversed string experiment") {
    val line = """
      |лінія
    """.stripMargin
    val result = Processor.process(line)
    println(result)

  }
  test("get reversed string experiment") {
    val line = """
      |linija
      """.stripMargin
    val reversed = Processor.processReverse(line)
    println(reversed)
  }
}
