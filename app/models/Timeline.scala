package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class Timeline(
                   frameInterval: Long,
                   frames: List[Frame]
                     )

object Timeline {

  implicit var timelineFormat = Json.format[Timeline]
}
