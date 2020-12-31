package cz.sedy.coaches.repository

import cz.sedy.coaches.model.domain.Coach
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

interface CoachRepository : ReactiveMongoRepository<Coach,String>