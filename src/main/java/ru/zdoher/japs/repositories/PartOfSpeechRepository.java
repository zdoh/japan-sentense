package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.PartOfSpeech;

@Repository
public interface PartOfSpeechRepository extends MongoRepository<PartOfSpeech, String> {
}