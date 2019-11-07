package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.textbook.TextbookSeries;

import java.util.Map;

@ChangeLog(order = "008")
public class Init_008_TextbookSeries {
    private Map<String, TextbookSeries> textbookSeriesMap;

    public Init_008_TextbookSeries() {
        textbookSeriesMap = InitMaps.textbookSeriesMap;
    }

    @ChangeSet(order = "001", id = "initialTextbookSeries", author = "zdoh", runAlways = true)
    public void initTextbookSeries(MongoTemplate template) {
        textbookSeriesMap.put(Constants.MINNA_S, template.save(
                new TextbookSeries("みんなの日本語", Constants.MINNA_S)));

        textbookSeriesMap.put(Constants.BASIC_KANJI_BOOK_S, template.save(
                new TextbookSeries(Constants.BASIC_KANJI_BOOK_S, Constants.BASIC_KANJI_BOOK_S)));

    }
}
