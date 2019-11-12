package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.textbook.TextbookType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "004")
public class Init_004_TextbookType {
    private Map<String, TextbookType> textbookTypeMap;
    private Map<String, Language> languageMap;

    public Init_004_TextbookType() {
        textbookTypeMap = InitMaps.textbookTypeMap;
        languageMap = InitMaps.languageMap;
    }

    @ChangeSet(order = "001", id = "initialTextbookType", author = "zdoh", runAlways = true)
    public void initTextbookType(MongoTemplate template)    {
        textbookTypeMap.put("文法", template.save(new TextbookType("文法", List.of(new TranslateEntity(languageMap.get("ru"), "Грамматика")))));
        textbookTypeMap.put("読解", template.save(new TextbookType("読解", List.of(new TranslateEntity(languageMap.get("ru"), "Чтение")))));
        textbookTypeMap.put("語彙", template.save(new TextbookType("語彙", List.of(new TranslateEntity(languageMap.get("ru"), "Слова")))));
        textbookTypeMap.put("漢字", template.save(new TextbookType("漢字", List.of(new TranslateEntity(languageMap.get("ru"), "Иероглифы")))));
        textbookTypeMap.put("聴解", template.save(new TextbookType("聴解", List.of(new TranslateEntity(languageMap.get("ru"), "Аудирование")))));
        textbookTypeMap.put("other", template.save(new TextbookType("other", List.of(new TranslateEntity(languageMap.get("ru"), "Другое")))));
    }
}
