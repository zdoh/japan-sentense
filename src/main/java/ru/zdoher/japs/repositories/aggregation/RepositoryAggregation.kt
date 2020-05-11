package ru.zdoher.japs.repositories.aggregation

import reactor.core.publisher.Mono
import kotlin.reflect.KClass

interface RepositoryAggregation<T> {
    fun getRandom(tClass: KClass<*>): Mono<T>
}