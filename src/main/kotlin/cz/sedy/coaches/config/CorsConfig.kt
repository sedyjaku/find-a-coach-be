package cz.sedy.coaches.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.server.ServerWebExchange


const val CORS_PROPERTIES_PREFIX = "web.cors"


@Configuration
@EnableWebFlux
class CorsGlobalConfiguration : WebFluxConfigurer {

    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
            .maxAge(3600)
    }

    @Bean
    fun corsFilter(): CorsWebFilter? {
        return CorsWebFilter { CorsConfiguration().applyPermitDefaultValues() }
    }
}