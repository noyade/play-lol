package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Rune(
                 rank: Long,
                 runeId: Long
                 )

object Rune {

  implicit val runeFormat = Json.format[Rune]
}