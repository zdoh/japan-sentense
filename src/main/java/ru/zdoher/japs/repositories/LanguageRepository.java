package ru.zdoher.japs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Language;

@Repository
public interface LanguageRepository extends MongoRepository<Language, String> {
}
