import nl.medvediev.latinua.processor.Processor
import scala.io.Source
class ProcessorExperimentSuite extends munit.FunSuite {
  // test("get reversed svojeji") {
  //   val line = "своєї"
  //   val latin = "сво'є'ї"
  //   val result = Processor.processReverse(latin)
  //   assertEquals(result, line)
  // }
  test("get reversed string experiment") {
    //   val line = "хвоздиколюбец"
    //   val processed = Processor.process(line)
    //   val reversed = Processor.processReverse(processed)
    //   assertEquals(reversed, line)
    //   println(reversed)
    val line = """
    ОСТАННІ НОВИНИ
    ГОЛОВНЕ Політика Фінанси Суспільство 

21:26
На Одещині під час обстрілу зруйновано п'ять будівель, є поранені
20:54
СюжетБлок на ТБ. Нові санкції від США та G7
20:48
Поранено шістьох жителів Донецької області
20:45
США скасували мита на українську сталь
20:29
На Херсонщині окупанти викрали жінку
20:19
З Херсона виїхало приблизно 45% жителів – голова ОВА
20:15
Зеленський провів зустріч із генсеком Ради Європи
20:07
СюжетВторгнення Росії в Україну. Онлайн
20:02
Заочно повідомлено про підозру окупанту, який знущався з цивільних
19:50
У Мережі поширюють фейк про "епідемію туберкульозу" в ЗСУ
19:34
Десантники показали, як нищать ворога
19:25
СюжетДень Перемоги без перемог. ЗМІ про промову Путіна на параді
19:25
Названі щоденні втрати через блокування портів
19:13
Троє жителів Сумщини переправляли охочих на територію РФ
19:09
Енергетики повернули світло 115 тисячам сімей у чотирьох областях
19:05
Українців просять не повідомляти про успіхи ЗСУ
18:59
Вакарчук написав зворушливий вірш про ненависть
18:55
Через фільтраційні табори депортовано майже 1,2 млн осіб – омбудсмен
18:47
Втрати супротивника зростають - Генштаб
18:42
Маша Єфросініна засудила парад до Дня Перемоги в РФ
18:37
Житель Закарпаття зберігав удома 150 кг канабісу
18:29
Окупанти призначили "губернатора" Запорізької області
18:23
Аліна Паш записала кавер на хіт Kalush Orchestra
18:18
Росіяни хочуть знищити міст, по якому йшла евакуація з Маріуполя
18:12
Четверо львів'ян виклали у соцмережі прильоти по місту ракет
18:06
Селін Діон присвятила пост українським матерям
18:01
Угорщина продовжує блокувати ембарго на нафту РФ
18:00
У Польщі прокоментували інцидент із послом РФ
17:58
У Маріуполі окупанти і колаборанти заклали так звану "алею слави"
17:44
У боях за Азовсталь загинув відомий український поет
"""
    val result = Processor.process(line)
    println(result)

  }
  test("get reversed string experiment") {
    // val line = "Boemchakalaka in maj faice"
    // val line = "Bumshakalaka in maj fejs!"
    val line =
      "pushynka"
    val reversed = Processor.processReverse(line)
    // println(reversed)
  }
  // test("get reversed string experiment") {
  //   val line = "Mij syn Mishka najkrashchyj"
  //   val reversed = Processor.processReverse(line)
  //   println(reversed)
  // }
  // test("get string experiment") {
  //   val line = """
// Енеїда
// Іван Котляревський
// ІВАН КОТЛЯРЕВСЬКИЙ
// ЕНЕЇДА
// ЧАСТИНА ПЕРША
// 1 Еней був парубок моторний
// І хлопець хоть куди козак,
// Удавсь на всеє зле проворний,
// Завзятіший од всіх бурлак.
// Но греки, як спаливши Трою,
// Зробили з неї скирту гною,
// Він, взявши торбу, тягу дав;
// Забравши деяких троянців,
// Осмалених, як гиря, ланців,
// П'ятами з Трої накивав.
// 2 Він, швидко поробивши човни,
// На синє море поспускав,
// Троянців насажавши повні,
// І куди очі почухрав.
// Но зла Юнона, суча дочка,
// Розкудкудакалась, як квочка, —
// Енея не любила — страх;
// Давно уже вона хотіла,
// Його щоб душка полетіла
// К чортам і щоб і дух не пах.
// 3 Еней був тяжко не по серцю
// Юноні — все її гнівив;
// Здававсь гірчійший їй від перцю,
// Ні в чім Юнони не просив;
// Но гірш за те їй не любився,
// Що, бачиш, в Трої народився
// І мамою Венеру звав;
// І що його покійний дядько,
// Парис, Пріамове дитятко,
// Путивочку Венері дав.
// 4 Побачила Юнона з неба,
// Що пан Еней на поромах;
// А те шепнула сука Геба...
// Юнону взяв великий жах!
// Впрягла в гринджолята павичку,
// Сховала під кибалку мичку,
// Щоб не світилася коса;
// Взяла спідницю і шнурівку,
// І хліба з сіллю на тарілку,
// К Еолу мчалась, як оса."""
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