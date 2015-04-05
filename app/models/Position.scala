package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Position(
                     x: Int,
                     y: Int
                     )

object Position {

  implicit val positionFormat = Json.format[Position]
}