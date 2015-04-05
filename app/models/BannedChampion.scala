package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class BannedChampion(
                           championId: Int,
                           pickTurn: Int
                           )

object BannedChampion {

  implicit val bannedChampionFormat = Json.format[BannedChampion]
}