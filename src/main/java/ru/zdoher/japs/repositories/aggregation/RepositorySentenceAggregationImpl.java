package ru.zdoher.japs.repositories.aggregation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.sentence.Sentence;

@Repository
public class RepositorySentenceAggregationImpl implements RepositorySentenceAggregation {
    private static final int RANDOM_COUNT = 1;

    private final MongoTemplate mongoTemplate;

    public RepositorySentenceAggregationImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Sentence getRandom() {
        SampleOperation match = Aggregation.sample(RANDOM_COUNT);
        Aggregation aggregation = Aggregation.newAggregation(match);

        return mongoTemplate.aggregate(aggregation, Sentence.class, Sentence.class).getUniqueMappedResult();
    }
}
