package ru.zdoher.japs.repositories.textbook;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.textbook.TextbookType;
import ru.zdoher.japs.repositories.LanguageRepository;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Class - TextbookType")
@DataMongoTest
class TextbookTypeRepositoryTest {

    @Autowired
    private TextbookTypeRepository textbookTypeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    void textbookTypeAddAndGet() {
        Language language = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);

        TextbookType addedTextbookType = textbookTypeRepository.insert(
                new TextbookType(NameHelper.TEXTBOOK_TYPE_NAME, List.of(translateEntity)));

        TextbookType textbookType = textbookTypeRepository.findById(addedTextbookType.getId()).orElse(null);

        assertThat(textbookType).isNotNull()
                .matches( t -> NameHelper.TEXTBOOK_TYPE_NAME.equals(textbookType.getName()))
                .matches( t -> NameHelper.TRANSLATE_STR.equals(textbookType.getTranslateName().get(0).getTranslate()));


    }
}