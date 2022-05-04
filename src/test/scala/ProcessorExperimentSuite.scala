import nl.medvediev.latinua.Processor
import scala.io.Source
class ProcessorExperimentSuite extends munit.FunSuite {
  // test("get reversed svojeji") {
  //   val line = "своєї"
  //   val latin = "сво'є'ї"
  //   val result = Processor.processReverse(latin)
  //   assertEquals(result, line)
  // }
  // test("get reversed string experiment") {
  //   val line = "хвоздиколюбец"
  //   val processed = Processor.process(line)
  //   val reversed = Processor.processReverse(processed)
  //   assertEquals(reversed, line)
  //   println(reversed)
  // }
  test("get reversed string experiment") {
    // val line = "Boemchakalaka in maj faice"
    // val line = "Bumshakalaka in maj fejs!"
    val line =
      "pushynka"
    val reversed = Processor.processReverse(line)
    println(reversed)
  }
  // test("get reversed string experiment") {
  //   val line = "Mij syn Mishka najkrashchyj"
  //   val reversed = Processor.processReverse(line)
  //   println(reversed)
  // }
  // test("get string experiment") {
  //   val line = "Мій син Мішка найкращий"
  //   val reversed = Processor.process(line)
  //   println(reversed)
  // }
  // test("get and reverse") {
  //   // val text = """ """.replace("’", "'")
  //   val lines = Source.fromFile("src/test/resources/Enejida.txt").getLines

  //   for (line <- lines) {
  //     val processed = Processor.process(line)
  //     val reversed = Processor.processReverse(processed)
  //     assertEquals(reversed, line)
  //   }
  // }
}
