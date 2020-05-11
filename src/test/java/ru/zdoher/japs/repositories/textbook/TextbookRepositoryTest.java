package ru.zdoher.japs.repositories.textbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.textbook.Textbook;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.domain.textbook.TextbookType;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class - TextbookRepository")
@DataMongoTest
class TextbookRepositoryTest {

    @Autowired
    private TextbookSeriesRepository textbookSeriesRepository;


    @Autowired
    private TextbookTypeRepository textbookTypeRepository;

    @Autowired
    private TextbookRepository textbookRepository;

//    @Test
//    @DisplayName(" textbook add and get - success")
//    void textbookAddAndGet() {
//        TextbookSeries textbookSeries = new TextbookSeries("1", NameHelper.TEXTBOOK_SERIES_NAME, NameHelper.TEXTBOOK_SERIES_ENGLISHNAME);
//        Language language = new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME);
//        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);
//        TextbookType textbookType = new TextbookType("1", NameHelper.TEXTBOOK_TYPE_NAME, List.of(translateEntity));
//
//        textbookSeriesRepository.save(textbookSeries).block();
//        textbookTypeRepository.save(textbookType).block();
//
//        Textbook addedTextBook = new Textbook(NameHelper.TEXTBOOK_JAPANESENAME, NameHelper.TEXTBOOK_ENGLISHNAME,
//                textbookSeries, true, List.of(textbookType));
//
//        textbookRepository.save(addedTextBook).block();
//
//        Mono<Textbook> textbookResult = textbookRepository.findById(addedTextBook.getId());
//
//        StepVerifier
//                .create(textbookResult)
//                .expectNextMatches(textbook -> {
//                    assertNotNull(textbook);
//                    assertThat(textbook.getJapaneseName()).isEqualTo(NameHelper.TEXTBOOK_JAPANESENAME);
//                    assertThat(textbook.getTextbookSeries().getName()).isEqualTo(NameHelper.TEXTBOOK_SERIES_NAME);
//                    assertThat(textbook.getTextbookType().get(0).getName()).isEqualTo(NameHelper.TEXTBOOK_TYPE_NAME);
//                    return true;
//                })
//                .expectComplete()
//                .verify();
//    }
}
