package ru.zdoher.japs.repositories.aggregation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import reactor.core.publisher.Mono;

public class RepositoryAggregationImpl<T> implements RepositoryAggregation<T> {
    private static final int RANDOM_COUNT = 1;

    private ReactiveMongoTemplate mongoTemplate;

    public RepositoryAggregationImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<T> getRandom(Class<T> tClass) {

        SampleOperation match = Aggregation.sample(RANDOM_COUNT);
        Aggregation aggregation = Aggregation.newAggregation(match);

        return mongoTemplate.aggregate(aggregation, tClass, tClass).last();
    }
}
