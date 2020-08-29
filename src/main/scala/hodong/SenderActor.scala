package hodong


import akka.actor.Actor


class SenderActor extends Actor {
    
    override def receive: Receive = {
        case msg : Envelope =>
            FileUtil.appendMessageToFile(msg)
    }
}