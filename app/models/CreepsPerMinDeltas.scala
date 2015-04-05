package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class CreepsPerMinDeltas(
                               zeroToTen: Double,
                               tenToTwenty: Double,
                               twentyToThirty: Double,
                               thirtyToEnd: Double
                               )

object CreepsPerMinDeltas {

  implicit var creepsPerMinDeltasFormat = Json.format[CreepsPerMinDeltas]
}
