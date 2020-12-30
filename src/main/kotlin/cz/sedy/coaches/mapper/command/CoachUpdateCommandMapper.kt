package cz.sedy.planner.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.planner.model.controller.request.CoachRequest
import cz.sedy.planner.model.command.CoachUpdateCommand
import org.mapstruct.Mapper

@Mapper(config = MappingConfig::class)
interface CoachUpdateCommandMapper{

	fun createFromRequest(request: CoachRequest, id: String): CoachUpdateCommand
}
