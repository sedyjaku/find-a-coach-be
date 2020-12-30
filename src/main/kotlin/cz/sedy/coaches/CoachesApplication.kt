package cz.sedy.coaches

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoachesApplication

fun main(args: Array<String>) {
	runApplication<CoachesApplication>(*args)
}
