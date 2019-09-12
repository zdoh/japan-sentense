package ru.zdoher.japs.repositories.sentence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;

@Repository
public interface SentencePolitenessRepository extends MongoRepository<SentencePoliteness, String> {
}
