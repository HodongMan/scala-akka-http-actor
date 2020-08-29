package hodong

import akka.actor.Actor


class AuthenticateActor extends Actor {

    val logActor        = context.actorSelection("/user/logActor")
    val senderActor     = context.actorSelection("/user/senderActor")

    override def receive: Receive = {

        case message : Envelope =>
            val users = FileUtil.loadUsersFromFile()

            if(users.contains(msg.senderId)){
                logActor ! "Message from "+msg.senderId+" accepted"
                sender() ! new OpSuccess("Operation accepted")\
                senderActor ! msg
            } else {
                logActor ! "Message from "+msg.senderId+" refused"
                sender() ! new OpFailure("Sender is not registered")
            }

    }
}