package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.repositories.aggregation.RepositoryKanjiAggregation;

@Repository
public interface KanjiRepository extends MongoRepository<Kanji, String>, RepositoryKanjiAggregation {
}
