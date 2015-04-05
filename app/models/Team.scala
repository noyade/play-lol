package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Team(
                 bans: List[BannedChampion],
                 baronKills: Int,
                 dominionVictoryScore: Long,
                 dragonKills: Int,
                 firstBaron: Boolean,
                 firstBlood: Boolean,
                 firstDragon: Boolean,
                 firstInhibitor: Boolean,
                 firstTower: Boolean,
                 inhibitorKills: Int,
                 teamId: Int,
                 towerKills: Int,
                 vilemawKills: Int,
                 winner: Boolean
                  )

object Team {

  implicit val teamFormat = Json.format[Team]
}