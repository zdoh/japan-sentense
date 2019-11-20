package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

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

        partOfSpeechMap.putIfAbsent("num", template.save(new PartOfSpeech("num",
                List.of(new TranslateEntity(languageMap.get("ru"), "числительное"), new TranslateEntity(languageMap.get("en"), "numeral")), "数詞")));

        partOfSpeechMap.putIfAbsent("n", template.save(new PartOfSpeech("n",
                List.of(new TranslateEntity(languageMap.get("ru"), "существительное"), new TranslateEntity(languageMap.get("en"), "noun (common)")), "名詞")));

        partOfSpeechMap.putIfAbsent("pn", template.save(new PartOfSpeech("pn",
                List.of(new TranslateEntity(languageMap.get("ru"), "местоимение"), new TranslateEntity(languageMap.get("en"), "pronoun")), "代名詞")));

        partOfSpeechMap.putIfAbsent("hon", template.save(new PartOfSpeech("hon",
                List.of(new TranslateEntity(languageMap.get("ru"), "вежливая речь"), new TranslateEntity(languageMap.get("en"), "honorific or respectful (sonkeigo) language")))));

        partOfSpeechMap.putIfAbsent("adv", template.save(new PartOfSpeech("adv",
                List.of(new TranslateEntity(languageMap.get("ru"), "наречие"), new TranslateEntity(languageMap.get("en"), "adverb")), "副詞")));

        partOfSpeechMap.putIfAbsent("int", template.save(new PartOfSpeech("int",
                List.of(new TranslateEntity(languageMap.get("ru"), "междометие"), new TranslateEntity(languageMap.get("en"), "interjection")), "感動詞")));

        partOfSpeechMap.putIfAbsent("adj-na", template.save(new PartOfSpeech("adj-na",
                List.of(new TranslateEntity(languageMap.get("ru"), "na-прилагательное (предикативное)"), new TranslateEntity(languageMap.get("en"), "adjectival nouns or quasi-adjectives")), "な形容詞")));

        partOfSpeechMap.putIfAbsent("adj-i", template.save(new PartOfSpeech("adj-i",
                List.of(new TranslateEntity(languageMap.get("ru"), "i-прилагательное (полупредикативное)"), new TranslateEntity(languageMap.get("en"), "adjective")), "い形容詞")));

        partOfSpeechMap.putIfAbsent("v", template.save(new PartOfSpeech("v",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол"), new TranslateEntity(languageMap.get("en"), "verb")), "動詞")));

        partOfSpeechMap.putIfAbsent("v5b", template.save(new PartOfSpeech("v5b",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ぶ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'bu' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5g", template.save(new PartOfSpeech("v5g",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ぐ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'gu' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5k", template.save(new PartOfSpeech("v5k",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -く"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'ku' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5k-s", template.save(new PartOfSpeech("v5k-s",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -す (специальный клаас)"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'su' ending (special class)")), "")));

        partOfSpeechMap.putIfAbsent("v5m", template.save(new PartOfSpeech("v5m",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -む"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'mu' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5n", template.save(new PartOfSpeech("v5n",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ぬ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'nu' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5r", template.save(new PartOfSpeech("v5r",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -る"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'ru' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5s", template.save(new PartOfSpeech("v5s",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -す"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'su' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5t", template.save(new PartOfSpeech("v5t",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -つ"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'tu' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5u", template.save(new PartOfSpeech("v5u",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -う"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'u' ending")), "")));

        partOfSpeechMap.putIfAbsent("v5z", template.save(new PartOfSpeech("v5z",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол I-спряжение, -ず"), new TranslateEntity(languageMap.get("en"), "Godan verb with 'zu' ending")), "")));

        partOfSpeechMap.putIfAbsent("vi", template.save(new PartOfSpeech("vi",
                List.of(new TranslateEntity(languageMap.get("ru"), "непереходный глагол"), new TranslateEntity(languageMap.get("en"), "intransitive verb")), "")));

        partOfSpeechMap.putIfAbsent("prefix", template.save(new PartOfSpeech("prefix",
                List.of(new TranslateEntity(languageMap.get("ru"), "префикс"), new TranslateEntity(languageMap.get("en"), "prefix")), "")));

        partOfSpeechMap.putIfAbsent("v1", template.save(new PartOfSpeech("v1",
                List.of(new TranslateEntity(languageMap.get("ru"), "глагол II-спряжение"), new TranslateEntity(languageMap.get("en"), "ichidan verb")), "")));

        partOfSpeechMap.putIfAbsent("vt", template.save(new PartOfSpeech("vt",
                List.of(new TranslateEntity(languageMap.get("ru"), "переходный глагол"), new TranslateEntity(languageMap.get("en"), "transitive verb")), "")));

        partOfSpeechMap.putIfAbsent("n-adv", template.save(new PartOfSpeech("n-adv",
                List.of(new TranslateEntity(languageMap.get("ru"), "отглагольное существительное"), new TranslateEntity(languageMap.get("en"), "adverbial noun")), "")));

        partOfSpeechMap.putIfAbsent("n-t", template.save(new PartOfSpeech("n-t",
                List.of(new TranslateEntity(languageMap.get("ru"), "существительное (временное)"), new TranslateEntity(languageMap.get("en"), "noun (temporal)")), "")));

        partOfSpeechMap.putIfAbsent("vk", template.save(new PartOfSpeech("vk",
                List.of(new TranslateEntity(languageMap.get("ru"), "специальный глагол 来る"), new TranslateEntity(languageMap.get("en"), "来る verb - special class")), "")));

        partOfSpeechMap.putIfAbsent("vs", template.save(new PartOfSpeech("vs",
                List.of(new TranslateEntity(languageMap.get("ru"), "существительное, которое используется с する"), new TranslateEntity(languageMap.get("en"), "noun or participle which takes the aux. verb suru")), "")));

        partOfSpeechMap.putIfAbsent("ctr", template.save(new PartOfSpeech("ctr",
                List.of(new TranslateEntity(languageMap.get("ru"), "счетчик"), new TranslateEntity(languageMap.get("en"), "counter")), "")));

        partOfSpeechMap.putIfAbsent("n-suf", template.save(new PartOfSpeech("n-suf",
                List.of(new TranslateEntity(languageMap.get("ru"), "существительное, котором может использоваться как суффикс"), new TranslateEntity(languageMap.get("en"), "noun, used as a suffix")), "")));

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
