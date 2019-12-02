package ru.zdoher.japs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.PartOfSpeech;

@Repository
public interface PartOfSpeechRepository
        extends CrudRepository<PartOfSpeech, String> {
}
