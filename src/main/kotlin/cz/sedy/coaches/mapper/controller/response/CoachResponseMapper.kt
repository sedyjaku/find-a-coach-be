package cz.sedy.coaches.mapper.controller.response

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.domain.Coach
import cz.sedy.coaches.model.controller.response.CoachResponse
import org.mapstruct.Mapper


@Mapper(config = MappingConfig::class)
interface CoachResponseMapper{

	fun createFromDomain(domain: Coach): CoachResponse
}
