package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.textbook.Textbook;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.domain.textbook.TextbookType;

import java.util.List;
import java.util.Map;

@ChangeLog(order = "009")
public class Init_009_Textbook {
    private Map<String, Textbook> textbookMap;
    private Map<String, TextbookType> textbookTypeMap;
    private Map<String, TextbookSeries> textbookSeriesMap;

    public Init_009_Textbook() {
        textbookMap = InitMaps.textbookMap;
        textbookTypeMap = InitMaps.textbookTypeMap;
        textbookSeriesMap = InitMaps.textbookSeriesMap;
    }

    @ChangeSet(order = "001", id = "initialTextbook", author = "zdoh", runAlways = true)
    public void initTextbook(MongoTemplate template) {
        textbookMap.put(Constants.MINNA_GR_1, template.save(
                new Textbook("みんなの日本語初級I文法", Constants.MINNA_GR_1, textbookSeriesMap.get(Constants.MINNA_S), true,
                        List.of(textbookTypeMap.get("文法"), textbookTypeMap.get("語彙")))));

        textbookMap.put(Constants.MINNA_KANJI_1, template.save(
                new Textbook("みんなの日本語初級I漢字", Constants.MINNA_KANJI_1, textbookSeriesMap.get(Constants.MINNA_S), true,
                        List.of(textbookTypeMap.get("漢字"), textbookTypeMap.get("語彙")))));

        textbookMap.put(Constants.BASIC_KANJI_BOOK_1, template.save(
                new Textbook("Basic kanji book", Constants.BASIC_KANJI_BOOK_1, textbookSeriesMap.get(Constants.BASIC_KANJI_BOOK_S), true,
                        List.of(textbookTypeMap.get("漢字"), textbookTypeMap.get("語彙")))));

    }
}
