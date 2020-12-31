package cz.sedy.coaches.service

import cz.sedy.coaches.model.domain.Coach
import cz.sedy.coaches.model.command.CoachCreateCommand
import cz.sedy.coaches.model.command.CoachUpdateCommand
import kotlinx.coroutines.flow.Flow

interface CoachService {
    fun getAll(): Flow<Coach>

    suspend fun getById(id: String): Coach

    suspend fun createCoach(createCommand: CoachCreateCommand): Coach

    suspend fun updateCoach(updateCommand: CoachUpdateCommand): Coach

    suspend fun deleteById(id: String)
}