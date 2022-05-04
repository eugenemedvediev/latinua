val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "latinua",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    mainClass := Some("nl.medvediev.latinua"),
    // Test / mainClass := Some("nl.medvediev.latinua"),
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )
