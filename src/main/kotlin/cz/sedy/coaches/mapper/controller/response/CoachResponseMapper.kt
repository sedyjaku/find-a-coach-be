package cz.sedy.planner.mapper.controller.response

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.domain.Coach
import cz.sedy.planner.model.controller.response.CoachResponse
import org.mapstruct.Mapper


@Mapper(config = MappingConfig::class)
interface CoachResponseMapper{

	fun createFromDomain(domain: Coach): CoachResponse
}
