package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Frame(
                  events: List[Event],
                  participantFrames: Map[String, ParticipantFrame],
                  timestamp: Long
                   )

object Frame {

  implicit val frameFormat = Json.format[Frame]
}