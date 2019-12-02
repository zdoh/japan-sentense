package ru.zdoher.japs.repositories.aggregation;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;

public class RepositoryAggregationImpl<T> implements RepositoryAggregation<T> {
    private static final int RANDOM_COUNT = 1;

    private MongoTemplate mongoTemplate;

    public RepositoryAggregationImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public T getRandom(Class<T> tClass) {

        SampleOperation match = Aggregation.sample(RANDOM_COUNT);
        Aggregation aggregation = Aggregation.newAggregation(match);

        return mongoTemplate.aggregate(aggregation, tClass, tClass).getUniqueMappedResult();
    }
}
