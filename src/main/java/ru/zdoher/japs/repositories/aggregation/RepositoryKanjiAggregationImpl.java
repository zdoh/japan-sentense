package ru.zdoher.japs.repositories.aggregation;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.SampleOperation;
import ru.zdoher.japs.domain.Kanji;

public class RepositoryKanjiAggregationImpl implements RepositoryKanjiAggregation {
    private static final int RANDOM_COUNT = 1;

    private final MongoTemplate mongoTemplate;

    public RepositoryKanjiAggregationImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Kanji getRandom() {
        SampleOperation match = Aggregation.sample(RANDOM_COUNT);
        Aggregation aggregation = Aggregation.newAggregation(match);

        return mongoTemplate.aggregate(aggregation, Kanji.class, Kanji.class).getUniqueMappedResult();
    }
}
