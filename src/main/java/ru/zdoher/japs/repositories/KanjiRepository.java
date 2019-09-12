package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation;

@Repository
public interface KanjiRepository
        extends ReactiveMongoRepository<Kanji, String>, RepositoryAggregation<Kanji> {
}
