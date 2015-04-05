package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Participant(
                        championId: Int,
                        highestAchievedSeasonTier: String,
                        masteries: List[Mastery],
                        participantId: Int,
                        runes: List[Rune],
                        spell1Id: Int,
                        spell2Id: Int,
                        stats: ParticipantStats,
                        teamId: Int,
                        timeline: ParticipantTimeline
                         )

object Participant {

  implicit val participantFormat = Json.format[Participant]
}