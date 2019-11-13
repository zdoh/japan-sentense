package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.morphology.KuramojiPartOfSpeech;
import ru.zdoher.japs.domain.morphology.KuramojiTypeOfSpeech;

import java.util.List;
import java.util.Map;

@ChangeLog(order = "015")
public class Init_015_MorphPartOfSpeech {
    private Map<String, Language> languageMap;

    public Init_015_MorphPartOfSpeech() {
        languageMap = InitMaps.languageMap;
    }

    @ChangeSet(order = "001", id = "initialMorphPartOfSpeech", author = "zdoh", runAlways = true)
    public void initMorphPartOfSpeech(MongoTemplate template) {
        template.save(new KuramojiPartOfSpeech("名詞", List.of(new TranslateEntity(languageMap.get("ru"), "существительное")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("助詞", List.of(new TranslateEntity(languageMap.get("ru"), "грам. служебное слово")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("動詞", List.of(new TranslateEntity(languageMap.get("ru"), "грам. глагол")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("助動詞", List.of(new TranslateEntity(languageMap.get("ru"), "вспомогательные глаголы")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("記号", List.of(new TranslateEntity(languageMap.get("ru"), "знак, символ")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("句点", List.of(new TranslateEntity(languageMap.get("ru"), "знаки препинания")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("読点", List.of(new TranslateEntity(languageMap.get("ru"), "запятая")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("形容詞", List.of(new TranslateEntity(languageMap.get("ru"), "прилагательное (предикативное)")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("接尾", List.of(new TranslateEntity(languageMap.get("ru"), "суффикс")), KuramojiTypeOfSpeech.SUFFIX));
        template.save(new KuramojiPartOfSpeech("代名詞", List.of(new TranslateEntity(languageMap.get("ru"), "местоимение")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("一般", List.of(new TranslateEntity(languageMap.get("ru"), "обыкновенное")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("係助詞", List.of(new TranslateEntity(languageMap.get("ru"), "связующая частица")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("副助詞", List.of(new TranslateEntity(languageMap.get("ru"), "наречная частица")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("並立助詞", List.of(new TranslateEntity(languageMap.get("ru"), "частица, используемая для перечисления элементов")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("終助詞", List.of(new TranslateEntity(languageMap.get("ru"), "частица, заканчивающая предложениу")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("固有名詞", List.of(new TranslateEntity(languageMap.get("ru"), "имя собственное")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("人名", List.of(new TranslateEntity(languageMap.get("ru"), "имя человека")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("姓", List.of(new TranslateEntity(languageMap.get("ru"), "фамилия")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("括弧開", List.of(new TranslateEntity(languageMap.get("ru"), "открытая скобка")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("括弧閉", List.of(new TranslateEntity(languageMap.get("ru"), "закрытая скобка")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("地域", List.of(new TranslateEntity(languageMap.get("ru"), "район, территория")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("国", List.of(new TranslateEntity(languageMap.get("ru"), "страна")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("感動詞", List.of(new TranslateEntity(languageMap.get("ru"), "междометие")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("連体詞", List.of(new TranslateEntity(languageMap.get("ru"), "адноминальное прилагательное")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("非自立", List.of(new TranslateEntity(languageMap.get("ru"), "не независимый")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("助数詞", List.of(new TranslateEntity(languageMap.get("ru"), "суффикс счетчика")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("数", List.of(new TranslateEntity(languageMap.get("ru"), "число, числительное")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("名", List.of(new TranslateEntity(languageMap.get("ru"), "имя")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("自立", List.of(new TranslateEntity(languageMap.get("ru"), "независимый, самостоятельный")), KuramojiTypeOfSpeech.MAIN));
        template.save(new KuramojiPartOfSpeech("格助詞", List.of(new TranslateEntity(languageMap.get("ru"), "частица маркировки случая")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("組織", List.of(new TranslateEntity(languageMap.get("ru"), "название организации")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("連体化", List.of(new TranslateEntity(languageMap.get("ru"), "адноминальное прилагательное")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("空白", List.of(new TranslateEntity(languageMap.get("ru"), "пробел")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("副詞", List.of(new TranslateEntity(languageMap.get("ru"), "наречие")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("接続詞", List.of(new TranslateEntity(languageMap.get("ru"), "соединение частиц")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("助詞類接続", List.of(new TranslateEntity(languageMap.get("ru"), "соединение частиц")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("サ変接続", List.of(new TranslateEntity(languageMap.get("ru"), "не понятное соединение")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("形容動詞語幹", List.of(new TranslateEntity(languageMap.get("ru"), "прилагательное глагол основы")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("接続助詞", List.of(new TranslateEntity(languageMap.get("ru"), "прилагательное глагол основы")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("接頭詞", List.of(new TranslateEntity(languageMap.get("ru"), "префикс")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("名詞接続", List.of(new TranslateEntity(languageMap.get("ru"), "существительное соединение")), KuramojiTypeOfSpeech.OTHER));
        template.save(new KuramojiPartOfSpeech("副詞可能", List.of(new TranslateEntity(languageMap.get("ru"), "возможно наречие")), KuramojiTypeOfSpeech.OTHER));


        //template.save(new KuramojiPartOfSpeech("名詞", List.of(new TranslateEntity(langRu, "существительное")), true));
    }
}
