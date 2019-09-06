package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.aggregation.RepositoryWordAggregation;

@Repository
public interface WordRepositories extends MongoRepository<Word, String>, RepositoryWordAggregation {

}
