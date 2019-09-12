package ru.zdoher.japs.repositories.textbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.textbook.Textbook;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.domain.textbook.TextbookType;
import ru.zdoher.japs.repositories.LanguageRepository;
import ru.zdoher.japs.NameHelper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Class - TextbookRepository")
@DataMongoTest
class TextbookRepositoryTest {

    @Autowired
    private TextbookSeriesRepository textbookSeriesRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TextbookTypeRepository textbookTypeRepository;

    @Autowired
    private TextbookRepository textbookRepository;

    @Test
    @DisplayName(" textbook add and get - success")
    void textbookAddAndGet() {
        TextbookSeries textbookSeries = textbookSeriesRepository.insert(
                new TextbookSeries(NameHelper.TEXTBOOK_SERIES_NAME, NameHelper.TEXTBOOK_SERIES_ENGLISHNAME));

        Language language = languageRepository.insert(
                new Language(NameHelper.LANGUAGE_SHORT_NAME, NameHelper.LANGUAGE_FULL_NAME));

        TranslateEntity translateEntity = new TranslateEntity(language, NameHelper.TRANSLATE_STR);

        TextbookType textbookType = textbookTypeRepository.insert(
                new TextbookType(NameHelper.TEXTBOOK_TYPE_NAME, List.of(translateEntity)));

        Textbook addedTextBook = textbookRepository.insert(
                new Textbook(NameHelper.TEXTBOOK_JAPANESENAME,
                        NameHelper.TEXTBOOK_ENGLISHNAME,
                        textbookSeries,
                        true,
                        List.of(textbookType)));

        Textbook textbook = textbookRepository.findById(addedTextBook.getId()).orElse(null);

        assertThat(textbook).isNotNull()
                .matches( t -> NameHelper.TEXTBOOK_JAPANESENAME.equals(t.getJapaneseName()))
                .matches( t -> NameHelper.TEXTBOOK_SERIES_NAME.equals(t.getTextbookSeries().getName()))
                .matches( t -> NameHelper.TEXTBOOK_TYPE_NAME.equals(t.getTextbookType().get(0).getName()));
    }
}