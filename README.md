# Latin UA

The idea of this project is to enable people who doesn't know the Ukrainian
keyboard layout to type in latin and transliterate text to Ukrainian Cyrillic.
Example: `Ce zvychajnyj tekst` would be transliterated to `Це звичайний текст`

## How to build
>$ sbt nativeLink
- exit sbt
- try it out
>$ ./target/scala-3.3.3/root "perevirochnyj tekst"

- move it to `/usr/bin`
>$ sudo mv ./target/scala-3.3.3/root /usr/bin/latin

- make wrapper script which automatically puts result to the system clipboard
>$ sudo vim /usr/bin/latinc

content of latinc:
```
#!/bin/bash

value=$(/usr/bin/latin $@)
echo $value | xclip -selection clipboard
echo $value
```

- add executive rights to the wrapper script
>$ sudo chmod +x /usr/bin/latinc

## How to use
>$ latinc "Ce zvychajnyj tekst"
>Це звичайний текст

- After successful execution you should see Ukrainian Cyrillic transliteration
  and be able to paste text from system clipboard whenever you need it.

## How to test
 - comment `enablePlugins(ScalaNativePlugin)` line in the `build.sbt`
>$ sbt test

| Ukrainian | Latin |
| ---       | ---   |
| а         | a     |
| б         | b     |
| в         | v     |
| г         | h     |
| ґ         | g     |
| д         | d     |
| е         | e     |
| є         | je    |
| ж         | zh    |
| з         | z     |
| и         | y     |
| і         | i     |
| ї         | ji    |
| й         | j     |
| к         | k     |
| л         | l     |
| м         | m     |
| н         | n     |
| о         | o     |
| п         | p     |
| р         | r     |
| с         | s     |
| т         | t     |
| у         | u     |
| ф         | f     |
| х         | kh    |
| ц         | c     |
| ч         | ch    |
| ш         | sh    |
| щ         | shch  |
| ь         | '     |
| ю         | ju    |
| я         | ja    |
| " "       | " "   |
| А         | A     |
| Б         | B     |
| В         | V     |
| Г         | H     |
| Ґ         | G     |
| Д         | D     |
| Е         | E     |
| Є         | Je    |
| Ж         | Zh    |
| З         | Z     |
| И         | Y     |
| І         | I     |
| Ї         | Ji    |
| Й         | J     |
| К         | K     |
| Л         | L     |
| М         | M     |
| Н         | N     |
| О         | O     |
| П         | P     |
| Р         | R     |
| С         | S     |
| Т         | T     |
| У         | U     |
| Ф         | F     |
| Х         | Kh    |
| Ц         | C     |
| Ч         | Ch    |
| Ш         | Sh    |
| Щ         | Shch  |
| Ь         | "''"  |
| Ю         | Ju    |
| Я         | Ja    |

Additional mappings
| Ukrainian | Latin |
| ---       | ---   |
| зг        | zgh   |

Apostrophe automatically transliterated according to the rules in Ukrainian language: `zvjazok` -> `зв'язок` 
