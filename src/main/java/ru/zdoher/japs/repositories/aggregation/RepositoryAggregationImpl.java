package ru.zdoher.japs.repositories.aggregation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.service.MyMessageService;

public class RepositoryAggregationImpl<T> implements RepositoryAggregation<T> {
    private static final int RANDOM_COUNT = 1;

    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    private MyMessageService sendChannel;

    public RepositoryAggregationImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<T> getRandom(Class<T> tClass) {

        SampleOperation match = Aggregation.sample(RANDOM_COUNT);
        Aggregation aggregation = Aggregation.newAggregation(match);

        Mono<T> result = mongoTemplate.aggregate(aggregation, tClass, tClass).last();
        sendChannel.sendMes(MessageBuilder.withPayload("got random fo " + tClass.getSimpleName()).build());
        return result;
    }
}
