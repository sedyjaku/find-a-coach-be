package cz.sedy.coaches.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.controller.request.CoachRequest
import cz.sedy.coaches.model.command.CoachUpdateCommand
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MappingConfig::class)
interface CoachUpdateCommandMapper{

	@Mapping(target = "id", source = "id")
	fun createFromRequest(request: CoachRequest, id: String): CoachUpdateCommand
}
