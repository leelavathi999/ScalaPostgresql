import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object UserApp extends App {
  val userRepo = new UserRepository(DatabaseConfig.db)

  println("🚀 Attempting to connect to the database...")

  // ✅ Ensure the table is created before proceeding
  Await.result(userRepo.createTable(), 10.seconds)
  println("✅ Database connected & table created successfully")

  val newUser = User(0, "Leela", "leela@example.com")


  // ✅ Insert user and wait for result
  Await.result(userRepo.insert(newUser), 10.seconds)
  println("✅ User inserted successfully")

  // ✅ Fetch all users and print them
  val users = Await.result(userRepo.getAll(), 10.seconds)
  println(s"📂 Users in DB: $users")
}
