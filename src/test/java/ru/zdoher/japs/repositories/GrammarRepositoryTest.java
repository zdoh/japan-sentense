package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.grammar.AddingGrammar;
import ru.zdoher.japs.domain.grammar.Grammar;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.grammar.GrammarType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class GrammarRepository")
@DataMongoTest
class GrammarRepositoryTest {

    @Autowired
    private GrammarRepository grammarRepository;

    @Test
    @DisplayName(" grammar add and get - success")
    void grammarCreateAndGet() {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity));
        Grammar addedGrammar = Grammar.builder()
                .name(NameHelper.GRAMMAR_NAME)
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(List.of(partOfSpeech), List.of(translateEntity)))
                .build();

        grammarRepository.save(addedGrammar).block();

        Mono<Grammar> grammarResult = grammarRepository.findById(addedGrammar.getId());

        StepVerifier
                .create(grammarResult)
                .expectNextMatches(grammar -> {
                    assertNotNull(grammar);
                    assertThat(grammar.getName()).isEqualTo(NameHelper.GRAMMAR_NAME);
                    assertSame(grammar.getGrammarType(), GrammarType.ADDING);
                    assertThat(grammar.getAddingGrammar().getGrammarComment().get(0).getTranslate()).isEqualTo(NameHelper.TRANSLATE_STR);
                    assertThat(grammar.getAddingGrammar().getGrammarComment().get(0).getLanguage().getShortName()).isEqualTo(NameHelper.LANGUAGE_SHORT_NAME);
                    return true;
                })
                .expectComplete()
                .verify();
    }
}
