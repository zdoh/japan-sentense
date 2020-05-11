package ru.zdoher.japs.repositories.aggregation

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import reactor.core.publisher.Mono

class RepositoryAggregationImpl<T>(private val mongoTemplate: ReactiveMongoTemplate) : RepositoryAggregation<T> {

    override fun getRandom(tClass: Class<T>): Mono<T> {
        val match = Aggregation.sample(RANDOM_COUNT.toLong())
        val aggregation = Aggregation.newAggregation(match)
        return mongoTemplate.aggregate(aggregation, tClass, tClass).last()
    }

    companion object {
        private const val RANDOM_COUNT = 1
    }

}