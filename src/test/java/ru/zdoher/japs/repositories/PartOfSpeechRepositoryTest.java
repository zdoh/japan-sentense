package ru.zdoher.japs.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.NameHelper;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
@DisplayName("Class PartOfSpeech")
@DataMongoTest
class PartOfSpeechRepositoryTest {

    @Autowired
    private PartOfSpeechRepository partOfSpeechRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Test
    @DisplayName(" partOfSpeech add and get - success")
    void partOfSpeechAddAndGet() {
        Language language = languageRepository.insert(new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        PartOfSpeech addedPartOfSpeech = partOfSpeechRepository.insert(new PartOfSpeech(NameHelper.POS_NAME, List.of(translateEntity)));

        PartOfSpeech partOfSpeech = partOfSpeechRepository.findById(addedPartOfSpeech.getId()).orElse(null);

        assertThat(partOfSpeech).isNotNull()
                .matches( p -> NameHelper.POS_NAME.equals(p.getShortName()))
                .matches( p -> NameHelper.TRANSLATE_STR.equals(p.getTranslateName().get(0).getTranslate()))
                .matches( p -> NameHelper.LANGUAGE_SHORT_NAME.equals(p.getTranslateName().get(0).getLanguage().getShortName()));

    }
}*/
