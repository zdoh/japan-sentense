package ru.zdoher.japs.changelog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.*;
import ru.zdoher.japs.domain.sentence.OtherPossibleSentence;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.domain.sentence.SentenceTranslate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "000")
public class InitMongoDBDataChangeLog {
    private final String MINNA_GR_1 = "Minna no nihongo begin grammar I";

    private final String MINNA_GR_1_L1 = "Minna no nihongo begin grammar I - Lesson1";

    private final String MINNA_S = "Minna no nihongo";

    private Language langRu;
    private Language langEn;

    private Map<String, TextbookType>  textbookTypeMap = new HashMap<>();

    private Map<String, WordType> wordTypeMap = new HashMap<>();

    private Map<String, Word> wordsMap = new HashMap<>();

    private Map<String, Kanji> kanjiMap = new HashMap<>();

    private Map<String, Grammar> grammarMap = new HashMap<>();

    private Map<String, TextbookSeries> textbookSeriesMap = new HashMap<>();

    private Map<String, Textbook> textbookMap = new HashMap<>();

    private Map<String, SentencePoliteness> sentencePolitenessMap = new HashMap<>();

   /* @ChangeSet(order = "000", id = "dropDB", author = "zdoh", runAlways = true)
    public void initMaps(MongoDatabase database) {

    }*/

    @ChangeSet(order = "001", id = "dropDB", author = "zdoh", runAlways = true)
    public void dropDB(MongoDatabase database) {
        database.drop();
    }

    @ChangeSet(order = "002", id = "initialLanguage", author = "zdoh", runAlways = true)
    public void initAuthors(MongoTemplate template) {
        langRu = template.save(new Language("ru", "Русский"));
        langEn = template.save(new Language("en", "English"));
    }

