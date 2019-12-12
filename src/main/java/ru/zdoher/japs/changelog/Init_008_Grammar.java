package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.grammar.AddingGrammar;
import ru.zdoher.japs.domain.grammar.ChangeGrammar;
import ru.zdoher.japs.domain.grammar.Grammar;
import ru.zdoher.japs.domain.grammar.GrammarType;

import java.util.List;
import java.util.Map;

@ChangeLog(order = "008")
public class Init_008_Grammar {
    private Map<String, Grammar> grammarMap;
    private Map<String, PartOfSpeech> partOfSpeechMap;
    private Map<String, Language> languageMap;
    private Map<String, SentencePoliteness> sentencePolitenessMap;

    public Init_008_Grammar() {
        grammarMap = InitMaps.grammarMap;
        partOfSpeechMap = InitMaps.partOfSpeechMap;
        languageMap = InitMaps.languageMap;
        sentencePolitenessMap = InitMaps.sentencePolitenessMap;
    }

    @ChangeSet(order = "001", id = "initialGrammar", author = "zdoh", runAlways = true)
    public void initGrammar(MongoTemplate template) {
        grammarMap.put("nは", template.save(Grammar.builder()
                .name("nは")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(List.of(partOfSpeechMap.get("は"), partOfSpeechMap.get("n")),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Частица 「は」 указывает, что перед ней стоит существительное, " + "является темой высказывания."))))
                .build()));

        grammarMap.put("nです", template.save(Grammar.builder()
                .name("nです")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("です"), partOfSpeechMap.get("n")), partOfSpeechMap.get("文"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Существительное, оформленное связной 「です」, является именным сказуемым. " +
                                "です указывает на суждения или утверждение. " +
                                "です выражает нейтрально-вежливый стиль речи говорящего по отношению к собеседнику." +
                                "です изменяется в отрицательных предложениях и в прошедшем времени."))))
                .sentencePoliteness(sentencePolitenessMap.get("polite"))
                .build()));

        grammarMap.put("nじゃありません", template.save(Grammar.builder()
                .name("nじゃありません")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("じゃありません")), partOfSpeechMap.get("文"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "じゃありません является разговорной отрицательной версией 「です」."))))
                .conversation(true)
                .sentencePoliteness(sentencePolitenessMap.get("polite"))
                .build()));

        grammarMap.put("nではありません", template.save(Grammar.builder()
                .name("nではありません")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("ではありません"), partOfSpeechMap.get("n")), partOfSpeechMap.get("文"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "ではありません　является отрицательной версией 「です」. " +
                                "Используется в нейтрально-вежливом или информационном стиле, а также в письменной речи."))))
                .sentencePoliteness(sentencePolitenessMap.get("polite"))
                .build()));

        grammarMap.put("文か", template.save(Grammar.builder()
                .name("文か")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("か"), partOfSpeechMap.get("です"), partOfSpeechMap.get("n")), partOfSpeechMap.get("文"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Частица か указывает на сомнение, вопрос и тд говорящего. " +
                                "Вопросительное предложение образуется путем добавление частицы 「か」 в конец предложения."))))
                .sentencePoliteness(sentencePolitenessMap.get("polite"))
                .build()));

        grammarMap.put("nも", template.save(Grammar.builder()
                .name("nも")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("も"), partOfSpeechMap.get("n")),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Вместо тематической частицы 「は」 употребляется частица 「も」, " +
                                "если утверждается то же самое, что и по поводу предыдущей темы"))))
                .build()));

        grammarMap.put("nのn", template.save(Grammar.builder()
                .name("nのn")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("の"), partOfSpeechMap.get("n")), partOfSpeechMap.get("n"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Частица 「の」 служит для связи двух существительных, если второе существительное" +
                                "является определениек к первому существительному. Например 'моя книга'"))))
                .build()));

        grammarMap.put("nの", template.save(Grammar.builder()
                .name("nの")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("の"), partOfSpeechMap.get("n")), partOfSpeechMap.get("n"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "В конструкции 「nのn」, в случае если из контекста понятно о каком втором существительном " +
                                "идет речь, то второе существительное может опускаться. Например 「この本は私のです」"))))
                .build()));

        grammarMap.put("name+mr-suf", template.save(Grammar.builder()
                .name("name+mr-suf")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("mr-suf"), partOfSpeechMap.get("name")), partOfSpeechMap.get("n"),
                        List.of(new TranslateEntity(languageMap.get("ru"), ""))))
                .build()));

        grammarMap.put("これ", template.save(Grammar.builder()
                .name("これ")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("これ")),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                                "грамматически функционируют так же, как и имена существительные. これ указывает на предмет, более близкий к говорящему."))))
                .build()));

        grammarMap.put("それ", template.save(Grammar.builder()
                .name("それ")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("それ")),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                                "грамматически функционируют иак же, как и имена существительные. それ указывает на предмет, более близкий к собеседнику."))))
                .build()));

        grammarMap.put("あれ", template.save(Grammar.builder()
                .name("あれ")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("それ")),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                                "грамматически функционируют иак же, как и имена существительные. あれ указывает на предмет, равноудаленный от собеседников."))))
                .build()));

        grammarMap.put("このn", template.save(Grammar.builder()
                .name("このn")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("この")), partOfSpeechMap.get("n"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Относительно-указательное местоимение 「この」 определяет существительное и используется " +
                                "с ним. 「このn」 указывает на предмет, более близкий к говорящему."))))
                .build()));

        grammarMap.put("そのn", template.save(Grammar.builder()
                .name("そのn")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("その")), partOfSpeechMap.get("n"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Относительно-указательное местоимение 「その」 определяет существительное и используется " +
                                "с ним. 「そのn」 указывает на предмет, более близкий к собеседнику."))))
                .build()));

        grammarMap.put("あのn", template.save(Grammar.builder()
                .name("あのn")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("あの")), partOfSpeechMap.get("n"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Относительно-указательное местоимение 「あの」 определяет существительное и используется " +
                                "с ним. 「あのn」 указывает на предмет, равноудаленный от говорящих."))))
                .build()));

        grammarMap.put("文か、文か", template.save(Grammar.builder()
                .name("文か、文か")
                .grammarType(GrammarType.ADDING)
                .addingGrammar(new AddingGrammar(
                        List.of(partOfSpeechMap.get("か"), partOfSpeechMap.get("文"), partOfSpeechMap.get("、"), partOfSpeechMap.get("か"), partOfSpeechMap.get("文")), partOfSpeechMap.get("文"),
                        List.of(new TranslateEntity(languageMap.get("ru"), "Альтернативный вопрос, при ответе на который требуется выбрать правильное утверждение " +
                                "из двух (или более) предложенных. Ответом является повторение правильного утверждения без добавления 「はい」 или 「いいえ」"))))
                .build()));

        grammarMap.put("vBas1", template.save(Grammar.builder()
                .name("vBas1")
                .grammarType(GrammarType.CHANGE)
                .changeGrammarMap(List.of(
                        ChangeGrammar.builder().name("v1").deletingPart("る").addingPart("").build(),

                        ChangeGrammar.builder().name("v5u").deletingPart("う").addingPart("わ").build(),
                        ChangeGrammar.builder().name("v5k").deletingPart("く").addingPart("か").build(),
                        ChangeGrammar.builder().name("v5g").deletingPart("ぐ").addingPart("が").build(),
                        ChangeGrammar.builder().name("v5s").deletingPart("す").addingPart("さ").build(),
                        ChangeGrammar.builder().name("v5t").deletingPart("つ").addingPart("た").build(),
                        ChangeGrammar.builder().name("v5n").deletingPart("ぬ").addingPart("な").build(),
                        ChangeGrammar.builder().name("v5b").deletingPart("ぶ").addingPart("ば").build(),
                        ChangeGrammar.builder().name("v5m").deletingPart("む").addingPart("ま").build(),
                        ChangeGrammar.builder().name("v5r").deletingPart("る").addingPart("ら").build(),

                        ChangeGrammar.builder().name("vk").deletingPart("くる").addingPart("こ").build(),
                        ChangeGrammar.builder().name("vs").deletingPart("する").addingPart("し").build()))
                .build()));

        grammarMap.put("vBas2", template.save(Grammar.builder()
                .name("vBas2")
                .grammarType(GrammarType.CHANGE)
                .changeGrammarMap(List.of(
                        ChangeGrammar.builder().name("v1").deletingPart("る").addingPart("").build(),

                        ChangeGrammar.builder().name("v5u").deletingPart("う").addingPart("い").build(),
                        ChangeGrammar.builder().name("v5k").deletingPart("く").addingPart("き").build(),
                        ChangeGrammar.builder().name("v5g").deletingPart("ぐ").addingPart("ぎ").build(),
                        ChangeGrammar.builder().name("v5s").deletingPart("す").addingPart("し").build(),
                        ChangeGrammar.builder().name("v5t").deletingPart("つ").addingPart("ち").build(),
                        ChangeGrammar.builder().name("v5n").deletingPart("ぬ").addingPart("に").build(),
                        ChangeGrammar.builder().name("v5b").deletingPart("ぶ").addingPart("び").build(),
                        ChangeGrammar.builder().name("v5m").deletingPart("む").addingPart("み").build(),
                        ChangeGrammar.builder().name("v5r").deletingPart("る").addingPart("り").build(),

                        ChangeGrammar.builder().name("vk").deletingPart("くる").addingPart("き").build(),
                        ChangeGrammar.builder().name("vs").deletingPart("する").addingPart("し").build()))
                .build()));

        grammarMap.put("vBas4", template.save(Grammar.builder()
                .name("vBas4")
                .grammarType(GrammarType.CHANGE)
                .changeGrammarMap(List.of(
                        ChangeGrammar.builder().name("v1").deletingPart("る").addingPart("れ").build(),

                        ChangeGrammar.builder().name("v5u").deletingPart("う").addingPart("え").build(),
                        ChangeGrammar.builder().name("v5k").deletingPart("く").addingPart("け").build(),
                        ChangeGrammar.builder().name("v5g").deletingPart("ぐ").addingPart("げ").build(),
                        ChangeGrammar.builder().name("v5s").deletingPart("す").addingPart("せ").build(),
                        ChangeGrammar.builder().name("v5t").deletingPart("つ").addingPart("て").build(),
                        ChangeGrammar.builder().name("v5n").deletingPart("ぬ").addingPart("ね").build(),
                        ChangeGrammar.builder().name("v5b").deletingPart("ぶ").addingPart("べ").build(),
                        ChangeGrammar.builder().name("v5m").deletingPart("む").addingPart("め").build(),
                        ChangeGrammar.builder().name("v5r").deletingPart("る").addingPart("れ").build(),

                        ChangeGrammar.builder().name("vk").deletingPart("る").addingPart("れ").build(),
                        ChangeGrammar.builder().name("vs").deletingPart("る").addingPart("れ").build()))
                .build()));

        grammarMap.put("vBas5", template.save(Grammar.builder()
                .name("vBas5")
                .grammarType(GrammarType.CHANGE)
                .changeGrammarMap(List.of(
                        ChangeGrammar.builder().name("v1").deletingPart("る").addingPart("よう").build(),

                        ChangeGrammar.builder().name("v5u").deletingPart("う").addingPart("おう").build(),
                        ChangeGrammar.builder().name("v5k").deletingPart("く").addingPart("こう").build(),
                        ChangeGrammar.builder().name("v5g").deletingPart("ぐ").addingPart("ごう").build(),
                        ChangeGrammar.builder().name("v5s").deletingPart("す").addingPart("そう").build(),
                        ChangeGrammar.builder().name("v5t").deletingPart("つ").addingPart("とう").build(),
                        ChangeGrammar.builder().name("v5n").deletingPart("ぬ").addingPart("のう").build(),
                        ChangeGrammar.builder().name("v5b").deletingPart("ぶ").addingPart("ぼう").build(),
                        ChangeGrammar.builder().name("v5m").deletingPart("む").addingPart("もう").build(),
                        ChangeGrammar.builder().name("v5r").deletingPart("る").addingPart("ろう").build(),

                        ChangeGrammar.builder().name("vk").deletingPart("くる").addingPart("こよう").build(),
                        ChangeGrammar.builder().name("vs").deletingPart("する").addingPart("しよう").build()))
                .build()));
/*
        grammarMap.put("", template.save(new Grammar(
                List.of(partOfSpeechMap.get(""), partOfSpeechMap.get("")),
                List.of(new TranslateEntity(languageMap.get("ru"), "")))));
*/

    }

}
