package cz.sedy.planner.mapper.command

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.planner.model.controller.request.UserMessageRequest
import cz.sedy.planner.model.command.UserMessageCreateCommand
import org.mapstruct.Mapper

@Mapper(config = MappingConfig::class)
interface UserMessageCreateCommandMapper{

	fun createFromRequest(request: UserMessageRequest): UserMessageCreateCommand
}