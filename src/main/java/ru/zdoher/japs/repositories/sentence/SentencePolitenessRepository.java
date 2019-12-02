package ru.zdoher.japs.repositories.sentence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;

@Repository
public interface SentencePolitenessRepository
        extends CrudRepository<SentencePoliteness, String> {
}
