package ru.zdoher.japs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation;

@Repository
public interface KanjiRepository
        extends CrudRepository<Kanji, String>, RepositoryAggregation<Kanji> {
}
