import Dependencies._

ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.kafkata"
ThisBuild / organizationName := "kafkata"

lazy val root = (project in file("."))
	.settings(
		name := "traffic",
		libraryDependencies += scalaTest % Test,
		libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
		libraryDependencies += "com.typesafe.play" %% "play-json" % "2.8.1"
	)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
