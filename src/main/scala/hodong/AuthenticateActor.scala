package hodong

import akka.actor.Actor


class AuthenticateActor extends Actor {

    val logActor        = context.actorSelection("/user/logActor")
    val senderActor     = context.actorSelection("/user/senderActor")

    override def receive: Receive = {

        case message : Envelope =>
            val users = FileUtil.loadUsersFromFile()

            if(users.contains(message.senderId)){
                logActor ! "Message from "+message.senderId+" accepted"
                sender() ! new OpSuccess("Operation accepted")\
                senderActor ! message
            } else {
                logActor ! "Message from "+message.senderId+" refused"
                sender() ! new OpFailure("Sender is not registered")
            }

    }
}