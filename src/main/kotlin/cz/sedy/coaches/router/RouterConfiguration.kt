package cz.sedy.coaches.router

import USER_MESSAGE_ENDPOINT
import cz.sedy.coaches.handler.CoachHandler
import cz.sedy.coaches.handler.UserMessageHandler
import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {

    @FlowPreview
    @Bean
    fun userMessageRoutes(handler: UserMessageHandler) = coRouter {
        USER_MESSAGE_ENDPOINT.nest {
            GET("", handler::getAll)
            GET("/{id}", handler::getById)
            POST("", handler::createUserMessage)
            PUT("/{id}", handler::updateUserMessage)
            DELETE("/{id}", handler::deleteUserMessage)
        }
    }

    @FlowPreview
    @Bean
    fun coachRoutes(handler: CoachHandler) = coRouter {
        USER_MESSAGE_ENDPOINT.nest {
            GET("", handler::getAll)
            GET("/{id}", handler::getById)
            POST("", handler::createCoach)
            PUT("/{id}", handler::updateCoach)
            DELETE("/{id}", handler::deleteCoach)
        }
    }
}