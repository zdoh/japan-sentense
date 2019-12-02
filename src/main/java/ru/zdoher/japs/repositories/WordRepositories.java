package ru.zdoher.japs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation;

import java.util.List;

@Repository
public interface WordRepositories
        extends CrudRepository<Word, String>, RepositoryAggregation<Word> {

    List<Word> findAll();

}
