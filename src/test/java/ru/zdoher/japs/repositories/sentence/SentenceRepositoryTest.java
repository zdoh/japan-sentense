package ru.zdoher.japs.repositories.sentence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.domain.Politeness;
import ru.zdoher.japs.domain.sentence.SentenceTranslate;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class - SentenceRepository")
@DataMongoTest
class SentenceRepositoryTest {

    @Autowired
    private SentenceRepository sentenceRepository;

    @Test
    @DisplayName(" sentence add and get - success")
    void sentenceAddAndGet() {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        SentenceTranslate sentenceTranslate = new SentenceTranslate(language, NameHelper.SENTENCE_TRANSLATE);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        Politeness politeness = new Politeness(NameHelper.SENTENCE_POLITENESS_NAME, List.of(translateEntity));
        Sentence addedSentence = new Sentence(NameHelper.SENTENCE_SENTENCE, List.of(sentenceTranslate),
                        NameHelper.SENTENCE_SOURCE, politeness, true);

        sentenceRepository.save(addedSentence).block();

        Mono<Sentence> sentenceResult = sentenceRepository.findById(addedSentence.getId());

        StepVerifier
                .create(sentenceResult)
                .expectNextMatches(sentence -> {
                    assertNotNull(sentence);
                    assertThat(sentence.getSentence()).isEqualTo(NameHelper.SENTENCE_SENTENCE);
                    assertThat(sentence.getSentenceSource()).isEqualTo(NameHelper.SENTENCE_SOURCE);
                    assertThat(sentence.getTranslateList().get(0).getTranslate()).isEqualTo(NameHelper.SENTENCE_TRANSLATE);
                    return true;
                })
                .expectComplete()
                .verify();
    }
}
