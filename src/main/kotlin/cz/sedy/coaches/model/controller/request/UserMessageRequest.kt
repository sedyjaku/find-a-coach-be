package cz.sedy.coaches.model.controller.request

import cz.sedy.coaches.model.Identified
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class UserMessageRequest(

	val title: String,

	val message: String,

	var answer: String,

	val coachId: String,

	val userId: String
)