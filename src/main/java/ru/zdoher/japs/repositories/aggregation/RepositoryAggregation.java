package ru.zdoher.japs.repositories.aggregation;

import reactor.core.publisher.Mono;

public interface RepositoryAggregation<T> {
    Mono<T> getRandom(Class<T> tClass);
}
