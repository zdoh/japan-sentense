package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Language;

@Repository
public interface LanguageRepository
        extends ReactiveMongoRepository<Language, String> {
}
