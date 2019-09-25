package ru.zdoher.japs.changelog;


import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import ru.zdoher.japs.domain.*;
import ru.zdoher.japs.domain.sentence.OtherPossibleSentence;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.domain.sentence.SentenceTranslate;
import ru.zdoher.japs.domain.textbook.Textbook;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.domain.textbook.TextbookType;
import ru.zdoher.japs.domain.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "000")
public class InitMongoDBDataChangeLog {
    private final String MINNA_S = "Minna no nihongo";
    private final String MINNA_GR_1 = "Minna no nihongo begin grammar I";
    private final String MINNA_KANJI_1 = "Minna no nihongo begin kanji I";

    private final String BASIC_KANJI_BOOK_S = "Basic kanji book";
    private final String BASIC_KANJI_BOOK_1 = "Basic kanji book I";

    private Language langRu;
    private Language langEn;

    private Map<String, TextbookType>  textbookTypeMap = new HashMap<>();

    private Map<String, PartOfSpeech> partOfSpeechMap = new HashMap<>();

    private Map<String, Word> wordsMap = new HashMap<>();

    private Map<String, Kanji> kanjiMap = new HashMap<>();

    private Map<String, Grammar> grammarMap = new HashMap<>();

    private Map<String, TextbookSeries> textbookSeriesMap = new HashMap<>();

    private Map<String, Textbook> textbookMap = new HashMap<>();

    private Map<String, SentencePoliteness> sentencePolitenessMap = new HashMap<>();

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

        partOfSpeechMap.put("num", template.save(new PartOfSpeech("num",
                        List.of(new TranslateEntity(langRu, "числительное"), new TranslateEntity(langEn, "numeral")), "数詞")));

        partOfSpeechMap.put("n", template.save(new PartOfSpeech("n",
                List.of(new TranslateEntity(langRu, "существительное"), new TranslateEntity(langEn, "noun (common)")), "名詞")));

        partOfSpeechMap.put("pn", template.save(new PartOfSpeech("pn",
                List.of(new TranslateEntity(langRu, "местоимение"), new TranslateEntity(langEn, "pronoun")), "代名詞")));

        partOfSpeechMap.put("hon", template.save(new PartOfSpeech("hon",
                List.of(new TranslateEntity(langRu, "вежливая речь"), new TranslateEntity(langEn, "honorific or respectful (sonkeigo) language")))));

        partOfSpeechMap.put("adv", template.save(new PartOfSpeech("adv",
                List.of(new TranslateEntity(langRu, "наречие"), new TranslateEntity(langEn, "adverb")), "副詞")));

        partOfSpeechMap.put("int", template.save(new PartOfSpeech("int",
                List.of(new TranslateEntity(langRu, "междометие"), new TranslateEntity(langEn, "interjection")), "感動詞")));

        partOfSpeechMap.put("adj-na", template.save(new PartOfSpeech("adj-na",
                List.of(new TranslateEntity(langRu, "na-прилагательное (предикативное)"), new TranslateEntity(langEn, "adjectival nouns or quasi-adjectives")), "な形容詞")));

        partOfSpeechMap.put("adj-i", template.save(new PartOfSpeech("adj-i",
                List.of(new TranslateEntity(langRu, "i-прилагательное (полупредикативное)"), new TranslateEntity(langEn, "adjective")), "い形容詞")));

        partOfSpeechMap.put("v", template.save(new PartOfSpeech("v",
                List.of(new TranslateEntity(langRu, "глагол"), new TranslateEntity(langEn, "verb")), "動詞")));

