name := "JIRCLib"

version := "0.9.1"

scalaVersion := "2.11.2"

libraryDependencies ++= {
  Seq(
    "org.specs2" %% "specs2" % "2.4.2" % "test",
    "com.typesafe.akka" %% "akka-actor" % "2.3.4"
  )
}

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
