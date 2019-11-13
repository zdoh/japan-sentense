package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;

import java.util.List;
import java.util.Map;

@ChangeLog(order = "007")
public class Init_007_SentencePoliteness {
    private Map<String, SentencePoliteness> sentencePolitenessMap;
    private Map<String, Language> languageMap;

    public Init_007_SentencePoliteness() {
        sentencePolitenessMap = InitMaps.sentencePolitenessMap;
        languageMap = InitMaps.languageMap;
    }

    @ChangeSet(order = "013", id = "initialSentencePoliteness", author = "zdoh", runAlways = true)
    public void initSentencePoliteness(MongoTemplate template) {
        sentencePolitenessMap.put("polite", template.save(new SentencePoliteness("丁寧語",
                List.of(new TranslateEntity(languageMap.get("ru"), "нейтрально-вежливая речь"), new TranslateEntity(languageMap.get("en"), "polite language")))));

        sentencePolitenessMap.put("respectful", template.save(new SentencePoliteness("尊敬語",
                List.of(new TranslateEntity(languageMap.get("ru"), "уважительная речь"), new TranslateEntity(languageMap.get("en"), "respectful language")))));

        sentencePolitenessMap.put("humble", template.save(new SentencePoliteness("謙譲語",
                List.of(new TranslateEntity(languageMap.get("ru"), "скромная речь"), new TranslateEntity(languageMap.get("en"), "humble language")))));

        sentencePolitenessMap.put("simple", template.save(new SentencePoliteness("丁寧語",
                List.of(new TranslateEntity(languageMap.get("ru"), "не формальная речь"), new TranslateEntity(languageMap.get("en"), "informal language")))));


    }

}
