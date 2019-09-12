package ru.zdoher.japs.repositories.sentence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.domain.sentence.SentenceTranslate;
import ru.zdoher.japs.repositories.LanguageRepository;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - SentenceRepository")
@DataMongoTest
class SentenceRepositoryTest {

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private SentencePolitenessRepository sentencePolitenessRepository;

    @Test
    @DisplayName(" sentence add and get - success")
    void sentenceAddAndGet() {
        Language language = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        SentenceTranslate sentenceTranslate = new SentenceTranslate(language, NameHelper.SENTENCE_TRANSLATE);

        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);

        SentencePoliteness sentencePoliteness = sentencePolitenessRepository.insert(
                new SentencePoliteness(NameHelper.SENTENCE_POLITENESS_NAME, List.of(translateEntity)));


        Sentence addedSentence = sentenceRepository.insert(
                new Sentence(NameHelper.SENTENCE_SENTENCE,
                        List.of(sentenceTranslate),
                        NameHelper.SENTENCE_SOURCE,
                        sentencePoliteness,
                        true));

        Sentence sentence = sentenceRepository.findById(addedSentence.getId()).orElse(null);

        assertThat(sentence).isNotNull()
                .matches( s -> NameHelper.SENTENCE_SENTENCE.equals(s.getSentence()))
                .matches( s -> NameHelper.SENTENCE_SOURCE.equals(s.getSentenceSource()))
                .matches( s -> NameHelper.SENTENCE_TRANSLATE.equals(s.getTranslateList().get(0).getTranslate()));



    }

}
