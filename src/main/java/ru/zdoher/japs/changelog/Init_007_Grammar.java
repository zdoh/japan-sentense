package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Grammar;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "007")
public class Init_007_Grammar {
    private Map<String, Grammar> grammarMap;
    private Map<String, PartOfSpeech> partOfSpeechMap;
    private Map<String, Language> languageMap;

    public Init_007_Grammar() {
        grammarMap = InitMaps.grammarMap;
        partOfSpeechMap = InitMaps.partOfSpeechMap;
        languageMap = InitMaps.languageMap;
    }

    @ChangeSet(order = "001", id = "initialGrammar", author = "zdoh", runAlways = true)
    public void initGrammar(MongoTemplate template) {
        grammarMap.put("nは", template.save(new Grammar("nは",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Частица 「は」 указывает, что перед ней стоит существительное, является темой высказывания.")))));

        grammarMap.put("nです", template.save(new Grammar("nです",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("です")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(languageMap.get("ru"), "Существительное, оформленное связной 「です」, является именным сказуемым. " +
                        "です указывает на суждения или утверждение. " +
                        "です выражает нейтрально-вежливый стиль речи говорящего по отношению к собеседнику." +
                        "です изменяется в отрицательных предложениях и в прошедшем времени.")))));

        grammarMap.put("nじゃありません", template.save(new Grammar("nじゃありません",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("じゃありません")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(languageMap.get("ru"), "じゃありません является разговорной отрицательной версией 「です」.")))));

        grammarMap.put("nではありません", template.save(new Grammar("nではありません",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("ではありません")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(languageMap.get("ru"), "ではありません　является отрицательной версией 「です」. " +
                        "Используется в нейтрально-вежливом или информационном стиле, а также в письменной речи.")))));

        grammarMap.put("nですか", template.save(new Grammar("nですか",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("です"), partOfSpeechMap.get("か")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(languageMap.get("ru"), "Частица か указывает на сомнение, вопрос и тд говорящего. " +
                        "Вопросительное предложение образуется путем добавление частицы 「か」 в конец предложения.")))));

        grammarMap.put("nも", template.save(new Grammar("nも",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("も")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Вместо тематической частицы 「は」 употребляется частица 「も」, " +
                        "если утверждается то же самое, что и по поводу предыдущей темы")))));

        grammarMap.put("nのn", template.save(new Grammar("nのn",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("の"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Частица 「の」 служит для связи двух существительных, если второе существительное" +
                        "является определениек к первому существительному. Например 'моя книга'")))));

        grammarMap.put("nの", template.save(new Grammar("nの",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("の"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(languageMap.get("ru"), "В конструкции 「nのn」, в случае если из контекста понятно о каком втором существительном " +
                        "идет речь, то второе существительное может опускаться. Например 「この本は私のです」")))));

        grammarMap.put("これは", template.save(new Grammar("これは",
                List.of(partOfSpeechMap.get("これ"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                        "грамматически функционируют иак же, как и имена существительные. これ указывает на предмет, более близкий к говорящему.")))));

        grammarMap.put("それは", template.save(new Grammar("それは",
                List.of(partOfSpeechMap.get("それ"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                        "грамматически функционируют иак же, как и имена существительные. それ указывает на предмет, более близкий к собеседнику.")))));

        grammarMap.put("あれは", template.save(new Grammar("あれは",
                List.of(partOfSpeechMap.get("それ"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                        "грамматически функционируют иак же, как и имена существительные. あれ указывает на предмет, равноудаленный от собеседников.")))));

        grammarMap.put("このn", template.save(new Grammar("このn",
                List.of(partOfSpeechMap.get("この"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Относительно-указательное местоимение 「この」 определяет существительное и используется " +
                        "с ним. 「このn」 указывает на предмет, более близкий к говорящему.")))));

        grammarMap.put("そのn", template.save(new Grammar("そのn",
                List.of(partOfSpeechMap.get("その"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Относительно-указательное местоимение 「その」 определяет существительное и используется " +
                        "с ним. 「そのn」 указывает на предмет, более близкий к собеседнику.")))));

        grammarMap.put("あのn", template.save(new Grammar("あのn",
                List.of(partOfSpeechMap.get("あの"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Относительно-указательное местоимение 「あの」 определяет существительное и используется " +
                        "с ним. 「あのn」 указывает на предмет, равноудаленный от говорящих.")))));

        grammarMap.put("文か、文か", template.save(new Grammar("文か、文か",
                List.of(partOfSpeechMap.get("文"), partOfSpeechMap.get("か"), partOfSpeechMap.get("、"), partOfSpeechMap.get("文"), partOfSpeechMap.get("か")),
                List.of(new TranslateEntity(languageMap.get("ru"), "Альтернативный вопрос, при ответе на который требуется выбрать правильное утверждение " +
                        "из двух (или более) предложенных. Ответом является повторение правильного утверждения без добавления 「はい」 или 「いいえ」")))));

/*
        grammarMap.put("", template.save(new Grammar(
                List.of(partOfSpeechMap.get(""), partOfSpeechMap.get("")),
                List.of(new TranslateEntity(languageMap.get("ru"), "")))));
*/

    }

}
