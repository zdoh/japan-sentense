package ru.zdoher.japs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Grammar;

@Repository
public interface GrammarRepository
        extends CrudRepository<Grammar, String> {

}
