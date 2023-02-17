import nl.medvediev.latinua.processor.Processor
import scala.io.Source

class ProcessorExperimentSuite extends munit.FunSuite {
  test("*get normal string experiment") {
    val line = """
      |лінія
    """.stripMargin
    val result: String = Processor.process(line)
    assertEquals(result.trim(), "linija")

  }
  test("*get reversed string experiment") {
    val line = """
      |linija
      """.stripMargin
    val reversed = Processor.processReverse(line)
    assertEquals(reversed.trim(), "лінія")
  }
}
