# Latin UA

The idea of this project is to enable people who doesn't know the Ukrainian
keyboard layout to type in latin and transliterate text to Ukrainian Cyrillic.
Example: `Ce zvychajnyj tekst` would be transliterated to `Це звичайний текст`

## How to build
`$sbt`
`$sbt:root> nativeLink`
- exit sbt
- try it out
`$./target/scala-3.1.0/root-out "perevirochnyj tekst"`
- move it to `/usr/bin`
`$sudo mv ./target/scala-3.1.0/root-out /usr/bin/latin`
- make wrapper script which automatically puts result to the system clipboard
`$sudo nvim /usr/bin/latinc`

content of latinc:
```
#!/bin/bash

value=$(/usr/bin/latin $@)
echo $value | xclip -selection clipboard
echo $value
```

- add executive rights to the wrapper script
`$sudo chmod +x /usr/bin/latinc`

## How to use
`$latinc "Ce zvychajnyj tekst"`
`Це звичайний текст`

>
- After successful execution you should see Ukrainian Cyrillic transliteration
  and be able to paste text whenever you need it.

## How to test
 - comment enablePlugins line in the build.sbt
`$sbt test`
 
