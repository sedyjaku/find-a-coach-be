package cz.sedy.coaches.handler

import cz.sedy.coaches.constant.ID_PATH_VARIABLE
import cz.sedy.coaches.service.UserMessageService
import cz.sedy.planner.mapper.command.UserMessageCreateCommandMapper
import cz.sedy.planner.mapper.command.UserMessageUpdateCommandMapper
import cz.sedy.planner.mapper.controller.response.UserMessageResponseMapper
import cz.sedy.planner.model.controller.request.UserMessageRequest
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class UserMessageHandler (
        private val userMessageService: UserMessageService,
        private val userMessageResponseMapper: UserMessageResponseMapper,
        private val userMessageUpdateCommandMapper: UserMessageUpdateCommandMapper,
        private val userMessageCreateCommandMapper: UserMessageCreateCommandMapper
) {

    suspend fun getAll(request: ServerRequest): ServerResponse =
            ServerResponse.ok().json().bodyAndAwait(
                    userMessageService.getAll()
                            .map { userMessageResponseMapper::createFromDomain }
            )

    suspend fun getById(request: ServerRequest): ServerResponse =
            ServerResponse.ok().json().bodyValueAndAwait(
                    userMessageResponseMapper.createFromDomain(
                            userMessageService.getById(request.pathVariable(ID_PATH_VARIABLE))
                    )
            )

    suspend fun createUserMessage(request: ServerRequest) =
            ServerResponse.ok().json().bodyValueAndAwait(
                    userMessageService.createUserMessage(
                            userMessageCreateCommandMapper.createFromRequest(request.awaitBody(UserMessageRequest::class))
                    )
            )

    suspend fun updateUserMessage(request: ServerRequest) =
            ServerResponse.ok().json().bodyValueAndAwait(
                    userMessageService.updateUserMessage(
                            userMessageUpdateCommandMapper.createFromRequest(
                                    request.awaitBody(UserMessageRequest::class),
                                    request.pathVariable(ID_PATH_VARIABLE)
                            )
                    )
            )

    suspend fun deleteUserMessage(request: ServerRequest): ServerResponse {
        userMessageService.deleteById(request.pathVariable(ID_PATH_VARIABLE))
        return ServerResponse.noContent().buildAndAwait()
    }
}