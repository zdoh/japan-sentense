package ru.zdoher.japs.repositories.textbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.NameHelper;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - TextbookSeries")
@DataMongoTest
class TextbookSeriesRepositoryTest {

    @Autowired
    private TextbookSeriesRepository textbookSeriesRepository;


    @Test
    @DisplayName("textbookSeries add and get - success")
    void textbookAddAndGet() {
        TextbookSeries addedTextbookSeries = textbookSeriesRepository.insert(
                new TextbookSeries(NameHelper.TEXTBOOK_SERIES_NAME, NameHelper.TEXTBOOK_SERIES_ENGLISHNAME));

        TextbookSeries textbookSeries = textbookSeriesRepository.findById(addedTextbookSeries.getId()).orElse(null);


        assertThat(textbookSeries).isNotNull()
                .matches( t -> NameHelper.TEXTBOOK_SERIES_NAME.equals(t.getName()))
                .matches( t -> NameHelper.TEXTBOOK_SERIES_ENGLISHNAME.equals(t.getEnglishName()));

    }
}