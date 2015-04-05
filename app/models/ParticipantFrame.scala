package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class ParticipantFrame(
                             currentGold: Int,
                             dominionScore: Int,
                             jungleMinionsKilled: Int,
                             level: Int,
                             minionsKilled: Int,
                             participantId: Int,
                             position: Position,
                             teamScore: Int,
                             totalGold: Int,
                             xp: Int
                             )

object ParticipantFrame {

  implicit var participantFrameFormat = Json.format[ParticipantFrame]
}


