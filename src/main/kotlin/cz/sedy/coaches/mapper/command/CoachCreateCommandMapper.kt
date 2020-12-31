package cz.sedy.coaches.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.controller.request.CoachRequest
import cz.sedy.coaches.model.command.CoachCreateCommand
import org.mapstruct.Mapper

@Mapper(config = MappingConfig::class)
interface CoachCreateCommandMapper{

	fun createFromRequest(request: CoachRequest): CoachCreateCommand
}
