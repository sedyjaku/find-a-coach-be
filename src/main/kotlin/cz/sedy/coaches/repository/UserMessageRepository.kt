package cz.sedy.coaches.repository

import cz.sedy.coaches.model.domain.UserMessage
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface UserMessageRepository : ReactiveMongoRepository<UserMessage,String>