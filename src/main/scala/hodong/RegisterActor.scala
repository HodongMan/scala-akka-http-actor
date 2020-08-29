package hodong

import akka.actor.Actor


class RegisterActor extends Actor {

    val logActor = context.actorSelection("/user/logActor")

    override def receive: Receive = {

        case message: Registration =>
            //logActor | "Register User" + message.id

            val data = FileUtil.loadUserFromFile()

            FileUtil.saveUserToFile(data + (message.id -> message))
    }
}