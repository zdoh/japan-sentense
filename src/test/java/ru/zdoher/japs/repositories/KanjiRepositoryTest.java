package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
@DisplayName("Class - KanjiRepository")
@DataMongoTest
class KanjiRepositoryTest {

    @Autowired
    private KanjiRepository kanjiRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private PartOfSpeechRepository partOfSpeechRepository;

    @Autowired
    private WordRepositories wordRepositories;

    @Test
    @DisplayName(" kanji add and get - success")
    void kanjiCreateAndGet() {
        Language language = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);

        PartOfSpeech partOfSpeech = partOfSpeechRepository.insert(
                new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity)));

        Word word = wordRepositories.insert(
                new Word(NameHelper.WORD_WORDKANJI,
                        NameHelper.WORD_PRONUNCIATION,
                        List.of(translateEntity),
                        List.of(partOfSpeech)));

        final Kanji addedKanji = kanjiRepository.insert(
                new Kanji(NameHelper.KANJI_KANJI,
                        List.of(translateEntity),
                        List.of(NameHelper.KANJI_ONYUMI),
                        List.of(word), word));

        Kanji kanji = kanjiRepository.findById(addedKanji.getId()).orElse(null);

        assertThat(kanji).isNotNull()
                .matches( k -> NameHelper.KANJI_KANJI.equals(k.getKanji()))
                .matches( k -> NameHelper.TRANSLATE_STR.equals(k.getMeaning().get(0).getTranslate()));

    }

}*/
