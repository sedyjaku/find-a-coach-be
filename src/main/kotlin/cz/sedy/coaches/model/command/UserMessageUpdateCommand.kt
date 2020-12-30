package cz.sedy.planner.model.command

import cz.sedy.coaches.model.Identified
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class UserMessageUpdateCommand(

	val id: String,

	val title: String,

	val message: String,

	var answer: String,

	val coachId: String,

	val userId: String
)