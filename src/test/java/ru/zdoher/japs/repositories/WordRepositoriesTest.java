package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class - Word")
@DataMongoTest
class WordRepositoriesTest {

    @Autowired
    private WordRepositories wordRepositories;

//    @Test
//    @DisplayName(" word add and get - success")
//    void wordAddAndGet() {
//        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
//        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
//        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
//        Word addedWord = new Word(NameHelper.WORD_WORDKANJI, NameHelper.WORD_PRONUNCIATION,
//                List.of(translateEntity), List.of(partOfSpeech));
//
//        wordRepositories.save(addedWord).block();
//
//        Mono<Word> wordResult = wordRepositories.findById(addedWord.getId());
//
//        StepVerifier
//                .create(wordResult)
//                .expectNextMatches(word -> {
//                    assertNotNull(word);
//                    assertThat(word.getWordKanji()).isEqualTo(NameHelper.WORD_WORDKANJI);
//                    assertThat(word.getPartOfSpeeches().get(0).getShortName()).isEqualTo(NameHelper.POS_NAME);
//                    assertThat(word.getPartOfSpeeches().get(0).getTranslateName().get(0).getTranslate()).isEqualTo(NameHelper.TRANSLATE_STR);
//                    return true;
//                })
//                .expectComplete()
//                .verify();
//    }
}
