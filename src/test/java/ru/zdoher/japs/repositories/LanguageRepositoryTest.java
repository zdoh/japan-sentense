package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - LanguageRepository")
@DataMongoTest
class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    @DisplayName(" language add and get - success")
    void languageAddAndGet() {
        Language addedLanguage = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        Language language = languageRepository.findById(addedLanguage.getId()).orElse(null);

        assertThat(language).isNotNull()
                .matches( l -> NameHelper.LANGUAGE_SHORT_NAME.equals(l.getShortName()))
                .matches( l -> NameHelper.LANGUAGE_FULL_NAME.equals(l.getFullName()));

    }
}