package cz.sedy.coaches.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.controller.request.UserMessageRequest
import cz.sedy.coaches.model.command.UserMessageCreateCommand
import org.mapstruct.Mapper

@Mapper(config = MappingConfig::class)
interface UserMessageCreateCommandMapper{

	fun createFromRequest(request: UserMessageRequest): UserMessageCreateCommand
}
