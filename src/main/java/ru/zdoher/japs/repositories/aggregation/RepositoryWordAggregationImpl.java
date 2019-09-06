package ru.zdoher.japs.repositories.aggregation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import ru.zdoher.japs.domain.Word;

public class RepositoryWordAggregationImpl implements RepositoryWordAggregation {
    private static final int RANDOM_COUNT = 1;

    private final MongoTemplate mongoTemplate;

    public RepositoryWordAggregationImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Word getRandom() {
        MatchOperation match = Aggregation.match(new Criteria("dontShow").is(false));
        SampleOperation sampleOperation = Aggregation.sample(RANDOM_COUNT);
        //SampleOperation match = Aggregation.match(new Criteria("dontShow").is(false)).sample(RANDOM_COUNT);
        Aggregation aggregation = Aggregation.newAggregation(match, sampleOperation);

        return mongoTemplate.aggregate(aggregation, Word.class, Word.class).getUniqueMappedResult();
    }
}
