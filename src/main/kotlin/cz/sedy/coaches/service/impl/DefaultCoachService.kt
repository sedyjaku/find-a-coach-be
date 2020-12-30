package cz.sedy.coaches.service.impl

import cz.sedy.coaches.exception.NotFoundException
import cz.sedy.coaches.model.domain.Coach
import cz.sedy.coaches.service.CoachService
import cz.sedy.planner.mapper.domain.CoachMapper
import cz.sedy.planner.model.command.CoachCreateCommand
import cz.sedy.planner.model.command.CoachUpdateCommand
import cz.sedy.planner.repository.CoachRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrElse
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Service

@Service
class DefaultCoachService (
        private val coachRepository: CoachRepository,
        private val coachMapper: CoachMapper
        ) : CoachService {


    override fun getAll(): Flow<Coach> =
            coachRepository.findAll().asFlow()

    override suspend fun getById(id: String): Coach =
            coachRepository.findById(id).awaitFirstOrElse { throw NotFoundException.of(id, Coach::class.java) }

    override suspend fun createCoach(createCommand: CoachCreateCommand): Coach =
            coachRepository.save(
                    coachMapper.createFromCreateCommand(createCommand)
            ).awaitSingle()

    override suspend fun updateCoach(updateCommand: CoachUpdateCommand): Coach {
        val existingCoach = coachRepository.findById(updateCommand.id)
                .awaitFirstOrElse { throw NotFoundException.of(updateCommand.id, Coach::class.java) }
        coachMapper.updateByUpdateCommand(updateCommand, existingCoach)
        return coachRepository.save(existingCoach).awaitSingle()
    }

    override suspend fun deleteById(id: String) {
        coachRepository.deleteById(id).awaitFirstOrElse { throw NotFoundException.of(id, Coach::class.java) }
    }
}