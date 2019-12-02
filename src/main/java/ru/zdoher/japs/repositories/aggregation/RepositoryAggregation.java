package ru.zdoher.japs.repositories.aggregation;

public interface RepositoryAggregation<T> {
    T getRandom(Class<T> tClass);
}
