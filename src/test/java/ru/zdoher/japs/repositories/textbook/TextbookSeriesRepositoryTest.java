package ru.zdoher.japs.repositories.textbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.NameHelper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Class - TextbookSeries")
@DataMongoTest
class TextbookSeriesRepositoryTest {

    @Autowired
    private TextbookSeriesRepository textbookSeriesRepository;


    @Test
    @DisplayName("textbookSeries add and get - success")
    void textbookAddAndGet() {
        TextbookSeries addedTextbookSeries =
                new TextbookSeries(NameHelper.TEXTBOOK_SERIES_NAME, NameHelper.TEXTBOOK_SERIES_ENGLISHNAME);

        textbookSeriesRepository.save(addedTextbookSeries).block();

        Mono<TextbookSeries> textbookSeriesResult = textbookSeriesRepository.findById(addedTextbookSeries.getId());

        StepVerifier
                .create(textbookSeriesResult)
                .expectNextMatches(textbookSeries -> {
                    assertNotNull(textbookSeries);
                    assertThat(textbookSeries.getName()).isEqualTo(NameHelper.TEXTBOOK_SERIES_NAME);
                    assertThat(textbookSeries.getEnglishName()).isEqualTo(NameHelper.TEXTBOOK_SERIES_ENGLISHNAME);
                    return true;
                } )
                .expectComplete()
                .verify();
    }
}
