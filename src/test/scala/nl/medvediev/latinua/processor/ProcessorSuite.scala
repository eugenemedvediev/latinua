import nl.medvediev.latinua.processor.Processor

import scala.io.Source
import scala.util.Using.Manager.Resource

class ProcessorSuite extends munit.FunSuite {
  test("process anthem") {
    val expected =
      "Shche ne vmerla Ukrajiny ni slava, ni vol'a, Shche nam, bratt'a molodiji, usmikhnet's'a dol'a. Zghynut' nashi vorozhen'ky, jak rosa na sonci. Zapanujem i my, bratt'a, u svojij storonci. Dushu j tilo my polozhym za nashu svobodu, I pokazhem, shcho my, bratt'a, kozac'koho rodu. Stanem, bratt'a, v bij kryvavyj, vid S'anu do Donu, V ridnim kraju panuvaty ne damo nikomu, Chorne more shche vsmikhnet's'a, did-Dnipro zradije, Shche u nashij Ukrajini — dolen'ka naspije. Dushu j tilo my polozhym za nashu svobodu, I pokazhem, shcho my, bratt'a, kozac'koho rodu. A zavz'att'a, prac'a shchyra svoho shche dokazhe, Shche s'a voli v Ukrajini pisn' huchna rozl'azhe, Za Karpaty vidibjet's'a, zghomonyt' stepamy, Ukrajiny slava stane pomizh narodamy. Dushu j tilo my polozhym za nashu svobodu I pokazhem, shcho my, bratt'a, kozac'koho rodu."

    val result = Processor.process(
      "Ще не вмерла України ні слава, ні воля, Ще нам, браття молодії, усміхнеться доля. Згинуть наші вороженьки, як роса на сонці. Запануєм і ми, браття, у своїй сторонці. Душу й тіло ми положим за нашу свободу, І покажем, що ми, браття, козацького роду. Станем, браття, в бій кривавий, від Сяну до Дону, В ріднім краю панувати не дамо нікому, Чорне море ще всміхнеться, дід-Дніпро зрадіє, Ще у нашій Україні — доленька наспіє. Душу й тіло ми положим за нашу свободу, І покажем, що ми, браття, козацького роду. А завзяття, праця щира свого ще докаже, Ще ся волі в Україні піснь гучна розляже, За Карпати відіб'ється, згомонить степами, України слава стане поміж народами. Душу й тіло ми положим за нашу свободу І покажем, що ми, браття, козацького роду."
    )

    assertEquals(result, expected)
  }
  test("processReverse anthem") {
    val expected =
      "Ще не вмерла України ні слава, ні воля, Ще нам, браття молодії, усміхнеться доля. Згинуть наші вороженьки, як роса на сонці. Запануєм і ми, браття, у своїй сторонці. Душу й тіло ми положим за нашу свободу, І покажем, що ми, браття, козацького роду. Станем, браття, в бій кривавий, від Сяну до Дону, В ріднім краю панувати не дамо нікому, Чорне море ще всміхнеться, дід-Дніпро зрадіє, Ще у нашій Україні — доленька наспіє. Душу й тіло ми положим за нашу свободу, І покажем, що ми, браття, козацького роду. А завзяття, праця щира свого ще докаже, Ще ся волі в Україні піснь гучна розляже, За Карпати відіб'ється, згомонить степами, України слава стане поміж народами. Душу й тіло ми положим за нашу свободу І покажем, що ми, браття, козацького роду."

    val result = Processor.processReverse(
      "Shche ne vmerla Ukrajiny ni slava, ni vol'a, Shche nam, bratt'a molodiji, usmikhnet's'a dol'a. Zghynut' nashi vorozhen'ky, jak rosa na sonci. Zapanujem i my, bratt'a, u svojij storonci. Dushu j tilo my polozhym za nashu svobodu, I pokazhem, shcho my, bratt'a, kozac'koho rodu. Stanem, bratt'a, v bij kryvavyj, vid S'anu do Donu, V ridnim kraju panuvaty ne damo nikomu, Chorne more shche vsmikhnet's'a, did-Dnipro zradije, Shche u nashij Ukrajini — dolen'ka naspije. Dushu j tilo my polozhym za nashu svobodu, I pokazhem, shcho my, bratt'a, kozac'koho rodu. A zavz'att'a, prac'a shchyra svoho shche dokazhe, Shche s'a voli v Ukrajini pisn' huchna rozl'azhe, Za Karpaty vidibjet's'a, zghomonyt' stepamy, Ukrajiny slava stane pomizh narodamy. Dushu j tilo my polozhym za nashu svobodu I pokazhem, shcho my, bratt'a, kozac'koho rodu."
    )

    assertEquals(result, expected)
  }
  test("process anthem uppercase") {
    //   val expected =

    val result = Processor.process(
      "ЩЕ НЕ ВМЕРЛА УКРАЇНИ НІ СЛАВА, НІ ВОЛЯ, ЩЕ НАМ, БРАТТЯ МОЛОДІЇ, УСМІХНЕТЬСЯ ДОЛЯ. ЗГИНУТЬ НАШІ ВОРОЖЕНЬКИ, ЯК РОСА НА СОНЦІ. ЗАПАНУЄМ І МИ, БРАТТЯ, У СВОЇЙ СТОРОНЦІ. ДУШУ Й ТІЛО МИ ПОЛОЖИМ ЗА НАШУ СВОБОДУ, І ПОКАЖЕМ, ЩО МИ, БРАТТЯ, КОЗАЦЬКОГО РОДУ. СТАНЕМ, БРАТТЯ, В БІЙ КРИВАВИЙ, ВІД СЯНУ ДО ДОНУ, В РІДНІМ КРАЮ ПАНУВАТИ НЕ ДАМО НІКОМУ, ЧОРНЕ МОРЕ ЩЕ ВСМІХНЕТЬСЯ, ДІД-ДНІПРО ЗРАДІЄ, ЩЕ У НАШІЙ УКРАЇНІ — ДОЛЕНЬКА НАСПІЄ. ДУШУ Й ТІЛО МИ ПОЛОЖИМ ЗА НАШУ СВОБОДУ, І ПОКАЖЕМ, ЩО МИ, БРАТТЯ, КОЗАЦЬКОГО РОДУ. А ЗАВЗЯТТЯ, ПРАЦЯ ЩИРА СВОГО ЩЕ ДОКАЖЕ, ЩЕ СЯ ВОЛІ В УКРАЇНІ ПІСНЬ ГУЧНА РОЗЛЯЖЕ, ЗА КАРПАТИ ВІДІБ'ЄТЬСЯ, ЗГОМОНИТЬ СТЕПАМИ, УКРАЇНИ СЛАВА СТАНЕ ПОМІЖ НАРОДАМИ. ДУШУ Й ТІЛО МИ ПОЛОЖИМ ЗА НАШУ СВОБОДУ І ПОКАЖЕМ, ЩО МИ, БРАТТЯ, КОЗАЦЬКОГО РОДУ."
    )

    //   assertEquals(result, expected)
  }
  test("preprocessZgh") {
    val expected = "zghинуть"

    val result = Processor.preprocessZgh("згинуть")

    assertEquals(result, expected)
  }
  test("preprocessApostrophe ja") {
    val expected = "любjaзний"

    val result = Processor.preprocessApostrophe("люб'язний")

    assertEquals(result, expected)
  }
  test("preprocessApostrophe ju") {
    val expected = "бjuться"

    val result = Processor.preprocessApostrophe("б'ються")

    assertEquals(result, expected)

  }
  test("preprocessApostrophe je") {
    val expected = "бjeшся"

    val result = Processor.preprocessApostrophe("б'єшся")

    assertEquals(result, expected)

  }
  test("preprocessApostrophe ji") {
    val expected = "соловji"

    val result = Processor.preprocessApostrophe("солов'ї")

    assertEquals(result, expected)
  }
  test("preprocessApostrophe uppercase") {
    val expected = "JA, JU, JE, JI"

    val result = Processor.preprocessApostrophe("'Я, 'Ю, 'Є, 'Ї")

    assertEquals(result, expected)
  }
  test("preprocessApostrophe kind") {
    val expected = "солов'ї"

    val result = Processor.preprocessApostropheKind("солов’ї")

    assertEquals(result, expected)
  }
  test("preprocessSoftSound after vowel") {
    val expected = "моja, моju, моje, моji молодіji, їji"

    val result = Processor.preprocessSoftSound("моя, мою, моє, мої молодії, її")

    assertEquals(result, expected)
  }
  test("preprocessSoftSound after cyllable") {
    val expected = "вол'a, братт'a"

    val result = Processor.preprocessSoftSound("воля, браття")

    assertEquals(result, expected)
  }
  test("get string") {
    val line = "Ще не вмерла України ні слава, ні воля, Ще нам, браття молодії, усміхнеться доля."
    val result = Processor.process(line)
  }
  test("get reversed string") {
    val line = "Chytaty Enejidu online"
    val result = Processor.processReverse(line)
  }
  test("get reversed Enejida") {
    val line = "Енеїда"
    val processed = Processor.process(line)
    val result = Processor.processReverse(processed)
    assertEquals(result, line)
  }
  test("get reversed Enejida") {
    val line = "своєї"
    val processed = Processor.process(line)
    val result = Processor.processReverse(processed)
    assertEquals(result, line)
  }

  test("get and reverse") {
    // val text = """ """.replace("’", "'")
    val lines = Source.fromResource("Enejida.txt").getLines

    for (line <- lines if !line.startsWith("//")) {
      val processed = Processor.process(line)
      val reversed = Processor.processReverse(processed)
      assertEquals(reversed, line)
    }
  }
}
