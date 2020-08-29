package hodong


import java.util.Date

import akka.actor.Actor


class LogActor extends Actor {

  override def receive: Receive = {
    case message: String =>
      println(new Date()+") "+ message)
  }
}