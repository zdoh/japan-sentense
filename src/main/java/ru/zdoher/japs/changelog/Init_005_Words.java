package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "005")
public class Init_005_Words {
    private Map<String, Word> wordsMap;
    private Map<String, Language> languageMap;
    private Map<String, PartOfSpeech> partOfSpeechMap;

    public Init_005_Words() {
        wordsMap = InitMaps.wordsMap;
        languageMap = InitMaps.languageMap;
        partOfSpeechMap = InitMaps.partOfSpeechMap;
    }

    @ChangeSet(order = "001", id = "initialWord", author = "zdoh", runAlways = true)
    public void initWord(MongoTemplate template) {
        wordsMap.put("一つ", template.save(
                new Word("一つ", "ひとつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "один"), new TranslateEntity(languageMap.get("en"), "one")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("二つ", template.save(
                new Word("二つ", "ふたつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "два"), new TranslateEntity(languageMap.get("en"), "two")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("三つ", template.save(
                new Word("三つ", "みつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "три"), new TranslateEntity(languageMap.get("en"), "three")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("四つ", template.save(
                new Word("四つ", "よっつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "четыре"), new TranslateEntity(languageMap.get("en"), "four")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("五つ", template.save(
                new Word("五つ", "いつつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "пять"), new TranslateEntity(languageMap.get("en"), "five")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("六つ", template.save(
                new Word("六つ", "むっつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "шесть"), new TranslateEntity(languageMap.get("en"), "six")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("七つ", template.save(
                new Word("七つ", "ななつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "семь"), new TranslateEntity(languageMap.get("en"), "seven")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("八つ", template.save(
                new Word("八つ", "やっつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "восемь"), new TranslateEntity(languageMap.get("en"), "eight")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("九つ", template.save(
                new Word("九つ", "ここのつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "девять"), new TranslateEntity(languageMap.get("en"), "nine")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("十", template.save(
                new Word("十", "とお",
                        List.of(new TranslateEntity(languageMap.get("ru"), "десять"), new TranslateEntity(languageMap.get("en"), "ten")),
                        List.of(partOfSpeechMap.get("num")))));

        wordsMap.put("一月", template.save(
                new Word("一月", "いちがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "январь"), new TranslateEntity(languageMap.get("en"), "january")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("二月", template.save(
                new Word("二月", "にがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "февраль"), new TranslateEntity(languageMap.get("en"), "february")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("三月", template.save(
                new Word("三月", "さんがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "март"), new TranslateEntity(languageMap.get("en"), "march")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("四月", template.save(
                new Word("四月", "しがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "апрель"), new TranslateEntity(languageMap.get("en"), "april")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("五月", template.save(
                new Word("五月", "ごがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "май"), new TranslateEntity(languageMap.get("en"), "may")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("六月", template.save(
                new Word("六月", "ろくがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "июнь"), new TranslateEntity(languageMap.get("en"), "june")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("七月", template.save(
                new Word("七月", "しちがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "июль"), new TranslateEntity(languageMap.get("en"), "jule")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("八月", template.save(
                new Word("八月", "はちがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "август"), new TranslateEntity(languageMap.get("en"), "august")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("九月", template.save(
                new Word("九月", "くがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "сентябрь"), new TranslateEntity(languageMap.get("en"), "september")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十月", template.save(
                new Word("十月", "じゅうがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "октябрь"), new TranslateEntity(languageMap.get("en"), "october")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十一月", template.save(
                new Word("十一月", "じゅういちがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "ноябрь"), new TranslateEntity(languageMap.get("en"), "november")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十二月", template.save(
                new Word("十二月", "じゅうにがつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "декабрь"), new TranslateEntity(languageMap.get("en"), "december")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("十日", template.save(
                new Word("十日", "とおか",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) десятый день месяца 2) десять дней"), new TranslateEntity(languageMap.get("en"), "1) the tenth day of the month 2)  ten days")),
                        List.of(partOfSpeechMap.get("n")))));


        wordsMap.put("私", template.save(
                new Word("私", "わたし",
                        List.of(new TranslateEntity(languageMap.get("ru"), "я"), new TranslateEntity(languageMap.get("en"), "i")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あなた", template.save(
                new Word("あたな", "あなた",
                        List.of(new TranslateEntity(languageMap.get("ru"), "ты (вы)"), new TranslateEntity(languageMap.get("en"), "you")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あの人", template.save(
                new Word("あの人", "あのひと",
                        List.of(new TranslateEntity(languageMap.get("ru"), "он, она"), new TranslateEntity(languageMap.get("en"), "he, she, that person")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あの方", template.save(
                new Word("あの方", "あのかた",
                        List.of(new TranslateEntity(languageMap.get("ru"), "он, она (вежливее чем あの人)"), new TranslateEntity(languageMap.get("en"), "he, she")),
                        List.of(partOfSpeechMap.get("pn"), partOfSpeechMap.get("hon")))));

        wordsMap.put("先生", template.save(
                new Word("先生", "せんせい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "учитель, преподаватель (не употребляется о себе)"), new TranslateEntity(languageMap.get("en"), "teacher, master, doctor (can't use for myself)")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("hon")))));

        wordsMap.put("教師", template.save(
                new Word("教師", "きょうし",
                        List.of(new TranslateEntity(languageMap.get("ru"), "учитель, преподаватель (употребляется о себе)"), new TranslateEntity(languageMap.get("en"), "teacher (can use for myself)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("学生", template.save(
                new Word("学生", "がくせい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "студент"), new TranslateEntity(languageMap.get("en"), "student")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("会社員", template.save(
                new Word("会社員", "かいしゃいん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "служащий фирмы"), new TranslateEntity(languageMap.get("en"), "company employee")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("社員", template.save(
                new Word("社員", "しゃいん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "служащий фирмы ~ (послелог указывающий на то, какой фирмы)"), new TranslateEntity(languageMap.get("en"), "1) company employee 2) member of a corporation; company stockholder")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("銀行員", template.save(
                new Word("銀行員", "ぎんこういん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "служащий банка"), new TranslateEntity(languageMap.get("en"), "bank employee; bank staff member; bank clerk")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("医者", template.save(
                new Word("医者", "いしゃ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "врач"), new TranslateEntity(languageMap.get("en"), "doctor; physician")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("研究者", template.save(
                new Word("研究者", "けんきゅうしゃ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "исследователь, ученый"), new TranslateEntity(languageMap.get("en"), "researcher")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("大学", template.save(
                new Word("大学", "だいがく",
                        List.of(new TranslateEntity(languageMap.get("ru"), "университет"), new TranslateEntity(languageMap.get("en"), "university; college")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("病院", template.save(
                new Word("病院", "びょういん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "больница"), new TranslateEntity(languageMap.get("en"), "hospital")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("誰", template.save(
                new Word("誰", "だれ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "кто"), new TranslateEntity(languageMap.get("en"), "who")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("どなた", template.save(
                new Word("どなた", "どなた",
                        List.of(new TranslateEntity(languageMap.get("ru"), "кто (вежливее чем だれ)"), new TranslateEntity(languageMap.get("en"), "who (respectful)")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("hon")))));

        wordsMap.put("何歳", template.save(
                new Word("何歳", "なんさい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "сколько лет?"), new TranslateEntity(languageMap.get("en"), "how old?; what age?")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("いくつ", template.save(
                new Word("いくつ", "いくつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "сколько лет? (вежливый вариант 何歳)"), new TranslateEntity(languageMap.get("en"), "how many?; (2) how old? (respectful)")),
                        List.of(partOfSpeechMap.get("adv")))));

        wordsMap.put("はい", template.save(
                new Word("はい", "はい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "да"), new TranslateEntity(languageMap.get("en"), "yes")),
                        List.of(partOfSpeechMap.get("int")))));

        wordsMap.put("いいえ", template.save(
                new Word("いいえ", "いいえ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "нет"), new TranslateEntity(languageMap.get("en"), "no")),
                        List.of(partOfSpeechMap.get("int")))));

        wordsMap.put("国", template.save(
                new Word("国", "くに",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) страна, государство 2) родина"), new TranslateEntity(languageMap.get("en"), "1) country, state 2) region 3) national government, central government; (4) home")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("言葉", template.save(
                new Word("言葉", "ことば",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) слово; слова 2) язык 3) диалект"), new TranslateEntity(languageMap.get("en"), "1) language, dialect 2) word, words, phrase, term, expression, remark 3) speech")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("アメリカ", template.save(
                new Word("アメリカ", "アメリカ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "сша"), new TranslateEntity(languageMap.get("en"), "1) America 2) United States of America")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("イギリス", template.save(
                new Word("イギリス", "イギリス",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Англия"), new TranslateEntity(languageMap.get("en"), "1) United Kingdom, Britain, Great Britain 2) England")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("イタリア", template.save(
                new Word("イタリア", "イタリア",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Италия"), new TranslateEntity(languageMap.get("en"), "Italy")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("イラン", template.save(
                new Word("イラン", "イラン",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Иран"), new TranslateEntity(languageMap.get("en"), "Iran")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("韓国", template.save(
                new Word("韓国", "かんこく",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Корея (южная)"), new TranslateEntity(languageMap.get("en"), "South Korea, Republic of Korea")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("スペイン", template.save(
                new Word("スペイン", "スペイン",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Испания"), new TranslateEntity(languageMap.get("en"), "Spain")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ドイツ", template.save(
                new Word("ドイツ", "ドイツ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Германия"), new TranslateEntity(languageMap.get("en"), "Germany")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日本", template.save(
                new Word("日本", "にほん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Япония"), new TranslateEntity(languageMap.get("en"), "Japan")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ロシア", template.save(
                new Word("ロシア", "ロシア",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Россия"), new TranslateEntity(languageMap.get("en"), "Russia")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("中国", template.save(
                new Word("中国", "ちゅうごく",
                        List.of(new TranslateEntity(languageMap.get("ru"), "Китай"), new TranslateEntity(languageMap.get("en"), "China")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("アメリカ人", template.save(
                new Word("アメリカ人", "アメリカじん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "американец"), new TranslateEntity(languageMap.get("en"), "American person")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("韓国人", template.save(
                new Word("韓国人", "かんこくじん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "кореец"), new TranslateEntity(languageMap.get("en"), "South Korean person")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("中国人", template.save(
                new Word("中国人", "ちゅうごくじん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "китаец"), new TranslateEntity(languageMap.get("en"), "Chinese person")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日本人", template.save(
                new Word("日本人", "にほんじん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "японец"), new TranslateEntity(languageMap.get("en"), "Japanese person, Japanese people")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ロシア人", template.save(
                new Word("ロシア人", "ロシアじん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "русский"), new TranslateEntity(languageMap.get("en"), "Russian (person, people)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("英語", template.save(
                new Word("英語", "えいご",
                        List.of(new TranslateEntity(languageMap.get("ru"), "английский язык"), new TranslateEntity(languageMap.get("en"), "English (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("韓国語", template.save(
                new Word("韓国語", "かんこくご",
                        List.of(new TranslateEntity(languageMap.get("ru"), "корейский язык"), new TranslateEntity(languageMap.get("en"), "Korean (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日本語", template.save(
                new Word("日本語", "にほんご",
                        List.of(new TranslateEntity(languageMap.get("ru"), "японский язык"), new TranslateEntity(languageMap.get("en"), "Japanese (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ロシア語", template.save(
                new Word("ロシア語", "ロシアご",
                        List.of(new TranslateEntity(languageMap.get("ru"), "русский язык"), new TranslateEntity(languageMap.get("en"), "Russian (language)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("本", template.save(
                new Word("本", "ほん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "книга"), new TranslateEntity(languageMap.get("en"), "book")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("辞書", template.save(
                new Word("辞書", "じしょ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "фонетический словарь"), new TranslateEntity(languageMap.get("en"), "dictionary, lexicon")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("雑誌", template.save(
                new Word("雑誌", "ざっし",
                        List.of(new TranslateEntity(languageMap.get("ru"), "журнал"), new TranslateEntity(languageMap.get("en"), "journal, magazine, periodical")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("新聞", template.save(
                new Word("新聞", "しんぶん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "газета"), new TranslateEntity(languageMap.get("en"), "newspaper")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ノート", template.save(
                new Word("ノート", "ノート",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) записная книжка, блокнот 2) записки, записи 3) ноутбук"), new TranslateEntity(languageMap.get("en"), "notebook, copy-book, exercise book")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("手帳", template.save(
                new Word("手帳", "てちょう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "тетрадь; записная книжка, блокнот"), new TranslateEntity(languageMap.get("en"), "notebook; memo pad")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("名刺", template.save(
                new Word("名刺", "めいし",
                        List.of(new TranslateEntity(languageMap.get("ru"), "визитная карточка"), new TranslateEntity(languageMap.get("en"), "business card")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("カード", template.save(
                new Word("カード", "カード",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) карточка 2) кредитная карточка"), new TranslateEntity(languageMap.get("en"), "card")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("鉛筆", template.save(
                new Word("鉛筆", "えんぴつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "карандаш"), new TranslateEntity(languageMap.get("en"), "pencil")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("ボールペン", template.save(
                new Word("ボールペン", "ボールペン",
                        List.of(new TranslateEntity(languageMap.get("ru"), "шариковая ручка"), new TranslateEntity(languageMap.get("en"), "ball-point pen")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("シャープペンシル", template.save(
                new Word("シャープペンシル", "シャープペンシル",
                        List.of(new TranslateEntity(languageMap.get("ru"), "механический карандаш"), new TranslateEntity(languageMap.get("en"), "propelling pencil, mechanical pencil")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("鍵", template.save(
                new Word("鍵", "かぎ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "ключ"), new TranslateEntity(languageMap.get("en"), "key")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("時計", template.save(
                new Word("時計", "とけい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "часы"), new TranslateEntity(languageMap.get("en"), "watch, clock, timepiece")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("傘", template.save(
                new Word("傘", "かさ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "зонт, зонтик"), new TranslateEntity(languageMap.get("en"), "umbrella, parasol")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("かばん", template.save(
                new Word("かばん", "かばん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "саквояж, чемодан; портфель"), new TranslateEntity(languageMap.get("en"), "bag, satchel, briefcase, basket")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("テレビ", template.save(
                new Word("テレビ", "テレビ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) телевидение 2) телевизор"), new TranslateEntity(languageMap.get("en"), "1) television, TV 2) TV program, TV programme, TV broadcast")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("カメラ", template.save(
                new Word("カメラ", "カメラ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) фотоаппарат, кинокамера 2) камера фотоаппарата"), new TranslateEntity(languageMap.get("en"), "camera")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("コンピューター", template.save(
                new Word("コンピューター", "コンピューター",
                        List.of(new TranslateEntity(languageMap.get("ru"), "компьютер"), new TranslateEntity(languageMap.get("en"), "computer")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("車", template.save(
                new Word("車", "くるま",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) машина, повозка 2) колесо"), new TranslateEntity(languageMap.get("en"), "1) car, automobile, vehicle, 2) wheel")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("机", template.save(
                new Word("机", "つくえ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "стол, парта"), new TranslateEntity(languageMap.get("en"), "desk")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("椅子", template.save(
                new Word("椅子", "いす",
                        List.of(new TranslateEntity(languageMap.get("ru"), "стул"), new TranslateEntity(languageMap.get("en"), "1) chair, stool 2) post, office, position")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("チョコレート", template.save(
                new Word("チョコレート歳", "チョコレート",
                        List.of(new TranslateEntity(languageMap.get("ru"), "шоколад"), new TranslateEntity(languageMap.get("en"), "chocolate")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("コーヒー", template.save(
                new Word("コーヒー", "コーヒー",
                        List.of(new TranslateEntity(languageMap.get("ru"), "кофе"), new TranslateEntity(languageMap.get("en"), "coffee")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("土産", template.save(
                new Word("土産", "みやげ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "подарок, гостинец; сувенир"), new TranslateEntity(languageMap.get("en"), "present, souvenir")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("何", template.save(
                new Word("何", "なん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "что"), new TranslateEntity(languageMap.get("en"), "what?")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("これ", template.save(
                new Word("これ", "これ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "это (о предмете, более близком к говорящему)"), new TranslateEntity(languageMap.get("en"), "this (indicating an item near the speaker, the action of the speaker, or the current topic)")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("それ", template.save(
                new Word("それ", "それ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "то (о предмете, более близком к говорящему)"), new TranslateEntity(languageMap.get("en"), "that (indicating an item or person near the listener, the action of the listener, or something on their mind)")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("あれ", template.save(
                new Word("あれ", "あれ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "то (о предмете, равноудаленном к собеседникам)"), new TranslateEntity(languageMap.get("en"), "1) that (indicating something distant from both speaker and listener (in space, time or psychologically), or something understood without naming it directly)")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("名", template.save(
                new Word("名", "な",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) имя, название, наименование 2) имя, репутация, честь 3) имя, известность"), new TranslateEntity(languageMap.get("en"), "1) name, given name 2) title 3) fame, renown, reputation")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("有名", template.save(
                new Word("有名", "ゆうめい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "знаменитый, известный"), new TranslateEntity(languageMap.get("en"), "how old?; what age?")),
                        List.of(partOfSpeechMap.get("adj-na")))));

        wordsMap.put("方法", template.save(
                new Word("方法", "ほうほう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) способ, метод; средство, мера 2) план, программа"), new TranslateEntity(languageMap.get("en"), "method; process; manner; way; means; technique")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("方", template.save(
                new Word("方", "ほう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "направление; сторона"), new TranslateEntity(languageMap.get("en"), "direction, way, side, area (in a particular direction)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("人", template.save(
                new Word("人", "ひと",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) человек, люди 2) личность, характер"), new TranslateEntity(languageMap.get("en"), "1) man; person 2) human being, mankind, people")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("日", template.save(
                new Word("日", "ひ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) день"), new TranslateEntity(languageMap.get("en"), "1) day, days 2) sun, sunshine, sunlight")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("毎日", template.save(
                new Word("毎日", "まいにち",
                        List.of(new TranslateEntity(languageMap.get("ru"), "каждый день, ежедневно, день за днём, изо дня в день"), new TranslateEntity(languageMap.get("en"), "every day")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("大きい", template.save(
                new Word("大きい", "おおきい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "большой, крупный"), new TranslateEntity(languageMap.get("en"), "1) big, large, great 2) loud 3) extensive, spacious")),
                        List.of(partOfSpeechMap.get("adj-i")))));

        wordsMap.put("大いに", template.save(
                new Word("大いに", "おおいに",
                        List.of(new TranslateEntity(languageMap.get("ru"), "очень, весьма, в высшей степени"), new TranslateEntity(languageMap.get("en"), "very; much; greatly; a lot of")),
                        List.of(partOfSpeechMap.get("adv")))));

        wordsMap.put("学ぶ", template.save(
                new Word("学ぶ", "まなぶ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "учиться чему-л., изучать что-л.; обучаться"), new TranslateEntity(languageMap.get("en"), "to study (in depth), to learn, to take lessons in")),
                        List.of(partOfSpeechMap.get("v"), partOfSpeechMap.get("v5b")))));

        wordsMap.put("社", template.save(
                new Word("社", "やしろ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "[синтоистский] храм"), new TranslateEntity(languageMap.get("en"), "shrine (usually Shinto)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("会う", template.save(
                new Word("会う", "あう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) (に) [по]встречаться с кем-л.; видеться с кем-л. 2) встретить что-л.; перенести, испытать что-л."), new TranslateEntity(languageMap.get("en"), "1) to meet, to encounter, to see 2) to have an accident, to have a bad experience")),
                        List.of(partOfSpeechMap.get("v"), partOfSpeechMap.get("v5u"), partOfSpeechMap.get("vi")))));

        wordsMap.put("会社", template.save(
                new Word("会社", "かいしゃ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "компания, общество, фирма"), new TranslateEntity(languageMap.get("en"), "1) company, corporation 2) workplace")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("先", template.save(
                new Word("先", "さき",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) первенство 2) раньше, прежде 3) заранее; до того как 4) дальше, далее; впереди чего-л.; в сторону от чего-л."), new TranslateEntity(languageMap.get("en"), "1) previous, prior, former, first, earlier, some time ago, preceding 2) point (e.g. pencil), tip, end, nozzle 3) head (of a line), front")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("prefix")))));

        wordsMap.put("生きる", template.save(
                new Word("生きる", "いきる",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) жить, быть живым 2) (жарг.) восстанавливать зачёркнутое (в корректуре)"), new TranslateEntity(languageMap.get("en"), "1) to live, to exist 2) to make a living, to subsist 3) to be in effect, to be in use, to function 4) to come to life, to be enlivened 5) to be safe (in baseball, go, etc.)")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("生かす", template.save(
                new Word("生かす", "いかす",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) оживлять, воскрешать; обр. оживить; вдохнуть жизнь во что-л. 2) оставлять в живых; сохранять в живом виде"), new TranslateEntity(languageMap.get("en"), "1) to make (the best) use of, to put to good use, to leverage (skills, attributes, experience, etc.), to capitalise on (experience, etc.) 2) to let live, to keep alive 3) to revive, to resuscitate, to bring back to life 4) to restore (a deleted passage; in proofreading)")),
                        List.of(partOfSpeechMap.get("v5s"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生ける", template.save(
                new Word("生ける", "いける",
                        List.of(new TranslateEntity(languageMap.get("ru"), "живой"), new TranslateEntity(languageMap.get("en"), "1) to arrange (flowers), to plant 2) living, live")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生まれる", template.save(
                new Word("生まれる", "うまれる",
                        List.of(new TranslateEntity(languageMap.get("ru"), "родиться, появиться на свет"), new TranslateEntity(languageMap.get("en"), "to be born")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("生む", template.save(
                new Word("生む", "うむ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) рождать, рожать, производить на свет; плодиться 2) порождать, приносить"), new TranslateEntity(languageMap.get("en"), "1) to give birth, to bear (child), to lay (eggs) 2) to produce, to yield, to give rise to, to deliver")),
                        List.of(partOfSpeechMap.get("v5m"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生える", template.save(
                new Word("生える", "はえる",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) расти (о растениях) 2) расти (о волосах, ногтях, тж. о крыльях у птиц); прорезаться (о зубах)"), new TranslateEntity(languageMap.get("en"), "1) to grow, to spring up, to sprout 2) to cut (teeth)")),
                        List.of(partOfSpeechMap.get("v1"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("生やす", template.save(
                new Word("生やす", "はやす",
                        List.of(new TranslateEntity(languageMap.get("ru"), "отращивать, отпускать (бороду, усы)"), new TranslateEntity(languageMap.get("en"), "to grow; to cultivate; to wear a beard")),
                        List.of(partOfSpeechMap.get("v5s"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("生", template.save(
                new Word("生", "なま",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) сырой 2) (перен.) необработанный, полусырой, неспелый, зелёный"), new TranslateEntity(languageMap.get("en"), "1) raw, uncooked, fresh 2) natural, as it is, unedited, unprocessed 3) (col) unprotected (sex) 4) live (i.e. not recorded) 5) inexperienced, unpolished, green, crude")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("銀行", template.save(
                new Word("銀行", "ぎんこう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "банк"), new TranslateEntity(languageMap.get("en"), "bank")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("行く", template.save(
                new Word("行く", "いく, ゆく",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) идти, ходить (о ком-л.) 2) идти, ехать, направляться, следовать куда-л. (о ком-л.; тж. о поезде, пароходе и т. п.); вести куда-л. (о дороге) 3) [по]бывать где-л. "), new TranslateEntity(languageMap.get("en"), "1) to go, to move, to head (towards), to be transported (towards), to reach 2) to proceed, to take place 3) to pass through, to come and go 4) to walk")),
                        List.of(partOfSpeechMap.get("vi"), partOfSpeechMap.get("v5k-s"), partOfSpeechMap.get("v")))));

        wordsMap.put("行う", template.save(
                new Word("行う", "おこなう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) делать, совершать, производить 2) выполнять, осуществлять, проводить [в жизнь]"), new TranslateEntity(languageMap.get("en"), "to perform; to do; to conduct oneself; to carry out")),
                        List.of(partOfSpeechMap.get("v5u"), partOfSpeechMap.get("vt"), partOfSpeechMap.get("v")))));

        wordsMap.put("来年", template.save(
                new Word("来年", "らいねん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "будущий (следующий) год"), new TranslateEntity(languageMap.get("en"), "next year")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("来る", template.save(
                new Word("来る", "くる",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) приходить, прибывать; приезжать; приходить в гости 2) приходить, наступать (о чём-л.) 3) происходить, проистекать (из чего-л.)"), new TranslateEntity(languageMap.get("en"), "1) to come (spatially or temporally); to approach; to arrive; (vk,vi,aux-v) (2) (See 行って来る) to come back; to do ... and come back; (3) to come to be; to become; to get; to grow; to continue")),
                        List.of(partOfSpeechMap.get("vk"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("電車", template.save(
                new Word("電車", "でんしゃ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "трамвай"), new TranslateEntity(languageMap.get("en"), "train; electric train")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("二十歳", template.save(
                new Word("二十歳", "はたち",
                        List.of(new TranslateEntity(languageMap.get("ru"), "двадцатилетний возраст; двадцать лет [от роду]"), new TranslateEntity(languageMap.get("en"), "1) 20 years old")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("失礼", template.save(
                new Word("失礼", "しつれい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) невежливость, грубость 2) (при извинении)"), new TranslateEntity(languageMap.get("en"), "1) discourtesy; impoliteness 2) excuse me; goodbye 3) to leave 4) to be rude")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("vs"), partOfSpeechMap.get("adj-na")))));

        wordsMap.put("木", template.save(
                new Word("木", "き",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) дерево, деревцо 2) дерево, лес (как материал)"), new TranslateEntity(languageMap.get("en"), "wood (first of the five elements)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("月曜日", template.save(
                new Word("月曜日", "げつようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "понедельник"), new TranslateEntity(languageMap.get("en"), "Monday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("火曜日", template.save(
                new Word("火曜日", "かようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "вторник"), new TranslateEntity(languageMap.get("en"), "Tuesday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("水曜日", template.save(
                new Word("水曜日", "すいようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "среда"), new TranslateEntity(languageMap.get("en"), "Wednesday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("木曜日", template.save(
                new Word("木曜日", "もくようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "четверг"), new TranslateEntity(languageMap.get("en"), "Thursday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("金曜日", template.save(
                new Word("金曜日", "きんようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "пятница"), new TranslateEntity(languageMap.get("en"), "Friday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("土曜日", template.save(
                new Word("土曜日", "どようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "суббота"), new TranslateEntity(languageMap.get("en"), "Saturday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("日曜日", template.save(
                new Word("日曜日", "にちようび",
                        List.of(new TranslateEntity(languageMap.get("ru"), "воскресенье"), new TranslateEntity(languageMap.get("en"), "Sunday")),
                        List.of(partOfSpeechMap.get("n-adv"), partOfSpeechMap.get("n-t")))));

        wordsMap.put("月", template.save(
                new Word("月", "つき",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) луна, месяц 2) месяц (календарный)"), new TranslateEntity(languageMap.get("en"), "1) moon 2) month")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("三日", template.save(
                new Word("", "",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) третье [число] 2) три дня"), new TranslateEntity(languageMap.get("en"), "1) the third day of the month 2) three days")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("山", template.save(
                new Word("山", "やま",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) гора 2) лес 3) (тж. 鉱山) рудник"), new TranslateEntity(languageMap.get("en"), "1) mountain; hill 2) mine (e.g. coal mine) 3) heap; pile")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("ctr")))));

        wordsMap.put("火山", template.save(
                new Word("火山", "かざん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "вулкан"), new TranslateEntity(languageMap.get("en"), "volcano")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("富士山", template.save(
                new Word("富士山", "ふじさん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "гора Фудзи"), new TranslateEntity(languageMap.get("en"), "Mount Fuji; Mt. Fuji; Fujiyama; Fuji-san")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("川", template.save(
                new Word("川", "かわ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "река"), new TranslateEntity(languageMap.get("en"), "1) river; stream; (suf) 2) (suffix used with the names of rivers) River; the ... river")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("suf")))));

        wordsMap.put("河川", template.save(
                new Word("河川", "かせん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "реки"), new TranslateEntity(languageMap.get("en"), "rivers")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("田", template.save(
                new Word("田", "た",
                        List.of(new TranslateEntity(languageMap.get("ru"), "[заболоченное] рисовое поле"), new TranslateEntity(languageMap.get("en"), "rice field")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("田んぼ", template.save(
                new Word("田んぼ", "たんぼ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "рисовое поле"), new TranslateEntity(languageMap.get("en"), "paddy field; farm")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("水田", template.save(
                new Word("水田", "すいでん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "заливное [рисовое] поле"), new TranslateEntity(languageMap.get("en"), "(water-filled) paddy field")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("三人", template.save(
                new Word("三人", "さんにん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "три человека"), new TranslateEntity(languageMap.get("en"), "three people")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("口", template.save(
                new Word("口", "くち",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) рот; уста, губы 2) язык, речь; слова 3) вкус 4) вход, выход; ход куда-л.; место начала подъёма (на гору)"), new TranslateEntity(languageMap.get("en"), "1) mouth; (2) opening; hole; gap; orifice; (3) mouth (of a bottle); spout; nozzle; mouthpiece; (4) gate; door; entrance; exit")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("出口", template.save(
                new Word("出口", "でぐち",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) выход 2) выпускное (выходное) отверстие"), new TranslateEntity(languageMap.get("en"), "exit; gateway; way out; outlet; leak; vent")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("入り口", template.save(
                new Word("入り口", "いりぐち",
                        List.of(new TranslateEntity(languageMap.get("ru"), "вход"), new TranslateEntity(languageMap.get("en"), "entrance; entry; gate; approach; mouth")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("人口", template.save(
                new Word("人口", "じんこう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "население, численность населения; число жителей; численность людского состава"), new TranslateEntity(languageMap.get("en"), "1) population 2) common talk")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("自動車", template.save(
                new Word("自動車", "じどうしゃ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "автомобиль, [авто]машина"), new TranslateEntity(languageMap.get("en"), "automobile")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("門", template.save(
                new Word("門", "かど",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) ворота 2) научная школа; школа (научное направление) какого-л. учёного 3) раздел, разряд"), new TranslateEntity(languageMap.get("en"), "gate")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-suf")))));

        wordsMap.put("専門", template.save(
                new Word("専門", "せんもん",
                        List.of(new TranslateEntity(languageMap.get("ru"), "специальность"), new TranslateEntity(languageMap.get("en"), "speciality; specialty; subject of study; expert; area of expertise")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("火", template.save(
                new Word("火", "ひ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) огонь, пламя 2) пожар"), new TranslateEntity(languageMap.get("en"), "fire; flame; blaze")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-suf")))));

        wordsMap.put("水", template.save(
                new Word("水", "みず",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) вода; холодная вода 2) жидкость"), new TranslateEntity(languageMap.get("en"), "1) water (esp. cool, fresh water, e.g. drinking water); (2) fluid (esp. in an animal tissue); liquid; (3) flood; floodwaters")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("金", template.save(
                new Word("金", "かね",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) металл 2) деньги"), new TranslateEntity(languageMap.get("en"), "1) (See お金) money 2) metal")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("土", template.save(
                new Word("土", "つち",
                        List.of(new TranslateEntity(languageMap.get("ru"), "земля"), new TranslateEntity(languageMap.get("en"), "1) earth; soil; dirt; clay; mud; (2) the earth (historically, esp. as opposed to the heavens); the ground; the land")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("土木", template.save(
                new Word("土木", "どぼく",
                        List.of(new TranslateEntity(languageMap.get("ru"), "инженерные (строительные) работы"), new TranslateEntity(languageMap.get("en"), "engineering works; civil engineering; public works")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("子", template.save(
                new Word("子", "こ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) ребёнок, дитя 2) детёныш"), new TranslateEntity(languageMap.get("en"), "1) child (2) young (animal)")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-suf")))));

        wordsMap.put("子供", template.save(
                new Word("子供", "こども",
                        List.of(new TranslateEntity(languageMap.get("ru"), "ребёнок, дитя; сын; дочь; дети"), new TranslateEntity(languageMap.get("en"), "child")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女子学生", template.save(
                new Word("女子学生", "じょしがくせい",
                        List.of(new TranslateEntity(languageMap.get("ru"), "студентка"), new TranslateEntity(languageMap.get("en"), "female student")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女の子", template.save(
                new Word("女の子", "おんなのこ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "девочка"), new TranslateEntity(languageMap.get("en"), "girl")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女子", template.save(
                new Word("女子", "じょし",
                        List.of(new TranslateEntity(languageMap.get("ru"), "женщина, девушка"), new TranslateEntity(languageMap.get("en"), "woman; girl")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("女", template.save(
                new Word("女", "おんな",
                        List.of(new TranslateEntity(languageMap.get("ru"), "женщина"), new TranslateEntity(languageMap.get("en"), "1) female; woman; female sex; (n) (2) female lover; girlfriend; mistress; (someone's) woman")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("n-pref")))));

        wordsMap.put("女の人", template.save(
                new Word("女の人", "おんなのひと",
                        List.of(new TranslateEntity(languageMap.get("ru"), "женщина"), new TranslateEntity(languageMap.get("en"), "woman")),
                        List.of(partOfSpeechMap.get("n"), partOfSpeechMap.get("exp")))));

        wordsMap.put("彼女", template.save(
                new Word("彼女", "かのじょ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "она"), new TranslateEntity(languageMap.get("en"), "1) she; her 2) girlfriend")),
                        List.of(partOfSpeechMap.get("pn")))));

        wordsMap.put("学校", template.save(
                new Word("学校", "がっこう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) школа, училище; учебное заведение 2) (перен.) занятия (в учебном заведении)"), new TranslateEntity(languageMap.get("en"), "school")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("先月", template.save(
                new Word("先月", "せんげつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "прошлый месяц"), new TranslateEntity(languageMap.get("en"), "last month")),
                        List.of(partOfSpeechMap.get("n-t"), partOfSpeechMap.get("n-adv")))));

        wordsMap.put("私立大学", template.save(
                new Word("私立大学", "しりつだいがく",
                        List.of(new TranslateEntity(languageMap.get("ru"), "частный колледж (университет)"), new TranslateEntity(languageMap.get("en"), "private university")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("私立", template.save(
                new Word("私立", "しりつ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "частный (содержащийся на частные средства)"), new TranslateEntity(languageMap.get("en"), "private (establishment)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("火事", template.save(
                new Word("火事", "かじ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "пожар"), new TranslateEntity(languageMap.get("en"), "fire; conflagration")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("生年月日", template.save(
                new Word("生年月日", "せいねんがっぴ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "дата рождения"), new TranslateEntity(languageMap.get("en"), "birth date; date of birth")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("違う", template.save(
                new Word("違う", "ちがう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "1) отличаться от чего-л., расходиться с чем-л. 2) нарушать что-л., идти против чего-л."), new TranslateEntity(languageMap.get("en"), "1) to differ (from); to vary 2) to not be in the usual condition 3) to not match the correct")),
                        List.of(partOfSpeechMap.get("v5u"), partOfSpeechMap.get("vi"), partOfSpeechMap.get("v")))));

        wordsMap.put("神戸", template.save(
                new Word("神戸", "こうべ",
                        List.of(new TranslateEntity(languageMap.get("ru"), "г. Кобэ"), new TranslateEntity(languageMap.get("en"), "Kobe (city)")),
                        List.of(partOfSpeechMap.get("n")))));

        wordsMap.put("そう", template.save(
                new Word("そう", "そう",
                        List.of(new TranslateEntity(languageMap.get("ru"), "так"), new TranslateEntity(languageMap.get("en"), "1) so; really; seeming; (adj-na,suf) 2) (after masu stem or adj-stem) appearing that; seeming that; looking like; having the appearance of")),
                        List.of(partOfSpeechMap.get("adv")))));




/*
        wordsMap.put("", template.save(
                new Word("", "",
                        List.of(new TranslateEntity(languageMap.get("ru"), ""), new TranslateEntity(languageMap.get("en"), "")),
                        List.of(partOfSpeechMap.get("")))));
*/


    }
}
