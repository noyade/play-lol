package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class ParticipantTimelineData (
                                     tenToTwenty: Option[Double],
                                     thirtyToEnd: Option[Double],
                                     twentyToThirty: Option[Double],
                                     zeroToTen: Option[Double]
                                     )

object ParticipantTimelineData {

  implicit val participantTimelineDataFormat = Json.format[ParticipantTimelineData]
}




