package models

import play.api.libs.json.Json
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

/**
 * Created by lou on 4/3/15.
 */

case class MatchDetail (
                         mapId: Int,
                         matchCreation: Long,
                         matchDuration: Long,
                         matchId: Long,
                         matchMode: String,
                         matchType: String,
                         participantIdentities: Option[List[ParticipantIdentity]],
                         participants: List[Participant],
                         platformId: String,
                         queueType: String,
                         region: String,
                         season: String,
                         teams: Option[List[Team]],
                         timeline: Option[Timeline]
                         )

object MatchDetail {

  implicit val matchDetailFormat = Json.format[MatchDetail]
}