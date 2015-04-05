package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Mastery(
                      masteryId: Long,
                      rank: Long
                      )

object Mastery {

  implicit val masteryFormat = Json.format[Mastery]
}