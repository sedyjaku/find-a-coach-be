package cz.sedy.planner.model.command

import cz.sedy.coaches.model.ExpertiseType
import cz.sedy.coaches.model.Identified
import cz.sedy.coaches.model.SexType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class CoachUpdateCommand(

	val id: String,

	var firstName: String,

	var lastName: String,

	var email: String,

	var Age: Int,

	var sexTypeId: SexType,

	val expertiseList: MutableList<ExpertiseType>
)