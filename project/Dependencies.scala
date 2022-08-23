import sbt.*

object Dependencies {
  // Versions
  lazy val munitVersion = "0.7.29"

  // Libraries
  val munit = "org.scalameta" %% "munit" % munitVersion

  // Projects
  val commandLineDeps = Seq(munit % Test)
}
