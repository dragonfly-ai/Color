ThisBuild / scalaVersion := "2.13.3"

lazy val root = project.in(file(".")).aggregate(color.js, color.jvm)

lazy val color = crossProject(JSPlatform, JVMPlatform).settings(
  publishTo := Some(Resolver.file("file",  new File( "/var/www/maven" ))),
  name := "color",
  version := "0.203",
  organization := "ai.dragonfly.code",
  resolvers += "dragonfly.ai" at "https://code.dragonfly.ai/",
  libraryDependencies += "ai.dragonfly.code" %%% "vector" % "0.303",
  scalacOptions ++= Seq("-feature", "-deprecation"),
  mainClass in (Compile, run) := Some("ai.dragonfly.color.experiments.TestColors")
).jvmSettings().jsSettings(
  scalaJSUseMainModuleInitializer := true
)