package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class ParticipantIdentity(
                                  participantId: Int,
                                  player: Option[Player]
                                  )

object ParticipantIdentity {

  implicit val participantIdentityFormat = Json.format[ParticipantIdentity]
}