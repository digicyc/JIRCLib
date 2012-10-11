name := "JIRCLib"

version := "0.9.1"

scalaVersion := "2.9.1"

libraryDependencies ++= {
  Seq(
    "org.specs2" %% "specs2" % "1.9" % "test",
    "com.typesafe.akka" % "akka-actor" % "2.0.3"
  )
}

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
