package cz.sedy.coaches.exception

import cz.sedy.coaches.model.Identified


class NotFoundException(message: String?) : RuntimeException(message) {

    companion object {
        fun of(id: String, clazz: Class<*>): NotFoundException {
            return NotFoundException("Document of type ${clazz.simpleName} with id $id was not found.")
        }

        fun of(identified: Identified): NotFoundException {
            return NotFoundException("Document of type ${identified.javaClass.simpleName} with id ${identified.id} was not found.")
        }

    }
}