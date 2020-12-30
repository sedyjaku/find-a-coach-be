package cz.sedy.coaches.model.domain

import cz.sedy.coaches.model.Identified
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class UserMessage(

        @Id
        override val id: String?,

        val title: String,

        val message: String,

        var answer: String?,

        val coachId: String,

        val userId: String

):Identified