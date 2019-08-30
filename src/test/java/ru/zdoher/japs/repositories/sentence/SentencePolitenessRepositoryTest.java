package ru.zdoher.japs.repositories.sentence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.repositories.LanguageRepository;
import ru.zdoher.japs.repositories.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - SentencePolitenessRepository")
@DataMongoTest
class SentencePolitenessRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private SentencePolitenessRepository sentencePolitenessRepository;

    @Test
    @DisplayName("sentencePoliteness add and get - success")
    void sentencePolitenessAddAndGet() {
        Language language = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);

        SentencePoliteness addedSentencePoliteness = sentencePolitenessRepository.insert(
                new SentencePoliteness(NameHelper.SENTENCE_POLITENESS_NAME, List.of(translateEntity)));

        SentencePoliteness sentencePoliteness =
                sentencePolitenessRepository.findById(addedSentencePoliteness.getId()).orElse(null);

        assertThat(sentencePoliteness).isNotNull()
                .matches( s -> NameHelper.SENTENCE_POLITENESS_NAME.equals(s.getJapName()))
                .matches( s -> NameHelper.TRANSLATE_STR.equals(s.getTranslateEntities().get(0).getTranslate()));

    }
}