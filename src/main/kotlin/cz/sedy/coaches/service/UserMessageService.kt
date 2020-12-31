package cz.sedy.coaches.service

import cz.sedy.coaches.model.domain.UserMessage
import cz.sedy.coaches.model.command.UserMessageCreateCommand
import cz.sedy.coaches.model.command.UserMessageUpdateCommand
import kotlinx.coroutines.flow.Flow

interface UserMessageService {
    fun getAll(): Flow<UserMessage>

    suspend fun getById(id: String): UserMessage

    suspend fun createUserMessage(createCommand: UserMessageCreateCommand): UserMessage

    suspend fun updateUserMessage(updateCommand: UserMessageUpdateCommand): UserMessage

    suspend fun deleteById(id: String)
}