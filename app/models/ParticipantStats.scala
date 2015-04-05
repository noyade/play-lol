package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class ParticipantStats(
                             assists: Long,
                             champLevel: Long,
                             combatPlayerScore: Long,
                             deaths: Long,
                             doubleKills: Long,
                             firstBloodAssist: Boolean,
                             firstBloodKill: Boolean,
                             firstInhibitorAssist: Boolean,
                             firstInhibitorKill: Boolean,
                             firstTowerAssist: Boolean,
                             firstTowerKill: Boolean,
                             goldEarned: Long,
                             goldSpent: Long,
                             inhibitorKills: Long,
                             item0: Long,
                             item1: Long,
                             item2: Long,
                             item3: Long,
                             item4: Long,
                             item5: Long,
                             item6: Long
                             )

case class MoreParticipantStats(
                                 killingSprees: Long,
                                 kills: Long,
                                 largestCriticalStrike: Long,
                                 largestKillingSpree: Long,
                                 largestMultiKill: Long,
                                 magicDamageDealt: Long,
                                 magicDamageDealtToChampions: Long,
                                 magicDamageTaken: Long,
                                 minionsKilled: Long,
                                 neutralMinionsKilled: Long,
                                 neutralMinionsKilledEnemyJungle: Long,
                                 neutralMinionsKilledTeamJungle: Long,
                                 nodeCapture: Long,
                                 nodeCaptureAssist: Long,
                                 nodeNeutralize: Long,
                                 nodeNeutralizeAssist: Long,
                                 objectivePlayerScore: Long,
                                 pentaKills: Long,
                                 physicalDamageDealt: Long,
                                 physicalDamageDealtToChampions: Long,
                                 physicalDamageTaken: Long
                                 )

case class MoreMoreParticipantStats(
                                     quadraKills: Long,
                                     sightWardsBoughtInGame: Long,
                                     teamObject: Long,
                                     totalDamageDealt: Long,
                                     totalDamageDealtToChampions: Long,
                                     totalDamageTaken: Long,
                                     totalHeal: Long,
                                     totalPlayerScore: Long,
                                     totalScoreRank: Long,
                                     totalTimeCrowdControlDealt: Long,
                                     totalUnitsHealed: Long,
                                     towerKills: Long,
                                     tripleKills: Long,
                                     trueDamageDealt: Long,
                                     trueDamageDealtToChampions: Long,
                                     trueDamageTaken: Long,
                                     unrealKills: Long,
                                     visionWardsBoughtInGame: Long,
                                     wardsKilled: Long,
                                     wardsPlaced: Long,
                                     winner: Boolean
                                     )

object MoreMoreParticipantStats{
  implicit val moreMoreParticipantStatsFormat = Json.format[MoreMoreParticipantStats]
}

object MoreParticipantStats{
  import MoreMoreParticipantStats._
  implicit val moreParticipantStatsFormat = Json.format[MoreParticipantStats]
}

object ParticipantStats {
  import MoreParticipantStats._
  implicit val participantStatsFormat = Json.format[ParticipantStats]
}
