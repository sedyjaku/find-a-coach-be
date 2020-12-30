package cz.sedy.planner.mapper.domain

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.planner.model.command.CoachCreateCommand
import cz.sedy.coaches.model.domain.Coach
import cz.sedy.planner.model.command.CoachUpdateCommand
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget


@Mapper(config = MappingConfig::class)
interface CoachMapper{

	fun createFromCreateCommand(createCommand: CoachCreateCommand): Coach

	fun updateByUpdateCommand(updateCommand: CoachUpdateCommand, @MappingTarget domain: Coach)
}
