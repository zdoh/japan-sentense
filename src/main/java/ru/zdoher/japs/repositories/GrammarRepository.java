package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.grammar.Grammar;

@Repository
public interface GrammarRepository
        extends ReactiveMongoRepository<Grammar, String> {

}
