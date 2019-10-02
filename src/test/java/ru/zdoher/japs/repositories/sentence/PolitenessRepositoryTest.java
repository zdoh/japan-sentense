package ru.zdoher.japs.repositories.sentence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Politeness;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.junit.Assert.assertNotNull;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - SentencePolitenessRepository")
@DataMongoTest
class PolitenessRepositoryTest {

    @Autowired
    private SentencePolitenessRepository sentencePolitenessRepository;

    @Test
    @DisplayName("sentencePoliteness add and get - success")
    void sentencePolitenessAddAndGet() {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        Politeness addedPoliteness = new Politeness(NameHelper.SENTENCE_POLITENESS_NAME, List.of(translateEntity));

        sentencePolitenessRepository.save(addedPoliteness).block();

        Mono<Politeness> sentencePolitenessResult =
                sentencePolitenessRepository.findById(addedPoliteness.getId());

        StepVerifier
                .create(sentencePolitenessResult)
                .expectNextMatches( sentencePol -> {
                    assertNotNull(sentencePol);
                    assertThat(sentencePol.getJapName()).isEqualTo(NameHelper.SENTENCE_POLITENESS_NAME);
                    return true;
                })
                .expectComplete()
                .verify();
    }
}
