package controllers

import models._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.{Json, JsResult}
import scala.concurrent.ExecutionContext.Implicits.global

import controllers.Application._
import play.api.libs.ws.WS
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future
import scala.util.{Success, Failure}


/**
 * Created by lou on 4/4/15.
 */
object CMatch extends Controller with services.ChampMatches {

  val testJson = """
  {
  "matchId":1694547936,
  "region":"NA",
  "platformId":"NA1",
  "matchMode":"CLASSIC",
  "matchType":"MATCHED_GAME",
  "matchCreation":1421045251794,
  "matchDuration":2251,
  "queueType":"RANKED_SOLO_5x5",
  "mapId":11,
  "season":"PRESEASON2015",
  "matchVersion":"4.21.0.397"
  }
  """


  val testParticipantJson = """
  {
    "teamId":100,
    "spell1Id":12,
    "spell2Id":4,
    "championId":127,
    "highestAchievedSeasonTier":"GOLD",
    "timeline":{
      "creepsPerMinDeltas":{
      "zeroToTen":5.0,
      "tenToTwenty":7.4,
      "twentyToThirty":7.1,
      "thirtyToEnd":6.0
    },
      "xpPerMinDeltas":{
      "zeroToTen":413.9,
      "tenToTwenty":519.0999999999999,
      "twentyToThirty":460.6,
      "thirtyToEnd":441.8
    },
      "goldPerMinDeltas":{
      "zeroToTen":190.10000000000002,
      "tenToTwenty":333.4,
      "twentyToThirty":354.6,
      "thirtyToEnd":343.4
    },
      "csDiffPerMinDeltas":{
      "zeroToTen":-1.2999999999999996,
      "tenToTwenty":-2.3000000000000003,
      "twentyToThirty":-1.6,
      "thirtyToEnd":0.0
    },
      "xpDiffPerMinDeltas":{
      "zeroToTen":-72.6,
      "tenToTwenty":7.299999999999983,
      "twentyToThirty":-147.10000000000005,
      "thirtyToEnd":-84.40000000000003
    },
      "damageTakenPerMinDeltas":{
      "zeroToTen":256.5,
      "tenToTwenty":494.4,
      "twentyToThirty":798.4,
      "thirtyToEnd":1345.4
    },
      "damageTakenDiffPerMinDeltas":{
      "zeroToTen":-370.20000000000005,
      "tenToTwenty":-1021.4000000000001,
      "twentyToThirty":-345.8,
      "thirtyToEnd":-551.1999999999998
    },
      "role":"SOLO",
      "lane":"TOP"
    },
    "masteries":[
    {
      "masteryId":4113,
      "rank":3
    },
    {
      "masteryId":4114,
      "rank":1
    },
    {
      "masteryId":4123,
      "rank":3
    },
    {
      "masteryId":4124,
      "rank":1
    },
    {
      "masteryId":4133,
      "rank":1
    },
    {
      "masteryId":4134,
      "rank":3
    },
    {
      "masteryId":4143,
      "rank":3
    },
    {
      "masteryId":4144,
      "rank":1
    },
    {
      "masteryId":4152,
      "rank":3
    },
    {
      "masteryId":4154,
      "rank":1
    },
    {
      "masteryId":4162,
      "rank":1
    },
    {
      "masteryId":4312,
      "rank":3
    },
    {
      "masteryId":4313,
      "rank":3
    },
    {
      "masteryId":4322,
      "rank":1
    },
    {
      "masteryId":4324,
      "rank":1
    },
    {
      "masteryId":4334,
      "rank":1
    }
    ],
    "stats":{
      "winner":true,
      "champLevel":17,
      "item0":3027,
      "item1":3157,
      "item2":1052,
      "item3":3020,
      "item4":0,
      "item5":3165,
      "item6":3340,
      "kills":1,
      "doubleKills":0,
      "tripleKills":0,
      "quadraKills":0,
      "pentaKills":0,
      "unrealKills":0,
      "largestKillingSpree":0,
      "deaths":7,
      "assists":10,
      "totalDamageDealt":195530,
      "totalDamageDealtToChampions":29488,
      "totalDamageTaken":22834,
      "largestCriticalStrike":0,
      "totalHeal":930,
      "minionsKilled":231,
      "neutralMinionsKilled":0,
      "neutralMinionsKilledTeamJungle":0,
      "neutralMinionsKilledEnemyJungle":0,
      "goldEarned":12331,
      "goldSpent":11110,
      "combatPlayerScore":0,
      "objectivePlayerScore":0,
      "totalPlayerScore":0,
      "totalScoreRank":0,
      "magicDamageDealtToChampions":22296,
      "physicalDamageDealtToChampions":7092,
      "trueDamageDealtToChampions":100,
      "visionWardsBoughtInGame":1,
      "sightWardsBoughtInGame":3,
      "magicDamageDealt":174305,
      "physicalDamageDealt":20874,
      "trueDamageDealt":350,
      "magicDamageTaken":9409,
      "physicalDamageTaken":12523,
      "trueDamageTaken":902,
      "firstBloodKill":false,
      "firstBloodAssist":false,
      "firstTowerKill":false,
      "firstTowerAssist":false,
      "firstInhibitorKill":false,
      "firstInhibitorAssist":false,
      "inhibitorKills":0,
      "towerKills":0,
      "wardsPlaced":13,
      "wardsKilled":0,
      "largestMultiKill":1,
      "killingSprees":0,
      "totalUnitsHealed":1,
      "totalTimeCrowdControlDealt":520
    },
    "participantId":1,
    "runes":[
    {
      "runeId":5273,
      "rank":9
    },
    {
      "runeId":5298,
      "rank":9
    },
    {
      "runeId":5317,
      "rank":9
    },
    {
      "runeId":5357,
      "rank":3
    }
    ]
  }

  """

  val champMatches = new ChampMatchesService

  val apikey = current.configuration.getString("riot.apikey") match {
    case Some(key) => key
    case None => println("No api key found!")
  }

  def getMatch(id: Long) = Action {
    val uri = "https://na.api.pvp.net/api/lol/na/v2.2/match/" + id + "?api_key=" + apikey

    var futureResult: Future[JsResult[MatchDetail]] = WS.url(uri).get().map {
      response =>
        (response.json).validate[MatchDetail]
    }

    futureResult onComplete {
      case Success(matchDetail) => {

        println("---- matchDetail ----")
        println(matchDetail.get)
        println("---- end matchDetail ----")

        var futureCreatedMatch: Future[ChampMatchDetail] =
        champMatches.transformAndInsert(matchDetail.get).map {
          case Some(created:ChampMatchDetail) => created
          case _ => null
        }

        futureCreatedMatch onComplete {
          case Success(champMatchDetail) => {
            println("inserted!")
          }
        }
      }
      case Failure(t) => println("An error has occured: " + t.getMessage)
    }

    Ok("yup")
  }

  def matches = Action {
    var matchDetail = Json.parse(testParticipantJson).validate[Participant]

    println(matchDetail.get)
    Ok("sure")
  }

  def matchReceived(matchDetail: MatchDetail) = Action {
    Ok(matchDetail.toString)
  }

  def urfMatches = Action {
    Ok(views.html.index("urf"))
  }

}