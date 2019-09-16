package ru.zdoher.japs.repositories.textbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.textbook.TextbookType;
import ru.zdoher.japs.repositories.LanguageRepository;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DisplayName("Class - TextbookType")
@DataMongoTest
class TextbookTypeRepositoryTest {

    @Autowired
    private TextbookTypeRepository textbookTypeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @DisplayName(" textbooktype add and get - success")
    @Test
    void textbookTypeAddAndGet() {
        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
        TextbookType addedTextbookType = new TextbookType(NameHelper.TEXTBOOK_TYPE_NAME, List.of(translateEntity));

        textbookTypeRepository.save(addedTextbookType).block();

        Mono<TextbookType> textbookTypeResult = textbookTypeRepository.findById(addedTextbookType.getId());

        StepVerifier
                .create(textbookTypeResult)
                .expectNextMatches(textbookType -> {
                    assertNotNull(textbookType);
                    assertThat(textbookType.getName()).isEqualTo(NameHelper.TEXTBOOK_TYPE_NAME);
                    assertThat(textbookType.getTranslateName().get(0).getTranslate()).isEqualTo(NameHelper.TRANSLATE_STR);


                    return true;
                })

                .expectComplete()
                .verify();

    }
}
