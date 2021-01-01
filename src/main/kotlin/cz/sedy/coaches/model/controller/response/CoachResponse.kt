package cz.sedy.coaches.model.controller.response

import cz.sedy.coaches.model.ExpertiseType
import cz.sedy.coaches.model.Identified
import cz.sedy.coaches.model.SexType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class CoachResponse(

	val id: String,

	var firstName: String,

	var lastName: String,

	var email: String,

	var age: Int,

	var sexType: SexType,

	val expertiseList: MutableList<ExpertiseType>
)