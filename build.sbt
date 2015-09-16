name := "helloMacro"

version := "1.0"

val commonSettings = Seq(
  scalaVersion := "2.11.7",

  scalacOptions ++= Seq("-deprecation", "-feature"),

//  unmanagedSourceDirectories in Compile := List((scalaSource in Compile).value),
//
//  unmanagedSourceDirectories in Test := List((scalaSource in Test).value),

  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value
  )
)

lazy val macroLib = project.in(file("macroLib")).settings(commonSettings: _*)

lazy val macroApp = project.in(file("macroApp")).settings(commonSettings: _*).dependsOn(macroLib)