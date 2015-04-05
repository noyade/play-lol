package repositories

import models.ChampMatchDetail

import scala.language.postfixOps

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

import anorm._
import play.api.db.DB
import play.api.Play.current

/**
 * Created by lou on 4/4/15.
 */
trait ChampMatchDetails {

  val champMatchDetails:ChampMatchDetailsContract

  trait ChampMatchDetailsContract {

    def getById(id: Long):Future[Option[ChampMatchDetail]]
    def findByChampId(champId: Long):Future[List[ChampMatchDetail]]
    def create(champMatchDetail: ChampMatchDetail):Future[Option[ChampMatchDetail]]
  }

  class AnormChampMatchDetails extends ChampMatchDetailsContract {
    val fields ="""id,champId"""

    def getById(id: Long) = Future {
      DB.withConnection { implicit connection =>
        SQL(
          s"""
              SELECT $fields
              FROM PUBLIC.CHAMPMATCHDETAIL
              WHERE id = {id}
              LIMIT 1
           """
        ).on(
            'id -> id
          ).as(ChampMatchDetail.fromDB.singleOpt)
      }
    }

    def findByChampId(champId: Long) = Future {
      DB.withConnection { implicit connection =>
        println(connection.toString)
        SQL(
        s"""
           SELECT $fields
           FROM PUBLIC.CHAMPMATCHDETAIL
           WHERE champId = {champId}
        """
        ).on(
            'champId -> champId
          ).as(ChampMatchDetail.fromDB *)
      }
    }

    def create(champMatchDetail: ChampMatchDetail) = Future {

      DB.withConnection { implicit connection =>
        SQL(
        s"""
           INSERT INTO PUBLIC.CHAMPMATCHDETAIL (champId)
           VALUES ({champId});
         """).on(
          'champId -> champMatchDetail.champId
          ).executeInsert()
      }
    } map {
      case Some(id:Long) =>
        Some(ChampMatchDetail(
          id,
          champMatchDetail.champId
        ))
      case _ => None
    }
  }
}
