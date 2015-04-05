package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Player(
                   matchHistoryUri: String,
                   profileIcon: Int,
                   summonerId: Int,
                   summonerName: String
                   )

object Player {

  implicit val playerFormat = Json.format[Player]
}