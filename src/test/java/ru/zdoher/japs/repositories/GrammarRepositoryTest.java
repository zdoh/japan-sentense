package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Grammar;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class GrammarRepository")
@DataMongoTest
class GrammarRepositoryTest {

    @Autowired
    private GrammarRepository grammarRepository;

//    @Test
//    @DisplayName(" grammar add and get - success")
//    void grammarCreateAndGet() {
//        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
//        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
//        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
//        Grammar addedGrammar = new Grammar(NameHelper.GRAMMAR_NAME, List.of(partOfSpeech), List.of(translateEntity));
//
//        grammarRepository.save(addedGrammar).block();
//
//        Mono<Grammar> grammarResult = grammarRepository.findById(addedGrammar.getId());
//
//        StepVerifier
//                .create(grammarResult)
//                .expectNextMatches(grammar -> {
//                    assertNotNull(grammar);
//                    assertThat(grammar.getName()).isEqualTo(NameHelper.GRAMMAR_NAME);
//                    assertThat(grammar.getGrammarCreate().get(0).getShortName()).isEqualTo(NameHelper.POS_NAME);
//                    assertThat(grammar.getGrammarCreate().get(0).getTranslateName().get(0).getTranslate()).isEqualTo(NameHelper.TRANSLATE_STR);
//                    assertThat(grammar.getGrammarCreate().get(0).getTranslateName().get(0).getLanguage().getShortName()).isEqualTo(NameHelper.LANGUAGE_SHORT_NAME);
//                    return true;
//                })
//                .expectComplete()
//                .verify();
//    }
}
