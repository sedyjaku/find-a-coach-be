package cz.sedy.coaches

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
class CoachesApplication

fun main(args: Array<String>) {
	runApplication<CoachesApplication>(*args)
}
