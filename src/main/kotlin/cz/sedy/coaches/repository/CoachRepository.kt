package cz.sedy.planner.repository

import cz.sedy.coaches.model.domain.Coach
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CoachRepository : ReactiveMongoRepository<Coach,String>