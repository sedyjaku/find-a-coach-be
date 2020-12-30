package cz.sedy.coaches.service.impl

import cz.sedy.coaches.exception.NotFoundException
import cz.sedy.coaches.model.domain.UserMessage
import cz.sedy.coaches.service.UserMessageService
import cz.sedy.planner.mapper.domain.UserMessageMapper
import cz.sedy.planner.model.command.UserMessageCreateCommand
import cz.sedy.planner.model.command.UserMessageUpdateCommand
import cz.sedy.planner.repository.UserMessageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrElse
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service

@Service
class DefaultUserMessageService (
        private val userMessageRepository: UserMessageRepository,
        private val userMessageMapper: UserMessageMapper
) : UserMessageService {


    override fun getAll(): Flow<UserMessage> =
            userMessageRepository.findAll().asFlow()

    override suspend fun getById(id: String): UserMessage =
            userMessageRepository.findById(id).awaitFirstOrElse { throw NotFoundException.of(id, UserMessage::class.java) }

    override suspend fun createUserMessage(createCommand: UserMessageCreateCommand): UserMessage =
            userMessageRepository.save(
                    userMessageMapper.createFromCreateCommand(createCommand)
            ).awaitSingle()

    override suspend fun updateUserMessage(updateCommand: UserMessageUpdateCommand): UserMessage {
        val existingUserMessage = userMessageRepository.findById(updateCommand.id)
                .awaitFirstOrElse { throw NotFoundException.of(updateCommand.id, UserMessage::class.java) }
        userMessageMapper.updateFromUpdateCommand(updateCommand, existingUserMessage)
        return userMessageRepository.save(existingUserMessage).awaitSingle()
    }

    override suspend fun deleteById(id: String) {
        userMessageRepository.deleteById(id).awaitFirstOrElse { throw NotFoundException.of(id, UserMessage::class.java) }
    }
}