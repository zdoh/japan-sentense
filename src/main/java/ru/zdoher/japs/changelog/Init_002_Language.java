package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;

import java.util.Map;

@ChangeLog(order = "002")
public class Init_002_Language {
    private Map<String, Language> languageMap;

    public Init_002_Language() {
        this.languageMap = InitMaps.languageMap;
    }

    @ChangeSet(order = "001", id = "initialLanguage", author = "zdoh", runAlways = true)
    public void initAuthors(MongoTemplate template) {
        languageMap.put(Constants.RUSSIAN_LANG_SHORT, template.save(new Language(Constants.RUSSIAN_LANG_SHORT, Constants.RUSSIAN_LANG)));
        languageMap.put(Constants.ENGLISH_LANG_SHORT, template.save(new Language(Constants.ENGLISH_LANG_SHORT, Constants.ENGLISH_LANG)));
    }
}
