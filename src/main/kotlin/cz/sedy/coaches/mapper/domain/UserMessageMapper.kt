package cz.sedy.planner.mapper.domain

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.planner.model.command.UserMessageCreateCommand
import cz.sedy.coaches.model.domain.UserMessage
import cz.sedy.planner.model.command.UserMessageUpdateCommand
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(config = MappingConfig::class)
interface UserMessageMapper{

	fun createFromCreateCommand(createCommand: UserMessageCreateCommand): UserMessage

	fun updateFromUpdateCommand(updateCommand: UserMessageUpdateCommand, @MappingTarget domain: UserMessage)
}
