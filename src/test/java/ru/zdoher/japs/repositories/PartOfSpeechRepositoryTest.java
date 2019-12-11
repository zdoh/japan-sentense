package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.http.codec.multipart.Part;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class PartOfSpeech")
@DataMongoTest
class PartOfSpeechRepositoryTest {

    @Autowired
    private PartOfSpeechRepository partOfSpeechRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    @DisplayName(" partOfSpeech add and get - success")
    void partOfSpeechAddAndGet() {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech addedPartOfSpeech = PartOfSpeech.builder()
                .shortName(NameHelper.POS_NAME)
                .translateName(List.of(translateEntity))
                .build();

        partOfSpeechRepository.save(addedPartOfSpeech).block();

        Mono<PartOfSpeech> partOfSpeechResult = partOfSpeechRepository.findById(addedPartOfSpeech.getId());

        StepVerifier
                .create(partOfSpeechResult)
                .expectNextMatches(partOfSpeech -> {
                    assertNotNull(partOfSpeech);
                    assertThat(partOfSpeech.getShortName()).isEqualTo(NameHelper.POS_NAME);
                    assertThat(partOfSpeech.getTranslateName().get(0).getTranslate()).isEqualTo(NameHelper.TRANSLATE_STR);
                    assertThat(partOfSpeech.getTranslateName().get(0).getLanguage().getShortName()).isEqualTo(NameHelper.LANGUAGE_SHORT_NAME);
                    return true;
                })
                .expectComplete()
                .verify();

    }
}
