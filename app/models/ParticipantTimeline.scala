package models

import play.api.libs.json.Json

/**
 * Created by lou on 4/3/15.
 */
case class ParticipantTimeline(
                                ancientGolemAssistsPerMinCounts: Option[ParticipantTimelineData],
                                ancientGolemKillsPerMinCounts: Option[ParticipantTimelineData],
                                assistedLaneDeathsPerMinDeltas: Option[ParticipantTimelineData],
                                assistedLaneKillsPerMinDeltas: Option[ParticipantTimelineData],
                                baronAssistsPerMinCounts: Option[ParticipantTimelineData],
                                baronKillsPerMinCounts: Option[ParticipantTimelineData],
                                creepsPerMinDeltas: Option[ParticipantTimelineData],
                                csDiffPerMinDeltas: Option[ParticipantTimelineData],
                                damageTakenDiffPerMinDeltas: Option[ParticipantTimelineData],
                                damageTakenPerMinDeltas: Option[ParticipantTimelineData],
                                dragonAssistsPerMinCounts: Option[ParticipantTimelineData],
                                dragonKillsPerMinCounts: Option[ParticipantTimelineData],
                                elderLizardAssistsPerMinCounts: Option[ParticipantTimelineData],
                                elderLizardKillsPerMinCounts: Option[ParticipantTimelineData],
                                goldPerMinDeltas: Option[ParticipantTimelineData],
                                inhibitorAssistsPerMinCounts: Option[ParticipantTimelineData],
                                inhibitorKillsPerMinCounts: Option[ParticipantTimelineData],
                                lane: String,
                                role: String,
                                towerAssistsPerMinCounts: Option[ParticipantTimelineData],
                                towerKillsPerMinCounts: Option[ParticipantTimelineData]
                                )

case class MoreParticipantTimeline(
                                    towerKillsPerMinDeltas: Option[ParticipantTimelineData],
                                    vilemawAssistsPerMinCounts: Option[ParticipantTimelineData],
                                    vilemawKillsPerMinCounts: Option[ParticipantTimelineData],
                                    wardsPerMinDeltas: Option[ParticipantTimelineData],
                                    xpDiffPerMinDeltas: Option[ParticipantTimelineData],
                                    xpPerMinDeltas: Option[ParticipantTimelineData]
                                    )

object MoreParticipantTimeline {
  implicit val moreParticipantTimelineFormat = Json.format[MoreParticipantTimeline]
}

object ParticipantTimeline {
  import MoreParticipantTimeline._
  implicit val participantTimelineFormat = Json.format[ParticipantTimeline]
}