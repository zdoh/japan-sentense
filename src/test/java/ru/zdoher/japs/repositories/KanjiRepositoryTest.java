package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class - KanjiRepository")
@DataMongoTest
class KanjiRepositoryTest {

    @Autowired
    private KanjiRepository kanjiRepository;

    @Autowired
    private WordRepositories wordRepositories;

//    @Test
//    @DisplayName(" kanji add and get - success")
//    void kanjiCreateAndGet() {
//        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
//        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
//        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
//        Word word = new Word(NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
//                        List.of(translateEntity), List.of(partOfSpeech));
//
//        wordRepositories.save(word).block();
//
//        Kanji addedKanji = new Kanji(NameHelper.KANJI_KANJI, List.of(translateEntity),
//                        List.of(NameHelper.KANJI_ONYUMI), List.of(word), word);
//
//        kanjiRepository.save(addedKanji).block();
//
//        Mono<Kanji> kanjiResult = kanjiRepository.findById(addedKanji.getId());
//
//        StepVerifier
//                .create(kanjiResult)
//                .expectNextMatches(kanji -> {
//                    assertNotNull(kanji);
//                    assertThat(kanji.getKanji()).isEqualTo(NameHelper.KANJI_KANJI);
//                    assertThat(kanji.getMeaning().get(0).getTranslate()).isEqualTo(NameHelper.TRANSLATE_STR);
//                    return true;
//                })
//                .expectComplete()
//                .verify();
//
//    }

}
