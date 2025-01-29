import slick.jdbc.PostgresProfile.api._

object DatabaseConfig {
  val db = Database.forConfig("postgresDB")
}