    @ChangeSet(order = "003", id = "initialWordType", author = "zdoh", runAlways = true)
    public void initWordType(MongoTemplate template) {
        //wordTypeMap.put("", template.save(new WordType("", List.of(), "")));

        wordTypeMap.put("num", template.save(new WordType("num",
                        List.of(new TranslateEntity(langRu, "числительное"), new TranslateEntity(langEn, "numeral")), "数詞")));

        wordTypeMap.put("n", template.save(new WordType("n",
                List.of(new TranslateEntity(langRu, "существительное"), new TranslateEntity(langEn, "noun (common)")), "名詞")));

        wordTypeMap.put("pn", template.save(new WordType("pn",
                List.of(new TranslateEntity(langRu, "местоимение"), new TranslateEntity(langEn, "pronoun")), "代名詞")));

        wordTypeMap.put("hon", template.save(new WordType("hon",
                List.of(new TranslateEntity(langRu, "вежливая речь"), new TranslateEntity(langEn, "honorific or respectful (sonkeigo) language")))));

        wordTypeMap.put("adv", template.save(new WordType("adv",
                List.of(new TranslateEntity(langRu, "наречие"), new TranslateEntity(langEn, "adverb")), "副詞")));

        wordTypeMap.put("int", template.save(new WordType("int",
                List.of(new TranslateEntity(langRu, "междометие"), new TranslateEntity(langEn, "interjection")), "感動詞")));

        wordTypeMap.put("adj-na", template.save(new WordType("adj-na",
                List.of(new TranslateEntity(langRu, "na-прилагательное (предикативное)"), new TranslateEntity(langEn, "adjectival nouns or quasi-adjectives")), "な形容詞")));

        wordTypeMap.put("adj-i", template.save(new WordType("adj-i",
                List.of(new TranslateEntity(langRu, "i-прилагательное (полупредикативное)"), new TranslateEntity(langEn, "adjective")), "い形容詞")));

        wordTypeMap.put("v", template.save(new WordType("v",
                List.of(new TranslateEntity(langRu, "глагол"), new TranslateEntity(langEn, "verb")), "動詞")));

        wordTypeMap.put("v5b", template.save(new WordType("v5b",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ぶ"), new TranslateEntity(langEn, "Godan verb with 'bu' ending")), "")));

        wordTypeMap.put("v5g", template.save(new WordType("v5g",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ぐ"), new TranslateEntity(langEn, "Godan verb with 'gu' ending")), "")));

        wordTypeMap.put("v5k", template.save(new WordType("v5k",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -く"), new TranslateEntity(langEn, "Godan verb with 'ku' ending")), "")));

        wordTypeMap.put("v5k-s", template.save(new WordType("v5k-s",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -す (специальный клаас)"), new TranslateEntity(langEn, "Godan verb with 'su' ending (special class)")), "")));

        wordTypeMap.put("v5m", template.save(new WordType("v5m",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -む"), new TranslateEntity(langEn, "Godan verb with 'mu' ending")), "")));

        wordTypeMap.put("v5n", template.save(new WordType("v5n",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ぬ"), new TranslateEntity(langEn, "Godan verb with 'nu' ending")), "")));

        wordTypeMap.put("v5r", template.save(new WordType("v5r",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -る"), new TranslateEntity(langEn, "Godan verb with 'ru' ending")), "")));

        wordTypeMap.put("v5s", template.save(new WordType("v5s",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -す"), new TranslateEntity(langEn, "Godan verb with 'su' ending")), "")));

        wordTypeMap.put("v5t", template.save(new WordType("v5t",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -つ"), new TranslateEntity(langEn, "Godan verb with 'tu' ending")), "")));

        wordTypeMap.put("v5u", template.save(new WordType("v5u",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -う"), new TranslateEntity(langEn, "Godan verb with 'u' ending")), "")));

        wordTypeMap.put("v5z", template.save(new WordType("v5z",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ず"), new TranslateEntity(langEn, "Godan verb with 'zu' ending")), "")));

        wordTypeMap.put("vi", template.save(new WordType("vi",
                List.of(new TranslateEntity(langRu, "непереходный глагол"), new TranslateEntity(langEn, "intransitive verb")), "")));

        wordTypeMap.put("prefix", template.save(new WordType("prefix",
                List.of(new TranslateEntity(langRu, "префикс"), new TranslateEntity(langEn, "prefix")), "")));

        wordTypeMap.put("v1", template.save(new WordType("v1",
                List.of(new TranslateEntity(langRu, "глагол II-спряжение"), new TranslateEntity(langEn, "ichidan verb")), "")));

        wordTypeMap.put("vt", template.save(new WordType("vt",
                List.of(new TranslateEntity(langRu, "переходный глагол"), new TranslateEntity(langEn, "transitive verb")), "")));

        wordTypeMap.put("n-adv", template.save(new WordType("n-adv",
                List.of(new TranslateEntity(langRu, "отглагольное существительное"), new TranslateEntity(langEn, "adverbial noun")), "")));

        wordTypeMap.put("n-t", template.save(new WordType("n-t",
                List.of(new TranslateEntity(langRu, "существительное (временное)"), new TranslateEntity(langEn, "noun (temporal)")), "")));

        wordTypeMap.put("vk", template.save(new WordType("vk",
                List.of(new TranslateEntity(langRu, "специальный глагол 来る"), new TranslateEntity(langEn, "来る verb - special class")), "")));

        wordTypeMap.put("vs", template.save(new WordType("vs",
                List.of(new TranslateEntity(langRu, "существительное, которое используется с する"), new TranslateEntity(langEn, "noun or participle which takes the aux. verb suru")), "")));

        wordTypeMap.put("ctr", template.save(new WordType("ctr",
                List.of(new TranslateEntity(langRu, "счетчик"), new TranslateEntity(langEn, "counter")), "")));

        wordTypeMap.put("n-suf", template.save(new WordType("n-suf",
                List.of(new TranslateEntity(langRu, "существительное, котором может использоваться как суффикс"), new TranslateEntity(langEn, "noun, used as a suffix")), "")));

        wordTypeMap.put("suf", template.save(new WordType("suf",
                List.of(new TranslateEntity(langRu, "суффикс"), new TranslateEntity(langEn, "suffix")), "")));

        wordTypeMap.put("exp", template.save(new WordType("exp",
                List.of(new TranslateEntity(langRu, "выражение"), new TranslateEntity(langEn, "expressions (phrases, clauses, etc.)")), "")));

        wordTypeMap.put("n-pref", template.save(new WordType("n-pref",
                List.of(new TranslateEntity(langRu, "существительное, котором может использоваться как преффикс"), new TranslateEntity(langEn, "expressions (phrases, clauses, etc.)")), "")));


/*
        wordTypeMap.put("", template.save(new WordType("",
                List.of(new TranslateEntity(langRu, ""), new TranslateEntity(langEn, "")), "")));
*/

    }

    @ChangeSet(order = "004", id = "initialTextbookType", author = "zdoh", runAlways = true)
    public void initTextbookType(MongoTemplate template) {
        textbookTypeMap.put("文法", template.save(new TextbookType("文法")));
        textbookTypeMap.put("読解", template.save(new TextbookType("読解")));
        textbookTypeMap.put("語彙", template.save(new TextbookType("語彙")));
        textbookTypeMap.put("漢字", template.save(new TextbookType("漢字")));
        textbookTypeMap.put("聴解", template.save(new TextbookType("聴解")));
    }

    @ChangeSet(order = "005", id = "initialWord", author = "zdoh", runAlways = true)
    public void initWord(MongoTemplate template) {
        wordsMap.put("一つ", template.save(
                new Word("一つ", "ひとつ",
                        List.of(new TranslateEntity(langRu, "один"), new TranslateEntity(langEn, "one")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("二つ", template.save(
                new Word("二つ", "ふたつ",
                        List.of(new TranslateEntity(langRu, "два"), new TranslateEntity(langEn, "two")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("三つ", template.save(
                new Word("三つ", "みつ",
                        List.of(new TranslateEntity(langRu, "три"), new TranslateEntity(langEn, "three")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("四つ", template.save(
                new Word("四つ", "よっつ",
                        List.of(new TranslateEntity(langRu, "четыре"), new TranslateEntity(langEn, "four")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("五つ", template.save(
                new Word("五つ", "いつつ",
                        List.of(new TranslateEntity(langRu, "пять"), new TranslateEntity(langEn, "five")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("六つ", template.save(
                new Word("六つ", "むっつ",
                        List.of(new TranslateEntity(langRu, "шесть"), new TranslateEntity(langEn, "six")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("七つ", template.save(
                new Word("七つ", "ななつ",
                        List.of(new TranslateEntity(langRu, "семь"), new TranslateEntity(langEn, "seven")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("八つ", template.save(
                new Word("八つ", "やっつ",
                        List.of(new TranslateEntity(langRu, "восемь"), new TranslateEntity(langEn, "eight")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("九つ", template.save(
                new Word("九つ", "ここのつ",
                        List.of(new TranslateEntity(langRu, "девять"), new TranslateEntity(langEn, "nine")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("十", template.save(
                new Word("十", "とお",
                        List.of(new TranslateEntity(langRu, "десять"), new TranslateEntity(langEn, "ten")),
                        List.of(wordTypeMap.get("num")))));

        wordsMap.put("一月", template.save(
                new Word("一月", "いちがつ",
                        List.of(new TranslateEntity(langRu, "январь"), new TranslateEntity(langEn, "january")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("二月", template.save(
                new Word("二月", "にがつ",
                        List.of(new TranslateEntity(langRu, "февраль"), new TranslateEntity(langEn, "february")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("三月", template.save(
                new Word("三月", "さんがつ",
                        List.of(new TranslateEntity(langRu, "март"), new TranslateEntity(langEn, "march")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("四月", template.save(
                new Word("四月", "しがつ",
                        List.of(new TranslateEntity(langRu, "апрель"), new TranslateEntity(langEn, "april")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("五月", template.save(
                new Word("五月", "ごがつ",
                        List.of(new TranslateEntity(langRu, "май"), new TranslateEntity(langEn, "may")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("六月", template.save(
                new Word("六月", "ろくがつ",
                        List.of(new TranslateEntity(langRu, "июнь"), new TranslateEntity(langEn, "june")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("七月", template.save(
                new Word("七月", "しちがつ",
                        List.of(new TranslateEntity(langRu, "июль"), new TranslateEntity(langEn, "jule")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("八月", template.save(
                new Word("八月", "はちがつ",
                        List.of(new TranslateEntity(langRu, "август"), new TranslateEntity(langEn, "august")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("九月", template.save(
                new Word("九月", "くがつ",
                        List.of(new TranslateEntity(langRu, "сентябрь"), new TranslateEntity(langEn, "september")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("十月", template.save(
                new Word("十月", "じゅうがつ",
                        List.of(new TranslateEntity(langRu, "октябрь"), new TranslateEntity(langEn, "october")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("十一月", template.save(
                new Word("十一月", "じゅういちがつ",
                        List.of(new TranslateEntity(langRu, "ноябрь"), new TranslateEntity(langEn, "november")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("十二月", template.save(
                new Word("十二月", "じゅうにがつ",
                        List.of(new TranslateEntity(langRu, "декабрь"), new TranslateEntity(langEn, "december")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("十日", template.save(
                new Word("十日", "とおか",
                        List.of(new TranslateEntity(langRu, "1) десятый день месяца 2) десять дней"), new TranslateEntity(langEn, "1) the tenth day of the month 2)  ten days")),
                        List.of(wordTypeMap.get("n")))));


        wordsMap.put("私", template.save(
                new Word("私", "わたし",
                        List.of(new TranslateEntity(langRu, "я"), new TranslateEntity(langEn, "i")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("あなた", template.save(
                new Word("あたな", "あなた",
                        List.of(new TranslateEntity(langRu, "ты (вы)"), new TranslateEntity(langEn, "you")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("あの人", template.save(
                new Word("あの人", "あのひと",
                        List.of(new TranslateEntity(langRu, "он, она"), new TranslateEntity(langEn, "he, she, that person")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("あの方", template.save(
                new Word("あの方", "あのかた",
                        List.of(new TranslateEntity(langRu, "он, она (вежливее чем あの人)"), new TranslateEntity(langEn, "he, she")),
                        List.of(wordTypeMap.get("pn"), wordTypeMap.get("hon")))));

        wordsMap.put("先生", template.save(
                new Word("先生", "せんせい",
                        List.of(new TranslateEntity(langRu, "учитель, преподаватель (не употребляется о себе)"), new TranslateEntity(langEn, "teacher, master, doctor (can't use for myself)")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("hon")))));

        wordsMap.put("教師", template.save(
                new Word("教師", "きょうし",
                        List.of(new TranslateEntity(langRu, "учитель, преподаватель (употребляется о себе)"), new TranslateEntity(langEn, "teacher (can use for myself)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("学生", template.save(
                new Word("学生", "がくせい",
                        List.of(new TranslateEntity(langRu, "студент"), new TranslateEntity(langEn, "student")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("会社員", template.save(
                new Word("会社員", "かいしゃいん",
                        List.of(new TranslateEntity(langRu, "служащий фирмы"), new TranslateEntity(langEn, "company employee")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("社員", template.save(
                new Word("社員", "しゃいん",
                        List.of(new TranslateEntity(langRu, "служащий фирмы ~ (послелог указывающий на то, какой фирмы)"), new TranslateEntity(langEn, "1) company employee 2) member of a corporation; company stockholder")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("銀行員", template.save(
                new Word("銀行員", "ぎんこういん",
                        List.of(new TranslateEntity(langRu, "служащий банка"), new TranslateEntity(langEn, "bank employee; bank staff member; bank clerk")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("医者", template.save(
                new Word("医者", "いしゃ",
                        List.of(new TranslateEntity(langRu, "врач"), new TranslateEntity(langEn, "doctor; physician")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("研究者", template.save(
                new Word("研究者", "けんきゅうしゃ",
                        List.of(new TranslateEntity(langRu, "исследователь, ученый"), new TranslateEntity(langEn, "researcher")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("大学", template.save(
                new Word("大学", "だいがく",
                        List.of(new TranslateEntity(langRu, "университет"), new TranslateEntity(langEn, "university; college")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("病院", template.save(
                new Word("病院", "びょういん",
                        List.of(new TranslateEntity(langRu, "больница"), new TranslateEntity(langEn, "hospital")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("誰", template.save(
                new Word("誰", "だれ",
                        List.of(new TranslateEntity(langRu, "кто"), new TranslateEntity(langEn, "who")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("どなた", template.save(
                new Word("どなた", "どなた",
                        List.of(new TranslateEntity(langRu, "кто (вежливее чем だれ)"), new TranslateEntity(langEn, "who (respectful)")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("hon")))));

        wordsMap.put("何歳", template.save(
                new Word("何歳", "なんさい",
                        List.of(new TranslateEntity(langRu, "сколько лет?"), new TranslateEntity(langEn, "how old?; what age?")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("いくつ", template.save(
                new Word("いくつ", "いくつ",
                        List.of(new TranslateEntity(langRu, "сколько лет? (вежливый вариант 何歳)"), new TranslateEntity(langEn, "how many?; (2) how old? (respectful)")),
                        List.of(wordTypeMap.get("adv")))));

        wordsMap.put("はい", template.save(
                new Word("はい", "はい",
                        List.of(new TranslateEntity(langRu, "да"), new TranslateEntity(langEn, "yes")),
                        List.of(wordTypeMap.get("int")))));

        wordsMap.put("いいえ", template.save(
                new Word("いいえ", "いいえ",
                        List.of(new TranslateEntity(langRu, "нет"), new TranslateEntity(langEn, "no")),
                        List.of(wordTypeMap.get("int")))));

        wordsMap.put("国", template.save(
                new Word("国", "くに",
                        List.of(new TranslateEntity(langRu, "1) страна, государство 2) родина"), new TranslateEntity(langEn, "1) country, state 2) region 3) national government, central government; (4) home")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("言葉", template.save(
                new Word("言葉", "ことば",
                        List.of(new TranslateEntity(langRu, "1) слово; слова 2) язык 3) диалект"), new TranslateEntity(langEn, "1) language, dialect 2) word, words, phrase, term, expression, remark 3) speech")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("アメリカ", template.save(
                new Word("アメリカ", "アメリカ",
                        List.of(new TranslateEntity(langRu, "сша"), new TranslateEntity(langEn, "1) America 2) United States of America")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("イギリス", template.save(
                new Word("イギリス", "イギリス",
                        List.of(new TranslateEntity(langRu, "Англия"), new TranslateEntity(langEn, "1) United Kingdom, Britain, Great Britain 2) England")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("イタリア", template.save(
                new Word("イタリア", "イタリア",
                        List.of(new TranslateEntity(langRu, "Италия"), new TranslateEntity(langEn, "Italy")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("イラン", template.save(
                new Word("イラン", "イラン",
                        List.of(new TranslateEntity(langRu, "Иран"), new TranslateEntity(langEn, "Iran")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("韓国", template.save(
                new Word("韓国", "かんこく",
                        List.of(new TranslateEntity(langRu, "Корея (южная)"), new TranslateEntity(langEn, "South Korea, Republic of Korea")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("スペイン", template.save(
                new Word("スペイン", "スペイン",
                        List.of(new TranslateEntity(langRu, "Испания"), new TranslateEntity(langEn, "Spain")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("ドイツ", template.save(
                new Word("ドイツ", "ドイツ",
                        List.of(new TranslateEntity(langRu, "Германия"), new TranslateEntity(langEn, "Germany")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("日本", template.save(
                new Word("日本", "にほん",
                        List.of(new TranslateEntity(langRu, "Япония"), new TranslateEntity(langEn, "Japan")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("ロシア", template.save(
                new Word("ロシア", "ロシア",
                        List.of(new TranslateEntity(langRu, "Россия"), new TranslateEntity(langEn, "Russia")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("中国", template.save(
                new Word("中国", "ちゅうごく",
                        List.of(new TranslateEntity(langRu, "Китай"), new TranslateEntity(langEn, "China")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("アメリカ人", template.save(
                new Word("アメリカ人", "アメリカじん",
                        List.of(new TranslateEntity(langRu, "американец"), new TranslateEntity(langEn, "American person")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("韓国人", template.save(
                new Word("韓国人", "かんこくじん",
                        List.of(new TranslateEntity(langRu, "кореец"), new TranslateEntity(langEn, "South Korean person")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("中国人", template.save(
                new Word("中国人", "ちゅうごくじん",
                        List.of(new TranslateEntity(langRu, "китаец"), new TranslateEntity(langEn, "Chinese person")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("日本人", template.save(
                new Word("日本人", "にほんじん",
                        List.of(new TranslateEntity(langRu, "японец"), new TranslateEntity(langEn, "Japanese person, Japanese people")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("ロシア人", template.save(
                new Word("ロシア人", "ロシアじん",
                        List.of(new TranslateEntity(langRu, "русский"), new TranslateEntity(langEn, "Russian (person, people)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("英語", template.save(
                new Word("英語", "えいご",
                        List.of(new TranslateEntity(langRu, "английский язык"), new TranslateEntity(langEn, "English (language)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("韓国語", template.save(
                new Word("韓国語", "かんこくご",
                        List.of(new TranslateEntity(langRu, "корейский язык"), new TranslateEntity(langEn, "Korean (language)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("日本語", template.save(
                new Word("日本語", "にほんご",
                        List.of(new TranslateEntity(langRu, "японский язык"), new TranslateEntity(langEn, "Japanese (language)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("ロシア語", template.save(
                new Word("ロシア語", "ロシアご",
                        List.of(new TranslateEntity(langRu, "русский язык"), new TranslateEntity(langEn, "Russian (language)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("本", template.save(
                new Word("本", "ほん",
                        List.of(new TranslateEntity(langRu, "книга"), new TranslateEntity(langEn, "book")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("辞書", template.save(
                new Word("辞書", "じしょ",
                        List.of(new TranslateEntity(langRu, "фонетический словарь"), new TranslateEntity(langEn, "dictionary, lexicon")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("雑誌", template.save(
                new Word("雑誌", "ざっし",
                        List.of(new TranslateEntity(langRu, "журнал"), new TranslateEntity(langEn, "journal, magazine, periodical")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("新聞", template.save(
                new Word("新聞", "しんぶん",
                        List.of(new TranslateEntity(langRu, "газета"), new TranslateEntity(langEn, "newspaper")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("ノート", template.save(
                new Word("ノート", "ノート",
                        List.of(new TranslateEntity(langRu, "1) записная книжка, блокнот 2) записки, записи 3) ноутбук"), new TranslateEntity(langEn, "notebook, copy-book, exercise book")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("手帳", template.save(
                new Word("手帳", "てちょう",
                        List.of(new TranslateEntity(langRu, "тетрадь; записная книжка, блокнот"), new TranslateEntity(langEn, "notebook; memo pad")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("名刺", template.save(
                new Word("名刺", "めいし",
                        List.of(new TranslateEntity(langRu, "визитная карточка"), new TranslateEntity(langEn, "business card")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("カード", template.save(
                new Word("カード", "カード",
                        List.of(new TranslateEntity(langRu, "1) карточка 2) кредитная карточка"), new TranslateEntity(langEn, "card")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("鉛筆", template.save(
                new Word("鉛筆", "えんぴつ",
                        List.of(new TranslateEntity(langRu, "карандаш"), new TranslateEntity(langEn, "pencil")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("ボールペン", template.save(
                new Word("ボールペン", "ボールペン",
                        List.of(new TranslateEntity(langRu, "шариковая ручка"), new TranslateEntity(langEn, "ball-point pen")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("シャープペンシル", template.save(
                new Word("シャープペンシル", "シャープペンシル",
                        List.of(new TranslateEntity(langRu, "механический карандаш"), new TranslateEntity(langEn, "propelling pencil, mechanical pencil")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("鍵", template.save(
                new Word("鍵", "かぎ",
                        List.of(new TranslateEntity(langRu, "ключ"), new TranslateEntity(langEn, "key")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("時計", template.save(
                new Word("時計", "とけい",
                        List.of(new TranslateEntity(langRu, "часы"), new TranslateEntity(langEn, "watch, clock, timepiece")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("傘", template.save(
                new Word("傘", "かさ",
                        List.of(new TranslateEntity(langRu, "зонт, зонтик"), new TranslateEntity(langEn, "umbrella, parasol")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("かばん", template.save(
                new Word("かばん", "かばん",
                        List.of(new TranslateEntity(langRu, "саквояж, чемодан; портфель"), new TranslateEntity(langEn, "bag, satchel, briefcase, basket")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("テレビ", template.save(
                new Word("テレビ", "テレビ",
                        List.of(new TranslateEntity(langRu, "1) телевидение 2) телевизор"), new TranslateEntity(langEn, "1) television, TV 2) TV program, TV programme, TV broadcast")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("カメラ", template.save(
                new Word("カメラ", "カメラ",
                        List.of(new TranslateEntity(langRu, "1) фотоаппарат, кинокамера 2) камера фотоаппарата"), new TranslateEntity(langEn, "camera")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("コンピューター", template.save(
                new Word("コンピューター", "コンピューター",
                        List.of(new TranslateEntity(langRu, "компьютер"), new TranslateEntity(langEn, "computer")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("車", template.save(
                new Word("車", "くるま",
                        List.of(new TranslateEntity(langRu, "1) машина, повозка 2) колесо"), new TranslateEntity(langEn, "1) car, automobile, vehicle, 2) wheel")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("机", template.save(
                new Word("机", "つくえ",
                        List.of(new TranslateEntity(langRu, "стол, парта"), new TranslateEntity(langEn, "desk")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("椅子", template.save(
                new Word("椅子", "いす",
                        List.of(new TranslateEntity(langRu, "стул"), new TranslateEntity(langEn, "1) chair, stool 2) post, office, position")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("チョコレート", template.save(
                new Word("チョコレート歳", "チョコレート",
                        List.of(new TranslateEntity(langRu, "шоколад"), new TranslateEntity(langEn, "chocolate")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("コーヒー", template.save(
                new Word("コーヒー", "コーヒー",
                        List.of(new TranslateEntity(langRu, "кофе"), new TranslateEntity(langEn, "coffee")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("土産", template.save(
                new Word("土産", "みやげ",
                        List.of(new TranslateEntity(langRu, "подарок, гостинец; сувенир"), new TranslateEntity(langEn, "present, souvenir")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("何", template.save(
                new Word("何", "なん",
                        List.of(new TranslateEntity(langRu, "что"), new TranslateEntity(langEn, "what?")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("これ", template.save(
                new Word("これ", "これ",
                        List.of(new TranslateEntity(langRu, "это (о предмете, более близком к говорящему)"), new TranslateEntity(langEn, "this (indicating an item near the speaker, the action of the speaker, or the current topic)")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("それ", template.save(
                new Word("それ", "それ",
                        List.of(new TranslateEntity(langRu, "то (о предмете, более близком к говорящему)"), new TranslateEntity(langEn, "that (indicating an item or person near the listener, the action of the listener, or something on their mind)")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("あれ", template.save(
                new Word("あれ", "あれ",
                        List.of(new TranslateEntity(langRu, "то (о предмете, равноудаленном к собеседникам)"), new TranslateEntity(langEn, "1) that (indicating something distant from both speaker and listener (in space, time or psychologically), or something understood without naming it directly)")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("名", template.save(
                new Word("名", "な",
                        List.of(new TranslateEntity(langRu, "1) имя, название, наименование 2) имя, репутация, честь 3) имя, известность"), new TranslateEntity(langEn, "1) name, given name 2) title 3) fame, renown, reputation")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("有名", template.save(
                new Word("有名", "ゆうめい",
                        List.of(new TranslateEntity(langRu, "знаменитый, известный"), new TranslateEntity(langEn, "how old?; what age?")),
                        List.of(wordTypeMap.get("adj-na")))));

        wordsMap.put("方法", template.save(
                new Word("方法", "ほうほう",
                        List.of(new TranslateEntity(langRu, "1) способ, метод; средство, мера 2) план, программа"), new TranslateEntity(langEn, "method; process; manner; way; means; technique")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("方", template.save(
                new Word("方", "ほう",
                        List.of(new TranslateEntity(langRu, "направление; сторона"), new TranslateEntity(langEn, "direction, way, side, area (in a particular direction)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("人", template.save(
                new Word("人", "ひと",
                        List.of(new TranslateEntity(langRu, "1) человек, люди 2) личность, характер"), new TranslateEntity(langEn, "1) man; person 2) human being, mankind, people")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("日", template.save(
                new Word("日", "ひ",
                        List.of(new TranslateEntity(langRu, "1) день"), new TranslateEntity(langEn, "1) day, days 2) sun, sunshine, sunlight")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("毎日", template.save(
                new Word("毎日", "まいにち",
                        List.of(new TranslateEntity(langRu, "каждый день, ежедневно, день за днём, изо дня в день"), new TranslateEntity(langEn, "every day")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("大きい", template.save(
                new Word("大きい", "おおきい",
                        List.of(new TranslateEntity(langRu, "большой, крупный"), new TranslateEntity(langEn, "1) big, large, great 2) loud 3) extensive, spacious")),
                        List.of(wordTypeMap.get("adj-i")))));

        wordsMap.put("大いに", template.save(
                new Word("大いに", "おおいに",
                        List.of(new TranslateEntity(langRu, "очень, весьма, в высшей степени"), new TranslateEntity(langEn, "very; much; greatly; a lot of")),
                        List.of(wordTypeMap.get("adv")))));

        wordsMap.put("学ぶ", template.save(
                new Word("学ぶ", "まなぶ",
                        List.of(new TranslateEntity(langRu, "учиться чему-л., изучать что-л.; обучаться"), new TranslateEntity(langEn, "to study (in depth), to learn, to take lessons in")),
                        List.of(wordTypeMap.get("v"), wordTypeMap.get("v5b")))));

        wordsMap.put("社", template.save(
                new Word("社", "やしろ",
                        List.of(new TranslateEntity(langRu, "[синтоистский] храм"), new TranslateEntity(langEn, "shrine (usually Shinto)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("会う", template.save(
                new Word("会う", "あう",
                        List.of(new TranslateEntity(langRu, "1) (に) [по]встречаться с кем-л.; видеться с кем-л. 2) встретить что-л.; перенести, испытать что-л."), new TranslateEntity(langEn, "1) to meet, to encounter, to see 2) to have an accident, to have a bad experience")),
                        List.of(wordTypeMap.get("v"), wordTypeMap.get("v5u"), wordTypeMap.get("vi")))));

        wordsMap.put("会社", template.save(
                new Word("会社", "かいしゃ",
                        List.of(new TranslateEntity(langRu, "компания, общество, фирма"), new TranslateEntity(langEn, "1) company, corporation 2) workplace")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("先", template.save(
                new Word("先", "さき",
                        List.of(new TranslateEntity(langRu, "1) первенство 2) раньше, прежде 3) заранее; до того как 4) дальше, далее; впереди чего-л.; в сторону от чего-л."), new TranslateEntity(langEn, "1) previous, prior, former, first, earlier, some time ago, preceding 2) point (e.g. pencil), tip, end, nozzle 3) head (of a line), front")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("prefix")))));

        wordsMap.put("生きる", template.save(
                new Word("生きる", "いきる",
                        List.of(new TranslateEntity(langRu, "1) жить, быть живым 2) (жарг.) восстанавливать зачёркнутое (в корректуре)"), new TranslateEntity(langEn, "1) to live, to exist 2) to make a living, to subsist 3) to be in effect, to be in use, to function 4) to come to life, to be enlivened 5) to be safe (in baseball, go, etc.)")),
                        List.of(wordTypeMap.get("v1"), wordTypeMap.get("vi"), wordTypeMap.get("v")))));

        wordsMap.put("生かす", template.save(
                new Word("生かす", "いかす",
                        List.of(new TranslateEntity(langRu, "1) оживлять, воскрешать; обр. оживить; вдохнуть жизнь во что-л. 2) оставлять в живых; сохранять в живом виде"), new TranslateEntity(langEn, "1) to make (the best) use of, to put to good use, to leverage (skills, attributes, experience, etc.), to capitalise on (experience, etc.) 2) to let live, to keep alive 3) to revive, to resuscitate, to bring back to life 4) to restore (a deleted passage; in proofreading)")),
                        List.of(wordTypeMap.get("v5s"), wordTypeMap.get("vt"), wordTypeMap.get("v")))));

        wordsMap.put("生ける", template.save(
                new Word("生ける", "いける",
                        List.of(new TranslateEntity(langRu, "живой"), new TranslateEntity(langEn, "1) to arrange (flowers), to plant 2) living, live")),
                        List.of(wordTypeMap.get("v1"), wordTypeMap.get("vt"), wordTypeMap.get("v")))));

        wordsMap.put("生まれる", template.save(
                new Word("生まれる", "うまれる",
                        List.of(new TranslateEntity(langRu, "родиться, появиться на свет"), new TranslateEntity(langEn, "to be born")),
                        List.of(wordTypeMap.get("v1"), wordTypeMap.get("vi"), wordTypeMap.get("v")))));

        wordsMap.put("生む", template.save(
                new Word("生む", "うむ",
                        List.of(new TranslateEntity(langRu, "1) рождать, рожать, производить на свет; плодиться 2) порождать, приносить"), new TranslateEntity(langEn, "1) to give birth, to bear (child), to lay (eggs) 2) to produce, to yield, to give rise to, to deliver")),
                        List.of(wordTypeMap.get("v5m"), wordTypeMap.get("vt"), wordTypeMap.get("v")))));

        wordsMap.put("生える", template.save(
                new Word("生える", "はえる",
                        List.of(new TranslateEntity(langRu, "1) расти (о растениях) 2) расти (о волосах, ногтях, тж. о крыльях у птиц); прорезаться (о зубах)"), new TranslateEntity(langEn, "1) to grow, to spring up, to sprout 2) to cut (teeth)")),
                        List.of(wordTypeMap.get("v1"), wordTypeMap.get("vi"), wordTypeMap.get("v")))));

        wordsMap.put("生やす", template.save(
                new Word("生やす", "はやす",
                        List.of(new TranslateEntity(langRu, "отращивать, отпускать (бороду, усы)"), new TranslateEntity(langEn, "to grow; to cultivate; to wear a beard")),
                        List.of(wordTypeMap.get("v5s"), wordTypeMap.get("vt"), wordTypeMap.get("v")))));

        wordsMap.put("生", template.save(
                new Word("生", "なま",
                        List.of(new TranslateEntity(langRu, "1) сырой 2) (перен.) необработанный, полусырой, неспелый, зелёный"), new TranslateEntity(langEn, "1) raw, uncooked, fresh 2) natural, as it is, unedited, unprocessed 3) (col) unprotected (sex) 4) live (i.e. not recorded) 5) inexperienced, unpolished, green, crude")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("銀行", template.save(
                new Word("銀行", "ぎんこう",
                        List.of(new TranslateEntity(langRu, "банк"), new TranslateEntity(langEn, "bank")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("行く", template.save(
                new Word("行く", "いく, ゆく",
                        List.of(new TranslateEntity(langRu, "1) идти, ходить (о ком-л.) 2) идти, ехать, направляться, следовать куда-л. (о ком-л.; тж. о поезде, пароходе и т. п.); вести куда-л. (о дороге) 3) [по]бывать где-л. "), new TranslateEntity(langEn, "1) to go, to move, to head (towards), to be transported (towards), to reach 2) to proceed, to take place 3) to pass through, to come and go 4) to walk")),
                        List.of(wordTypeMap.get("vi"), wordTypeMap.get("v5k-s"), wordTypeMap.get("v")))));

        wordsMap.put("行う", template.save(
                new Word("行う", "おこなう",
                        List.of(new TranslateEntity(langRu, "1) делать, совершать, производить 2) выполнять, осуществлять, проводить [в жизнь]"), new TranslateEntity(langEn, "to perform; to do; to conduct oneself; to carry out")),
                        List.of(wordTypeMap.get("v5u"), wordTypeMap.get("vt"), wordTypeMap.get("v")))));

        wordsMap.put("来年", template.save(
                new Word("来年", "らいねん",
                        List.of(new TranslateEntity(langRu, "будущий (следующий) год"), new TranslateEntity(langEn, "next year")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("来る", template.save(
                new Word("来る", "くる",
                        List.of(new TranslateEntity(langRu, "1) приходить, прибывать; приезжать; приходить в гости 2) приходить, наступать (о чём-л.) 3) происходить, проистекать (из чего-л.)"), new TranslateEntity(langEn, "1) to come (spatially or temporally); to approach; to arrive; (vk,vi,aux-v) (2) (See 行って来る) to come back; to do ... and come back; (3) to come to be; to become; to get; to grow; to continue")),
                        List.of(wordTypeMap.get("vk"), wordTypeMap.get("vi"), wordTypeMap.get("v")))));

        wordsMap.put("電車", template.save(
                new Word("電車", "でんしゃ",
                        List.of(new TranslateEntity(langRu, "трамвай"), new TranslateEntity(langEn, "train; electric train")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("二十歳", template.save(
                new Word("二十歳", "はたち",
                        List.of(new TranslateEntity(langRu, "двадцатилетний возраст; двадцать лет [от роду]"), new TranslateEntity(langEn, "1) 20 years old")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("失礼", template.save(
                new Word("失礼", "しつれい",
                        List.of(new TranslateEntity(langRu, "1) невежливость, грубость 2) (при извинении)"), new TranslateEntity(langEn, "1) discourtesy; impoliteness 2) excuse me; goodbye 3) to leave 4) to be rude")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("vs"), wordTypeMap.get("adj-na")))));

        wordsMap.put("木", template.save(
                new Word("木", "き",
                        List.of(new TranslateEntity(langRu, "1) дерево, деревцо 2) дерево, лес (как материал)"), new TranslateEntity(langEn, "wood (first of the five elements)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("月曜日", template.save(
                new Word("月曜日", "げつようび",
                        List.of(new TranslateEntity(langRu, "понедельник"), new TranslateEntity(langEn, "Monday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("火曜日", template.save(
                new Word("火曜日", "かようび",
                        List.of(new TranslateEntity(langRu, "вторник"), new TranslateEntity(langEn, "Tuesday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("水曜日", template.save(
                new Word("水曜日", "すいようび",
                        List.of(new TranslateEntity(langRu, "среда"), new TranslateEntity(langEn, "Wednesday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("木曜日", template.save(
                new Word("木曜日", "もくようび",
                        List.of(new TranslateEntity(langRu, "четверг"), new TranslateEntity(langEn, "Thursday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("金曜日", template.save(
                new Word("金曜日", "きんようび",
                        List.of(new TranslateEntity(langRu, "пятница"), new TranslateEntity(langEn, "Friday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("土曜日", template.save(
                new Word("土曜日", "どようび",
                        List.of(new TranslateEntity(langRu, "суббота"), new TranslateEntity(langEn, "Saturday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("日曜日", template.save(
                new Word("日曜日", "にちようび",
                        List.of(new TranslateEntity(langRu, "воскресенье"), new TranslateEntity(langEn, "Sunday")),
                        List.of(wordTypeMap.get("n-adv"), wordTypeMap.get("n-t")))));

        wordsMap.put("月", template.save(
                new Word("月", "つき",
                        List.of(new TranslateEntity(langRu, "1) луна, месяц 2) месяц (календарный)"), new TranslateEntity(langEn, "1) moon 2) month")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("三日", template.save(
                new Word("", "",
                        List.of(new TranslateEntity(langRu, "1) третье [число] 2) три дня"), new TranslateEntity(langEn, "1) the third day of the month 2) three days")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("山", template.save(
                new Word("山", "やま",
                        List.of(new TranslateEntity(langRu, "1) гора 2) лес 3) (тж. 鉱山) рудник"), new TranslateEntity(langEn, "1) mountain; hill 2) mine (e.g. coal mine) 3) heap; pile")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("ctr")))));

        wordsMap.put("火山", template.save(
                new Word("火山", "かざん",
                        List.of(new TranslateEntity(langRu, "вулкан"), new TranslateEntity(langEn, "volcano")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("富士山", template.save(
                new Word("富士山", "ふじさん",
                        List.of(new TranslateEntity(langRu, "гора Фудзи"), new TranslateEntity(langEn, "Mount Fuji; Mt. Fuji; Fujiyama; Fuji-san")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("川", template.save(
                new Word("川", "かわ",
                        List.of(new TranslateEntity(langRu, "река"), new TranslateEntity(langEn, "1) river; stream; (suf) 2) (suffix used with the names of rivers) River; the ... river")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("suf")))));

        wordsMap.put("河川", template.save(
                new Word("河川", "かせん",
                        List.of(new TranslateEntity(langRu, "реки"), new TranslateEntity(langEn, "rivers")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("田", template.save(
                new Word("田", "た",
                        List.of(new TranslateEntity(langRu, "[заболоченное] рисовое поле"), new TranslateEntity(langEn, "rice field")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("田んぼ", template.save(
                new Word("田んぼ", "たんぼ",
                        List.of(new TranslateEntity(langRu, "рисовое поле"), new TranslateEntity(langEn, "paddy field; farm")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("水田", template.save(
                new Word("水田", "すいでん",
                        List.of(new TranslateEntity(langRu, "заливное [рисовое] поле"), new TranslateEntity(langEn, "(water-filled) paddy field")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("三人", template.save(
                new Word("三人", "さんにん",
                        List.of(new TranslateEntity(langRu, "три человека"), new TranslateEntity(langEn, "three people")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("口", template.save(
                new Word("口", "くち",
                        List.of(new TranslateEntity(langRu, "1) рот; уста, губы 2) язык, речь; слова 3) вкус 4) вход, выход; ход куда-л.; место начала подъёма (на гору)"), new TranslateEntity(langEn, "1) mouth; (2) opening; hole; gap; orifice; (3) mouth (of a bottle); spout; nozzle; mouthpiece; (4) gate; door; entrance; exit")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("出口", template.save(
                new Word("出口", "でぐち",
                        List.of(new TranslateEntity(langRu, "1) выход 2) выпускное (выходное) отверстие"), new TranslateEntity(langEn, "exit; gateway; way out; outlet; leak; vent")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("入り口", template.save(
                new Word("入り口", "いりぐち",
                        List.of(new TranslateEntity(langRu, "вход"), new TranslateEntity(langEn, "entrance; entry; gate; approach; mouth")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("人口", template.save(
                new Word("人口", "じんこう",
                        List.of(new TranslateEntity(langRu, "население, численность населения; число жителей; численность людского состава"), new TranslateEntity(langEn, "1) population 2) common talk")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("自動車", template.save(
                new Word("自動車", "じどうしゃ",
                        List.of(new TranslateEntity(langRu, "автомобиль, [авто]машина"), new TranslateEntity(langEn, "automobile")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("門", template.save(
                new Word("門", "かど",
                        List.of(new TranslateEntity(langRu, "1) ворота 2) научная школа; школа (научное направление) какого-л. учёного 3) раздел, разряд"), new TranslateEntity(langEn, "gate")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("n-suf")))));

        wordsMap.put("専門", template.save(
                new Word("専門", "せんもん",
                        List.of(new TranslateEntity(langRu, "специальность"), new TranslateEntity(langEn, "speciality; specialty; subject of study; expert; area of expertise")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("火", template.save(
                new Word("火", "ひ",
                        List.of(new TranslateEntity(langRu, "1) огонь, пламя 2) пожар"), new TranslateEntity(langEn, "fire; flame; blaze")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("n-suf")))));

        wordsMap.put("水", template.save(
                new Word("水", "みず",
                        List.of(new TranslateEntity(langRu, "1) вода; холодная вода 2) жидкость"), new TranslateEntity(langEn, "1) water (esp. cool, fresh water, e.g. drinking water); (2) fluid (esp. in an animal tissue); liquid; (3) flood; floodwaters")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("金", template.save(
                new Word("金", "かね",
                        List.of(new TranslateEntity(langRu, "1) металл 2) деньги"), new TranslateEntity(langEn, "1) (See お金) money 2) metal")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("土", template.save(
                new Word("土", "つち",
                        List.of(new TranslateEntity(langRu, "земля"), new TranslateEntity(langEn, "1) earth; soil; dirt; clay; mud; (2) the earth (historically, esp. as opposed to the heavens); the ground; the land")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("土木", template.save(
                new Word("土木", "どぼく",
                        List.of(new TranslateEntity(langRu, "инженерные (строительные) работы"), new TranslateEntity(langEn, "engineering works; civil engineering; public works")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("子", template.save(
                new Word("子", "こ",
                        List.of(new TranslateEntity(langRu, "1) ребёнок, дитя 2) детёныш"), new TranslateEntity(langEn, "1) child (2) young (animal)")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("n-suf")))));

        wordsMap.put("子供", template.save(
                new Word("子供", "こども",
                        List.of(new TranslateEntity(langRu, "ребёнок, дитя; сын; дочь; дети"), new TranslateEntity(langEn, "child")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("女子学生", template.save(
                new Word("女子学生", "じょしがくせい",
                        List.of(new TranslateEntity(langRu, "студентка"), new TranslateEntity(langEn, "female student")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("女の子", template.save(
                new Word("女の子", "おんなのこ",
                        List.of(new TranslateEntity(langRu, "девочка"), new TranslateEntity(langEn, "girl")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("女子", template.save(
                new Word("女子", "じょし",
                        List.of(new TranslateEntity(langRu, "женщина, девушка"), new TranslateEntity(langEn, "woman; girl")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("女", template.save(
                new Word("女", "おんな",
                        List.of(new TranslateEntity(langRu, "женщина"), new TranslateEntity(langEn, "1) female; woman; female sex; (n) (2) female lover; girlfriend; mistress; (someone's) woman")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("n-pref")))));

        wordsMap.put("女の人", template.save(
                new Word("女の人", "おんなのひと",
                        List.of(new TranslateEntity(langRu, "женщина"), new TranslateEntity(langEn, "woman")),
                        List.of(wordTypeMap.get("n"), wordTypeMap.get("exp")))));

        wordsMap.put("彼女", template.save(
                new Word("彼女", "かのじょ",
                        List.of(new TranslateEntity(langRu, "она"), new TranslateEntity(langEn, "1) she; her 2) girlfriend")),
                        List.of(wordTypeMap.get("pn")))));

        wordsMap.put("学校", template.save(
                new Word("学校", "がっこう",
                        List.of(new TranslateEntity(langRu, "1) школа, училище; учебное заведение 2) (перен.) занятия (в учебном заведении)"), new TranslateEntity(langEn, "school")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("先月", template.save(
                new Word("先月", "せんげつ",
                        List.of(new TranslateEntity(langRu, "прошлый месяц"), new TranslateEntity(langEn, "last month")),
                        List.of(wordTypeMap.get("n-t"), wordTypeMap.get("n-adv")))));

        wordsMap.put("私立大学", template.save(
                new Word("私立大学", "しりつだいがく",
                        List.of(new TranslateEntity(langRu, "частный колледж (университет)"), new TranslateEntity(langEn, "private university")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("私立", template.save(
                new Word("私立", "しりつ",
                        List.of(new TranslateEntity(langRu, "частный (содержащийся на частные средства)"), new TranslateEntity(langEn, "private (establishment)")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("火事", template.save(
                new Word("火事", "かじ",
                        List.of(new TranslateEntity(langRu, "пожар"), new TranslateEntity(langEn, "fire; conflagration")),
                        List.of(wordTypeMap.get("n")))));

        wordsMap.put("生年月日", template.save(
                new Word("生年月日", "せいねんがっぴ",
                        List.of(new TranslateEntity(langRu, "дата рождения"), new TranslateEntity(langEn, "birth date; date of birth")),
                        List.of(wordTypeMap.get("n")))));

/*
        wordsMap.put("", template.save(
                new Word("", "",
                        List.of(new TranslateEntity(langRu, ""), new TranslateEntity(langEn, "")),
                        List.of(wordTypeMap.get("")))));
*/


    }

    @ChangeSet(order = "006", id = "initialKunyomiWord", author = "zdoh", runAlways = true)
    public void initialKunyomiWord(MongoTemplate template) {
        wordsMap.put("ひと", template.save(new Word("ひと")));
        wordsMap.put("ふた", template.save(new Word("ふた")));
        wordsMap.put("み", template.save(new Word("み")));
        wordsMap.put("みっ", template.save(new Word("みっ")));
        wordsMap.put("よ", template.save(new Word("よ")));
        wordsMap.put("よつ", template.save(new Word("よつっ")));
        wordsMap.put("よん", template.save(new Word("よん")));
        wordsMap.put("いつ", template.save(new Word("いつ")));
        wordsMap.put("むつ", template.save(new Word("むつ")));
        wordsMap.put("むい", template.save(new Word("むい")));
        wordsMap.put("なな", template.save(new Word("なな")));
        wordsMap.put("なの", template.save(new Word("なの")));
        wordsMap.put("や", template.save(new Word("や")));
        wordsMap.put("やつ", template.save(new Word("やつ")));
        wordsMap.put("よう", template.save(new Word("よう")));
        wordsMap.put("ここの", template.save(new Word("ここの")));
        wordsMap.put("と", template.save(new Word("と")));
        wordsMap.put("かた", template.save(new Word("かた")));
        wordsMap.put("もと", template.save(new Word("もと")));
        wordsMap.put("か", template.save(new Word("か")));
        wordsMap.put("おお", template.save(new Word("おお")));
        wordsMap.put("こ", template.save(new Word("こ")));
        wordsMap.put("ほ", template.save(new Word("ほ")));


    }

    @ChangeSet(order = "007", id = "initialKanji", author = "zdoh", runAlways = true)
    public void initKanji(MongoTemplate template) {
        kanjiMap.put("一", template.save(
                new Kanji("一",
                        List.of(new TranslateEntity(langRu, "один"), new TranslateEntity(langEn, "one")),
                        List.of("イチ", "イツ"), List.of(wordsMap.get("一つ"), wordsMap.get("ひと")), wordsMap.get("一月"))));

        kanjiMap.put("二", template.save(
                new Kanji("二",
                        List.of(new TranslateEntity(langRu, "два"), new TranslateEntity(langEn, "two")),
                        List.of("ニ"), List.of(wordsMap.get("二つ"), wordsMap.get("ふた")), wordsMap.get("二月"))));

        kanjiMap.put("三", template.save(
                new Kanji("三",
                        List.of(new TranslateEntity(langRu, "три"), new TranslateEntity(langEn, "three")),
                        List.of("サン"), List.of(wordsMap.get("三つ"), wordsMap.get("み"), wordsMap.get("みっ")), wordsMap.get("三月"))));

        kanjiMap.put("四", template.save(
                new Kanji("四",
                        List.of(new TranslateEntity(langRu, "четыре"), new TranslateEntity(langEn, "four")),
                        List.of("シ"), List.of(wordsMap.get("四つ"), wordsMap.get("よ"), wordsMap.get("よつ"), wordsMap.get("よん")), wordsMap.get("四月"))));

        kanjiMap.put("五", template.save(
                new Kanji("五",
                        List.of(new TranslateEntity(langRu, "пять"), new TranslateEntity(langEn, "five")),
                        List.of("ゴ"), List.of(wordsMap.get("五つ"), wordsMap.get("いつ")), wordsMap.get("五月"))));

        kanjiMap.put("六", template.save(
                new Kanji("六",
                        List.of(new TranslateEntity(langRu, "шесть"), new TranslateEntity(langEn, "six")),
                        List.of("ロク"), List.of(wordsMap.get("六つ"), wordsMap.get("むつ"), wordsMap.get("むい")), wordsMap.get("六月"))));

        kanjiMap.put("七", template.save(
                new Kanji("七",
                        List.of(new TranslateEntity(langRu, "семь"), new TranslateEntity(langEn, "seven")),
                        List.of("シチ"), List.of(wordsMap.get("七つ"), wordsMap.get("なな"), wordsMap.get("なの")), wordsMap.get("七月"))));

        kanjiMap.put("八", template.save(
                new Kanji("八",
                        List.of(new TranslateEntity(langRu, "восемь"), new TranslateEntity(langEn, "eight")),
                        List.of("ハチ"), List.of(wordsMap.get("八つ"), wordsMap.get("や"), wordsMap.get("やつ"), wordsMap.get("よう")), wordsMap.get("八月"))));

        kanjiMap.put("九", template.save(
                new Kanji("九",
                        List.of(new TranslateEntity(langRu, "девять"), new TranslateEntity(langEn, "nine")),
                        List.of("キュウ", "ク"), List.of(wordsMap.get("九つ"), wordsMap.get("ここの")), wordsMap.get("九月"))));

        kanjiMap.put("十", template.save(
                new Kanji("十",
                        List.of(new TranslateEntity(langRu, "пять"), new TranslateEntity(langEn, "five")),
                        List.of("サン"), List.of(wordsMap.get("十"), wordsMap.get("と")), wordsMap.get("十日"))));

        kanjiMap.put("人", template.save(
                new Kanji("人",
                        List.of(new TranslateEntity(langRu, "человек")),
                        List.of("ジン", "ニン"), List.of(wordsMap.get("人")), wordsMap.get("日本人"))));

        kanjiMap.put("名", template.save(
                new Kanji("名",
                        List.of(new TranslateEntity(langRu, "имя")),
                        List.of("メイ", "ミョウ"), List.of(wordsMap.get("名")), wordsMap.get("有名"))));

        kanjiMap.put("方", template.save(
                new Kanji("方",
                        List.of(new TranslateEntity(langRu, "направление; сторона")),
                        List.of("ホウ"), List.of(wordsMap.get("かた")), wordsMap.get("方法"))));

        kanjiMap.put("本", template.save(
                new Kanji("本",
                        List.of(new TranslateEntity(langRu, "книга; основа; источник")),
                        List.of("ホン"), List.of(wordsMap.get("十"), wordsMap.get("もと")), wordsMap.get("日本"))));

        kanjiMap.put("日", template.save(
                new Kanji("日",
                        List.of(new TranslateEntity(langRu, "день, солнце, счетчик для дней")),
                        List.of("ニチ", "ジツ"), List.of(wordsMap.get("日"), wordsMap.get("か")), wordsMap.get("毎日"))));

        kanjiMap.put("何", template.save(
                new Kanji("何",
                        List.of(new TranslateEntity(langRu, "что")),
                        List.of("カ"), List.of(wordsMap.get("何")), null)));

        kanjiMap.put("大", template.save(
                new Kanji("大",
                        List.of(new TranslateEntity(langRu, "большой")),
                        List.of("ダイ", "タイ"), List.of(wordsMap.get("大きい"), wordsMap.get("大いに"), wordsMap.get("おお")), wordsMap.get("大学"))));

        kanjiMap.put("学", template.save(
                new Kanji("学",
                        List.of(new TranslateEntity(langRu, "учиться; учеба; наука")),
                        List.of("ガク"), List.of(wordsMap.get("学ぶ")), wordsMap.get("大学"))));

        kanjiMap.put("社", template.save(
                new Kanji("社",
                        List.of(new TranslateEntity(langRu, "фирма")),
                        List.of("シャ"), List.of(wordsMap.get("社")), wordsMap.get("社員"))));

        kanjiMap.put("員", template.save(
                new Kanji("員",
                        List.of(new TranslateEntity(langRu, "работник; сотрудник; член персонала; суффикс профессии")),
                        List.of("イン"), null, wordsMap.get("社員"))));

        kanjiMap.put("会", template.save(
                new Kanji("会",
                        List.of(new TranslateEntity(langRu, "встреча")),
                        List.of("カイ", "エ"), List.of(wordsMap.get("会う")), wordsMap.get("会社"))));

        kanjiMap.put("先", template.save(
                new Kanji("先",
                        List.of(new TranslateEntity(langRu, "впереди; перед")),
                        List.of("セン"), List.of(wordsMap.get("先")), wordsMap.get("先生"))));

        kanjiMap.put("生", template.save(
                new Kanji("生",
                        List.of(new TranslateEntity(langRu, "жизнь")),
                        List.of("セイ", "ショウ"),
                        List.of(wordsMap.get("生きる"), wordsMap.get("生かす"), wordsMap.get("生ける"), wordsMap.get("生まれる"),
                                wordsMap.get("生む"), wordsMap.get("生える"), wordsMap.get("生やす"), wordsMap.get("生")),
                        wordsMap.get("先生"))));

        kanjiMap.put("行", template.save(
                new Kanji("行",
                        List.of(new TranslateEntity(langRu, "идти")),
                        List.of("コウ", "ギョウ", "アン"), List.of(wordsMap.get("行く"), wordsMap.get("行う")), wordsMap.get("銀行"))));

        kanjiMap.put("来", template.save(
                new Kanji("来",
                        List.of(new TranslateEntity(langRu, "приходить")),
                        List.of("ライ"), List.of(wordsMap.get("来る")), wordsMap.get("来年"))));

        kanjiMap.put("車", template.save(
                new Kanji("車",
                        List.of(new TranslateEntity(langRu, "машина; автомобиль")),
                        List.of("シャ"), List.of(wordsMap.get("車")), wordsMap.get("電車"))));

        kanjiMap.put("月", template.save(
                new Kanji("月",
                        List.of(new TranslateEntity(langRu, "месяц (календарный); месяц; луна")),
                        List.of("ゲツ", "ガツ"), List.of(wordsMap.get("月")), wordsMap.get("月曜日"))));

        /////////////////////////////////////////

        kanjiMap.put("木", template.save(
                new Kanji("木",
                        List.of(new TranslateEntity(langRu, "дерево")),
                        List.of("ボク", "モク"), List.of(wordsMap.get("木"), wordsMap.get("こ")), wordsMap.get("木曜日"))));

        kanjiMap.put("山", template.save(
                new Kanji("山",
                        List.of(new TranslateEntity(langRu, "гора")),
                        List.of("サン"), List.of(wordsMap.get("山")), wordsMap.get("火山"))));

        kanjiMap.put("川", template.save(
                new Kanji("川",
                        List.of(new TranslateEntity(langRu, "река")),
                        List.of("セン"), List.of(wordsMap.get("川")), wordsMap.get("河川"))));

        kanjiMap.put("田", template.save(
                new Kanji("田",
                        List.of(new TranslateEntity(langRu, "рисовое поле")),
                        List.of("デン"), List.of(wordsMap.get("田")), wordsMap.get("水田"))));

        kanjiMap.put("口", template.save(
                new Kanji("口",
                        List.of(new TranslateEntity(langRu, "рот")),
                        List.of("コウ", "ク"), List.of(wordsMap.get("口")), wordsMap.get("人口"))));

        kanjiMap.put("門", template.save(
                new Kanji("門",
                        List.of(new TranslateEntity(langRu, "ворота")),
                        List.of("モン"), List.of(wordsMap.get("門")), wordsMap.get("専門"))));

        kanjiMap.put("火", template.save(
                new Kanji("火",
                        List.of(new TranslateEntity(langRu, "огонь")),
                        List.of("カ"), List.of(wordsMap.get("火"), wordsMap.get("ほ")), wordsMap.get("火曜日"))));

        kanjiMap.put("水", template.save(
                new Kanji("水",
                        List.of(new TranslateEntity(langRu, "вода")),
                        List.of("スイ"), List.of(wordsMap.get("水")), wordsMap.get("水曜日"))));

        kanjiMap.put("金", template.save(
                new Kanji("金",
                        List.of(new TranslateEntity(langRu, "золото; деньги; металл")),
                        List.of("キン", "コン"), List.of(wordsMap.get("金")), wordsMap.get("金曜日"))));

        kanjiMap.put("土", template.save(
                new Kanji("土",
                        List.of(new TranslateEntity(langRu, "земля")),
                        List.of("ド", "ト"), List.of(wordsMap.get("土")), wordsMap.get("土曜日"))));

        kanjiMap.put("子", template.save(
                new Kanji("子",
                        List.of(new TranslateEntity(langRu, "ребенок")),
                        List.of("シ", "ス"), List.of(wordsMap.get("子")), wordsMap.get("女子"))));

        kanjiMap.put("女", template.save(
                new Kanji("女",
                        List.of(new TranslateEntity(langRu, "женщина")),
                        List.of("ジョ", "ニョ", "ニョウ"), List.of(wordsMap.get("女")), wordsMap.get("女子"))));

        kanjiMap.put("私", template.save(
                new Kanji("私",
                        List.of(new TranslateEntity(langRu, "я; свой; личный; приватный")),
                        List.of("シ"), List.of(wordsMap.get("私")), wordsMap.get("私立"))));


/*
        kanjiList.put("", template.save(
                new Kanji("",
                        List.of(new TranslateEntity(langRu, "")),
                        List.of(""), List.of(wordsMap.get("")), wordsMap.get(""))));
*/



    }

    @ChangeSet(order = "008", id = "initialGrammar", author = "zdoh", runAlways = true)
    public void initGrammar(MongoTemplate template) {

    }

    @ChangeSet(order = "009", id = "initialTextbookSeries", author = "zdoh", runAlways = true)
    public void initTextbookSeries(MongoTemplate template) {
        textbookSeriesMap.put(MINNA_S, template.save(
                new TextbookSeries("みんなの日本語", MINNA_S)));
    }

    @ChangeSet(order = "010", id = "initialTextbook", author = "zdoh", runAlways = true)
    public void initTextbook(MongoTemplate template) {
        textbookMap.put(MINNA_GR_1, template.save(
                new Textbook("みんなの日本語初級I文法", MINNA_GR_1,
                        textbookSeriesMap.get(MINNA_S), true)));
    }

    @ChangeSet(order = "011", id = "initialLesson", author = "zdoh", runAlways = true)
    public void initLesson(MongoTemplate template) {
        Textbook textbook = textbookMap.get(MINNA_GR_1);
        textbook.getLessonList().add(new Lesson("Lesson 1"));
        textbook.getLessonList().add(new Lesson("Lesson 2"));

        textbookMap.put(MINNA_GR_1_L1,
                template.save(textbook));
    }

    @ChangeSet(order = "012", id = "initialTextbookLessonWord", author = "zdoh", runAlways = true)
    public void initTextbookLessonWord(MongoTemplate template) {
        ArrayList<Word> words = new ArrayList<>();

        words.add(wordsMap.get("私"));
        words.add(wordsMap.get("あなた"));
        words.add(wordsMap.get("あの人"));
        words.add(wordsMap.get("あの方"));
        words.add(wordsMap.get("先生"));
        words.add(wordsMap.get("教師"));
        words.add(wordsMap.get("学生"));
        words.add(wordsMap.get("会社員"));
        words.add(wordsMap.get("社員"));
        words.add(wordsMap.get("銀行員"));
        words.add(wordsMap.get("医者"));
        words.add(wordsMap.get("研究者"));
        words.add(wordsMap.get("大学"));
        words.add(wordsMap.get("病院"));
        words.add(wordsMap.get("誰"));
        words.add(wordsMap.get("どなた"));
        words.add(wordsMap.get("何歳"));
        words.add(wordsMap.get("いくつ"));
        words.add(wordsMap.get("はい"));
        words.add(wordsMap.get("いいえ"));
        words.add(wordsMap.get("国"));
        words.add(wordsMap.get("言葉"));
        words.add(wordsMap.get("アメリカ"));
        words.add(wordsMap.get("イギリス"));
        words.add(wordsMap.get("イタリア"));
        words.add(wordsMap.get("イラン"));
        words.add(wordsMap.get("韓国"));
        words.add(wordsMap.get("スペイン"));
        words.add(wordsMap.get("ドイツ"));
        words.add(wordsMap.get("日本"));
        words.add(wordsMap.get("ロシア"));
        words.add(wordsMap.get("中国"));
        words.add(wordsMap.get("アメリカ人"));
        words.add(wordsMap.get("韓国人"));
        words.add(wordsMap.get("中国人"));
        words.add(wordsMap.get("日本人"));
        words.add(wordsMap.get("ロシア人"));
        words.add(wordsMap.get("英語"));
        words.add(wordsMap.get("韓国語"));
        words.add(wordsMap.get("日本語"));
        words.add(wordsMap.get("ロシア語"));

        //words.add(wordsMap.get(""));


        textbookMap.get(MINNA_GR_1).getLessonList().get(0).setWordList(words);
        //textbook.getLessonList().add(new Lesson("Lesson 1"));

        template.save(textbookMap.get(MINNA_GR_1));

        /*textbookMap.put("Minna no nihongo begin grammar I - Lesson1",
                template.save(textbookMap.get("Minna no nihongo begin grammar I")));*/
    }

    @ChangeSet(order = "013", id = "initialSentencePoliteness", author = "zdoh", runAlways = true)
    public void initSentencePoliteness(MongoTemplate template) {
        sentencePolitenessMap.put("polite", template.save(new SentencePoliteness("丁寧語",
                List.of(new TranslateEntity(langRu, "нейтрально-вежливая речь"), new TranslateEntity(langEn, "polite language")))));

        sentencePolitenessMap.put("respectful", template.save(new SentencePoliteness("尊敬語",
                List.of(new TranslateEntity(langRu, "уважительная речь"), new TranslateEntity(langEn, "respectful language")))));

        sentencePolitenessMap.put("humble", template.save(new SentencePoliteness("謙譲語",
                List.of(new TranslateEntity(langRu, "скромная речь"), new TranslateEntity(langEn, "humble language")))));

        sentencePolitenessMap.put("simple", template.save(new SentencePoliteness("丁寧語",
                List.of(new TranslateEntity(langRu, "не формальная речь"), new TranslateEntity(langEn, "informal language")))));


    }

    @ChangeSet(order = "014", id = "initialSentence", author = "zdoh", runAlways = true)
    public void initSentence(MongoTemplate template) {
        //Lesson lesson1 = textbookMap.get(MINNA_GR_1).getLessonList().get(0);

        //System.out.println(lesson1.getName());

        String source1 = textbookMap.get(MINNA_GR_1).getJapaneseName() + " - "
                + textbookMap.get(MINNA_GR_1).getLessonList().get(0).getName();

        ArrayList<Sentence> sentences = new ArrayList<>();

        sentences.add(template.save(new Sentence("私はマイク・ミラーです。",
                List.of(template.save(new SentenceTranslate(langRu, "Я Майк Миллер."))), source1, sentencePolitenessMap.get("polite"), false)));

        sentences.add(template.save(new Sentence("私は会社員です。",
                List.of(template.save(new SentenceTranslate(langRu, "Я сотрудник компании."))), source1, sentencePolitenessMap.get("polite"), false)));

        sentences.add(template.save(new Sentence("サントスさんは学生じゃありません。",
                List.of(template.save(new SentenceTranslate(langRu, "Сантос-сан не студент."))), source1, sentencePolitenessMap.get("polite"), true)));

        sentences.add(template.save(new Sentence("「ミラーさんはアメリカ人ですか」「はい、アメリカ人です」",
                List.of(template.save(new SentenceTranslate(langRu, "'Миллер-сан американец?' 'Да, американец'"))), source1, sentencePolitenessMap.get("polite"), true)));

        sentences.add(template.save(new Sentence("「ミラーさんは先生ですか」「いいえ、先生じゃありません」",
                List.of(template.save(new SentenceTranslate(langRu, "'Миллер-сан преподаватель?' 'Нет, не преподаватель'"))), source1, sentencePolitenessMap.get("polite"), true)));

        sentences.add(template.save(new Sentence("「あの方はどなたですか」「（あの方は）ミラーです」",
                List.of(template.save(new SentenceTranslate(langRu, "'Миллер-сан преподаватель?' 'Нет, не преподаватель'",
                        List.of(new OtherPossibleSentence("「あのひとはだれですか」「（あの人は）ミラーです」", "zdoh", 1))))), source1, sentencePolitenessMap.get("polite"), true)));

        sentences.add(template.save(new Sentence("ミラーさんは会社員です。",
                List.of(template.save(new SentenceTranslate(langRu, "Миллер-сан сотрудник компании."))), source1, sentencePolitenessMap.get("polite"), false)));

        sentences.add(template.save(new Sentence("ミラーさんはIMCの社員です。",
                List.of(template.save(new SentenceTranslate(langRu, "Миллер-сан сотрудник компании IMC."))), source1, sentencePolitenessMap.get("polite"), false)));

        sentences.add(template.save(new Sentence("あの方はミラーさんです。",
                List.of(template.save(new SentenceTranslate(langRu, "Это Миллер-сан.",
                        List.of(new OtherPossibleSentence("あの人はミラーさんです。", "zdoh", 1))))), source1, sentencePolitenessMap.get("polite"), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));

        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1, sentencePolitenessMap.get(""), false)));






/*
        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1)));
*/



        textbookMap.get(MINNA_GR_1).getLessonList().get(0).setSentencesList(sentences);

        System.out.println(textbookMap.get(MINNA_GR_1).getEnglishName());

        template.save(textbookMap.get(MINNA_GR_1));
    }

}

