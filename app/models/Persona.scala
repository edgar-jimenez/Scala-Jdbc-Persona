package models

import play.api.libs.json.{JsPath, Json, Reads, Writes}
import play.api.libs.functional.syntax._

case class Persona (nombre: String, apellido: String, edad: Int, n1: Int, n2:Int)

object Persona{

  implicit val personaWrites: Writes[Persona] = (
    (JsPath \ "nombre").write[String] and
      (JsPath \ "apellido").write[String] and
      (JsPath \ "edad").write[Int]and
      (JsPath \ "n1").write[Int]and
      (JsPath \ "n2").write[Int]
    )(unlift(Persona.unapply))

  implicit val personaReads: Reads[Persona] = (
    (JsPath \ "nombre").read[String] and
      (JsPath \ "apellido").read[String] and
      (JsPath \ "edad").read[Int]
    )(Persona)

  def apply(nombre: String, apellido: String, edad: Int): Persona = new Persona(nombre, apellido, edad, 1,2)

  def unapply(arg: Persona): (String, String, Int, Int, Int) = (arg.nombre,arg.apellido,arg.edad,2,2)

}

