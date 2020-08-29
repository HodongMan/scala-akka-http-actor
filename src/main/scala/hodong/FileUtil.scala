package hodong

import java.io.{File, FileWriter}
import spray.json._
import scala.io.Source


object FileUtil {

    val usersFile           = new File("users.json")
    val messagesDirectory   = new File("messages")

    def loadUserFromFile(): Map[String, Registration] = {

        return Map[String, Registration]()
    }

    def saveUserToFile(items: Map[String, Registration]): Unit = {

    }

    def appendMessageToFile(message: Envelope): Unit = {

    }
}

