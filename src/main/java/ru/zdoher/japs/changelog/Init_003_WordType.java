package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.codec.multipart.Part;
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

        partOfSpeechMap.putIfAbsent("pn", template.save(PartOfSpeech.builder()
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

        partOfSpeechMap.putIfAbsent("mr-suf", template.save(PartOfSpeech.builder()
                .shortName("mr-suf")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "суффикс обращения к кому-то: мистер, миссис и тд, используемый в японском языке")))
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

        partOfSpeechMap.putIfAbsent("n-pref", template.save(PartOfSpeech.builder()
                .shortName("n-pref")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "существительное, котором может использоваться как префикс"), new TranslateEntity(languageMap.get("en"), "noun, used as a prefix")))
                .build()));

        partOfSpeechMap.putIfAbsent("suf", template.save(PartOfSpeech.builder()
                .shortName("suf")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "суффикс"), new TranslateEntity(languageMap.get("en"), "suffix")))
                .build()));

        partOfSpeechMap.putIfAbsent("exp", template.save(PartOfSpeech.builder()
                .shortName("exp")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "выражение"), new TranslateEntity(languageMap.get("en"), "expressions (phrases, clauses, etc.)")))
                .build()));

        /// part of speech for grammar

        partOfSpeechMap.putIfAbsent("は", template.save(PartOfSpeech.builder()
                .shortName("は")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "частица は"), new TranslateEntity(languageMap.get("en"), "particle は")))
                .build()));

        partOfSpeechMap.putIfAbsent("です", template.save(PartOfSpeech.builder()
                .shortName("です")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "связка です"), new TranslateEntity(languageMap.get("en"), "....  です")))
                .build()));

        partOfSpeechMap.putIfAbsent("じゃありません", template.save(PartOfSpeech.builder()
                .shortName("じゃありません")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "разговорная отрицательная форма связки です")))
                .build()));

        partOfSpeechMap.putIfAbsent("ではありません", template.save(PartOfSpeech.builder()
                .shortName("ではありません")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "отрицательная форма связки です")))
                .build()));

        partOfSpeechMap.putIfAbsent("か", template.save(PartOfSpeech.builder()
                .shortName("か")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "вопросительная частица か")))
                .build()));

        partOfSpeechMap.putIfAbsent("も", template.save(PartOfSpeech.builder()
                .shortName("も")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "частица も")))
                .build()));

        partOfSpeechMap.putIfAbsent("の", template.save(PartOfSpeech.builder()
                .shortName("の")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "частица の")))
                .build()));

        partOfSpeechMap.putIfAbsent("さん", template.save(PartOfSpeech.builder()
                .shortName("さん")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "суффикс さん")))
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.SUFFIX)
                .build()));

        partOfSpeechMap.putIfAbsent("ちゃん", template.save(PartOfSpeech.builder()
                .shortName("ちゃん")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "суффикс ちゃん")))
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.SUFFIX)
                .build()));

        partOfSpeechMap.putIfAbsent("くん", template.save(PartOfSpeech.builder()
                .shortName("くん")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "суффикс くん")))
                .kuramojiTypeOfSpeech(KuramojiTypeOfSpeech.SUFFIX)
                .build()));

        partOfSpeechMap.putIfAbsent("これ", template.save(PartOfSpeech.builder()
                .shortName("これ")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "предметно-указательное местоимение これ")))
                .build()));

        partOfSpeechMap.putIfAbsent("それ", template.save(PartOfSpeech.builder()
                .shortName("それ")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "предметно-указательное местоимение それ")))
                .build()));

        partOfSpeechMap.putIfAbsent("あれ", template.save(PartOfSpeech.builder()
                .shortName("あれ")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "предметно-указательное местоимение あれ")))
                .build()));

        partOfSpeechMap.putIfAbsent("この", template.save(PartOfSpeech.builder()
                .shortName("この")
                .translateName( List.of(new TranslateEntity(languageMap.get("ru"), "относительно-указательное местоимение この")))
                .build()));

        partOfSpeechMap.putIfAbsent("その", template.save(PartOfSpeech.builder()
                .shortName("その")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "относительно-указательное местоимение その")))
                .build()));

        partOfSpeechMap.putIfAbsent("あの", template.save(PartOfSpeech.builder()
                .shortName("あの")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "относительно-указательное местоимение あの")))
                .build()));

        partOfSpeechMap.putIfAbsent("文", template.save(PartOfSpeech.builder()
                .shortName("文")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "показатель предложения")))
                .build()));

        partOfSpeechMap.putIfAbsent("、", template.save(PartOfSpeech.builder()
                .shortName("、")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "символ запятой")))
                .build()));

        partOfSpeechMap.putIfAbsent("。", template.save(PartOfSpeech.builder()
                .shortName("。")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "символ точки")))
                .build()));

        partOfSpeechMap.putIfAbsent("お", template.save(PartOfSpeech.builder()
                .shortName("お")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "показатель вежливости, префикс к существительному")))
                .build()));

        partOfSpeechMap.putIfAbsent("name", template.save(PartOfSpeech.builder()
                .shortName("name")
                .translateName(List.of(new TranslateEntity(languageMap.get("ru"), "имя, фамилия и тд")))
                .build()));

/*
        wordTypeMap.putIfAbsent("", template.save(new WordType("",
                List.of(new TranslateEntity(languageMap.get("ru"), ""), new TranslateEntity(languageMap.get("en"), "")), "")));
*/

    }

}
