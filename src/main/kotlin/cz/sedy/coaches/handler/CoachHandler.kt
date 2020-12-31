package cz.sedy.coaches.handler

import cz.sedy.coaches.constant.ID_PATH_VARIABLE
import cz.sedy.coaches.service.CoachService
import cz.sedy.coaches.mapper.command.CoachCreateCommandMapper
import cz.sedy.coaches.mapper.command.CoachUpdateCommandMapper
import cz.sedy.coaches.mapper.controller.response.CoachResponseMapper
import cz.sedy.coaches.model.controller.request.CoachRequest
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class CoachHandler(
        private val coachService: CoachService,
        private val coachResponseMapper: CoachResponseMapper,
        private val coachUpdateCommandMapper: CoachUpdateCommandMapper,
        private val coachCreateCommandMapper: CoachCreateCommandMapper
) {

    suspend fun getAll(request: ServerRequest): ServerResponse =
            ServerResponse.ok().json().bodyAndAwait(
                    coachService.getAll()
                            .map { coachResponseMapper::createFromDomain }
            )

    suspend fun getById(request: ServerRequest): ServerResponse =
            ServerResponse.ok().json().bodyValueAndAwait(
                    coachResponseMapper.createFromDomain(
                            coachService.getById(request.pathVariable(ID_PATH_VARIABLE))
                    )
            )

    suspend fun createCoach(request: ServerRequest) =
            ServerResponse.ok().json().bodyValueAndAwait(
                    coachService.createCoach(
                            coachCreateCommandMapper.createFromRequest(request.awaitBody(CoachRequest::class))
                    )
            )

    suspend fun updateCoach(request: ServerRequest) =
            ServerResponse.ok().json().bodyValueAndAwait(
                    coachService.updateCoach(
                            coachUpdateCommandMapper.createFromRequest(
                                    request.awaitBody(CoachRequest::class),
                                    request.pathVariable(ID_PATH_VARIABLE)
                            )
                    )
            )

    suspend fun deleteCoach(request: ServerRequest): ServerResponse {
        coachService.deleteById(request.pathVariable(ID_PATH_VARIABLE))
        return ServerResponse.noContent().buildAndAwait()
    }
}