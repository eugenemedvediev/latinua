import Dependencies.*

ThisBuild / organization := "nl.medvediev"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.0"

enablePlugins(ScalaNativePlugin)

lazy val root = project
  .in(file("."))
  .settings(
    libraryDependencies ++= commandLineDeps,
    Compile / mainClass := Some("nl.medvediev.latinua.Main")
  )
