package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation;

@Repository
public interface WordRepositories
        extends ReactiveMongoRepository<Word, String>, RepositoryAggregation<Word> {

}
