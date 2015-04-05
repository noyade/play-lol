package services

import models.{MatchDetail, ChampMatchDetail}

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

/**
 * Created by lou on 4/4/15.
 */
trait ChampMatches {

  val champMatches:ChampMatchesContract

  trait ChampMatchesContract extends repositories.ChampMatchDetails {
  }

  class ChampMatchesService extends ChampMatchesContract {
    val champMatchDetails = new AnormChampMatchDetails

    def transformAndInsert(matchDetail: MatchDetail) = champMatchDetails.create(new ChampMatchDetail(-1,3))
  }
}
