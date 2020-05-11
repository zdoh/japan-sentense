package ru.zdoher.japs.repositories.aggregation

import reactor.core.publisher.Mono

interface RepositoryAggregation<T> {
    fun getRandom(tClass: Class<T>): Mono<T>
}