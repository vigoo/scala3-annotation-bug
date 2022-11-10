ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "scala3-annotation-bug",
    idePackagePrefix := Some("demo")
  )
  .aggregate(base, dep)

lazy val base = project in file("base")
lazy val dep = (project in file("dep")).dependsOn(base).settings(
//  libraryDependencies ++= Seq(
//    "dev.zio" %% "zio-schema" % "0.2.1",
//    "dev.zio" %% "zio-schema-derivation" % "0.2.1"
//  )
)