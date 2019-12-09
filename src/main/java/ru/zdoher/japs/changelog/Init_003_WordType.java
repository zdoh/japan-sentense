package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.parameters.P;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.morphology.KuramojiTypeOfSpeech;

import java.util.List;
import java.util.Map;

@ChangeLog(order = "003")
public class Init_003_WordType {
    private Map<String, PartOfSpeech> partOfSpeechMap;
    private Map<String, Language> languageMap;

    public Init_003_WordType() {
        partOfSpeechMap = InitMaps.partOfSpeechMap;
        languageMap = InitMaps.languageMap;
    }

    @ChangeSet(order = "001", id = "initialWordType", author = "zdoh", runAlways = true)
    public void initWordType(MongoTemplate template) {
        //wordTypeMap.putIfAbsent("", template.save(new WordType("", List.of(), "")));

        // no kuramoji
        partOfSpeechMap.putIfAbsent("num", template.save(PartOfSpeech.builder()
                .shortName("num")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "числительное"), new TranslateEntity(languageMap.get("en"), "numeral")))
                .japanName("数詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.MAIN)
                .build()));

        partOfSpeechMap.putIfAbsent("n", template.save(PartOfSpeech.builder()
                .shortName("n")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "существительное"), new TranslateEntity(languageMap.get("en"), "noun (common)")))
                .japanName("名詞")
                .kuramojiToken("名詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.MAIN)
                .build()));

        partOfSpeechMap.putIfAbsent("`pn`", template.save(PartOfSpeech.builder()
                .shortName("pn")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "местоимение"), new TranslateEntity(languageMap.get("en"), "pronoun")))
                .japanName("代名詞")
                .kuramojiToken("代名詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.MAIN)
                .build()));

        // no kuramoji
        partOfSpeechMap.putIfAbsent("hon", template.save(PartOfSpeech.builder()
                .shortName("hon")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "вежливая речь"), new TranslateEntity(languageMap.get("en"), "honorific or respectful (sonkeigo) language")))
                .build()));


        partOfSpeechMap.putIfAbsent("adv", template.save(PartOfSpeech.builder()
                .shortName("adv")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "наречие"), new TranslateEntity(languageMap.get("en"), "adverb")))
                .japanName("副詞")
                .kuramojiToken("副詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.OTHER)
                .build()));

        partOfSpeechMap.putIfAbsent("int", template.save(PartOfSpeech.builder()
                .shortName("int")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "междометие"), new TranslateEntity(languageMap.get("en"), "interjection")))
                .japanName("感動詞")
                .kuramojiToken("感動詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.OTHER)
                .build()));

        partOfSpeechMap.putIfAbsent("adj-na", template.save(PartOfSpeech.builder()
                .shortName("adj-na")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "na-прилагательное (предикативное)"), new TranslateEntity(languageMap.get("en"), "adjectival nouns or quasi-adjectives")))
                .japanName("な形容詞")
                .kuramojiToken("形容動詞語幹")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.MAIN)
                .build()));

        partOfSpeechMap.putIfAbsent("adj-i", template.save(PartOfSpeech.builder()
                .shortName("adj-i")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "i-прилагательное (полупредикативное)"), new TranslateEntity(languageMap.get("en"), "adjective")))
                .japanName("い形容詞")
                .kuramojiToken("形容詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.MAIN)
                .build()));

        partOfSpeechMap.putIfAbsent("v", template.save(PartOfSpeech.builder()
                .shortName("v")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол"), new TranslateEntity(languageMap.get("en"), "verb")))
                .japanName("動詞")
                .kuramojiToken("動詞")
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.MAIN)
                .build()));

        partOfSpeechMap.putIfAbsent("v5b", template.save(PartOfSpeech.builder()
                .shortName("v5b")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ぶ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'bu' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5g", template.save(PartOfSpeech.builder()
                .shortName("v5g")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ぐ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'gu' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5k", template.save(PartOfSpeech.builder()
                .shortName("v5k")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -く"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'ku' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5k-s", template.save(PartOfSpeech.builder()
                .shortName("v5k-s")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -す (специальный клаас)"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'su' ending (special class)")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5m", template.save(PartOfSpeech.builder()
                .shortName("v5m")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -む"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'mu' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5n", template.save(PartOfSpeech.builder()
                .shortName("v5n")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ぬ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'nu' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5r", template.save(PartOfSpeech.builder()
                .shortName("v5r")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -る"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'ru' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5s", template.save(PartOfSpeech.builder()
                .shortName("v5s")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -す"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'su' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5t", template.save(PartOfSpeech.builder()
                .shortName("v5t")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -つ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'tu' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5u", template.save(PartOfSpeech.builder()
                .shortName("v5u")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -う"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'u' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("v5z", template.save(PartOfSpeech.builder()
                .shortName("v5z")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ず"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'zu' ending")))
                .build()));

        partOfSpeechMap.putIfAbsent("vi", template.save(PartOfSpeech.builder()
                .shortName("vi")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "непереходный глагол"), new TranslateEntity(languageMap.get("en"), "intransitive verb")))
                .build()));

        partOfSpeechMap.putIfAbsent("prefix", template.save(PartOfSpeech.builder()
                .shortName("prefix")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "префикс"), new TranslateEntity(languageMap.get("en"), "prefix")))
                .build()));

        partOfSpeechMap.putIfAbsent("v1", template.save(PartOfSpeech.builder()
                .shortName("v1")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "глагол II-спряжение"), new TranslateEntity(languageMap.get("en"), "ichidan verb")))
                .build()));

        partOfSpeechMap.putIfAbsent("vt", template.save(PartOfSpeech.builder()
                .shortName("vt")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "переходный глагол"), new TranslateEntity(languageMap.get("en"), "transitive verb")))
                .build()));

        partOfSpeechMap.putIfAbsent("n-adv", template.save(PartOfSpeech.builder()
                .shortName("n-adv")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "отглагольное существительное"), new TranslateEntity(languageMap.get("en"), "adverbial noun")))
                .build()));

        partOfSpeechMap.putIfAbsent("n-t", template.save(PartOfSpeech.builder()
                .shortName("n-t")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "существительное (временное)"), new TranslateEntity(languageMap.get("en"), "noun (temporal)")))
                .build()));

        partOfSpeechMap.putIfAbsent("vk", template.save(PartOfSpeech.builder()
                .shortName("vk")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "специальный глагол 来る"), new TranslateEntity(languageMap.get("en"), "来る verb - special class")))
                .build()));

        partOfSpeechMap.putIfAbsent("vs", template.save(PartOfSpeech.builder()
                .shortName("vs")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "существительное, которое используется с する"), new TranslateEntity(languageMap.get("en"), "noun or participle which takes the aux. verb suru")))
                .build()));

        partOfSpeechMap.putIfAbsent("ctr", template.save(PartOfSpeech.builder()
                .shortName("ctr")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "счетчик"), new TranslateEntity(languageMap.get("en"), "counter")))
                .build()));

        partOfSpeechMap.putIfAbsent("n-suf", template.save(PartOfSpeech.builder()
                .shortName("n-suf")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "существительное, котором может использоваться как суффикс"), new TranslateEntity(languageMap.get("en"), "noun, used as a suffix")))
                .build()));

        partOfSpeechMap.putIfAbsent("n-pref", template.save(new PartOfSpeech("n-pref",
                List.of(new TranslateEntity(languageMap.get("ru"), "существительное, котором может использоваться как префикс"), new TranslateEntity(languageMap.get("en"), "noun, used as a prefix")), "")));

        partOfSpeechMap.putIfAbsent("suf", template.save(new PartOfSpeech("suf",
                List.of(new TranslateEntity(languageMap.get("ru"), "суффикс"), new TranslateEntity(languageMap.get("en"), "suffix")), "")));

        partOfSpeechMap.putIfAbsent("exp", template.save(new PartOfSpeech("exp",
                List.of(new TranslateEntity(languageMap.get("ru"), "выражение"), new TranslateEntity(languageMap.get("en"), "expressions (phrases, clauses, etc.)")), "")));

        /// part of speech for grammar

        partOfSpeechMap.putIfAbsent("は", template.save(new PartOfSpeech("は",
                List.of(new TranslateEntity(languageMap.get("ru"), "частица は"), new TranslateEntity(languageMap.get("en"), "particle は")), "")));

        partOfSpeechMap.putIfAbsent("です", template.save(new PartOfSpeech("です",
                List.of(new TranslateEntity(languageMap.get("ru"), "связка です"), new TranslateEntity(languageMap.get("en"), "....  です")), "")));

        partOfSpeechMap.putIfAbsent("じゃありません", template.save(new PartOfSpeech("じゃありません",
                List.of(new TranslateEntity(languageMap.get("ru"), "разговорная отрицательная форма связки です")), "")));

        partOfSpeechMap.putIfAbsent("ではありません", template.save(new PartOfSpeech("ではありません",
                List.of(new TranslateEntity(languageMap.get("ru"), "отрицательная форма связки です")), "")));

        partOfSpeechMap.putIfAbsent("か", template.save(new PartOfSpeech("か",
                List.of(new TranslateEntity(languageMap.get("ru"), "вопросительная частица か")), "")));

        partOfSpeechMap.putIfAbsent("も", template.save(new PartOfSpeech("も",
                List.of(new TranslateEntity(languageMap.get("ru"), "частица も")), "")));

        partOfSpeechMap.putIfAbsent("の", template.save(new PartOfSpeech("の",
                List.of(new TranslateEntity(languageMap.get("ru"), "частица の")), "")));

        partOfSpeechMap.putIfAbsent("さん", template.save(new PartOfSpeech("さん",
                List.of(new TranslateEntity(languageMap.get("ru"), "суффикс さん")), "")));

        partOfSpeechMap.putIfAbsent("ちゃん", template.save(new PartOfSpeech("ちゃん",
                List.of(new TranslateEntity(languageMap.get("ru"), "суффикс ちゃん")), "")));

        partOfSpeechMap.putIfAbsent("これ", template.save(new PartOfSpeech("これ",
                List.of(new TranslateEntity(languageMap.get("ru"), "предметно-указательное местоимение これ")), "")));

        partOfSpeechMap.putIfAbsent("それ", template.save(new PartOfSpeech("それ",
                List.of(new TranslateEntity(languageMap.get("ru"), "предметно-указательное местоимение それ")), "")));

        partOfSpeechMap.putIfAbsent("あれ", template.save(new PartOfSpeech("あれ",
                List.of(new TranslateEntity(languageMap.get("ru"), "предметно-указательное местоимение あれ")), "")));

        partOfSpeechMap.putIfAbsent("この", template.save(new PartOfSpeech("この",
                List.of(new TranslateEntity(languageMap.get("ru"), "относительно-указательное местоимение この")), "")));

        partOfSpeechMap.putIfAbsent("その", template.save(new PartOfSpeech("その",
                List.of(new TranslateEntity(languageMap.get("ru"), "относительно-указательное местоимение その")), "")));

        partOfSpeechMap.putIfAbsent("あの", template.save(new PartOfSpeech("あの",
                List.of(new TranslateEntity(languageMap.get("ru"), "относительно-указательное местоимение あの")), "")));

        partOfSpeechMap.putIfAbsent("文", template.save(new PartOfSpeech("文",
                List.of(new TranslateEntity(languageMap.get("ru"), "показатель предложения")), "")));

        partOfSpeechMap.putIfAbsent("、", template.save(new PartOfSpeech("、",
                List.of(new TranslateEntity(languageMap.get("ru"), "символ запятой")), "")));

        partOfSpeechMap.putIfAbsent("。", template.save(new PartOfSpeech("。",
                List.of(new TranslateEntity(languageMap.get("ru"), "символ точки")), "")));

        partOfSpeechMap.putIfAbsent("お", template.save(new PartOfSpeech("お",
                List.of(new TranslateEntity(languageMap.get("ru"), "показатель вежливости, префикс к существительному")), "")));

        partOfSpeechMap.putIfAbsent("name", template.save(new PartOfSpeech("name",
                List.of(new TranslateEntity(languageMap.get("ru"), "имя, фамилия и тд")), "", true)));

/*
        wordTypeMap.putIfAbsent("", template.save(new WordType("",
                List.of(new TranslateEntity(languageMap.get("ru"), ""), new TranslateEntity(languageMap.get("en"), "")), "")));
*/

    }

}
