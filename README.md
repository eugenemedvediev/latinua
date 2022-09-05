## sbt project compiled with Scala 3

### Usage

#### How to test
 - comment enablePlugins in the build.sbt
 - sbt test
 
#### How to build
>sbt
>sbt:root> nativeLink
>./target/scala-3.1.0/root-out "perevirochnyj tekst"
>sudo mv ./target/scala-3.1.0/root-out /usr/bin/latin

>sudo nvim /usr/bin/latinc
content of latinc:
#!/bin/bash

value=$(/usr/bin/latin $@)
echo $value | xclip -selection clipboard
echo $value


>sudo chmod +x /usr/bin/latinc

