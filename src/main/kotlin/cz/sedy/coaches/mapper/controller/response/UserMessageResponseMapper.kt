package cz.sedy.coaches.mapper.controller.response

import cz.sedy.coaches.config.MappingConfig
import cz.sedy.coaches.model.domain.UserMessage
import cz.sedy.coaches.model.controller.response.UserMessageResponse
import org.mapstruct.Mapper

@Mapper(config = MappingConfig::class)
interface UserMessageResponseMapper{

	fun createFromDomain(domain: UserMessage): UserMessageResponse
}
