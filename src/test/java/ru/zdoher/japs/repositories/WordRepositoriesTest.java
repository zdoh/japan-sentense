package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - Word")
@DataMongoTest
class WordRepositoriesTest {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private PartOfSpeechRepository partOfSpeechRepository;

    @Autowired
    private WordRepositories wordRepositories;

    @Test
    @DisplayName(" word add and get - success")
    void wordAddAndGet() {
        Language language = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);

        PartOfSpeech partOfSpeech = partOfSpeechRepository.insert(
                new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity)));

        Word addedWord = wordRepositories.insert(
                new Word(NameHelper.WORD_WORDKANJI,
                        NameHelper.WORD_PRONUNCIATION,
                        List.of(translateEntity),
                        List.of(partOfSpeech)));

        Word word = wordRepositories.findById(addedWord.getId()).orElse(null);

        assertThat(word).isNotNull()
                .matches( w -> NameHelper.WORD_WORDKANJI.equals(w.getWordKanji()))
                .matches( w -> NameHelper.POS_NAME.equals(w.getPartOfSpeeches().get(0).getShortName()))
                .matches( w -> NameHelper.TRANSLATE_STR.equals(w.getPartOfSpeeches().get(0).getTranslateName().get(0).getTranslate()));
    }
}