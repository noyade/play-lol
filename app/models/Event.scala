package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/4/15.
 */
case class Event(
                  ascendedType: String,
                  assistingParticipantIds: List[String],
                  buildingType: String,
                  creatorId: Int,
                  eventType: String,
                  itemAfter: Int,
                  itemBefore: Int,
                  itemId: Int,
                  killerId: Int,
                  laneType: String,
                  levelUpType: String,
                  monsterType: String,
                  participantId: Int,
                  pointCaptured: String,
                  position: Position,
                  skillSlot: Int,
                  teamId: Int,
                  timestamp: Long,
                  towerType: String,
                  victimId: Int,
                  wardType: String
                  )

object Event {

  implicit val eventFormat = Json.format[Event]
}
