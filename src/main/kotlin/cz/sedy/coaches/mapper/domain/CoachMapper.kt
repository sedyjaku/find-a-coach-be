package cz.sedy.coaches.mapper.domain

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.command.CoachCreateCommand
import cz.sedy.coaches.model.domain.Coach
import cz.sedy.coaches.model.command.CoachUpdateCommand
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget


@Mapper(config = MappingConfig::class)
interface CoachMapper{

	fun createFromCreateCommand(createCommand: CoachCreateCommand): Coach

	fun updateByUpdateCommand(updateCommand: CoachUpdateCommand, @MappingTarget domain: Coach)
}
