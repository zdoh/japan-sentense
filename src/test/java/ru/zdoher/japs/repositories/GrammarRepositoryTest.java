package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Grammar;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
@DisplayName("Class GrammarRepository")
@DataMongoTest
class GrammarRepositoryTest {

    @Autowired
    private GrammarRepository grammarRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private PartOfSpeechRepository partOfSpeechRepository;


    @Test
    @DisplayName(" grammar add and get - success")
    void grammarCreateAndGet() {
        Language language = languageRepository.insert(new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech partOfSpeech = partOfSpeechRepository.insert(new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity)));
        Grammar addedGrammar = grammarRepository.insert(new Grammar(NameHelper.GRAMMAR_NAME, List.of(partOfSpeech), List.of(translateEntity)));

        Grammar grammar = grammarRepository.findById(addedGrammar.getId()).orElse(null);

        assertThat(grammar).isNotNull()
                .matches( g -> NameHelper.GRAMMAR_NAME.equals(g.getName()))
                .matches( g -> NameHelper.POS_NAME.equals(g.getGrammarCreate().get(0).getShortName()))
                .matches( g -> NameHelper.TRANSLATE_STR.equals(g.getGrammarCreate().get(0).getTranslateName().get(0).getTranslate()))
                .matches( g -> NameHelper.LANGUAGE_SHORT_NAME.equals(g.getGrammarCreate().get(0).getTranslateName().get(0).getLanguage().getShortName()));
    }
}*/
