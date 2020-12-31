package cz.sedy.coaches.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.controller.request.UserMessageRequest
import cz.sedy.coaches.model.command.UserMessageUpdateCommand
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(config = MappingConfig::class)
interface UserMessageUpdateCommandMapper{

	@Mapping(target = "id", source = "id")
	fun createFromRequest(request: UserMessageRequest, id: String): UserMessageUpdateCommand
}
