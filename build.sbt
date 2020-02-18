import Dependencies._

ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.kafkata"
ThisBuild / organizationName := "kafkata"

lazy val root = (project in file("."))
	.settings(
		name := "traffic",
		libraryDependencies += scalaTest % Test,
		libraryDependencies += "com.typesafe.play" %% "play-json" % "2.8.1",
		libraryDependencies += "com.sksamuel.avro4s" %% "avro4s-core" % "3.0.6",
		libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
		libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
		libraryDependencies += "org.gavaghan" % "geodesy" % "1.1.3"
	)

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
