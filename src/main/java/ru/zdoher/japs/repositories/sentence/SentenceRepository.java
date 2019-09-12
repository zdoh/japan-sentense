package ru.zdoher.japs.repositories.sentence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation;

@Repository
public interface SentenceRepository extends MongoRepository<Sentence, String>, RepositoryAggregation<Sentence> {
}
