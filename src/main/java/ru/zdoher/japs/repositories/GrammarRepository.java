package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Grammar;
import ru.zdoher.japs.domain.sentence.Sentence;

@Repository
public interface GrammarRepository extends MongoRepository<Grammar, String> {

}
