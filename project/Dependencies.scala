import sbt.*

object Dependencies {
  // Versions
  lazy val mainArgsVersion = "0.2.3"
  lazy val munitVersion = "0.7.29"

  // Libraries
  val mainArgs = "com.lihaoyi" %% "mainargs" % mainArgsVersion
  val munit = "org.scalameta" %% "munit" % munitVersion

  // Projects
  val coreDeps = Seq(munit % Test)
  val commandLineDeps = Seq(mainArgs, munit % Test)
}
