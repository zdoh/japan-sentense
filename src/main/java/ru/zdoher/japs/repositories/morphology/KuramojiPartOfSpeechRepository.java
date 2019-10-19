package ru.zdoher.japs.repositories.morphology;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.morphology.KuramojiPartOfSpeech;

@Repository
public interface KuramojiPartOfSpeechRepository extends ReactiveCrudRepository<KuramojiPartOfSpeech, String> {
    Mono<KuramojiPartOfSpeech> findByName(String name);
}
