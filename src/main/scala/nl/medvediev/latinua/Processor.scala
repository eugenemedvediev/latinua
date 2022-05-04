package nl.medvediev.latinua

import scala.annotation.tailrec
import scala.util.matching.Regex

object Processor {

  val vowelCyrillic = List("а", "е", "є", "и", "і", "ї", "о", "у", "ю", "я", "А", "Е", "Є", "И", "І", "Ї", "О", "У", "Ю", "Я")
  val cyllableCyrillic = List(
    "б",
    "в",
    "г",
    "ґ",
    "д",
    "ж",
    "з",
    "к",
    "л",
    "м",
    "н",
    "п",
    "р",
    "с",
    "т",
    "ф",
    "х",
    "ц",
    "ч",
    "ш",
    "щ",
    "Б",
    "В",
    "Г",
    "Ґ",
    "Д",
    "Ж",
    "З",
    "К",
    "Л",
    "М",
    "Н",
    "П",
    "Р",
    "С",
    "Т",
    "Ф",
    "Х",
    "Ц",
    "Ч",
    "Ш",
    "Щ"
  )
  def processReverse(line: String): String = {
    def loop(latin: List[String], acc: String): String = {
      latin match {
        case x :: xs => loop(xs, acc.replace(x, Mapper.mapperReverse(x)))
        case Nil     => acc
      }
    }

    val preprocessZghLine = preprocessZghReverse(line)
    val preprocessApostropheKindLine = preprocessApostropheKind(preprocessZghLine)
    val processedSoftSoundLine = preprocessSoftSoundReverse(preprocessApostropheKindLine)
    val preprocessApostropheLine = preprocessApostropheReverse(processedSoftSoundLine)
    val combinationSounds = Mapper.latin.filter(_.length > 2).sortBy(_.length).reverse
    val preprocessCominationSoundsLine = loop(combinationSounds, preprocessApostropheLine)
    val processed = loop(Mapper.latin.filterNot(_.equals("'")).sortBy(_.length).reverse, preprocessCominationSoundsLine)
    val postprocessedSoftSoundLine = postprocessSoftSoundReverse(processed)
    val eliminateDoubleSoftSignLine = eliminateDoubleSoftSign(postprocessedSoftSoundLine)
    eliminateDoubleSoftSignLine
  }

  def process(line: String): String = {
    def loop(cyrillic: List[String], acc: String): String = {
      cyrillic match {
        case x :: xs => loop(xs, acc.replace(x, Mapper.mapper(x)))
        case Nil     => acc
      }
    }

    val preprocessZghLine = preprocessZgh(line)
    val preprocessApostropheKindLine = preprocessApostropheKind(preprocessZghLine)
    val preprocessApostropheLine = preprocessApostrophe(preprocessApostropheKindLine)
    val preprocessSoftSoundLine = preprocessSoftSound(preprocessApostropheLine)
    loop(Mapper.cyrillic, preprocessSoftSoundLine)
  }

  def preprocessZgh(line: String): String =
    line.replace("зг", "zgh").replace("Зг", "Zgh")

  def preprocessZghReverse(line: String): String =
    line.replace("zgh", "зг").replace("Zgh", "Зг")

  def preprocessApostrophe(line: String): String = {
    line
      .replace("'я", "ja")
      .replace("'ю", "ju")
      .replace("'є", "je")
      .replace("'ї", "ji")
      .replace("'Я", "JA")
      .replace("'Ю", "JU")
      .replace("'Є", "JE")
      .replace("'Ї", "JI")
  }

  def preprocessApostropheReverse(line: String): String = {
    // TODO: add rules for apostrophe after cyllables
    // https://webpen.com.ua/pages/Pravopys_Pryholosnyh/apostrophe.html
    val res = line
      .replace("ja", "'я")
      .replace("ju", "'ю")
      .replace("je", "'є")
      .replace("ji", "'ї")
      .replace("JA", "'Я")
      .replace("JU", "'Ю")
      .replace("JE", "'Є")
      .replace("JI", "'Ї")
    res
  }

  def preprocessApostropheKind(line: String): String = line.replace("’", "'")

  def preprocessSoftSound(line: String): String = {
    def vowelLoop(listToProcess: List[String], acc: String): String =
      listToProcess match {
        case x :: xs =>
          vowelLoop(
            xs,
            acc
              .replace(s"${x}я", s"${x}ja")
              .replace(s"${x}ю", s"${x}ju")
              .replace(s"${x}є", s"${x}je")
              .replace(s"${x}ї", s"${x}ji")
          )
        case Nil => acc
      }
    def cyllableLoop(listToProcess: List[String], acc: String): String =
      listToProcess match {
        case x :: xs =>
          cyllableLoop(
            xs,
            acc
              .replace(s"${x}я", s"${x}'a")
              .replace(s"${x}ю", s"${x}'u")
              .replace(s"${x}є", s"${x}'e")
              .replace(s"${x}ї", s"${x}'i")
          )
        case Nil => acc
      }

    val vowels = vowelLoop(vowelCyrillic, line)
    cyllableLoop(cyllableCyrillic, vowels)

  }

  def preprocessSoftSoundReverse(line: String): String = line.replace("'", "ь")

  def postprocessSoftSoundReverse(line: String) = {
    def loop(candidates: List[String], acc: String): String = candidates match {
      case x :: xs =>
        loop(xs, acc.replace(s"${x}'я", s"${x}я").replace(s"${x}ью", s"${x}ю").replace(s"${x}ьє", s"${x}є").replace(s"${x}ьї", s"${x}ї"))
      case Nil => acc
    }
    @tailrec
    def loopApostrophe(line: String): String = {
      val vowelRegex =
        new Regex("""(^|[ аеєиіїоуюяАЕЄИІЇОУЮЯ])'([аеєиіїоуюяАЕЄИІЇОУЮЯ])""", "prefix", "body")
      val result = vowelRegex.replaceAllIn(line, m => s"${m.group("prefix")}${m.group("body")}")
      if (vowelRegex.findFirstIn(result).isDefined) loopApostrophe(result) else result
    }

    val eliminatedSoftSign = loop(
      vowelCyrillic,
      line
        .replace("ьа", "я")
        .replace("ьу", "ю")
        .replace("ье", "є")
        .replace("ьі", "ї")
    )
    val insertedApostropheAfterNotVowels = eliminatedSoftSign
      .replace("ья", "'я")
      .replace("ью", "'ю")
      .replace("ьє", "'є")
      .replace("ьї", "'ї")
    val eliminatedApostropheInTheBeginningOfTheLine = insertedApostropheAfterNotVowels
    // .replace(" 'я", " я")
    // .replace("\n'я", "\nя")
    // .replace(" 'ю", " ю")
    // .replace("\n'ю", "\nю")
    // .replace(" 'є", " є")
    // .replace("\n'є", "\nє")
    // .replace(" 'ї", " ї")
    // .replace("\n'ї", "\nї")
    import scala.util.matching.Regex
    val prefixRegex =
      new Regex("""([^аеєиіїоуюямвпбзфрАЕЄИІЇОУЮЯМВПБЗФР]|^від|^під|^над|^перед|^роз|^без|^об|^між)'([аеєиіїоуюя])""", "prefix", "body")
    val eliminatedPrefix =
      prefixRegex.replaceAllIn(eliminatedApostropheInTheBeginningOfTheLine, m => s"${m.group("prefix")}${m.group("body")}")
    // eliminatedApostropheInTheBeginningOfTheLine
    loopApostrophe(eliminatedPrefix)
  }
  def eliminateDoubleSoftSign(line: String): String = line.replace("ьь", "Ь")
}
