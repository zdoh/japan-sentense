package ru.zdoher.japs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.Language;

@Repository
public interface LanguageRepository
        extends CrudRepository<Language, String> {
}
