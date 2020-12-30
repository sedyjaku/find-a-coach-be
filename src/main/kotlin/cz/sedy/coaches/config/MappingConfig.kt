package cz.sedy.coaches.config

import org.mapstruct.InjectionStrategy
import org.mapstruct.MapperConfig


@MapperConfig(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface MappingConfig {
}