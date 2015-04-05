package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/4/15.
 */
case class ChampionDto(
                        allytips: List[String],
                        blurb: String,
                        enemytips: List[String],
                        id: Int,
                        //image: ImageDto,
                        //info: InfoDto,
                        key: String,
                        lore: String,
                        name: String,
                        partype: String,
                        //passive: PassiveDto,
                        //recommended: List[RecommendedDto],
                        //skins: List[SkinDto],
                        //spells: List[ChampionSpellDto],
                        //stats: StatsDto,
                        tags: List[String],
                        title: String
                        )

object ChampionDto {

  implicit val championDtoFormat = Json.format[ChampionDto]
}
