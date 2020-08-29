package hodong

import java.util.concurrent.TimeUnit

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

import akka.actor.Actor
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.{Http, HttpExt}
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import spray.json._
import akka.pattern.ask
import akka.util.Timeout

//import hodong.JsonSupport._


class HttpActor extends Actor {
    
    implicit val executionContext = context.dispatcher
    implicit val system = context.system
    implicit val timeout = Timeout(10,TimeUnit.SECONDS)
    implicit val materializer = ActorMaterializer()
}