ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaPostgresql",

    // Correct Slick dependencies for Scala 3
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % "3.5.2"  ,          // Slick core
      //"com.typesafe.slick" %% "slick-hikaricp" % "3.4.5",   // HikariCP for connection pooling
      "org.postgresql" % "postgresql" % "42.6.0",          // PostgreSQL JDBC driver
      "org.slf4j" % "slf4j-nop" % "2.0.7"
    )
    )