        partOfSpeechMap.put("v5b", template.save(new PartOfSpeech("v5b",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ぶ"), new TranslateEntity(langEn, "Godan verb with 'bu' ending")), "")));

        partOfSpeechMap.put("v5g", template.save(new PartOfSpeech("v5g",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ぐ"), new TranslateEntity(langEn, "Godan verb with 'gu' ending")), "")));

        partOfSpeechMap.put("v5k", template.save(new PartOfSpeech("v5k",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -く"), new TranslateEntity(langEn, "Godan verb with 'ku' ending")), "")));

        partOfSpeechMap.put("v5k-s", template.save(new PartOfSpeech("v5k-s",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -す (специальный клаас)"), new TranslateEntity(langEn, "Godan verb with 'su' ending (special class)")), "")));

        partOfSpeechMap.put("v5m", template.save(new PartOfSpeech("v5m",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -む"), new TranslateEntity(langEn, "Godan verb with 'mu' ending")), "")));

        partOfSpeechMap.put("v5n", template.save(new PartOfSpeech("v5n",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ぬ"), new TranslateEntity(langEn, "Godan verb with 'nu' ending")), "")));

        partOfSpeechMap.put("v5r", template.save(new PartOfSpeech("v5r",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -る"), new TranslateEntity(langEn, "Godan verb with 'ru' ending")), "")));

        partOfSpeechMap.put("v5s", template.save(new PartOfSpeech("v5s",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -す"), new TranslateEntity(langEn, "Godan verb with 'su' ending")), "")));

        partOfSpeechMap.put("v5t", template.save(new PartOfSpeech("v5t",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -つ"), new TranslateEntity(langEn, "Godan verb with 'tu' ending")), "")));

        partOfSpeechMap.put("v5u", template.save(new PartOfSpeech("v5u",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -う"), new TranslateEntity(langEn, "Godan verb with 'u' ending")), "")));

        partOfSpeechMap.put("v5z", template.save(new PartOfSpeech("v5z",
                List.of(new TranslateEntity(langRu, "глагол I-спряжение, -ず"), new TranslateEntity(langEn, "Godan verb with 'zu' ending")), "")));

        partOfSpeechMap.put("vi", template.save(new PartOfSpeech("vi",
                List.of(new TranslateEntity(langRu, "непереходный глагол"), new TranslateEntity(langEn, "intransitive verb")), "")));

        partOfSpeechMap.put("prefix", template.save(new PartOfSpeech("prefix",
                List.of(new TranslateEntity(langRu, "префикс"), new TranslateEntity(langEn, "prefix")), "")));

        partOfSpeechMap.put("v1", template.save(new PartOfSpeech("v1",
                List.of(new TranslateEntity(langRu, "глагол II-спряжение"), new TranslateEntity(langEn, "ichidan verb")), "")));

        partOfSpeechMap.put("vt", template.save(new PartOfSpeech("vt",
                List.of(new TranslateEntity(langRu, "переходный глагол"), new TranslateEntity(langEn, "transitive verb")), "")));

        partOfSpeechMap.put("n-adv", template.save(new PartOfSpeech("n-adv",
                List.of(new TranslateEntity(langRu, "отглагольное существительное"), new TranslateEntity(langEn, "adverbial noun")), "")));

        partOfSpeechMap.put("n-t", template.save(new PartOfSpeech("n-t",
                List.of(new TranslateEntity(langRu, "существительное (временное)"), new TranslateEntity(langEn, "noun (temporal)")), "")));

        partOfSpeechMap.put("vk", template.save(new PartOfSpeech("vk",
                List.of(new TranslateEntity(langRu, "специальный глагол 来る"), new TranslateEntity(langEn, "来る verb - special class")), "")));

        partOfSpeechMap.put("vs", template.save(new PartOfSpeech("vs",
                List.of(new TranslateEntity(langRu, "существительное, которое используется с する"), new TranslateEntity(langEn, "noun or participle which takes the aux. verb suru")), "")));

        partOfSpeechMap.put("ctr", template.save(new PartOfSpeech("ctr",
                List.of(new TranslateEntity(langRu, "счетчик"), new TranslateEntity(langEn, "counter")), "")));

        partOfSpeechMap.put("n-suf", template.save(new PartOfSpeech("n-suf",
                List.of(new TranslateEntity(langRu, "существительное, котором может использоваться как суффикс"), new TranslateEntity(langEn, "noun, used as a suffix")), "")));

        partOfSpeechMap.put("n-pref", template.save(new PartOfSpeech("n-pref",
                List.of(new TranslateEntity(langRu, "существительное, котором может использоваться как префикс"), new TranslateEntity(langEn, "noun, used as a prefix")), "")));

        partOfSpeechMap.put("suf", template.save(new PartOfSpeech("suf",
                List.of(new TranslateEntity(langRu, "суффикс"), new TranslateEntity(langEn, "suffix")), "")));

        partOfSpeechMap.put("exp", template.save(new PartOfSpeech("exp",
                List.of(new TranslateEntity(langRu, "выражение"), new TranslateEntity(langEn, "expressions (phrases, clauses, etc.)")), "")));

        /// part of speech for grammar

        partOfSpeechMap.put("は", template.save(new PartOfSpeech("は",
                List.of(new TranslateEntity(langRu, "частица は"), new TranslateEntity(langEn, "particle は")), "")));

        partOfSpeechMap.put("です", template.save(new PartOfSpeech("です",
                List.of(new TranslateEntity(langRu, "связка です"), new TranslateEntity(langEn, "....  です")), "")));

        partOfSpeechMap.put("じゃありません", template.save(new PartOfSpeech("じゃありません",
                List.of(new TranslateEntity(langRu, "разговорная отрицательная форма связки です")), "")));

        partOfSpeechMap.put("ではありません", template.save(new PartOfSpeech("ではありません",
                List.of(new TranslateEntity(langRu, "отрицательная форма связки です")), "")));

        partOfSpeechMap.put("か", template.save(new PartOfSpeech("か",
                List.of(new TranslateEntity(langRu, "вопросительная частица か")), "")));

        partOfSpeechMap.put("も", template.save(new PartOfSpeech("も",
                List.of(new TranslateEntity(langRu, "частица も")), "")));

        partOfSpeechMap.put("の", template.save(new PartOfSpeech("の",
                List.of(new TranslateEntity(langRu, "частица の")), "")));

        partOfSpeechMap.put("さん", template.save(new PartOfSpeech("さん",
                List.of(new TranslateEntity(langRu, "суффикс さん")), "")));

        partOfSpeechMap.put("ちゃん", template.save(new PartOfSpeech("ちゃん",
                List.of(new TranslateEntity(langRu, "суффикс ちゃん")), "")));

        partOfSpeechMap.put("これ", template.save(new PartOfSpeech("これ",
                List.of(new TranslateEntity(langRu, "предметно-указательное местоимение これ")), "")));

        partOfSpeechMap.put("それ", template.save(new PartOfSpeech("それ",
                List.of(new TranslateEntity(langRu, "предметно-указательное местоимение それ")), "")));

        partOfSpeechMap.put("あれ", template.save(new PartOfSpeech("あれ",
                List.of(new TranslateEntity(langRu, "предметно-указательное местоимение あれ")), "")));

        partOfSpeechMap.put("この", template.save(new PartOfSpeech("この",
                List.of(new TranslateEntity(langRu, "относительно-указательное местоимение この")), "")));

        partOfSpeechMap.put("その", template.save(new PartOfSpeech("その",
                List.of(new TranslateEntity(langRu, "относительно-указательное местоимение その")), "")));

        partOfSpeechMap.put("あの", template.save(new PartOfSpeech("あの",
                List.of(new TranslateEntity(langRu, "относительно-указательное местоимение あの")), "")));

        partOfSpeechMap.put("文", template.save(new PartOfSpeech("文",
                List.of(new TranslateEntity(langRu, "показатель предложения")), "")));

        partOfSpeechMap.put("、", template.save(new PartOfSpeech("、",
                List.of(new TranslateEntity(langRu, "символ запятой")), "")));

        partOfSpeechMap.put("。", template.save(new PartOfSpeech("。",
                List.of(new TranslateEntity(langRu, "символ точки")), "")));

        partOfSpeechMap.put("お", template.save(new PartOfSpeech("お",
                List.of(new TranslateEntity(langRu, "показатель вежливости, префикс к существительному")), "")));

/*
        wordTypeMap.put("", template.save(new WordType("",
                List.of(new TranslateEntity(langRu, ""), new TranslateEntity(langEn, "")), "")));
*/

    }

    @ChangeSet(order = "004", id = "initialTextbookType", author = "zdoh", runAlways = true)
    public void initTextbookType(MongoTemplate template)    {
        textbookTypeMap.put("文法", template.save(new TextbookType("文法", List.of(new TranslateEntity(langRu, "Грамматика")))));
        textbookTypeMap.put("読解", template.save(new TextbookType("読解", List.of(new TranslateEntity(langRu, "Чтение")))));
        textbookTypeMap.put("語彙", template.save(new TextbookType("語彙", List.of(new TranslateEntity(langRu, "Слова")))));
        textbookTypeMap.put("漢字", template.save(new TextbookType("漢字", List.of(new TranslateEntity(langRu, "Иероглифы")))));
        textbookTypeMap.put("聴解", template.save(new TextbookType("聴解", List.of(new TranslateEntity(langRu, "Аудирование")))));
        textbookTypeMap.put("other", template.save(new TextbookType("other", List.of(new TranslateEntity(langRu, "Другое")))));
    }

    @ChangeSet(order = "005", id = "initialWord", author = "zdoh", runAlways = true)
    public void initWord(MongoTemplate template) {
        wordsMap.put("一つ", template.save(
                new Word("一つ", "ひとつ",
                        List.of(new TranslateEntity(langRu, "один"), new TranslateEntity(langEn, "one")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("二つ", template.save(
                new Word("二つ", "ふたつ",
                        List.of(new TranslateEntity(langRu, "два"), new TranslateEntity(langEn, "two")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("三つ", template.save(
                new Word("三つ", "みつ",
                        List.of(new TranslateEntity(langRu, "три"), new TranslateEntity(langEn, "three")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("四つ", template.save(
                new Word("四つ", "よっつ",
                        List.of(new TranslateEntity(langRu, "четыре"), new TranslateEntity(langEn, "four")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("五つ", template.save(
                new Word("五つ", "いつつ",
                        List.of(new TranslateEntity(langRu, "пять"), new TranslateEntity(langEn, "five")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("六つ", template.save(
                new Word("六つ", "むっつ",
                        List.of(new TranslateEntity(langRu, "шесть"), new TranslateEntity(langEn, "six")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("七つ", template.save(
                new Word("七つ", "ななつ",
                        List.of(new TranslateEntity(langRu, "семь"), new TranslateEntity(langEn, "seven")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("八つ", template.save(
                new Word("八つ", "やっつ",
                        List.of(new TranslateEntity(langRu, "восемь"), new TranslateEntity(langEn, "eight")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("九つ", template.save(
                new Word("九つ", "ここのつ",
                        List.of(new TranslateEntity(langRu, "девять"), new TranslateEntity(langEn, "nine")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("十", template.save(
                new Word("十", "とお",
                        List.of(new TranslateEntity(langRu, "десять"), new TranslateEntity(langEn, "ten")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("一月", template.save(
                new Word("一月", "いちがつ",
                        List.of(new TranslateEntity(langRu, "январь"), new TranslateEntity(langEn, "january")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("二月", template.save(
                new Word("二月", "にがつ",
                        List.of(new TranslateEntity(langRu, "февраль"), new TranslateEntity(langEn, "february")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("三月", template.save(
                new Word("三月", "さんがつ",
                        List.of(new TranslateEntity(langRu, "март"), new TranslateEntity(langEn, "march")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("四月", template.save(
                new Word("四月", "しがつ",
                        List.of(new TranslateEntity(langRu, "апрель"), new TranslateEntity(langEn, "april")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("五月", template.save(
                new Word("五月", "ごがつ",
                        List.of(new TranslateEntity(langRu, "май"), new TranslateEntity(langEn, "may")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("六月", template.save(
                new Word("六月", "ろくがつ",
                        List.of(new TranslateEntity(langRu, "июнь"), new TranslateEntity(langEn, "june")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("七月", template.save(
                new Word("七月", "しちがつ",
                        List.of(new TranslateEntity(langRu, "июль"), new TranslateEntity(langEn, "jule")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("八月", template.save(
                new Word("八月", "はちがつ",
                        List.of(new TranslateEntity(langRu, "август"), new TranslateEntity(langEn, "august")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("九月", template.save(
                new Word("九月", "くがつ",
                        List.of(new TranslateEntity(langRu, "сентябрь"), new TranslateEntity(langEn, "september")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十月", template.save(
                new Word("十月", "じゅうがつ",
                        List.of(new TranslateEntity(langRu, "октябрь"), new TranslateEntity(langEn, "october")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十一月", template.save(
                new Word("十一月", "じゅういちがつ",
                        List.of(new TranslateEntity(langRu, "ноябрь"), new TranslateEntity(langEn, "november")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十二月", template.save(
                new Word("十二月", "じゅうにがつ",
                        List.of(new TranslateEntity(langRu, "декабрь"), new TranslateEntity(langEn, "december")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十日", template.save(
                new Word("十日", "とおか",
                        List.of(new TranslateEntity(langRu, "1) десятый день месяца 2) десять дней"), new TranslateEntity(langEn, "1) the tenth day of the month 2)  ten days")),
                        List.of(partOfSpeechMap.get("n")))));


        wordsMap.put("私", template.save(
                new Word("私", "わたし",
                        List.of(new TranslateEntity(langRu, "я"), new TranslateEntity(langEn, "i")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あなた", template.save(
                new Word("あたな", "あなた",
                        List.of(new TranslateEntity(langRu, "ты (вы)"), new TranslateEntity(langEn, "you")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あの人", template.save(
                new Word("あの人", "あのひと",
                        List.of(new TranslateEntity(langRu, "он, она"), new TranslateEntity(langEn, "he, she, that person")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あの方", template.save(
                new Word("あの方", "あのかた",
                        List.of(new TranslateEntity(langRu, "он, она (вежливее чем あの人)"), new TranslateEntity(langEn, "he, she")),
                        List.of(partOfSpeechMap.get("pn"), partOfSpeechMap.get("hon")))));

        wordsMap.put("先生", template.save(
                new Word("先生", "せんせい",
                        List.of(new TranslateEntity(langRu, "учитель, преподаватель (не употребляется о себе)"), new TranslateEntity(langEn, "teacher, master, doctor (can't use for myself)")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("hon")))));

        wordsMap.put("教師", template.save(
                new Word("教師", "きょうし",
                        List.of(new TranslateEntity(langRu, "учитель, преподаватель (употребляется о себе)"), new TranslateEntity(langEn, "teacher (can use for myself)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("学生", template.save(
                new Word("学生", "がくせい",
                        List.of(new TranslateEntity(langRu, "студент"), new TranslateEntity(langEn, "student")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("会社員", template.save(
                new Word("会社員", "かいしゃいん",
                        List.of(new TranslateEntity(langRu, "служащий фирмы"), new TranslateEntity(langEn, "company employee")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("社員", template.save(
                new Word("社員", "しゃいん",
                        List.of(new TranslateEntity(langRu, "служащий фирмы ~ (послелог указывающий на то, какой фирмы)"), new TranslateEntity(langEn, "1) company employee 2) member of a corporation; company stockholder")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("銀行員", template.save(
                new Word("銀行員", "ぎんこういん",
                        List.of(new TranslateEntity(langRu, "служащий банка"), new TranslateEntity(langEn, "bank employee; bank staff member; bank clerk")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("医者", template.save(
                new Word("医者", "いしゃ",
                        List.of(new TranslateEntity(langRu, "врач"), new TranslateEntity(langEn, "doctor; physician")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("研究者", template.save(
                new Word("研究者", "けんきゅうしゃ",
                        List.of(new TranslateEntity(langRu, "исследователь, ученый"), new TranslateEntity(langEn, "researcher")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("大学", template.save(
                new Word("大学", "だいがく",
                        List.of(new TranslateEntity(langRu, "университет"), new TranslateEntity(langEn, "university; college")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("病院", template.save(
                new Word("病院", "びょういん",
                        List.of(new TranslateEntity(langRu, "больница"), new TranslateEntity(langEn, "hospital")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("誰", template.save(
                new Word("誰", "だれ",
                        List.of(new TranslateEntity(langRu, "кто"), new TranslateEntity(langEn, "who")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("どなた", template.save(
                new Word("どなた", "どなた",
                        List.of(new TranslateEntity(langRu, "кто (вежливее чем だれ)"), new TranslateEntity(langEn, "who (respectful)")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("hon")))));

        wordsMap.put("何歳", template.save(
                new Word("何歳", "なんさい",
                        List.of(new TranslateEntity(langRu, "сколько лет?"), new TranslateEntity(langEn, "how old?; what age?")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("いくつ", template.save(
                new Word("いくつ", "いくつ",
                        List.of(new TranslateEntity(langRu, "сколько лет? (вежливый вариант 何歳)"), new TranslateEntity(langEn, "how many?; (2) how old? (respectful)")),
                        List.of(partOfSpeechMap.get("adv")))));

        wordsMap.put("はい", template.save(
                new Word("はい", "はい",
                        List.of(new TranslateEntity(langRu, "да"), new TranslateEntity(langEn, "yes")),
                        List.of(partOfSpeechMap.get("int")))));

        wordsMap.put("いいえ", template.save(
                new Word("いいえ", "いいえ",
                        List.of(new TranslateEntity(langRu, "нет"), new TranslateEntity(langEn, "no")),
                        List.of(partOfSpeechMap.get("int")))));

        wordsMap.put("国", template.save(
                new Word("国", "くに",
                        List.of(new TranslateEntity(langRu, "1) страна, государство 2) родина"), new TranslateEntity(langEn, "1) country, state 2) region 3) national government, central government; (4) home")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("言葉", template.save(
                new Word("言葉", "ことば",
                        List.of(new TranslateEntity(langRu, "1) слово; слова 2) язык 3) диалект"), new TranslateEntity(langEn, "1) language, dialect 2) word, words, phrase, term, expression, remark 3) speech")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("アメリカ", template.save(
                new Word("アメリカ", "アメリカ",
                        List.of(new TranslateEntity(langRu, "сша"), new TranslateEntity(langEn, "1) America 2) United States of America")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("イギリス", template.save(
                new Word("イギリス", "イギリス",
                        List.of(new TranslateEntity(langRu, "Англия"), new TranslateEntity(langEn, "1) United Kingdom, Britain, Great Britain 2) England")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("イタリア", template.save(
                new Word("イタリア", "イタリア",
                        List.of(new TranslateEntity(langRu, "Италия"), new TranslateEntity(langEn, "Italy")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("イラン", template.save(
                new Word("イラン", "イラン",
                        List.of(new TranslateEntity(langRu, "Иран"), new TranslateEntity(langEn, "Iran")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("韓国", template.save(
                new Word("韓国", "かんこく",
                        List.of(new TranslateEntity(langRu, "Корея (южная)"), new TranslateEntity(langEn, "South Korea, Republic of Korea")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("スペイン", template.save(
                new Word("スペイン", "スペイン",
                        List.of(new TranslateEntity(langRu, "Испания"), new TranslateEntity(langEn, "Spain")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ドイツ", template.save(
                new Word("ドイツ", "ドイツ",
                        List.of(new TranslateEntity(langRu, "Германия"), new TranslateEntity(langEn, "Germany")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日本", template.save(
                new Word("日本", "にほん",
                        List.of(new TranslateEntity(langRu, "Япония"), new TranslateEntity(langEn, "Japan")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ロシア", template.save(
                new Word("ロシア", "ロシア",
                        List.of(new TranslateEntity(langRu, "Россия"), new TranslateEntity(langEn, "Russia")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("中国", template.save(
                new Word("中国", "ちゅうごく",
                        List.of(new TranslateEntity(langRu, "Китай"), new TranslateEntity(langEn, "China")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("アメリカ人", template.save(
                new Word("アメリカ人", "アメリカじん",
                        List.of(new TranslateEntity(langRu, "американец"), new TranslateEntity(langEn, "American person")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("韓国人", template.save(
                new Word("韓国人", "かんこくじん",
                        List.of(new TranslateEntity(langRu, "кореец"), new TranslateEntity(langEn, "South Korean person")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("中国人", template.save(
                new Word("中国人", "ちゅうごくじん",
                        List.of(new TranslateEntity(langRu, "китаец"), new TranslateEntity(langEn, "Chinese person")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日本人", template.save(
                new Word("日本人", "にほんじん",
                        List.of(new TranslateEntity(langRu, "японец"), new TranslateEntity(langEn, "Japanese person, Japanese people")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ロシア人", template.save(
                new Word("ロシア人", "ロシアじん",
                        List.of(new TranslateEntity(langRu, "русский"), new TranslateEntity(langEn, "Russian (person, people)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("英語", template.save(
                new Word("英語", "えいご",
                        List.of(new TranslateEntity(langRu, "английский язык"), new TranslateEntity(langEn, "English (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("韓国語", template.save(
                new Word("韓国語", "かんこくご",
                        List.of(new TranslateEntity(langRu, "корейский язык"), new TranslateEntity(langEn, "Korean (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日本語", template.save(
                new Word("日本語", "にほんご",
                        List.of(new TranslateEntity(langRu, "японский язык"), new TranslateEntity(langEn, "Japanese (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ロシア語", template.save(
                new Word("ロシア語", "ロシアご",
                        List.of(new TranslateEntity(langRu, "русский язык"), new TranslateEntity(langEn, "Russian (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("本", template.save(
                new Word("本", "ほん",
                        List.of(new TranslateEntity(langRu, "книга"), new TranslateEntity(langEn, "book")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("辞書", template.save(
                new Word("辞書", "じしょ",
                        List.of(new TranslateEntity(langRu, "фонетический словарь"), new TranslateEntity(langEn, "dictionary, lexicon")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("雑誌", template.save(
                new Word("雑誌", "ざっし",
                        List.of(new TranslateEntity(langRu, "журнал"), new TranslateEntity(langEn, "journal, magazine, periodical")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("新聞", template.save(
                new Word("新聞", "しんぶん",
                        List.of(new TranslateEntity(langRu, "газета"), new TranslateEntity(langEn, "newspaper")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ノート", template.save(
                new Word("ノート", "ノート",
                        List.of(new TranslateEntity(langRu, "1) записная книжка, блокнот 2) записки, записи 3) ноутбук"), new TranslateEntity(langEn, "notebook, copy-book, exercise book")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("手帳", template.save(
                new Word("手帳", "てちょう",
                        List.of(new TranslateEntity(langRu, "тетрадь; записная книжка, блокнот"), new TranslateEntity(langEn, "notebook; memo pad")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("名刺", template.save(
                new Word("名刺", "めいし",
                        List.of(new TranslateEntity(langRu, "визитная карточка"), new TranslateEntity(langEn, "business card")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("カード", template.save(
                new Word("カード", "カード",
                        List.of(new TranslateEntity(langRu, "1) карточка 2) кредитная карточка"), new TranslateEntity(langEn, "card")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("鉛筆", template.save(
                new Word("鉛筆", "えんぴつ",
                        List.of(new TranslateEntity(langRu, "карандаш"), new TranslateEntity(langEn, "pencil")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ボールペン", template.save(
                new Word("ボールペン", "ボールペン",
                        List.of(new TranslateEntity(langRu, "шариковая ручка"), new TranslateEntity(langEn, "ball-point pen")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("シャープペンシル", template.save(
                new Word("シャープペンシル", "シャープペンシル",
                        List.of(new TranslateEntity(langRu, "механический карандаш"), new TranslateEntity(langEn, "propelling pencil, mechanical pencil")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("鍵", template.save(
                new Word("鍵", "かぎ",
                        List.of(new TranslateEntity(langRu, "ключ"), new TranslateEntity(langEn, "key")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("時計", template.save(
                new Word("時計", "とけい",
                        List.of(new TranslateEntity(langRu, "часы"), new TranslateEntity(langEn, "watch, clock, timepiece")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("傘", template.save(
                new Word("傘", "かさ",
                        List.of(new TranslateEntity(langRu, "зонт, зонтик"), new TranslateEntity(langEn, "umbrella, parasol")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("かばん", template.save(
                new Word("かばん", "かばん",
                        List.of(new TranslateEntity(langRu, "саквояж, чемодан; портфель"), new TranslateEntity(langEn, "bag, satchel, briefcase, basket")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("テレビ", template.save(
                new Word("テレビ", "テレビ",
                        List.of(new TranslateEntity(langRu, "1) телевидение 2) телевизор"), new TranslateEntity(langEn, "1) television, TV 2) TV program, TV programme, TV broadcast")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("カメラ", template.save(
                new Word("カメラ", "カメラ",
                        List.of(new TranslateEntity(langRu, "1) фотоаппарат, кинокамера 2) камера фотоаппарата"), new TranslateEntity(langEn, "camera")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("コンピューター", template.save(
                new Word("コンピューター", "コンピューター",
                        List.of(new TranslateEntity(langRu, "компьютер"), new TranslateEntity(langEn, "computer")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("車", template.save(
                new Word("車", "くるま",
                        List.of(new TranslateEntity(langRu, "1) машина, повозка 2) колесо"), new TranslateEntity(langEn, "1) car, automobile, vehicle, 2) wheel")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("机", template.save(
                new Word("机", "つくえ",
                        List.of(new TranslateEntity(langRu, "стол, парта"), new TranslateEntity(langEn, "desk")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("椅子", template.save(
                new Word("椅子", "いす",
                        List.of(new TranslateEntity(langRu, "стул"), new TranslateEntity(langEn, "1) chair, stool 2) post, office, position")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("チョコレート", template.save(
                new Word("チョコレート歳", "チョコレート",
                        List.of(new TranslateEntity(langRu, "шоколад"), new TranslateEntity(langEn, "chocolate")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("コーヒー", template.save(
                new Word("コーヒー", "コーヒー",
                        List.of(new TranslateEntity(langRu, "кофе"), new TranslateEntity(langEn, "coffee")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("土産", template.save(
                new Word("土産", "みやげ",
                        List.of(new TranslateEntity(langRu, "подарок, гостинец; сувенир"), new TranslateEntity(langEn, "present, souvenir")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("何", template.save(
                new Word("何", "なん",
                        List.of(new TranslateEntity(langRu, "что"), new TranslateEntity(langEn, "what?")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("これ", template.save(
                new Word("これ", "これ",
                        List.of(new TranslateEntity(langRu, "это (о предмете, более близком к говорящему)"), new TranslateEntity(langEn, "this (indicating an item near the speaker, the action of the speaker, or the current topic)")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("それ", template.save(
                new Word("それ", "それ",
                        List.of(new TranslateEntity(langRu, "то (о предмете, более близком к говорящему)"), new TranslateEntity(langEn, "that (indicating an item or person near the listener, the action of the listener, or something on their mind)")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あれ", template.save(
                new Word("あれ", "あれ",
                        List.of(new TranslateEntity(langRu, "то (о предмете, равноудаленном к собеседникам)"), new TranslateEntity(langEn, "1) that (indicating something distant from both speaker and listener (in space, time or psychologically), or something understood without naming it directly)")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("名", template.save(
                new Word("名", "な",
                        List.of(new TranslateEntity(langRu, "1) имя, название, наименование 2) имя, репутация, честь 3) имя, известность"), new TranslateEntity(langEn, "1) name, given name 2) title 3) fame, renown, reputation")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("有名", template.save(
                new Word("有名", "ゆうめい",
                        List.of(new TranslateEntity(langRu, "знаменитый, известный"), new TranslateEntity(langEn, "how old?; what age?")),
                        List.of(partOfSpeechMap.get("adj-na")))));

        wordsMap.put("方法", template.save(
                new Word("方法", "ほうほう",
                        List.of(new TranslateEntity(langRu, "1) способ, метод; средство, мера 2) план, программа"), new TranslateEntity(langEn, "method; process; manner; way; means; technique")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("方", template.save(
                new Word("方", "ほう",
                        List.of(new TranslateEntity(langRu, "направление; сторона"), new TranslateEntity(langEn, "direction, way, side, area (in a particular direction)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("人", template.save(
                new Word("人", "ひと",
                        List.of(new TranslateEntity(langRu, "1) человек, люди 2) личность, характер"), new TranslateEntity(langEn, "1) man; person 2) human being, mankind, people")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日", template.save(
                new Word("日", "ひ",
                        List.of(new TranslateEntity(langRu, "1) день"), new TranslateEntity(langEn, "1) day, days 2) sun, sunshine, sunlight")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("毎日", template.save(
                new Word("毎日", "まいにち",
                        List.of(new TranslateEntity(langRu, "каждый день, ежедневно, день за днём, изо дня в день"), new TranslateEntity(langEn, "every day")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("大きい", template.save(
                new Word("大きい", "おおきい",
                        List.of(new TranslateEntity(langRu, "большой, крупный"), new TranslateEntity(langEn, "1) big, large, great 2) loud 3) extensive, spacious")),
                        List.of(partOfSpeechMap.get("adj-i")))));

        wordsMap.put("大いに", template.save(
                new Word("大いに", "おおいに",
                        List.of(new TranslateEntity(langRu, "очень, весьма, в высшей степени"), new TranslateEntity(langEn, "very; much; greatly; a lot of")),
                        List.of(partOfSpeechMap.get("adv")))));

        wordsMap.put("学ぶ", template.save(
                new Word("学ぶ", "まなぶ",
                        List.of(new TranslateEntity(langRu, "учиться чему-л., изучать что-л.; обучаться"), new TranslateEntity(langEn, "to study (in depth), to learn, to take lessons in")),
                        List.of(partOfSpeechMap.get("v"), partOfSpeechMap.get("v5b")))));

        wordsMap.put("社", template.save(
                new Word("社", "やしろ",
                        List.of(new TranslateEntity(langRu, "[синтоистский] храм"), new TranslateEntity(langEn, "shrine (usually Shinto)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("会う", template.save(
                new Word("会う", "あう",
                        List.of(new TranslateEntity(langRu, "1) (に) [по]встречаться с кем-л.; видеться с кем-л. 2) встретить что-л.; перенести, испытать что-л."), new TranslateEntity(langEn, "1) to meet, to encounter, to see 2) to have an accident, to have a bad experience")),
                        List.of(partOfSpeechMap.get("v"), partOfSpeechMap.get("v5u"), partOfSpeechMap.get("vi")))));

        wordsMap.put("会社", template.save(
                new Word("会社", "かいしゃ",
                        List.of(new TranslateEntity(langRu, "компания, общество, фирма"), new TranslateEntity(langEn, "1) company, corporation 2) workplace")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("先", template.save(
                new Word("先", "さき",
                        List.of(new TranslateEntity(langRu, "1) первенство 2) раньше, прежде 3) заранее; до того как 4) дальше, далее; впереди чего-л.; в сторону от чего-л."), new TranslateEntity(langEn, "1) previous, prior, former, first, earlier, some time ago, preceding 2) point (e.g. pencil), tip, end, nozzle 3) head (of a line), front")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("prefix")))));

        wordsMap.put("生きる", template.save(
                new Word("生きる", "いきる",
                        List.of(new TranslateEntity(langRu, "1) жить, быть живым 2) (жарг.) восстанавливать зачёркнутое (в корректуре)"), new TranslateEntity(langEn, "1) to live, to exist 2) to make a living, to subsist 3) to be in effect, to be in use, to function 4) to come to life, to be enlivened 5) to be safe (in baseball, go, etc.)")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("生かす", template.save(
                new Word("生かす", "いかす",
                        List.of(new TranslateEntity(langRu, "1) оживлять, воскрешать; обр. оживить; вдохнуть жизнь во что-л. 2) оставлять в живых; сохранять в живом виде"), new TranslateEntity(langEn, "1) to make (the best) use of, to put to good use, to leverage (skills, attributes, experience, etc.), to capitalise on (experience, etc.) 2) to let live, to keep alive 3) to revive, to resuscitate, to bring back to life 4) to restore (a deleted passage; in proofreading)")),
                        List.of(partOfSpeechMap.get("v5s"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生ける", template.save(
                new Word("生ける", "いける",
                        List.of(new TranslateEntity(langRu, "живой"), new TranslateEntity(langEn, "1) to arrange (flowers), to plant 2) living, live")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生まれる", template.save(
                new Word("生まれる", "うまれる",
                        List.of(new TranslateEntity(langRu, "родиться, появиться на свет"), new TranslateEntity(langEn, "to be born")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("生む", template.save(
                new Word("生む", "うむ",
                        List.of(new TranslateEntity(langRu, "1) рождать, рожать, производить на свет; плодиться 2) порождать, приносить"), new TranslateEntity(langEn, "1) to give birth, to bear (child), to lay (eggs) 2) to produce, to yield, to give rise to, to deliver")),
                        List.of(partOfSpeechMap.get("v5m"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生える", template.save(
                new Word("生える", "はえる",
                        List.of(new TranslateEntity(langRu, "1) расти (о растениях) 2) расти (о волосах, ногтях, тж. о крыльях у птиц); прорезаться (о зубах)"), new TranslateEntity(langEn, "1) to grow, to spring up, to sprout 2) to cut (teeth)")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("生やす", template.save(
                new Word("生やす", "はやす",
                        List.of(new TranslateEntity(langRu, "отращивать, отпускать (бороду, усы)"), new TranslateEntity(langEn, "to grow; to cultivate; to wear a beard")),
                        List.of(partOfSpeechMap.get("v5s"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生", template.save(
                new Word("生", "なま",
                        List.of(new TranslateEntity(langRu, "1) сырой 2) (перен.) необработанный, полусырой, неспелый, зелёный"), new TranslateEntity(langEn, "1) raw, uncooked, fresh 2) natural, as it is, unedited, unprocessed 3) (col) unprotected (sex) 4) live (i.e. not recorded) 5) inexperienced, unpolished, green, crude")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("銀行", template.save(
                new Word("銀行", "ぎんこう",
                        List.of(new TranslateEntity(langRu, "банк"), new TranslateEntity(langEn, "bank")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("行く", template.save(
                new Word("行く", "いく, ゆく",
                        List.of(new TranslateEntity(langRu, "1) идти, ходить (о ком-л.) 2) идти, ехать, направляться, следовать куда-л. (о ком-л.; тж. о поезде, пароходе и т. п.); вести куда-л. (о дороге) 3) [по]бывать где-л. "), new TranslateEntity(langEn, "1) to go, to move, to head (towards), to be transported (towards), to reach 2) to proceed, to take place 3) to pass through, to come and go 4) to walk")),
                        List.of(partOfSpeechMap.get("vi"), partOfSpeechMap.get("v5k-s"), partOfSpeechMap.get("v")))));

        wordsMap.put("行う", template.save(
                new Word("行う", "おこなう",
                        List.of(new TranslateEntity(langRu, "1) делать, совершать, производить 2) выполнять, осуществлять, проводить [в жизнь]"), new TranslateEntity(langEn, "to perform; to do; to conduct oneself; to carry out")),
                        List.of(partOfSpeechMap.get("v5u"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("来年", template.save(
                new Word("来年", "らいねん",
                        List.of(new TranslateEntity(langRu, "будущий (следующий) год"), new TranslateEntity(langEn, "next year")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("来る", template.save(
                new Word("来る", "くる",
                        List.of(new TranslateEntity(langRu, "1) приходить, прибывать; приезжать; приходить в гости 2) приходить, наступать (о чём-л.) 3) происходить, проистекать (из чего-л.)"), new TranslateEntity(langEn, "1) to come (spatially or temporally); to approach; to arrive; (vk,vi,aux-v) (2) (See 行って来る) to come back; to do ... and come back; (3) to come to be; to become; to get; to grow; to continue")),
                        List.of(partOfSpeechMap.get("vk"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("電車", template.save(
                new Word("電車", "でんしゃ",
                        List.of(new TranslateEntity(langRu, "трамвай"), new TranslateEntity(langEn, "train; electric train")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("二十歳", template.save(
                new Word("二十歳", "はたち",
                        List.of(new TranslateEntity(langRu, "двадцатилетний возраст; двадцать лет [от роду]"), new TranslateEntity(langEn, "1) 20 years old")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("失礼", template.save(
                new Word("失礼", "しつれい",
                        List.of(new TranslateEntity(langRu, "1) невежливость, грубость 2) (при извинении)"), new TranslateEntity(langEn, "1) discourtesy; impoliteness 2) excuse me; goodbye 3) to leave 4) to be rude")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("vs"), partOfSpeechMap.get("adj-na")))));

        wordsMap.put("木", template.save(
                new Word("木", "き",
                        List.of(new TranslateEntity(langRu, "1) дерево, деревцо 2) дерево, лес (как материал)"), new TranslateEntity(langEn, "wood (first of the five elements)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("月曜日", template.save(
                new Word("月曜日", "げつようび",
                        List.of(new TranslateEntity(langRu, "понедельник"), new TranslateEntity(langEn, "Monday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("火曜日", template.save(
                new Word("火曜日", "かようび",
                        List.of(new TranslateEntity(langRu, "вторник"), new TranslateEntity(langEn, "Tuesday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("水曜日", template.save(
                new Word("水曜日", "すいようび",
                        List.of(new TranslateEntity(langRu, "среда"), new TranslateEntity(langEn, "Wednesday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("木曜日", template.save(
                new Word("木曜日", "もくようび",
                        List.of(new TranslateEntity(langRu, "четверг"), new TranslateEntity(langEn, "Thursday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("金曜日", template.save(
                new Word("金曜日", "きんようび",
                        List.of(new TranslateEntity(langRu, "пятница"), new TranslateEntity(langEn, "Friday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("土曜日", template.save(
                new Word("土曜日", "どようび",
                        List.of(new TranslateEntity(langRu, "суббота"), new TranslateEntity(langEn, "Saturday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("日曜日", template.save(
                new Word("日曜日", "にちようび",
                        List.of(new TranslateEntity(langRu, "воскресенье"), new TranslateEntity(langEn, "Sunday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("月", template.save(
                new Word("月", "つき",
                        List.of(new TranslateEntity(langRu, "1) луна, месяц 2) месяц (календарный)"), new TranslateEntity(langEn, "1) moon 2) month")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("三日", template.save(
                new Word("", "",
                        List.of(new TranslateEntity(langRu, "1) третье [число] 2) три дня"), new TranslateEntity(langEn, "1) the third day of the month 2) three days")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("山", template.save(
                new Word("山", "やま",
                        List.of(new TranslateEntity(langRu, "1) гора 2) лес 3) (тж. 鉱山) рудник"), new TranslateEntity(langEn, "1) mountain; hill 2) mine (e.g. coal mine) 3) heap; pile")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("ctr")))));

        wordsMap.put("火山", template.save(
                new Word("火山", "かざん",
                        List.of(new TranslateEntity(langRu, "вулкан"), new TranslateEntity(langEn, "volcano")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("富士山", template.save(
                new Word("富士山", "ふじさん",
                        List.of(new TranslateEntity(langRu, "гора Фудзи"), new TranslateEntity(langEn, "Mount Fuji; Mt. Fuji; Fujiyama; Fuji-san")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("川", template.save(
                new Word("川", "かわ",
                        List.of(new TranslateEntity(langRu, "река"), new TranslateEntity(langEn, "1) river; stream; (suf) 2) (suffix used with the names of rivers) River; the ... river")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("suf")))));

        wordsMap.put("河川", template.save(
                new Word("河川", "かせん",
                        List.of(new TranslateEntity(langRu, "реки"), new TranslateEntity(langEn, "rivers")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("田", template.save(
                new Word("田", "た",
                        List.of(new TranslateEntity(langRu, "[заболоченное] рисовое поле"), new TranslateEntity(langEn, "rice field")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("田んぼ", template.save(
                new Word("田んぼ", "たんぼ",
                        List.of(new TranslateEntity(langRu, "рисовое поле"), new TranslateEntity(langEn, "paddy field; farm")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("水田", template.save(
                new Word("水田", "すいでん",
                        List.of(new TranslateEntity(langRu, "заливное [рисовое] поле"), new TranslateEntity(langEn, "(water-filled) paddy field")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("三人", template.save(
                new Word("三人", "さんにん",
                        List.of(new TranslateEntity(langRu, "три человека"), new TranslateEntity(langEn, "three people")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("口", template.save(
                new Word("口", "くち",
                        List.of(new TranslateEntity(langRu, "1) рот; уста, губы 2) язык, речь; слова 3) вкус 4) вход, выход; ход куда-л.; место начала подъёма (на гору)"), new TranslateEntity(langEn, "1) mouth; (2) opening; hole; gap; orifice; (3) mouth (of a bottle); spout; nozzle; mouthpiece; (4) gate; door; entrance; exit")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("出口", template.save(
                new Word("出口", "でぐち",
                        List.of(new TranslateEntity(langRu, "1) выход 2) выпускное (выходное) отверстие"), new TranslateEntity(langEn, "exit; gateway; way out; outlet; leak; vent")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("入り口", template.save(
                new Word("入り口", "いりぐち",
                        List.of(new TranslateEntity(langRu, "вход"), new TranslateEntity(langEn, "entrance; entry; gate; approach; mouth")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("人口", template.save(
                new Word("人口", "じんこう",
                        List.of(new TranslateEntity(langRu, "население, численность населения; число жителей; численность людского состава"), new TranslateEntity(langEn, "1) population 2) common talk")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("自動車", template.save(
                new Word("自動車", "じどうしゃ",
                        List.of(new TranslateEntity(langRu, "автомобиль, [авто]машина"), new TranslateEntity(langEn, "automobile")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("門", template.save(
                new Word("門", "かど",
                        List.of(new TranslateEntity(langRu, "1) ворота 2) научная школа; школа (научное направление) какого-л. учёного 3) раздел, разряд"), new TranslateEntity(langEn, "gate")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-suf")))));

        wordsMap.put("専門", template.save(
                new Word("専門", "せんもん",
                        List.of(new TranslateEntity(langRu, "специальность"), new TranslateEntity(langEn, "speciality; specialty; subject of study; expert; area of expertise")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("火", template.save(
                new Word("火", "ひ",
                        List.of(new TranslateEntity(langRu, "1) огонь, пламя 2) пожар"), new TranslateEntity(langEn, "fire; flame; blaze")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-suf")))));

        wordsMap.put("水", template.save(
                new Word("水", "みず",
                        List.of(new TranslateEntity(langRu, "1) вода; холодная вода 2) жидкость"), new TranslateEntity(langEn, "1) water (esp. cool, fresh water, e.g. drinking water); (2) fluid (esp. in an animal tissue); liquid; (3) flood; floodwaters")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("金", template.save(
                new Word("金", "かね",
                        List.of(new TranslateEntity(langRu, "1) металл 2) деньги"), new TranslateEntity(langEn, "1) (See お金) money 2) metal")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("土", template.save(
                new Word("土", "つち",
                        List.of(new TranslateEntity(langRu, "земля"), new TranslateEntity(langEn, "1) earth; soil; dirt; clay; mud; (2) the earth (historically, esp. as opposed to the heavens); the ground; the land")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("土木", template.save(
                new Word("土木", "どぼく",
                        List.of(new TranslateEntity(langRu, "инженерные (строительные) работы"), new TranslateEntity(langEn, "engineering works; civil engineering; public works")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("子", template.save(
                new Word("子", "こ",
                        List.of(new TranslateEntity(langRu, "1) ребёнок, дитя 2) детёныш"), new TranslateEntity(langEn, "1) child (2) young (animal)")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-suf")))));

        wordsMap.put("子供", template.save(
                new Word("子供", "こども",
                        List.of(new TranslateEntity(langRu, "ребёнок, дитя; сын; дочь; дети"), new TranslateEntity(langEn, "child")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女子学生", template.save(
                new Word("女子学生", "じょしがくせい",
                        List.of(new TranslateEntity(langRu, "студентка"), new TranslateEntity(langEn, "female student")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女の子", template.save(
                new Word("女の子", "おんなのこ",
                        List.of(new TranslateEntity(langRu, "девочка"), new TranslateEntity(langEn, "girl")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女子", template.save(
                new Word("女子", "じょし",
                        List.of(new TranslateEntity(langRu, "женщина, девушка"), new TranslateEntity(langEn, "woman; girl")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女", template.save(
                new Word("女", "おんな",
                        List.of(new TranslateEntity(langRu, "женщина"), new TranslateEntity(langEn, "1) female; woman; female sex; (n) (2) female lover; girlfriend; mistress; (someone's) woman")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-pref")))));

        wordsMap.put("女の人", template.save(
                new Word("女の人", "おんなのひと",
                        List.of(new TranslateEntity(langRu, "женщина"), new TranslateEntity(langEn, "woman")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("exp")))));

        wordsMap.put("彼女", template.save(
                new Word("彼女", "かのじょ",
                        List.of(new TranslateEntity(langRu, "она"), new TranslateEntity(langEn, "1) she; her 2) girlfriend")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("学校", template.save(
                new Word("学校", "がっこう",
                        List.of(new TranslateEntity(langRu, "1) школа, училище; учебное заведение 2) (перен.) занятия (в учебном заведении)"), new TranslateEntity(langEn, "school")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("先月", template.save(
                new Word("先月", "せんげつ",
                        List.of(new TranslateEntity(langRu, "прошлый месяц"), new TranslateEntity(langEn, "last month")),
                        List.of(partOfSpeechMap.get("n-t"), partOfSpeechMap.get("n-adv")))));

        wordsMap.put("私立大学", template.save(
                new Word("私立大学", "しりつだいがく",
                        List.of(new TranslateEntity(langRu, "частный колледж (университет)"), new TranslateEntity(langEn, "private university")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("私立", template.save(
                new Word("私立", "しりつ",
                        List.of(new TranslateEntity(langRu, "частный (содержащийся на частные средства)"), new TranslateEntity(langEn, "private (establishment)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("火事", template.save(
                new Word("火事", "かじ",
                        List.of(new TranslateEntity(langRu, "пожар"), new TranslateEntity(langEn, "fire; conflagration")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("生年月日", template.save(
                new Word("生年月日", "せいねんがっぴ",
                        List.of(new TranslateEntity(langRu, "дата рождения"), new TranslateEntity(langEn, "birth date; date of birth")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("違う", template.save(
                new Word("違う", "ちがう",
                        List.of(new TranslateEntity(langRu, "1) отличаться от чего-л., расходиться с чем-л. 2) нарушать что-л., идти против чего-л."), new TranslateEntity(langEn, "1) to differ (from); to vary 2) to not be in the usual condition 3) to not match the correct")),
                        List.of(partOfSpeechMap.get("v5u"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("神戸", template.save(
                new Word("神戸", "こうべ",
                        List.of(new TranslateEntity(langRu, "г. Кобэ"), new TranslateEntity(langEn, "Kobe (city)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("そう", template.save(
                new Word("そう", "そう",
                        List.of(new TranslateEntity(langRu, "так"), new TranslateEntity(langEn, "1) so; really; seeming; (adj-na,suf) 2) (after masu stem or adj-stem) appearing that; seeming that; looking like; having the appearance of")),
                        List.of(partOfSpeechMap.get("adv")))));




/*
        wordsMap.put("", template.save(
                new Word("", "",
                        List.of(new TranslateEntity(langRu, ""), new TranslateEntity(langEn, "")),
                        List.of(partOfSpeechMap.get("")))));
*/


    }

    @ChangeSet(order = "006", id = "initialKunyomiWord", author = "zdoh", runAlways = true)
    public void initialKunyomiWord(MongoTemplate template) {
        wordsMap.put("ひと", template.save(new Word("ひと", true)));
        wordsMap.put("ふた", template.save(new Word("ふた", true)));
        wordsMap.put("み", template.save(new Word("み", true)));
        wordsMap.put("みっ", template.save(new Word("みっ", true)));
        wordsMap.put("よ", template.save(new Word("よ", true)));
        wordsMap.put("よつ", template.save(new Word("よつっ", true)));
        wordsMap.put("よん", template.save(new Word("よん", true)));
        wordsMap.put("いつ", template.save(new Word("いつ", true)));
        wordsMap.put("むつ", template.save(new Word("むつ", true)));
        wordsMap.put("むい", template.save(new Word("むい", true)));
        wordsMap.put("なな", template.save(new Word("なな", true)));
        wordsMap.put("なの", template.save(new Word("なの", true)));
        wordsMap.put("や", template.save(new Word("や", true)));
        wordsMap.put("やつ", template.save(new Word("やつ", true)));
        wordsMap.put("よう", template.save(new Word("よう", true)));
        wordsMap.put("ここの", template.save(new Word("ここの", true)));
        wordsMap.put("と", template.save(new Word("と", true)));
        wordsMap.put("かた", template.save(new Word("かた", true)));
        wordsMap.put("もと", template.save(new Word("もと", true)));
        wordsMap.put("か", template.save(new Word("か", true)));
        wordsMap.put("おお", template.save(new Word("おお", true)));
        wordsMap.put("こ", template.save(new Word("こ", true)));
        wordsMap.put("ほ", template.save(new Word("ほ", true)));


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
                        List.of("ホン"), List.of(wordsMap.get("もと")), wordsMap.get("日本"))));

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
        grammarMap.put("nは", template.save(new Grammar("nは",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(langRu, "Частица 「は」 указывает, что перед ней стоит существительное, является темой высказывания.")))));

        grammarMap.put("nです", template.save(new Grammar("nです",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("です")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(langRu, "Существительное, оформленное связной 「です」, является именным сказуемым. " +
                        "です указывает на суждения или утверждение. " +
                        "です выражает нейтрально-вежливый стиль речи говорящего по отношению к собеседнику." +
                        "です изменяется в отрицательных предложениях и в прошедшем времени.")))));

        grammarMap.put("nじゃありません", template.save(new Grammar("nじゃありません",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("じゃありません")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(langRu, "じゃありません является разговорной отрицательной версией 「です」.")))));

        grammarMap.put("nではありません", template.save(new Grammar("nではありません",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("ではありません")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(langRu, "ではありません　является отрицательной версией 「です」. " +
                        "Используется в нейтрально-вежливом или информационном стиле, а также в письменной речи.")))));

        grammarMap.put("nですか", template.save(new Grammar("nですか",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("です"), partOfSpeechMap.get("か")), partOfSpeechMap.get("文"),
                List.of(new TranslateEntity(langRu, "Частица か указывает на сомнение, вопрос и тд говорящего. " +
                        "Вопросительное предложение образуется путем добавление частицы 「か」 в конец предложения.")))));

        grammarMap.put("nも", template.save(new Grammar("nも",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("も")),
                List.of(new TranslateEntity(langRu, "Вместо тематической частицы 「は」 употребляется частица 「も」, " +
                        "если утверждается то же самое, что и по поводу предыдущей темы")))));

        grammarMap.put("nのn", template.save(new Grammar("nのn",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("の"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(langRu, "Частица 「の」 служит для связи двух существительных, если второе существительное" +
                        "является определениек к первому существительному. Например 'моя книга'")))));

        grammarMap.put("nの", template.save(new Grammar("nの",
                List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("の"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(langRu, "В конструкции 「nのn」, в случае если из контекста понятно о каком втором существительном " +
                        "идет речь, то второе существительное может опускаться. Например 「この本は私のです」")))));

        grammarMap.put("これは", template.save(new Grammar("これは",
                List.of(partOfSpeechMap.get("これ"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(langRu, "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                        "грамматически функционируют иак же, как и имена существительные. これ указывает на предмет, более близкий к говорящему.")))));

        grammarMap.put("それは", template.save(new Grammar("それは",
                List.of(partOfSpeechMap.get("それ"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(langRu, "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                        "грамматически функционируют иак же, как и имена существительные. それ указывает на предмет, более близкий к собеседнику.")))));

        grammarMap.put("あれは", template.save(new Grammar("あれは",
                List.of(partOfSpeechMap.get("それ"), partOfSpeechMap.get("は")),
                List.of(new TranslateEntity(langRu, "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                        "грамматически функционируют иак же, как и имена существительные. あれ указывает на предмет, равноудаленный от собеседников.")))));

        grammarMap.put("このn", template.save(new Grammar("このn",
                List.of(partOfSpeechMap.get("この"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(langRu, "Относительно-указательное местоимение 「この」 определяет существительное и используется " +
                        "с ним. 「このn」 указывает на предмет, более близкий к говорящему.")))));

        grammarMap.put("そのn", template.save(new Grammar("そのn",
                List.of(partOfSpeechMap.get("その"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(langRu, "Относительно-указательное местоимение 「その」 определяет существительное и используется " +
                        "с ним. 「そのn」 указывает на предмет, более близкий к собеседнику.")))));

        grammarMap.put("あのn", template.save(new Grammar("あのn",
                List.of(partOfSpeechMap.get("あの"), partOfSpeechMap.get("n")),
                List.of(new TranslateEntity(langRu, "Относительно-указательное местоимение 「あの」 определяет существительное и используется " +
                        "с ним. 「あのn」 указывает на предмет, равноудаленный от говорящих.")))));

        grammarMap.put("文か、文か", template.save(new Grammar("文か、文か",
                List.of(partOfSpeechMap.get("文"), partOfSpeechMap.get("か"), partOfSpeechMap.get("、"), partOfSpeechMap.get("文"), partOfSpeechMap.get("か")),
                List.of(new TranslateEntity(langRu, "Альтернативный вопрос, при ответе на который требуется выбрать правильное утверждение " +
                        "из двух (или более) предложенных. Ответом является повторение правильного утверждения без добавления 「はい」 или 「いいえ」")))));


/*
        grammarMap.put("", template.save(new Grammar(
                List.of(partOfSpeechMap.get(""), partOfSpeechMap.get("")),
                List.of(new TranslateEntity(langRu, "")))));
*/

    }

    @ChangeSet(order = "009", id = "initialTextbookSeries", author = "zdoh", runAlways = true)
    public void initTextbookSeries(MongoTemplate template) {
        textbookSeriesMap.put(MINNA_S, template.save(
                new TextbookSeries("みんなの日本語", MINNA_S)));

        textbookSeriesMap.put(BASIC_KANJI_BOOK_S, template.save(
                new TextbookSeries(BASIC_KANJI_BOOK_S, BASIC_KANJI_BOOK_S)));

    }

    @ChangeSet(order = "010", id = "initialTextbook", author = "zdoh", runAlways = true)
    public void initTextbook(MongoTemplate template) {
        textbookMap.put(MINNA_GR_1, template.save(
                new Textbook("みんなの日本語初級I文法", MINNA_GR_1, textbookSeriesMap.get(MINNA_S), true,
                        List.of(textbookTypeMap.get("文法"), textbookTypeMap.get("語彙")))));

        textbookMap.put(MINNA_KANJI_1, template.save(
                new Textbook("みんなの日本語初級I漢字", MINNA_KANJI_1, textbookSeriesMap.get(MINNA_S), true,
                        List.of(textbookTypeMap.get("漢字"), textbookTypeMap.get("語彙")))));

        textbookMap.put(BASIC_KANJI_BOOK_1, template.save(
                new Textbook("Basic kanji book", BASIC_KANJI_BOOK_1, textbookSeriesMap.get(BASIC_KANJI_BOOK_S), true,
                        List.of(textbookTypeMap.get("漢字"), textbookTypeMap.get("語彙")))));

    }

    @ChangeSet(order = "011", id = "initialLesson", author = "zdoh", runAlways = true)
    public void initLesson(MongoTemplate template) {
        Textbook textbook = textbookMap.get(MINNA_GR_1);
        textbook.getLessonList().add(new Lesson("Lesson 1"));
        textbook.getLessonList().add(new Lesson("Lesson 2"));

        Textbook textbook1 = textbookMap.get(MINNA_KANJI_1);
        textbook1.getLessonList().add(new Lesson("Lesson 0"));
        textbook1.getLessonList().add(new Lesson("Lesson 1-2"));

        Textbook textbook2 = textbookMap.get(BASIC_KANJI_BOOK_1);
        textbook2.getLessonList().add(new Lesson("Lesson 1"));
        textbook2.getLessonList().add(new Lesson("Lesson 2"));

        template.save(textbook);
        template.save(textbook1);
        template.save(textbook2);
    }

    @ChangeSet(order = "012", id = "initialTextbookLessonWord", author = "zdoh", runAlways = true)
    public void initTextbookLessonWord(MongoTemplate template) {
        ArrayList<Word> minnaGrWordsL1 = new ArrayList<>();
        ArrayList<Word> minnaGrWordsL2 = new ArrayList<>();
        ArrayList<Word> minnaKanjiWordsL0 = new ArrayList<>();
        ArrayList<Word> minnaKanjiWordsL1 = new ArrayList<>();
        ArrayList<Word> basicKanjiBookWordsL1 = new ArrayList<>();
        ArrayList<Word> basicKanjiBookWordsL2 = new ArrayList<>();

        ///

        minnaGrWordsL1.add(wordsMap.get("私"));
        minnaGrWordsL1.add(wordsMap.get("あなた"));
        minnaGrWordsL1.add(wordsMap.get("あの人"));
        minnaGrWordsL1.add(wordsMap.get("あの方"));
        minnaGrWordsL1.add(wordsMap.get("先生"));
        minnaGrWordsL1.add(wordsMap.get("教師"));
        minnaGrWordsL1.add(wordsMap.get("学生"));
        minnaGrWordsL1.add(wordsMap.get("会社員"));
        minnaGrWordsL1.add(wordsMap.get("社員"));
        minnaGrWordsL1.add(wordsMap.get("銀行員"));
        minnaGrWordsL1.add(wordsMap.get("医者"));
        minnaGrWordsL1.add(wordsMap.get("研究者"));
        minnaGrWordsL1.add(wordsMap.get("大学"));
        minnaGrWordsL1.add(wordsMap.get("病院"));
        minnaGrWordsL1.add(wordsMap.get("誰"));
        minnaGrWordsL1.add(wordsMap.get("どなた"));
        minnaGrWordsL1.add(wordsMap.get("何歳"));
        minnaGrWordsL1.add(wordsMap.get("いくつ"));
        minnaGrWordsL1.add(wordsMap.get("はい"));
        minnaGrWordsL1.add(wordsMap.get("いいえ"));
        minnaGrWordsL1.add(wordsMap.get("国"));
        minnaGrWordsL1.add(wordsMap.get("言葉"));
        minnaGrWordsL1.add(wordsMap.get("アメリカ"));
        minnaGrWordsL1.add(wordsMap.get("イギリス"));
        minnaGrWordsL1.add(wordsMap.get("イタリア"));
        minnaGrWordsL1.add(wordsMap.get("イラン"));
        minnaGrWordsL1.add(wordsMap.get("韓国"));
        minnaGrWordsL1.add(wordsMap.get("スペイン"));
        minnaGrWordsL1.add(wordsMap.get("ドイツ"));
        minnaGrWordsL1.add(wordsMap.get("日本"));
        minnaGrWordsL1.add(wordsMap.get("ロシア"));
        minnaGrWordsL1.add(wordsMap.get("中国"));
        minnaGrWordsL1.add(wordsMap.get("アメリカ人"));
        minnaGrWordsL1.add(wordsMap.get("韓国人"));
        minnaGrWordsL1.add(wordsMap.get("中国人"));
        minnaGrWordsL1.add(wordsMap.get("日本人"));
        minnaGrWordsL1.add(wordsMap.get("ロシア人"));
        minnaGrWordsL1.add(wordsMap.get("英語"));
        minnaGrWordsL1.add(wordsMap.get("韓国語"));
        minnaGrWordsL1.add(wordsMap.get("日本語"));
        minnaGrWordsL1.add(wordsMap.get("ロシア語"));


        ///

        minnaGrWordsL2.add(wordsMap.get("これ"));
        minnaGrWordsL2.add(wordsMap.get("それ"));
        minnaGrWordsL2.add(wordsMap.get("あれ"));
        minnaGrWordsL2.add(wordsMap.get("本"));
        minnaGrWordsL2.add(wordsMap.get("辞書"));
        minnaGrWordsL2.add(wordsMap.get("雑誌"));
        minnaGrWordsL2.add(wordsMap.get("新聞"));
        minnaGrWordsL2.add(wordsMap.get("ノット"));
        minnaGrWordsL2.add(wordsMap.get("手帳"));
        minnaGrWordsL2.add(wordsMap.get("名刺"));
        minnaGrWordsL2.add(wordsMap.get("カード"));
        minnaGrWordsL2.add(wordsMap.get("鉛筆"));
        minnaGrWordsL2.add(wordsMap.get("ボールペン"));
        minnaGrWordsL2.add(wordsMap.get("シャープペンシル"));
        minnaGrWordsL2.add(wordsMap.get("鍵"));
        minnaGrWordsL2.add(wordsMap.get("時計"));
        minnaGrWordsL2.add(wordsMap.get("傘"));
        minnaGrWordsL2.add(wordsMap.get("かばん"));
        minnaGrWordsL2.add(wordsMap.get("CD"));
        minnaGrWordsL2.add(wordsMap.get("テレビ"));
        minnaGrWordsL2.add(wordsMap.get("ラジオ"));
        minnaGrWordsL2.add(wordsMap.get("カメラ"));
        minnaGrWordsL2.add(wordsMap.get("コンピューター"));
        minnaGrWordsL2.add(wordsMap.get("車"));
        minnaGrWordsL2.add(wordsMap.get("机"));
        minnaGrWordsL2.add(wordsMap.get("椅子"));
        minnaGrWordsL2.add(wordsMap.get("チョコレート"));
        minnaGrWordsL2.add(wordsMap.get("コーヒー"));
        minnaGrWordsL2.add(wordsMap.get("土産"));
        minnaGrWordsL2.add(wordsMap.get("何"));
        minnaGrWordsL2.add(wordsMap.get("そう"));
        minnaGrWordsL2.add(wordsMap.get("違う"));

        ///

        minnaKanjiWordsL0.add(wordsMap.get("一つ"));
        minnaKanjiWordsL0.add(wordsMap.get("二つ"));
        minnaKanjiWordsL0.add(wordsMap.get("三つ"));
        minnaKanjiWordsL0.add(wordsMap.get("四つ"));
        minnaKanjiWordsL0.add(wordsMap.get("五つ"));
        minnaKanjiWordsL0.add(wordsMap.get("六つ"));
        minnaKanjiWordsL0.add(wordsMap.get("七つ"));
        minnaKanjiWordsL0.add(wordsMap.get("八つ"));
        minnaKanjiWordsL0.add(wordsMap.get("九つ"));
        minnaKanjiWordsL0.add(wordsMap.get("十"));
        minnaKanjiWordsL0.add(wordsMap.get("一月"));
        minnaKanjiWordsL0.add(wordsMap.get("二月"));
        minnaKanjiWordsL0.add(wordsMap.get("三月"));
        minnaKanjiWordsL0.add(wordsMap.get("四月"));
        minnaKanjiWordsL0.add(wordsMap.get("五月"));
        minnaKanjiWordsL0.add(wordsMap.get("六月"));
        minnaKanjiWordsL0.add(wordsMap.get("七月"));
        minnaKanjiWordsL0.add(wordsMap.get("八月"));
        minnaKanjiWordsL0.add(wordsMap.get("九月"));
        minnaKanjiWordsL0.add(wordsMap.get("十月"));

        ///

        minnaKanjiWordsL1.add(wordsMap.get("アメリカ人"));
        minnaKanjiWordsL1.add(wordsMap.get("あの人"));
        minnaKanjiWordsL1.add(wordsMap.get("人"));
        minnaKanjiWordsL1.add(wordsMap.get("日本人"));
        minnaKanjiWordsL1.add(wordsMap.get("だれ"));
        minnaKanjiWordsL1.add(wordsMap.get("名前"));
        minnaKanjiWordsL1.add(wordsMap.get("名"));
        minnaKanjiWordsL1.add(wordsMap.get("あの方"));
        minnaKanjiWordsL1.add(wordsMap.get("方"));
        minnaKanjiWordsL1.add(wordsMap.get("カメラ"));
        minnaKanjiWordsL1.add(wordsMap.get("本"));
        minnaKanjiWordsL1.add(wordsMap.get("日本"));
        minnaKanjiWordsL1.add(wordsMap.get("日"));
        minnaKanjiWordsL1.add(wordsMap.get("これ"));
        minnaKanjiWordsL1.add(wordsMap.get("何"));
        minnaKanjiWordsL1.add(wordsMap.get("大きい"));
        minnaKanjiWordsL1.add(wordsMap.get("大学"));
        minnaKanjiWordsL1.add(wordsMap.get("大いに"));
        minnaKanjiWordsL1.add(wordsMap.get("学ぶ"));
        minnaKanjiWordsL1.add(wordsMap.get("二十歳"));
        minnaKanjiWordsL1.add(wordsMap.get("社員"));
        minnaKanjiWordsL1.add(wordsMap.get("社"));
        minnaKanjiWordsL1.add(wordsMap.get("会社員"));
        minnaKanjiWordsL1.add(wordsMap.get("会う"));
        minnaKanjiWordsL1.add(wordsMap.get("先生"));
        minnaKanjiWordsL1.add(wordsMap.get("生む"));
        minnaKanjiWordsL1.add(wordsMap.get("生まれる"));
        minnaKanjiWordsL1.add(wordsMap.get("生"));
        minnaKanjiWordsL1.add(wordsMap.get("銀行員"));
        minnaKanjiWordsL1.add(wordsMap.get("行く"));
        minnaKanjiWordsL1.add(wordsMap.get("銀行"));
        minnaKanjiWordsL1.add(wordsMap.get("アメリカ"));
        minnaKanjiWordsL1.add(wordsMap.get("来る"));
        minnaKanjiWordsL1.add(wordsMap.get("来年"));
        minnaKanjiWordsL1.add(wordsMap.get("車"));
        minnaKanjiWordsL1.add(wordsMap.get("電車"));
        minnaKanjiWordsL1.add(wordsMap.get("いいえ"));
        minnaKanjiWordsL1.add(wordsMap.get("学生"));
        minnaKanjiWordsL1.add(wordsMap.get("どなた"));
        minnaKanjiWordsL1.add(wordsMap.get("失礼"));
        minnaKanjiWordsL1.add(wordsMap.get("ブラジル人"));
        minnaKanjiWordsL1.add(wordsMap.get("それ"));
        minnaKanjiWordsL1.add(wordsMap.get("雑誌"));
        minnaKanjiWordsL1.add(wordsMap.get("日本語"));
        minnaKanjiWordsL1.add(wordsMap.get("何歳"));

        ///

        basicKanjiBookWordsL1.add(wordsMap.get("日"));
        basicKanjiBookWordsL1.add(wordsMap.get("日本"));
        basicKanjiBookWordsL1.add(wordsMap.get("日曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("3日"));
        basicKanjiBookWordsL1.add(wordsMap.get("月"));
        basicKanjiBookWordsL1.add(wordsMap.get("一月"));
        basicKanjiBookWordsL1.add(wordsMap.get("月曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("木"));
        basicKanjiBookWordsL1.add(wordsMap.get("木曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("山"));
        basicKanjiBookWordsL1.add(wordsMap.get("富士山"));
        basicKanjiBookWordsL1.add(wordsMap.get("火山"));
        basicKanjiBookWordsL1.add(wordsMap.get("川"));
        basicKanjiBookWordsL1.add(wordsMap.get("河川"));
        basicKanjiBookWordsL1.add(wordsMap.get("田"));
        basicKanjiBookWordsL1.add(wordsMap.get("田んぼ"));
        basicKanjiBookWordsL1.add(wordsMap.get("水田"));
        basicKanjiBookWordsL1.add(wordsMap.get("人"));
        basicKanjiBookWordsL1.add(wordsMap.get("日本人"));
        basicKanjiBookWordsL1.add(wordsMap.get("三人"));
        basicKanjiBookWordsL1.add(wordsMap.get("口"));
        basicKanjiBookWordsL1.add(wordsMap.get("出口"));
        basicKanjiBookWordsL1.add(wordsMap.get("入り口"));
        basicKanjiBookWordsL1.add(wordsMap.get("人口"));
        basicKanjiBookWordsL1.add(wordsMap.get("車"));
        basicKanjiBookWordsL1.add(wordsMap.get("電車"));
        basicKanjiBookWordsL1.add(wordsMap.get("自動車"));
        basicKanjiBookWordsL1.add(wordsMap.get("門"));
        basicKanjiBookWordsL1.add(wordsMap.get("専門"));
        basicKanjiBookWordsL1.add(wordsMap.get("日曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("今日"));
        basicKanjiBookWordsL1.add(wordsMap.get("あの人"));
        basicKanjiBookWordsL1.add(wordsMap.get("二月"));
        basicKanjiBookWordsL1.add(wordsMap.get("三月"));
        basicKanjiBookWordsL1.add(wordsMap.get("四月"));
        basicKanjiBookWordsL1.add(wordsMap.get("五月"));
        basicKanjiBookWordsL1.add(wordsMap.get("六月"));
        basicKanjiBookWordsL1.add(wordsMap.get("七月"));
        basicKanjiBookWordsL1.add(wordsMap.get("八月"));
        basicKanjiBookWordsL1.add(wordsMap.get("九月"));
        basicKanjiBookWordsL1.add(wordsMap.get("十月"));
        basicKanjiBookWordsL1.add(wordsMap.get("十一月"));
        basicKanjiBookWordsL1.add(wordsMap.get("十二月"));

        ///

        basicKanjiBookWordsL2.add(wordsMap.get("火"));
        basicKanjiBookWordsL2.add(wordsMap.get("火山"));
        basicKanjiBookWordsL2.add(wordsMap.get("火曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("水"));
        basicKanjiBookWordsL2.add(wordsMap.get("水田"));
        basicKanjiBookWordsL2.add(wordsMap.get("水曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("お金"));
        basicKanjiBookWordsL2.add(wordsMap.get("金曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("土"));
        basicKanjiBookWordsL2.add(wordsMap.get("土木"));
        basicKanjiBookWordsL2.add(wordsMap.get("土曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("子供"));
        basicKanjiBookWordsL2.add(wordsMap.get("女の子"));
        basicKanjiBookWordsL2.add(wordsMap.get("女子"));
        basicKanjiBookWordsL2.add(wordsMap.get("女子学生"));
        basicKanjiBookWordsL2.add(wordsMap.get("女"));
        basicKanjiBookWordsL2.add(wordsMap.get("女の人"));
        basicKanjiBookWordsL2.add(wordsMap.get("彼女"));
        basicKanjiBookWordsL2.add(wordsMap.get("学ぶ"));
        basicKanjiBookWordsL2.add(wordsMap.get("学生"));
        basicKanjiBookWordsL2.add(wordsMap.get("大学"));
        basicKanjiBookWordsL2.add(wordsMap.get("学校"));
        basicKanjiBookWordsL2.add(wordsMap.get("生きる"));
        basicKanjiBookWordsL2.add(wordsMap.get("生む"));
        basicKanjiBookWordsL2.add(wordsMap.get("生まれる"));
        basicKanjiBookWordsL2.add(wordsMap.get("先生"));
        basicKanjiBookWordsL2.add(wordsMap.get("先"));
        basicKanjiBookWordsL2.add(wordsMap.get("先月"));
        basicKanjiBookWordsL2.add(wordsMap.get("私"));
        basicKanjiBookWordsL2.add(wordsMap.get("私立"));
        basicKanjiBookWordsL2.add(wordsMap.get("私立大学"));
        basicKanjiBookWordsL2.add(wordsMap.get("すみません"));
        basicKanjiBookWordsL2.add(wordsMap.get("生年月日"));
        basicKanjiBookWordsL2.add(wordsMap.get("火事"));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));




        //words.add(wordsMap.get(""));


        textbookMap.get(MINNA_GR_1).getLessonList().get(0).setWordList(minnaGrWordsL1);
        textbookMap.get(MINNA_GR_1).getLessonList().get(1).setWordList(minnaGrWordsL2);

        textbookMap.get(MINNA_KANJI_1).getLessonList().get(0).setWordList(minnaKanjiWordsL0);
        textbookMap.get(MINNA_KANJI_1).getLessonList().get(1).setWordList(minnaKanjiWordsL1);

        textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(0).setWordList(basicKanjiBookWordsL1);
        textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(1).setWordList(basicKanjiBookWordsL2);

        template.save(textbookMap.get(MINNA_GR_1));

        /*textbookMap.put("Minna no nihongo begin grammar I - Lesson1",
                template.save(textbookMap.get("Minna no nihongo begin grammar I")));*/
    }

    @ChangeSet(order = "012", id = "initialTextbookLessonKanji", author = "zdoh", runAlways = true)
    public void initialTextbookLessonKanji(MongoTemplate template) {
        List<Kanji> minnaKanjiL0 = new ArrayList<>();
        List<Kanji> minnaKanjiL1 = new ArrayList<>();

        List<Kanji> basicKanjiL1 = new ArrayList<>();
        List<Kanji> basicKanjiL2 = new ArrayList<>();



        minnaKanjiL0.add(kanjiMap.get("一"));
        minnaKanjiL0.add(kanjiMap.get("二"));
        minnaKanjiL0.add(kanjiMap.get("三"));
        minnaKanjiL0.add(kanjiMap.get("四"));
        minnaKanjiL0.add(kanjiMap.get("五"));
        minnaKanjiL0.add(kanjiMap.get("六"));
        minnaKanjiL0.add(kanjiMap.get("七"));
        minnaKanjiL0.add(kanjiMap.get("八"));
        minnaKanjiL0.add(kanjiMap.get("九"));
        minnaKanjiL0.add(kanjiMap.get("十"));

        minnaKanjiL1.add(kanjiMap.get("人"));
        minnaKanjiL1.add(kanjiMap.get("名"));
        minnaKanjiL1.add(kanjiMap.get("方"));
        minnaKanjiL1.add(kanjiMap.get("本"));
        minnaKanjiL1.add(kanjiMap.get("日"));
        minnaKanjiL1.add(kanjiMap.get("何"));
        minnaKanjiL1.add(kanjiMap.get("大"));
        minnaKanjiL1.add(kanjiMap.get("学"));
        minnaKanjiL1.add(kanjiMap.get("社"));
        minnaKanjiL1.add(kanjiMap.get("員"));
        minnaKanjiL1.add(kanjiMap.get("会"));
        minnaKanjiL1.add(kanjiMap.get("先"));
        minnaKanjiL1.add(kanjiMap.get("生"));
        minnaKanjiL1.add(kanjiMap.get("行"));
        minnaKanjiL1.add(kanjiMap.get("来"));
        minnaKanjiL1.add(kanjiMap.get("車"));

        basicKanjiL1.add(kanjiMap.get("日"));
        basicKanjiL1.add(kanjiMap.get("月"));
        basicKanjiL1.add(kanjiMap.get("木"));
        basicKanjiL1.add(kanjiMap.get("山"));
        basicKanjiL1.add(kanjiMap.get("川"));
        basicKanjiL1.add(kanjiMap.get("田"));
        basicKanjiL1.add(kanjiMap.get("人"));
        basicKanjiL1.add(kanjiMap.get("口"));
        basicKanjiL1.add(kanjiMap.get("車"));
        basicKanjiL1.add(kanjiMap.get("門"));

        basicKanjiL2.add(kanjiMap.get("火"));
        basicKanjiL2.add(kanjiMap.get("水"));
        basicKanjiL2.add(kanjiMap.get("金"));
        basicKanjiL2.add(kanjiMap.get("土"));
        basicKanjiL2.add(kanjiMap.get("子"));
        basicKanjiL2.add(kanjiMap.get("女"));
        basicKanjiL2.add(kanjiMap.get("学"));
        basicKanjiL2.add(kanjiMap.get("生"));
        basicKanjiL2.add(kanjiMap.get("先"));
        basicKanjiL2.add(kanjiMap.get("私"));

        // basicKanjiL2.add(kanjiMap.get(""));

        textbookMap.get(MINNA_KANJI_1).getLessonList().get(0).setKanjiList(minnaKanjiL0);
        textbookMap.get(MINNA_KANJI_1).getLessonList().get(1).setKanjiList(minnaKanjiL1);

        textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(0).setKanjiList(basicKanjiL1);
        textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(1).setKanjiList(basicKanjiL2);

        template.save(textbookMap.get(MINNA_KANJI_1));
        template.save(textbookMap.get(BASIC_KANJI_BOOK_1));
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

        String minnaGrSourceL1 = textbookMap.get(MINNA_GR_1).getJapaneseName() + " - "
                + textbookMap.get(MINNA_GR_1).getLessonList().get(0).getName();

        String minnaGrSourceL2 = textbookMap.get(MINNA_GR_1).getJapaneseName() + " - "
                + textbookMap.get(MINNA_GR_1).getLessonList().get(1).getName();

        String minnaKjSourceL1 = textbookMap.get(MINNA_KANJI_1).getJapaneseName() + " - "
                + textbookMap.get(MINNA_KANJI_1).getLessonList().get(0).getName();

        String basicKjSourceL1 = textbookMap.get(BASIC_KANJI_BOOK_1).getJapaneseName() + " - "
                + textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(0).getName();

        String basicKjSourceL2 = textbookMap.get(BASIC_KANJI_BOOK_1).getJapaneseName() + " - "
                + textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(1).getName();

        ArrayList<Sentence> sentMinGrLes1 = new ArrayList<>();
        ArrayList<Sentence> sentMinGrLes2 = new ArrayList<>();
        ArrayList<Sentence> sentMinKjLes1 = new ArrayList<>();
        ArrayList<Sentence> sentBasKjLes1 = new ArrayList<>();
        ArrayList<Sentence> sentBasKjLes2 = new ArrayList<>();

        sentMinGrLes1.add(template.save(new Sentence("私はマイク・ミラーです。",
                List.of(new SentenceTranslate(langRu, "Я Майк Миллер.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false,
                List.of(grammarMap.get("nは"), grammarMap.get("nです")),
                List.of(wordsMap.get("私")))));

        sentMinGrLes1.add(template.save(new Sentence("私は会社員です。",
                List.of(new SentenceTranslate(langRu, "Я сотрудник компании.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false,
                List.of(grammarMap.get("nは"), grammarMap.get("nです")),
                List.of(wordsMap.get("私"), wordsMap.get("会社員")))));

        sentMinGrLes1.add(template.save(new Sentence("「サントスさんは学生じゃありません。」",
                List.of(new SentenceTranslate(langRu, "Сантос-сан не студент.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんはアメリカ人ですか」「はい、アメリカ人です」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан американец?' 'Да, американец'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんは先生ですか」「いいえ、先生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан преподаватель?' 'Нет, не преподаватель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「（あの方は）ミラーです」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан преподаватель?' 'Нет, не преподаватель'",
                        List.of(new OtherPossibleSentence("「あのひとはだれですか」「（あの人は）ミラーです」", "zdoh", 1)))), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("ミラーさんは会社員です。",
                List.of(new SentenceTranslate(langRu, "Миллер-сан сотрудник компании.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ミラーさんはIMCの社員です。",
                List.of(new SentenceTranslate(langRu, "Миллер-сан сотрудник компании IMC.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("あの方はミラーさんです。",
                List.of(new SentenceTranslate(langRu, "Это Миллер-сан.",
                        List.of(new OtherPossibleSentence("あの人はミラーさんです。", "zdoh", 1)))), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「マイク・ミラーさんですか」「はい、マイク・ミラーです」",
                List.of(new SentenceTranslate(langRu, "'Вы Майк Миллер?' 'Да, Майк Миллер'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんは学生ですか」「いいえ、学生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан студент?' 'Нет, не студент'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワンさんは銀行ですか」「いいえ、銀行じゃありません。医者です」 ",
                List.of(new SentenceTranslate(langRu, "'Ван-сан сотрудник банка?' 'Нет, не сотрудник банка. Врач'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「ワットさんです。さくら大学の先生です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Ватт-сан. Преподаватель университета Сакура.'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「テレーザちゃんは何歳ですか」「9歳です」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Терезе-чян?' '9 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("ワンさんは中国人です。",
                List.of(new SentenceTranslate(langRu, "Ван-сан китаец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワンさんは医者です。",
                List.of(new SentenceTranslate(langRu, "Ван-сан врач.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「私はカール・シュミットじゃありません」",
                List.of(new SentenceTranslate(langRu, "'Я не Карл Шмидт'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("私はカール・シュミットではありません。",
                List.of(new SentenceTranslate(langRu, "Я не Карл Шмидт")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「私は教師じゃありません」",
                List.of(new SentenceTranslate(langRu, "私は教師ではありません。")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「イーさんはアメリカ人じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Ии-сан не американка'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("イーさんはアメリカ人ではありません",
                List.of(new SentenceTranslate(langRu, "Ии-сан не американка.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「イーさんは学生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Ии-сан не студентка'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("イーさんは学生ではありません",
                List.of(new SentenceTranslate(langRu, "Ии-сан не студентка.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「あの人は木村さんですか」",
                List.of(new SentenceTranslate(langRu, "'Он Кимура-сан?'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はマライさんですか」",
                List.of(new SentenceTranslate(langRu, "'Она Мария-сан?'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("あの方はだれですか",
                List.of(new SentenceTranslate(langRu, "Он кто?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("私はBMWの社員です。",
                List.of(new SentenceTranslate(langRu, "Я сотрудник компании БМВ.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("カリナさんは富士大学の学生です。",
                List.of(new SentenceTranslate(langRu, "Карина-сан студентка университета Фудзи.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんはさくら大学の先生です",
                List.of(new SentenceTranslate(langRu, "Ватт-сан преподаватель университета Сакура.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("サントスさんはブラジル人です。マリアさんもブラジル人です",
                List.of(new SentenceTranslate(langRu, "Сантос-сан бразилец. Мария-сан тоже бразильянка")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「太郎ちゃんは何歳ですか」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Таро-куну?'")), minnaGrSourceL1, sentencePolitenessMap.get(""), true)));

        sentMinGrLes1.add(template.save(new Sentence("山田さんは日本人です。",
                List.of(new SentenceTranslate(langRu, "Ямада-сан японец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんはイギリス人です。",
                List.of(new SentenceTranslate(langRu, "Ватт-сан англичанин.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("タワポンさんはタイ人です。",
                List.of(new SentenceTranslate(langRu, "Тавапон-сан таец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("シュミットさんはドイツ人です。",
                List.of(new SentenceTranslate(langRu, "Шмидт-сан немец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("山田さんは銀行員です。",
                List.of(new SentenceTranslate(langRu, "Ямада-сан сотрудник банка.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんは先生です。",
                List.of(new SentenceTranslate(langRu, "Ватт-сан учитель.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("タワポンさんは学生です。",
                List.of(new SentenceTranslate(langRu, "Тавапон-сан студент.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("シュミットさんは会社員です。",
                List.of(new SentenceTranslate(langRu, "Шмидт-сан сотрудник компании.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「山田さんは学生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Ямада-сан не студент'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんはドイツ人じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Ватт-сан не англичанин'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「タワポンさんは先生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Тавапон-сан не учитель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「シュミットさんはアメリカ人じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Шмидт-сан не американец'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「山田さんは銀行員ですか」「はい、銀行員です」",
                List.of(new SentenceTranslate(langRu, "'Ямада-сан сотрудник банка?' 'Да, сотрудник банка.'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんは会社員ですか」「いいえ、会社員じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Ватт-сан служащий компании?' 'Нет, не служащий банка'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「タワポンさんは先生ですか」「いいえ、先生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Тавапон-сан учитель?' 'Нет, не учитель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「シュミットさんはドイツ人ですか」「はい、ドイツ人です」",
                List.of(new SentenceTranslate(langRu, "'Шмидт-сан немец?' 'Да, немец'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「イーさんです。AKCの研究者です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Ии-сан. Ученый (компании) АКЦ'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「ワンさんです。神戸病院の医者です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Ван-сан. Врач больницы Кобэ'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「カリナさんです。富士大学の学生です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Карина-сан. Студентка университета Фудзи'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「サントスさんです。ブラジルエアーの社員です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Сантос-сан. Бразильский сотрудник'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("山田さんは銀行員です。イーさんも銀行員ですか。",
                List.of(new SentenceTranslate(langRu, "Ямада-сан сотрудник банка. Ии-сан тоже сотрудница банка?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんは先生です。ワンさんも先生せうか。",
                List.of(new SentenceTranslate(langRu, "Ватт-сан учитель. Ван-сан тоже учитель?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("タワポンさんは学生です。カリナサンも学生ですか。",
                List.of(new SentenceTranslate(langRu, "Тавапон-сан студент. Карина-сан тоже студентка?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("シュミットさんはドイツ人です。サントスさんもドイツじんですか。",
                List.of(new SentenceTranslate(langRu, "Шмидт-сан немец. Сантос-сан тоже немец?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「山田さんは何歳ですか」「38歳です」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Ямада-сану?' '38 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんは何歳ですか」「45歳です」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Ват-сану?' '45 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「タワポンさんは何歳ですか」「19歳です」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Тавапон-сану?' '19 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「シュミットさんは何歳ですか」「５２歳です」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Шмидт-сану?' '52 года'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あなたは学生ですか」「はい、学生です」",
                List.of(new SentenceTranslate(langRu, "'Ты студент?' 'Да, студент'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あなたはミラーですか」「はい、ミラーです」",
                List.of(new SentenceTranslate(langRu, "'Ты Миллер?' 'Да, Миллер'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんもアメリカ人ですか」「いいえ、アメリカ人じゃありません。イギリス人です」",
                List.of(new SentenceTranslate(langRu, "'Ватт-сан тоже американец?' 'Нет, не американец. Англичанин'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はだれですか」「サントスさんです」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Сантос-сан'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("私はミラーです。",
                List.of(new SentenceTranslate(langRu, "Я Миллер.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワンさん医者です。",
                List.of(new SentenceTranslate(langRu, "Ван-сан врач.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「カリナさんは先生でうか」「いいえ、先生じゃありません」",
                List.of(new SentenceTranslate(langRu, "'Карина-сан учитель?' 'Нет, не учитель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんは会社員です」「サントスさんも会社員です」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан сотруднки компании' 'Сантос-сан тоже сотрудник компании'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        /////////

        sentMinGrLes2.add(template.save(new Sentence("それは辞書ですか",
                List.of(new SentenceTranslate(langRu, "Это словарь?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはだれの傘ですか",
                List.of(new SentenceTranslate(langRu, "Это чей зонт?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("この本は私のです",
                List.of(new SentenceTranslate(langRu, "Эта книга моя.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あの方はどなたですか",
                List.of(new SentenceTranslate(langRu, "Он кто?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("「それは辞書ですか」「はい、そうです」",
                List.of(new SentenceTranslate(langRu, "'Это словарь?' 'Да, это так'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それはミラーさんのですか」「いいえ、違います」",
                List.of(new SentenceTranslate(langRu, "'Это миллера?' 'Нет, это не так.'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それはシャープペンシルですか」「いいえ、ボールペンです」",
                List.of(new SentenceTranslate(langRu, "'Это механический карандаш?' 'Нет, это шариковая ручка'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは９ですか、７ですか」「９です」",
                List.of(new SentenceTranslate(langRu, "'Это 9 или 7?' '9'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("これはコンピュータの本です。",
                List.of(new SentenceTranslate(langRu, "Это компьютерная книга.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは私の本です。",
                List.of(new SentenceTranslate(langRu, "Это моя книга.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("「あれはだれのかばんですか」「佐藤さんのです」",
                List.of(new SentenceTranslate(langRu, "'Это чей портфель?' 'Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このかばんはあなたのですか」「いいえ、私のじゃありません」",
                List.of(new SentenceTranslate(langRu, "'Этот портфель твой?' 'Нет, не мой'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「ミラーさんはIMCの社員ですか」「はい、IMCの社員です」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан сотрудник IMC?' 'Да, сотрудник IMC'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「この傘はあなたのですか」「いいえ、違います。シュミットさんのです。そうですか」",
                List.of(new SentenceTranslate(langRu, "'Этот зонт твой?' 'Нет, не так. Шмидта-сана. Понятно.'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはボールペンですか」「はい、そうです」",
                List.of(new SentenceTranslate(langRu, "'Это шариковая ручка?' 'Да, это так'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それはノートですか」「いいえ、手帳です」",
                List.of(new SentenceTranslate(langRu, "'Это тетрадь?' 'Нет, блокнот'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何ですか」「名刺です」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Визитка'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の雑誌ですか」「コンピューターの雑誌です」",
                List.of(new SentenceTranslate(langRu, "'Это что за журнал?' 'Компьютерный журнал'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「あれはだれのかばんですか」「佐藤さんのかばんです」",
                List.of(new SentenceTranslate(langRu, "'Это чей портфель?' 'Портфель Сатоу-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはミラーさんのですか」「いいえ、私のじゃありません」",
                List.of(new SentenceTranslate(langRu, "'Это Миллер-сана?' 'Нет, не мое'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このかばんはだれのですか」「私のです」",
                List.of(new SentenceTranslate(langRu, "'Этот портфель чей?' 'Мой'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("これは机です",
                List.of(new SentenceTranslate(langRu, "Это стол.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは新聞です",
                List.of(new SentenceTranslate(langRu, "Это газета.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは名刺です",
                List.of(new SentenceTranslate(langRu, "Это визитка.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは何ですか",
                List.of(new SentenceTranslate(langRu, "Это что?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはボールペンですか、シャープペンシルですか",
                List.of(new SentenceTranslate(langRu, "Это шариковая ручка или механический карандаш?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それは「１」ですか、「９」ですか。",
                List.of(new SentenceTranslate(langRu, "Это один или девять?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それは「あ」ですか、「お」ですか。",
                List.of(new SentenceTranslate(langRu, "Это 'а' или 'о'?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは車の本です。",
                List.of(new SentenceTranslate(langRu, "Это книга о машинах.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これはコンピュータの本です。",
                List.of(new SentenceTranslate(langRu, "Это книга о компьютерах.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは日本の本です。",
                List.of(new SentenceTranslate(langRu, "Это книга о Японии.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは何の本です。",
                List.of(new SentenceTranslate(langRu, "Это что за книга?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは私のかばんです。",
                List.of(new SentenceTranslate(langRu, "То мой портфель.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは佐藤さんのかばんです。",
                List.of(new SentenceTranslate(langRu, "То портфель Сатоу-сана.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは先生のかばんです。",
                List.of(new SentenceTranslate(langRu, "То портфель учителя?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれはだれのかばんですか。",
                List.of(new SentenceTranslate(langRu, "То чей портфель?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは私のです。",
                List.of(new SentenceTranslate(langRu, "То мое.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは佐藤さんのです。",
                List.of(new SentenceTranslate(langRu, "То Сатоу-сана.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは先生のです。",
                List.of(new SentenceTranslate(langRu, "То учителя.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれはだれのですか。",
                List.of(new SentenceTranslate(langRu, "То чье?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("この手帳は私のです。",
                List.of(new SentenceTranslate(langRu, "Этот блокнот мой.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("この鍵は私のです。",
                List.of(new SentenceTranslate(langRu, "Эти ключи мои.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("このかばんは私のです。",
                List.of(new SentenceTranslate(langRu, "Этот портфель мой.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは雑誌です。",
                List.of(new SentenceTranslate(langRu, "Это журнал.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはノートです。",
                List.of(new SentenceTranslate(langRu, "Это тетрадь.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは辞書です。",
                List.of(new SentenceTranslate(langRu, "То словарь.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはかばんです。",
                List.of(new SentenceTranslate(langRu, "То портфель.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは鍵です。",
                List.of(new SentenceTranslate(langRu, "Это ключ.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれはテレビです。",
                List.of(new SentenceTranslate(langRu, "То телевизор.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("「これは本ですか」「はい、本です」",
                List.of(new SentenceTranslate(langRu, "'Это книга?' 'Да, книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは手帳ですか」「いいえ、本です」",
                List.of(new SentenceTranslate(langRu, "'Это блокнот?' 'Нет, книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは時計ですか」「はい、時計です」",
                List.of(new SentenceTranslate(langRu, "'Это часы?' 'Да, часы'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはラジオですか」「いいえ、カメラです」",
                List.of(new SentenceTranslate(langRu, "'Это радио?' 'Нет, фотоаппарат'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは鉛筆ですか」「いいえ、シャープペンシルです」",
                List.of(new SentenceTranslate(langRu, "'Это карандаш?' 'Нет, механический карандаш'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは椅子ですか」「はい、椅子です」",
                List.of(new SentenceTranslate(langRu, "'Это стул?' 'Да, стул'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「本です」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「時計です」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Часы'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「カメラです」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Фотоаппарат'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「シャープペンシルです」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Механический карандаш'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「椅子です」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Стул'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはシャープペンシルですか、ボールペンですか」「ボールペンです」",
                List.of(new SentenceTranslate(langRu, "'Это механический карандаш или шариковая ручка?' 'Шариковая ручка'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは本ですか、雑誌ですか」「本です」",
                List.of(new SentenceTranslate(langRu, "'Это книга или журнал?' 'Книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは「い」ですか、「り」ですか」「「り」です」",
                List.of(new SentenceTranslate(langRu, "'Это и или ри?' 'Ри'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは「１」ですか、「７」ですか」「「７」です」",
                List.of(new SentenceTranslate(langRu, "'Это 1 или 7?' '7'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは「シ」ですか、「ツ」ですか」「「ツ」です」",
                List.of(new SentenceTranslate(langRu, "'Это ши или цу?' 'Цу'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何の鍵ですか」「車の鍵です」",
                List.of(new SentenceTranslate(langRu, "'Это что за ключ?' 'Ключ от машины'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の雑誌ですか」「車の雑誌です」",
                List.of(new SentenceTranslate(langRu, "'Это что за журнал?' 'Журнал о машинах'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何のCDですか」「日本語のCDです」",
                List.of(new SentenceTranslate(langRu, "'Это что за CD?' 'CD на японском языке'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の雑誌ですか」「カメラの雑誌です」",
                List.of(new SentenceTranslate(langRu, "'Это что за журнал?' 'Журнал о фотоаппаратах'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の本ですか」「日本語の本です」",
                List.of(new SentenceTranslate(langRu, "'Это что за книга?' 'Книга на японском языке'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれのノートですか」「カリナサンのノートです」",
                List.of(new SentenceTranslate(langRu, "'Это чья тетрадь?' 'Тетрадь Карины-сан'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれのかばんですか」「山田さんのかばん」",
                List.of(new SentenceTranslate(langRu, "'Это чей портфель?' 'Портфель Ямада-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれのカメラですか」「サントスさんのカメラです」",
                List.of(new SentenceTranslate(langRu, "'Это чей фотоаппарат?' 'Фотоаппарат Сансос-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれの傘ですか」「佐藤さんの傘です」",
                List.of(new SentenceTranslate(langRu, "'Это чей зонт?' 'Зонт Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれの手帳ですか」「ミラーさんの手帳です」",
                List.of(new SentenceTranslate(langRu, "'Это чей блокнот?' 'Блокнот Миллер-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはカリナさんのですか」「はい、カリナさんのです」",
                List.of(new SentenceTranslate(langRu, "'Это Карины-сан?' 'Да, Карины-сан?'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはミラーさんのですか」「いいえ、ミラーさんのじゃありません」",
                List.of(new SentenceTranslate(langRu, "'Это Миллер-сана?' 'Нет, не Миллер-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはワンさんのですか」「いいえ、ワンさんのじゃありません」",
                List.of(new SentenceTranslate(langRu, "'Это Ван-сана?' 'Нет, не Ван-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは佐藤さんのですか」「はい、佐藤さんのです」",
                List.of(new SentenceTranslate(langRu, "'Это Сато-сана?' 'Да, Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはワットさんのですか」「いいえ、ワットさんのじゃありません」",
                List.of(new SentenceTranslate(langRu, "'Это Ватто-сана?' 'Нет, не Ватто-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このノートはだれのですか」「カリナさんのです」",
                List.of(new SentenceTranslate(langRu, "'Эта тетрадь чья?' 'Карины-сан'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このかばんはだれのですか」「山田さんのです」",
                List.of(new SentenceTranslate(langRu, "'Этот портфель чей?' 'Ямады-сан'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このカメラはだれのですか」「サントスさんのです」",
                List.of(new SentenceTranslate(langRu, "'Этот фотоаппарат чей?' 'Сантос-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「この傘はだれのですか」「佐藤さんのです」",
                List.of(new SentenceTranslate(langRu, "'Этот зонт чей?' 'Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「この手帳はだれのですか」「ミラーさんのです」",
                List.of(new SentenceTranslate(langRu, "'Этот блокнот чей?' 'Миллер-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        ///

        sentMinKjLes1.add(template.save(new Sentence("「ミラーさんは学生ですか」「いいえ、学生じゃありません。会社員です」",
                List.of(new SentenceTranslate(langRu, "'Миллер-сан студент?' 'Нет, не студент. Сотрудник компании.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「あの方はどなたですか」「ワットさんです。さくら大学の先生です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Ван-сан. Преподаватель университета Сакура.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「失礼ですがお名前は？」「マイク・ミラーです。アメリカから来ました。どうぞよろしく」",
                List.of(new SentenceTranslate(langRu, "'Извините, как вас зовут?' 'Майк Миллре. Приехал из Америки. Приятно познакомиться.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「あの人はだれですか」「 サントスさんです。サントスさんはブラジル人です」",
                List.of(new SentenceTranslate(langRu, "'Он кто?' 'Сантос-сан. Сантос-сан бразилец.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「これは何ですか」「車の雑誌」",
                List.of(new SentenceTranslate(langRu, "'Это что?' 'Журнал о машинах.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("山田さんは銀行員です。",
                List.of(new SentenceTranslate(langRu, "Ямада-сан сотрудник банка.")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinKjLes1.add(template.save(new Sentence("「それは何の本ですか」「日本語の本です」",
                List.of(new SentenceTranslate(langRu, "'Это что за книга?' 'Книга на японском языке.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「イーさんは何歳ですか」「二十歳です」",
                List.of(new SentenceTranslate(langRu, "'Сколько лет Ии-сан?' 'Двадцать.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        ////

        sentBasKjLes1.add(template.save(new Sentence("あの人は山川さんです。",
                List.of(new SentenceTranslate(langRu, "Он Ямакава-сан.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("山川さんは日本人です。",
                List.of(new SentenceTranslate(langRu, "Ямакава-сан японец.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("あの山は筑波山です。",
                List.of(new SentenceTranslate(langRu, "Та гора - гора Тсубака.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("この川は利根川です。",
                List.of(new SentenceTranslate(langRu, "Эта река - река Тонэ.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("今日は3月15日です。",
                List.of(new SentenceTranslate(langRu, "Сегодня 15 марта.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("川田さんの専門は車です。",
                List.of(new SentenceTranslate(langRu, "Специальность Кавады-сана машины.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        ///

        sentBasKjLes2.add(template.save(new Sentence("これは山川さんのお金です。",
                List.of(new SentenceTranslate(langRu, "Это деньги Ямакавы-сан.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("すみません。水をください。",
                List.of(new SentenceTranslate(langRu, "Извините. Воду пожалуйста.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("あの女の人は学生です。",
                List.of(new SentenceTranslate(langRu, "Это жензина студентка.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("私は先生ではありません。",
                List.of(new SentenceTranslate(langRu, "Я не учитель.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("金田さんは大学の先生です。",
                List.of(new SentenceTranslate(langRu, "Канеда-сан преподаватель университета.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("あの女子学生は21歳です。",
                List.of(new SentenceTranslate(langRu, "Этой студентке 21 год.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("私の生年月日は1960年3月11日です。",
                List.of(new SentenceTranslate(langRu, "Моя дата рождения 11 марта 1960 год.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        /*
        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(langRu, ""))), source1)));
*/

        textbookMap.get(MINNA_GR_1).getLessonList().get(0).setSentencesList(sentMinGrLes1);
        textbookMap.get(MINNA_GR_1).getLessonList().get(1).setSentencesList(sentMinGrLes2);

        textbookMap.get(MINNA_KANJI_1).getLessonList().get(1).setSentencesList(sentMinKjLes1);

        textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(0).setSentencesList(sentBasKjLes1);
        textbookMap.get(BASIC_KANJI_BOOK_1).getLessonList().get(1).setSentencesList(sentBasKjLes2);


        template.save(textbookMap.get(MINNA_GR_1));
        template.save(textbookMap.get(MINNA_KANJI_1));
        template.save(textbookMap.get(BASIC_KANJI_BOOK_1));

    }

    @ChangeSet(order = "015", id = "initialUser", author = "zdoh", runAlways = true)
    public void initUser(MongoTemplate template) {
        template.save(new User("admin", BCrypt.hashpw("admin", BCrypt.gensalt()), List.of("ROLE_USER", "ROLE_ADMIN")));
        template.save(new User("user", BCrypt.hashpw("user", BCrypt.gensalt()), List.of("ROLE_USER")));
    }

}

