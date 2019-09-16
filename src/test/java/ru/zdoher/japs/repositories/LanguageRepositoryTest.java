package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class - LanguageRepository")
@DataMongoTest
class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    @DisplayName(" language add and get - success")
    void languageAddAndGet() {
        Language addedLanguage = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);

        languageRepository.save(addedLanguage).block();

        Mono<Language> languageResult = languageRepository.findById(addedLanguage.getId());

        StepVerifier
                .create(languageResult)
                .expectNextMatches(language -> {
                    assertNotNull(language);
                    assertThat(language.getShortName()).isEqualTo(NameHelper.LANGUAGE_SHORT_NAME);
                    assertThat(language.getFullName()).isEqualTo(NameHelper.LANGUAGE_FULL_NAME);
                    return true;
                })
                .expectComplete()
                .verify();
    }
}
