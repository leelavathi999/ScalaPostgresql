import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future

class UserRepository(db: Database) {
  private val users = TableQuery[UsersTable] // ✅ Fix here

  // ✅ Add createTable method
  def createTable(): Future[Unit] = db.run(users.schema.createIfNotExists)

  def insert(user: User) = db.run(users += user)

  def getAll() = db.run(users.result)
}
