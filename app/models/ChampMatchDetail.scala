package models

import anorm._
import anorm.SqlParser._

import play.api.libs.json.Json

/**
 * Created by lou on 4/4/15.
 */
case class ChampMatchDetail(
                           id: Long,
                           champId: Long
                             )
object ChampMatchDetail extends ((
    Long,
    Long
  ) => ChampMatchDetail) {

  implicit val jsonFormat = Json.format[ChampMatchDetail]

  val sqlResult =
    get[Long]("id") ~
    get[Long]("champId")

  val fromDB = sqlResult map {
    case id~champId =>
      ChampMatchDetail(id, champId)
  }
}


