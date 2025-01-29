import slick.jdbc.PostgresProfile.api._

case class User(id: Int=0, name: String, email: String)

class UsersTable(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def email = column[String]("email")

  def * = (id, name, email) <> ((User.apply _).tupled, User.unapply)
}

val users = TableQuery[UsersTable]
