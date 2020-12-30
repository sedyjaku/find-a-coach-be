package cz.sedy.planner.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.planner.model.controller.request.CoachRequest
import cz.sedy.planner.model.command.CoachCreateCommand
import org.mapstruct.Mapper

@Mapper(config = MappingConfig::class)
interface CoachCreateCommandMapper{

	fun createFromRequest(request: CoachRequest): CoachCreateCommand
}
