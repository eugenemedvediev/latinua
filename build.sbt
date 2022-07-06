import Dependencies.*

ThisBuild / organization := "nl.medvediev"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.1.0"

lazy val core = project
  .in(file("core"))
  .settings(
    name := "core",
    libraryDependencies ++= coreDeps
  )

lazy val console = project
  .in(file("console"))
  .settings(
    name := "console",
    libraryDependencies ++= commandLineDeps
  )
  .dependsOn(core)
