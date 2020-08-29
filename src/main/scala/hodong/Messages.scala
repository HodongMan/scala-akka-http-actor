package hodong

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol


case class SimpleMessage(val subject : String, val text : String)

case class Envelope(val senderId : String, val recipient : String, val message : SimpleMessage)

case class Registration(val id : String, val fullName : String)

case class OpSuccess(val message : String)

case class OpFailure(val message : String)


object JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
    
    implicit val simpleMessageFormat    = jsonFormat2(SimpleMessage)
    implicit val envelopeFormat         = jsonFormat3(Envelope)
    implicit val registrationFormat     = jsonFormat2(Registration)
    implicit val opSuccessFormat        = jsonFormat1(OpSuccess)
    implicit val opFailureFormat        = jsonFormat1(OpFailure)
}