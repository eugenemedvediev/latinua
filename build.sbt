import Dependencies.*

ThisBuild / organization := "nl.medvediev"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.2.1"

//TODO: uncomment to be able to make native binary
// enablePlugins(ScalaNativePlugin)

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies ++= commandLineDeps,
    Compile / mainClass := Some("nl.medvediev.latinua.Main")
  )
