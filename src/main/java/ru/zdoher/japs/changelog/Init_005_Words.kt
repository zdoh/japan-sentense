package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Language
import ru.zdoher.japs.domain.PartOfSpeech
import ru.zdoher.japs.domain.TranslateEntity
import ru.zdoher.japs.domain.Word

@ChangeLog(order = "005")
class Init_005_Words {

    @ChangeSet(order = "001", id = "initialWord", author = "zdoh", runAlways = true)
    fun initWord(template: MongoTemplate) {
        InitMaps.wordsMap["一つ"] = template.save(
            Word(
                wordKanji = "一つ",
                pronunciation = "ひとつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "один"),
                    TranslateEntity(InitMaps.languageMap["en"], "one")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["二つ"] = template.save(
            Word(
                wordKanji = "二つ",
                pronunciation = "ふたつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "два"),
                    TranslateEntity(InitMaps.languageMap["en"], "two")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["三つ"] = template.save(
            Word(
                wordKanji = "三つ",
                pronunciation = "みつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "три"),
                    TranslateEntity(InitMaps.languageMap["en"], "three")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["四つ"] = template.save(
            Word(
                wordKanji = "四つ",
                pronunciation = "よっつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "четыре"),
                    TranslateEntity(InitMaps.languageMap["en"], "four")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["五つ"] = template.save(
            Word(
                wordKanji = "五つ",
                pronunciation = "いつつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "пять"),
                    TranslateEntity(InitMaps.languageMap["en"], "five")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["六つ"] = template.save(
            Word(
                wordKanji = "六つ",
                pronunciation = "むっつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "шесть"),
                    TranslateEntity(InitMaps.languageMap["en"], "six")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["七つ"] = template.save(
            Word(
                wordKanji = "七つ",
                pronunciation = "ななつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "семь"),
                    TranslateEntity(InitMaps.languageMap["en"], "seven")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["八つ"] = template.save(
            Word(
                wordKanji = "八つ",
                pronunciation = "やっつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "восемь"),
                    TranslateEntity(InitMaps.languageMap["en"], "eight")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["九つ"] = template.save(
            Word(
                wordKanji = "九つ",
                pronunciation = "ここのつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "девять"),
                    TranslateEntity(InitMaps.languageMap["en"], "nine")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["十"] = template.save(
            Word(
                wordKanji = "十",
                pronunciation = "とお",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "десять"),
                    TranslateEntity(InitMaps.languageMap["en"], "ten")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["num"])
            )
        )
        InitMaps.wordsMap["一月"] = template.save(
            Word(
                wordKanji = "一月",
                pronunciation = "いちがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "январь"),
                    TranslateEntity(InitMaps.languageMap["en"], "january")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["二月"] = template.save(
            Word(
                wordKanji = "二月",
                pronunciation = "にがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "февраль"),
                    TranslateEntity(InitMaps.languageMap["en"], "february")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["三月"] = template.save(
            Word(
                wordKanji = "三月",
                pronunciation = "さんがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "март"),
                    TranslateEntity(InitMaps.languageMap["en"], "march")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["四月"] = template.save(
            Word(
                wordKanji = "四月",
                pronunciation = "しがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "апрель"),
                    TranslateEntity(InitMaps.languageMap["en"], "april")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["五月"] = template.save(
            Word(
                wordKanji = "五月",
                pronunciation = "ごがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "май"),
                    TranslateEntity(InitMaps.languageMap["en"], "may")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["六月"] = template.save(
            Word(
                wordKanji = "六月",
                pronunciation = "ろくがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "июнь"),
                    TranslateEntity(InitMaps.languageMap["en"], "june")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["七月"] = template.save(
            Word(
                wordKanji = "七月",
                pronunciation = "しちがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "июль"),
                    TranslateEntity(InitMaps.languageMap["en"], "jule")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["八月"] = template.save(
            Word(
                wordKanji = "八月",
                pronunciation = "はちがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "август"),
                    TranslateEntity(InitMaps.languageMap["en"], "august")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["九月"] = template.save(
            Word(
                wordKanji = "九月",
                pronunciation = "くがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "сентябрь"),
                    TranslateEntity(InitMaps.languageMap["en"], "september")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["十月"] = template.save(
            Word(
                wordKanji = "十月",
                pronunciation = "じゅうがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "октябрь"),
                    TranslateEntity(InitMaps.languageMap["en"], "october")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["十一月"] = template.save(
            Word(
                wordKanji = "十一月",
                pronunciation = "じゅういちがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "ноябрь"),
                    TranslateEntity(InitMaps.languageMap["en"], "november")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["十二月"] = template.save(
            Word(
                wordKanji = "十二月",
                pronunciation = "じゅうにがつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "декабрь"),
                    TranslateEntity(InitMaps.languageMap["en"], "december")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["十日"] = template.save(
            Word(
                wordKanji = "十日",
                pronunciation = "とおか",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) десятый день месяца 2) десять дней"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) the tenth day of the month 2)  ten days")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["私"] = template.save(
            Word(
                wordKanji = "私",
                pronunciation = "わたし",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "я"),
                    TranslateEntity(InitMaps.languageMap["en"], "i")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["あなた"] = template.save(
            Word(
                wordKanji = "あたな",
                pronunciation = "あなた",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "ты (вы)"),
                    TranslateEntity(InitMaps.languageMap["en"], "you")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["あの人"] = template.save(
            Word(
                wordKanji = "あの人",
                pronunciation = "あのひと",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "он, она"),
                    TranslateEntity(InitMaps.languageMap["en"], "he, she, that person")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["あの方"] = template.save(
            Word(
                wordKanji = "あの方",
                pronunciation = "あのかた",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "он, она (вежливее чем あの人)"),
                    TranslateEntity(InitMaps.languageMap["en"], "he, she")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"], InitMaps.partOfSpeechMap["hon"])
            )
        )
        InitMaps.wordsMap["先生"] = template.save(
            Word(
                wordKanji = "先生",
                pronunciation = "せんせい",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "учитель, преподаватель (не употребляется о себе)"
                    ), TranslateEntity(InitMaps.languageMap["en"], "teacher, master, doctor (can't use for myself)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["hon"])
            )
        )
        InitMaps.wordsMap["教師"] = template.save(
            Word(
                wordKanji = "教師",
                pronunciation = "きょうし",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "учитель, преподаватель (употребляется о себе)"
                    ), TranslateEntity(InitMaps.languageMap["en"], "teacher (can use for myself)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["学生"] = template.save(
            Word(
                wordKanji = "学生",
                pronunciation = "がくせい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "студент"),
                    TranslateEntity(InitMaps.languageMap["en"], "student")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["会社員"] = template.save(
            Word(
                wordKanji = "会社員",
                pronunciation = "かいしゃいん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "служащий фирмы"),
                    TranslateEntity(InitMaps.languageMap["en"], "company employee")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["社員"] = template.save(
            Word(
                wordKanji = "社員",
                pronunciation = "しゃいん",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "служащий фирмы ~ (послелог указывающий на то, какой фирмы)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) company employee 2) member of a corporation; company stockholder"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["銀行員"] = template.save(
            Word(
                wordKanji = "銀行員",
                pronunciation = "ぎんこういん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "служащий банка"),
                    TranslateEntity(InitMaps.languageMap["en"], "bank employee; bank staff member; bank clerk")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["医者"] = template.save(
            Word(
                wordKanji = "医者",
                pronunciation = "いしゃ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "врач"),
                    TranslateEntity(InitMaps.languageMap["en"], "doctor; physician")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["研究者"] = template.save(
            Word(
                wordKanji = "研究者",
                pronunciation = "けんきゅうしゃ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "исследователь, ученый"),
                    TranslateEntity(InitMaps.languageMap["en"], "researcher")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["大学"] = template.save(
            Word(
                wordKanji = "大学",
                pronunciation = "だいがく",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "университет"),
                    TranslateEntity(InitMaps.languageMap["en"], "university; college")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["病院"] = template.save(
            Word(
                wordKanji = "病院",
                pronunciation = "びょういん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "больница"),
                    TranslateEntity(InitMaps.languageMap["en"], "hospital")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["誰"] = template.save(
            Word(
                wordKanji = "誰",
                pronunciation = "だれ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "кто"),
                    TranslateEntity(InitMaps.languageMap["en"], "who")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["どなた"] = template.save(
            Word(
                wordKanji = "どなた",
                pronunciation = "どなた",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "кто (вежливее чем だれ)"),
                    TranslateEntity(InitMaps.languageMap["en"], "who (respectful)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["hon"])
            )
        )
        InitMaps.wordsMap["何歳"] = template.save(
            Word(
                wordKanji = "何歳",
                pronunciation = "なんさい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "сколько лет?"),
                    TranslateEntity(InitMaps.languageMap["en"], "how old?; what age?")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["いくつ"] = template.save(
            Word(
                wordKanji = "いくつ",
                pronunciation = "いくつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "сколько лет? (вежливый вариант 何歳)"),
                    TranslateEntity(InitMaps.languageMap["en"], "how many?; (2) how old? (respectful)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["adv"])
            )
        )
        InitMaps.wordsMap["はい"] = template.save(
            Word(
                wordKanji = "はい",
                pronunciation = "はい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "да"),
                    TranslateEntity(InitMaps.languageMap["en"], "yes")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["int"])
            )
        )
        InitMaps.wordsMap["いいえ"] = template.save(
            Word(
                wordKanji = "いいえ",
                pronunciation = "いいえ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "нет"),
                    TranslateEntity(InitMaps.languageMap["en"], "no")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["int"])
            )
        )
        InitMaps.wordsMap["国"] = template.save(
            Word(
                wordKanji = "国",
                pronunciation = "くに",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) страна, государство 2) родина"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) country, state 2) region 3) national government, central government; (4) home"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["言葉"] = template.save(
            Word(
                wordKanji = "言葉",
                pronunciation = "ことば",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) слово; слова 2) язык 3) диалект"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) language, dialect 2) word, words, phrase, term, expression, remark 3) speech"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["アメリカ"] = template.save(
            Word(
                wordKanji = "アメリカ",
                pronunciation = "アメリカ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "сша"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) America 2) United States of America")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["イギリス"] = template.save(
            Word(
                wordKanji = "イギリス",
                pronunciation = "イギリス",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Англия"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) United Kingdom, Britain, Great Britain 2) England")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["イタリア"] = template.save(
            Word(
                wordKanji = "イタリア",
                pronunciation = "イタリア",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Италия"),
                    TranslateEntity(InitMaps.languageMap["en"], "Italy")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["イラン"] = template.save(
            Word(
                wordKanji = "イラン",
                pronunciation = "イラン",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Иран"),
                    TranslateEntity(InitMaps.languageMap["en"], "Iran")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["韓国"] = template.save(
            Word(
                wordKanji = "韓国",
                pronunciation = "かんこく",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Корея (южная)"),
                    TranslateEntity(InitMaps.languageMap["en"], "South Korea, Republic of Korea")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["スペイン"] = template.save(
            Word(
                wordKanji = "スペイン",
                pronunciation = "スペイン",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Испания"),
                    TranslateEntity(InitMaps.languageMap["en"], "Spain")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["ドイツ"] = template.save(
            Word(
                wordKanji = "ドイツ",
                pronunciation = "ドイツ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Германия"),
                    TranslateEntity(InitMaps.languageMap["en"], "Germany")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["日本"] = template.save(
            Word(
                wordKanji = "日本",
                pronunciation = "にほん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Япония"),
                    TranslateEntity(InitMaps.languageMap["en"], "Japan")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["ロシア"] = template.save(
            Word(
                wordKanji = "ロシア",
                pronunciation = "ロシア",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Россия"),
                    TranslateEntity(InitMaps.languageMap["en"], "Russia")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["中国"] = template.save(
            Word(
                wordKanji = "中国",
                pronunciation = "ちゅうごく",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "Китай"),
                    TranslateEntity(InitMaps.languageMap["en"], "China")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["アメリカ人"] = template.save(
            Word(
                wordKanji = "アメリカ人",
                pronunciation = "アメリカじん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "американец"),
                    TranslateEntity(InitMaps.languageMap["en"], "American person")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["韓国人"] = template.save(
            Word(
                wordKanji = "韓国人",
                pronunciation = "かんこくじん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "кореец"),
                    TranslateEntity(InitMaps.languageMap["en"], "South Korean person")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["中国人"] = template.save(
            Word(
                wordKanji = "中国人",
                pronunciation = "ちゅうごくじん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "китаец"),
                    TranslateEntity(InitMaps.languageMap["en"], "Chinese person")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["日本人"] = template.save(
            Word(
                wordKanji = "日本人",
                pronunciation = "にほんじん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "японец"),
                    TranslateEntity(InitMaps.languageMap["en"], "Japanese person, Japanese people")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["ロシア人"] = template.save(
            Word(
                wordKanji = "ロシア人",
                pronunciation = "ロシアじん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "русский"),
                    TranslateEntity(InitMaps.languageMap["en"], "Russian (person, people)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["英語"] = template.save(
            Word(
                wordKanji = "英語",
                pronunciation = "えいご",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "английский язык"),
                    TranslateEntity(InitMaps.languageMap["en"], "English (language)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["韓国語"] = template.save(
            Word(
                wordKanji = "韓国語",
                pronunciation = "かんこくご",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "корейский язык"),
                    TranslateEntity(InitMaps.languageMap["en"], "Korean (language)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["日本語"] = template.save(
            Word(
                wordKanji = "日本語",
                pronunciation = "にほんご",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "японский язык"),
                    TranslateEntity(InitMaps.languageMap["en"], "Japanese (language)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["ロシア語"] = template.save(
            Word(
                wordKanji = "ロシア語",
                pronunciation = "ロシアご",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "русский язык"),
                    TranslateEntity(InitMaps.languageMap["en"], "Russian (language)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["本"] = template.save(
            Word(
                wordKanji = "本",
                pronunciation = "ほん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "книга"),
                    TranslateEntity(InitMaps.languageMap["en"], "book")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["辞書"] = template.save(
            Word(
                wordKanji = "辞書",
                pronunciation = "じしょ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "фонетический словарь"),
                    TranslateEntity(InitMaps.languageMap["en"], "dictionary, lexicon")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["雑誌"] = template.save(
            Word(
                wordKanji = "雑誌",
                pronunciation = "ざっし",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "журнал"),
                    TranslateEntity(InitMaps.languageMap["en"], "journal, magazine, periodical")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["新聞"] = template.save(
            Word(
                wordKanji = "新聞",
                pronunciation = "しんぶん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "газета"),
                    TranslateEntity(InitMaps.languageMap["en"], "newspaper")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["ノート"] = template.save(
            Word(
                wordKanji = "ノート",
                pronunciation = "ノート",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) записная книжка, блокнот 2) записки, записи 3) ноутбук"
                    ), TranslateEntity(InitMaps.languageMap["en"], "notebook, copy-book, exercise book")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["手帳"] = template.save(
            Word(
                wordKanji = "手帳",
                pronunciation = "てちょう",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "тетрадь; записная книжка, блокнот"),
                    TranslateEntity(InitMaps.languageMap["en"], "notebook; memo pad")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["名刺"] = template.save(
            Word(
                wordKanji = "名刺",
                pronunciation = "めいし",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "визитная карточка"),
                    TranslateEntity(InitMaps.languageMap["en"], "business card")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["カード"] = template.save(
            Word(
                wordKanji = "カード",
                pronunciation = "カード",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) карточка 2) кредитная карточка"),
                    TranslateEntity(InitMaps.languageMap["en"], "card")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["鉛筆"] = template.save(
            Word(
                wordKanji = "鉛筆",
                pronunciation = "えんぴつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "карандаш"),
                    TranslateEntity(InitMaps.languageMap["en"], "pencil")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["ボールペン"] = template.save(
            Word(
                wordKanji = "ボールペン",
                pronunciation = "ボールペン",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "шариковая ручка"),
                    TranslateEntity(InitMaps.languageMap["en"], "ball-point pen")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["シャープペンシル"] = template.save(
            Word(
                wordKanji = "シャープペンシル",
                pronunciation = "シャープペンシル",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "механический карандаш"),
                    TranslateEntity(InitMaps.languageMap["en"], "propelling pencil, mechanical pencil")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["鍵"] = template.save(
            Word(
                wordKanji = "鍵",
                pronunciation = "かぎ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "ключ"),
                    TranslateEntity(InitMaps.languageMap["en"], "key")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["時計"] = template.save(
            Word(
                wordKanji = "時計",
                pronunciation = "とけい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "часы"),
                    TranslateEntity(InitMaps.languageMap["en"], "watch, clock, timepiece")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["傘"] = template.save(
            Word(
                wordKanji = "傘",
                pronunciation = "かさ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "зонт, зонтик"),
                    TranslateEntity(InitMaps.languageMap["en"], "umbrella, parasol")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["かばん"] = template.save(
            Word(
                wordKanji = "かばん",
                pronunciation = "かばん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "саквояж, чемодан; портфель"),
                    TranslateEntity(InitMaps.languageMap["en"], "bag, satchel, briefcase, basket")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["テレビ"] = template.save(
            Word(
                wordKanji = "テレビ",
                pronunciation = "テレビ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) телевидение 2) телевизор"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) television, TV 2) TV program, TV programme, TV broadcast"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["カメラ"] = template.save(
            Word(
                wordKanji = "カメラ",
                pronunciation = "カメラ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) фотоаппарат, кинокамера 2) камера фотоаппарата"
                    ), TranslateEntity(InitMaps.languageMap["en"], "camera")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["コンピューター"] = template.save(
            Word(
                wordKanji = "コンピューター",
                pronunciation = "コンピューター",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "компьютер"),
                    TranslateEntity(InitMaps.languageMap["en"], "computer")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["車"] = template.save(
            Word(
                wordKanji = "車",
                pronunciation = "くるま",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) машина, повозка 2) колесо"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) car, automobile, vehicle, 2) wheel")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["机"] = template.save(
            Word(
                wordKanji = "机",
                pronunciation = "つくえ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "стол, парта"),
                    TranslateEntity(InitMaps.languageMap["en"], "desk")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["椅子"] = template.save(
            Word(
                wordKanji = "椅子",
                pronunciation = "いす",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "стул"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) chair, stool 2) post, office, position")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["チョコレート"] = template.save(
            Word(
                wordKanji = "チョコレート歳",
                pronunciation = "チョコレート",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "шоколад"),
                    TranslateEntity(InitMaps.languageMap["en"], "chocolate")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["コーヒー"] = template.save(
            Word(
                wordKanji = "コーヒー",
                pronunciation = "コーヒー",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "кофе"),
                    TranslateEntity(InitMaps.languageMap["en"], "coffee")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["土産"] = template.save(
            Word(
                wordKanji = "土産",
                pronunciation = "みやげ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "подарок, гостинец; сувенир"),
                    TranslateEntity(InitMaps.languageMap["en"], "present, souvenir")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["何"] = template.save(
            Word(
                wordKanji = "何",
                pronunciation = "なん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "что"),
                    TranslateEntity(InitMaps.languageMap["en"], "what?")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["これ"] = template.save(
            Word(
                wordKanji = "これ",
                pronunciation = "これ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "это (о предмете, более близком к говорящему)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "this (indicating an item near the speaker, the action of the speaker, or the current topic)"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["それ"] = template.save(
            Word(
                wordKanji = "それ",
                pronunciation = "それ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "то (о предмете, более близком к говорящему)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "that (indicating an item or person near the listener, the action of the listener, or something on their mind)"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["あれ"] = template.save(
            Word(
                wordKanji = "あれ",
                pronunciation = "あれ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "то (о предмете, равноудаленном к собеседникам)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) that (indicating something distant from both speaker and listener (in space, time or psychologically), or something understood without naming it directly)"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["名"] = template.save(
            Word(
                wordKanji = "名",
                pronunciation = "な",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) имя, название, наименование 2) имя, репутация, честь 3) имя, известность"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) name, given name 2) title 3) fame, renown, reputation"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["有名"] = template.save(
            Word(
                wordKanji = "有名",
                pronunciation = "ゆうめい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "знаменитый, известный"),
                    TranslateEntity(InitMaps.languageMap["en"], "how old?; what age?")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["adj-na"])
            )
        )
        InitMaps.wordsMap["方法"] = template.save(
            Word(
                wordKanji = "方法",
                pronunciation = "ほうほう",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) способ, метод; средство, мера 2) план, программа"
                    ), TranslateEntity(InitMaps.languageMap["en"], "method; process; manner; way; means; technique")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["方"] = template.save(
            Word(
                wordKanji = "方",
                pronunciation = "ほう",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "направление; сторона"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "direction, way, side, area (in a particular direction)"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["人"] = template.save(
            Word(
                wordKanji = "人",
                pronunciation = "ひと",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) человек, люди 2) личность, характер"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) man; person 2) human being, mankind, people")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["日"] = template.save(
            Word(
                wordKanji = "日",
                pronunciation = "ひ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) день"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) day, days 2) sun, sunshine, sunlight")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["毎日"] = template.save(
            Word(
                wordKanji = "毎日",
                pronunciation = "まいにち",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "каждый день, ежедневно, день за днём, изо дня в день"
                    ), TranslateEntity(InitMaps.languageMap["en"], "every day")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["大きい"] = template.save(
            Word(
                wordKanji = "大きい",
                pronunciation = "おおきい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "большой, крупный"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) big, large, great 2) loud 3) extensive, spacious")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["adj-i"])
            )
        )
        InitMaps.wordsMap["大いに"] = template.save(
            Word(
                wordKanji = "大いに",
                pronunciation = "おおいに",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "очень, весьма, в высшей степени"),
                    TranslateEntity(InitMaps.languageMap["en"], "very; much; greatly; a lot of")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["adv"])
            )
        )
        InitMaps.wordsMap["学ぶ"] = template.save(
            Word(
                wordKanji = "学ぶ",
                pronunciation = "まなぶ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "учиться чему-л., изучать что-л.; обучаться"
                    ), TranslateEntity(InitMaps.languageMap["en"], "to study (in depth), to learn, to take lessons in")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["v"], InitMaps.partOfSpeechMap["v5b"])
            )
        )
        InitMaps.wordsMap["社"] = template.save(
            Word(
                wordKanji = "社",
                pronunciation = "やしろ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "[синтоистский] храм"),
                    TranslateEntity(InitMaps.languageMap["en"], "shrine (usually Shinto)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["会う"] = template.save(
            Word(
                wordKanji = "会う",
                pronunciation = "あう",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) (に) [по]встречаться с кем-л.; видеться с кем-л. 2) встретить что-л.; перенести, испытать что-л."
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to meet, to encounter, to see 2) to have an accident, to have a bad experience"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v"],
                    InitMaps.partOfSpeechMap["v5u"],
                    InitMaps.partOfSpeechMap["vi"]
                )
            )
        )
        InitMaps.wordsMap["会社"] = template.save(
            Word(
                wordKanji = "会社",
                pronunciation = "かいしゃ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "компания, общество, фирма"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) company, corporation 2) workplace")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["先"] = template.save(
            Word(
                wordKanji = "先",
                pronunciation = "さき",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) первенство 2) раньше, прежде 3) заранее; до того как 4) дальше, далее; впереди чего-л.; в сторону от чего-л."
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) previous, prior, former, first, earlier, some time ago, preceding 2) point (e.g. pencil), tip, end, nozzle 3) head (of a line), front"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["prefix"])
            )
        )
        InitMaps.wordsMap["生きる"] = template.save(
            Word(
                wordKanji = "生きる",
                pronunciation = "いきる",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) жить, быть живым 2) (жарг.) восстанавливать зачёркнутое (в корректуре)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to live, to exist 2) to make a living, to subsist 3) to be in effect, to be in use, to function 4) to come to life, to be enlivened 5) to be safe (in baseball, go, etc.)"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v1"],
                    InitMaps.partOfSpeechMap["vi"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生かす"] = template.save(
            Word(
                wordKanji = "生かす",
                pronunciation = "いかす",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) оживлять, воскрешать; обр. оживить; вдохнуть жизнь во что-л. 2) оставлять в живых; сохранять в живом виде"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to make (the best) use of, to put to good use, to leverage (skills, attributes, experience, etc.), to capitalise on (experience, etc.) 2) to let live, to keep alive 3) to revive, to resuscitate, to bring back to life 4) to restore (a deleted passage; in proofreading)"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v5s"],
                    InitMaps.partOfSpeechMap["vt"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生ける"] = template.save(
            Word(
                wordKanji = "生ける",
                pronunciation = "いける",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "живой"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) to arrange (flowers), to plant 2) living, live")
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v1"],
                    InitMaps.partOfSpeechMap["vt"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生まれる"] = template.save(
            Word(
                wordKanji = "生まれる",
                pronunciation = "うまれる",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "родиться, появиться на свет"),
                    TranslateEntity(InitMaps.languageMap["en"], "to be born")
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v1"],
                    InitMaps.partOfSpeechMap["vi"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生む"] = template.save(
            Word(
                wordKanji = "生む",
                pronunciation = "うむ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) рождать, рожать, производить на свет; плодиться 2) порождать, приносить"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to give birth, to bear (child), to lay (eggs) 2) to produce, to yield, to give rise to, to deliver"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v5m"],
                    InitMaps.partOfSpeechMap["vt"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生える"] = template.save(
            Word(
                wordKanji = "生える",
                pronunciation = "はえる",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) расти (о растениях) 2) расти (о волосах, ногтях, тж. о крыльях у птиц); прорезаться (о зубах)"
                    ),
                    TranslateEntity(InitMaps.languageMap["en"], "1) to grow, to spring up, to sprout 2) to cut (teeth)")
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v1"],
                    InitMaps.partOfSpeechMap["vi"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生やす"] = template.save(
            Word(
                wordKanji = "生やす",
                pronunciation = "はやす",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "отращивать, отпускать (бороду, усы)"),
                    TranslateEntity(InitMaps.languageMap["en"], "to grow; to cultivate; to wear a beard")
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v5s"],
                    InitMaps.partOfSpeechMap["vt"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["生"] = template.save(
            Word(
                wordKanji = "生",
                pronunciation = "なま",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) сырой 2) (перен.) необработанный, полусырой, неспелый, зелёный"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) raw, uncooked, fresh 2) natural, as it is, unedited, unprocessed 3) (col) unprotected (sex) 4) live (i.e. not recorded) 5) inexperienced, unpolished, green, crude"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["銀行"] = template.save(
            Word(
                wordKanji = "銀行",
                pronunciation = "ぎんこう",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "банк"),
                    TranslateEntity(InitMaps.languageMap["en"], "bank")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["行く"] = template.save(
            Word(
                wordKanji = "行く",
                pronunciation = "いく, ゆく",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) идти, ходить (о ком-л.) 2) идти, ехать, направляться, следовать куда-л. (о ком-л.; тж. о поезде, пароходе и т. п.); вести куда-л. (о дороге) 3) [по]бывать где-л. "
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to go, to move, to head (towards), to be transported (towards), to reach 2) to proceed, to take place 3) to pass through, to come and go 4) to walk"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["vi"],
                    InitMaps.partOfSpeechMap["v5k-s"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["行う"] = template.save(
            Word(
                wordKanji = "行う",
                pronunciation = "おこなう",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) делать, совершать, производить 2) выполнять, осуществлять, проводить [в жизнь]"
                    ),
                    TranslateEntity(InitMaps.languageMap["en"], "to perform; to do; to conduct oneself; to carry out")
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v5u"],
                    InitMaps.partOfSpeechMap["vt"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["来年"] = template.save(
            Word(
                wordKanji = "来年",
                pronunciation = "らいねん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "будущий (следующий) год"),
                    TranslateEntity(InitMaps.languageMap["en"], "next year")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["来る"] = template.save(
            Word(
                wordKanji = "来る",
                pronunciation = "くる",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) приходить, прибывать; приезжать; приходить в гости 2) приходить, наступать (о чём-л.) 3) происходить, проистекать (из чего-л.)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to come (spatially or temporally); to approach; to arrive; (vk,vi,aux-v) (2) (See 行って来る) to come back; to do ... and come back; (3) to come to be; to become; to get; to grow; to continue"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["vk"],
                    InitMaps.partOfSpeechMap["vi"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["電車"] = template.save(
            Word(
                wordKanji = "電車",
                pronunciation = "でんしゃ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "трамвай"),
                    TranslateEntity(InitMaps.languageMap["en"], "train; electric train")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["二十歳"] = template.save(
            Word(
                wordKanji = "二十歳",
                pronunciation = "はたち",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "двадцатилетний возраст; двадцать лет [от роду]"
                    ), TranslateEntity(InitMaps.languageMap["en"], "1) 20 years old")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["失礼"] = template.save(
            Word(
                wordKanji = "失礼",
                pronunciation = "しつれい",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) невежливость, грубость 2) (при извинении)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) discourtesy; impoliteness 2) excuse me; goodbye 3) to leave 4) to be rude"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["n"],
                    InitMaps.partOfSpeechMap["vs"],
                    InitMaps.partOfSpeechMap["adj-na"]
                )
            )
        )
        InitMaps.wordsMap["木"] = template.save(
            Word(
                wordKanji = "木",
                pronunciation = "き",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) дерево, деревцо 2) дерево, лес (как материал)"
                    ), TranslateEntity(InitMaps.languageMap["en"], "wood (first of the five elements)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["月曜日"] = template.save(
            Word(
                wordKanji = "月曜日",
                pronunciation = "げつようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "понедельник"),
                    TranslateEntity(InitMaps.languageMap["en"], "Monday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["火曜日"] = template.save(
            Word(
                wordKanji = "火曜日",
                pronunciation = "かようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "вторник"),
                    TranslateEntity(InitMaps.languageMap["en"], "Tuesday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["水曜日"] = template.save(
            Word(
                wordKanji = "水曜日",
                pronunciation = "すいようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "среда"),
                    TranslateEntity(InitMaps.languageMap["en"], "Wednesday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["木曜日"] = template.save(
            Word(
                wordKanji = "木曜日",
                pronunciation = "もくようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "четверг"),
                    TranslateEntity(InitMaps.languageMap["en"], "Thursday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["金曜日"] = template.save(
            Word(
                wordKanji = "金曜日",
                pronunciation = "きんようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "пятница"),
                    TranslateEntity(InitMaps.languageMap["en"], "Friday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["土曜日"] = template.save(
            Word(
                wordKanji = "土曜日",
                pronunciation = "どようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "суббота"),
                    TranslateEntity(InitMaps.languageMap["en"], "Saturday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["日曜日"] = template.save(
            Word(
                wordKanji = "日曜日",
                pronunciation = "にちようび",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "воскресенье"),
                    TranslateEntity(InitMaps.languageMap["en"], "Sunday")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-adv"], InitMaps.partOfSpeechMap["n-t"])
            )
        )
        InitMaps.wordsMap["月"] = template.save(
            Word(
                wordKanji = "月",
                pronunciation = "つき",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) луна, месяц 2) месяц (календарный)"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) moon 2) month")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["三日"] = template.save(
            Word(
                wordKanji = "三日",
                pronunciation = "みっか",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) третье [число] 2) три дня"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) the third day of the month 2) three days")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["山"] = template.save(
            Word(
                wordKanji = "山",
                pronunciation = "やま",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) гора 2) лес 3) (тж. 鉱山) рудник"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) mountain; hill 2) mine (e.g. coal mine) 3) heap; pile"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["ctr"])
            )
        )
        InitMaps.wordsMap["火山"] = template.save(
            Word(
                wordKanji = "火山",
                pronunciation = "かざん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "вулкан"),
                    TranslateEntity(InitMaps.languageMap["en"], "volcano")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["富士山"] = template.save(
            Word(
                wordKanji = "富士山",
                pronunciation = "ふじさん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "гора Фудзи"),
                    TranslateEntity(InitMaps.languageMap["en"], "Mount Fuji; Mt. Fuji; Fujiyama; Fuji-san")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["川"] = template.save(
            Word(
                wordKanji = "川",
                pronunciation = "かわ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "река"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) river; stream; (suf) 2) (suffix used with the names of rivers) River; the ... river"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["suf"])
            )
        )
        InitMaps.wordsMap["河川"] = template.save(
            Word(
                wordKanji = "河川",
                pronunciation = "かせん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "реки"),
                    TranslateEntity(InitMaps.languageMap["en"], "rivers")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["田"] = template.save(
            Word(
                wordKanji = "田",
                pronunciation = "た",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "[заболоченное] рисовое поле"),
                    TranslateEntity(InitMaps.languageMap["en"], "rice field")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["田んぼ"] = template.save(
            Word(
                wordKanji = "田んぼ",
                pronunciation = "たんぼ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "рисовое поле"),
                    TranslateEntity(InitMaps.languageMap["en"], "paddy field; farm")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["水田"] = template.save(
            Word(
                wordKanji = "水田",
                pronunciation = "すいでん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "заливное [рисовое] поле"),
                    TranslateEntity(InitMaps.languageMap["en"], "(water-filled) paddy field")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["三人"] = template.save(
            Word(
                wordKanji = "三人",
                pronunciation = "さんにん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "три человека"),
                    TranslateEntity(InitMaps.languageMap["en"], "three people")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["口"] = template.save(
            Word(
                wordKanji = "口",
                pronunciation = "くち",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) рот; уста, губы 2) язык, речь; слова 3) вкус 4) вход, выход; ход куда-л.; место начала подъёма (на гору)"
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) mouth; (2) opening; hole; gap; orifice; (3) mouth (of a bottle); spout; nozzle; mouthpiece; (4) gate; door; entrance; exit"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["出口"] = template.save(
            Word(
                wordKanji = "出口",
                pronunciation = "でぐち",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) выход 2) выпускное (выходное) отверстие"
                    ), TranslateEntity(InitMaps.languageMap["en"], "exit; gateway; way out; outlet; leak; vent")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["入り口"] = template.save(
            Word(
                wordKanji = "入り口",
                pronunciation = "いりぐち",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "вход"),
                    TranslateEntity(InitMaps.languageMap["en"], "entrance; entry; gate; approach; mouth")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["人口"] = template.save(
            Word(
                wordKanji = "人口",
                pronunciation = "じんこう",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "население, численность населения; число жителей; численность людского состава"
                    ), TranslateEntity(InitMaps.languageMap["en"], "1) population 2) common talk")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["自動車"] = template.save(
            Word(
                wordKanji = "自動車",
                pronunciation = "じどうしゃ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "автомобиль, [авто]машина"),
                    TranslateEntity(InitMaps.languageMap["en"], "automobile")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["門"] = template.save(
            Word(
                wordKanji = "門",
                pronunciation = "かど",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) ворота 2) научная школа; школа (научное направление) какого-л. учёного 3) раздел, разряд"
                    ), TranslateEntity(InitMaps.languageMap["en"], "gate")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["n-suf"])
            )
        )
        InitMaps.wordsMap["専門"] = template.save(
            Word(
                wordKanji = "専門",
                pronunciation = "せんもん",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "специальность"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "speciality; specialty; subject of study; expert; area of expertise"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["火"] = template.save(
            Word(
                wordKanji = "火",
                pronunciation = "ひ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) огонь, пламя 2) пожар"),
                    TranslateEntity(InitMaps.languageMap["en"], "fire; flame; blaze")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["n-suf"])
            )
        )
        InitMaps.wordsMap["水"] = template.save(
            Word(
                wordKanji = "水",
                pronunciation = "みず",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) вода; холодная вода 2) жидкость"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) water (esp. cool, fresh water, e.g. drinking water); (2) fluid (esp. in an animal tissue); liquid; (3) flood; floodwaters"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["金"] = template.save(
            Word(
                wordKanji = "金",
                pronunciation = "かね",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) металл 2) деньги"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) (See お金) money 2) metal")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["土"] = template.save(
            Word(
                wordKanji = "土",
                pronunciation = "つち",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "земля"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) earth; soil; dirt; clay; mud; (2) the earth (historically, esp. as opposed to the heavens); the ground; the land"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["土木"] = template.save(
            Word(
                wordKanji = "土木",
                pronunciation = "どぼく",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "инженерные (строительные) работы"),
                    TranslateEntity(InitMaps.languageMap["en"], "engineering works; civil engineering; public works")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["子"] = template.save(
            Word(
                wordKanji = "子",
                pronunciation = "こ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "1) ребёнок, дитя 2) детёныш"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) child (2) young (animal)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["n-suf"])
            )
        )
        InitMaps.wordsMap["子供"] = template.save(
            Word(
                wordKanji = "子供",
                pronunciation = "こども",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "ребёнок, дитя; сын; дочь; дети"),
                    TranslateEntity(InitMaps.languageMap["en"], "child")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["女子学生"] = template.save(
            Word(
                wordKanji = "女子学生",
                pronunciation = "じょしがくせい",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "студентка"),
                    TranslateEntity(InitMaps.languageMap["en"], "female student")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["女の子"] = template.save(
            Word(
                wordKanji = "女の子",
                pronunciation = "おんなのこ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "девочка"),
                    TranslateEntity(InitMaps.languageMap["en"], "girl")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["女子"] = template.save(
            Word(
                wordKanji = "女子",
                pronunciation = "じょし",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "женщина, девушка"),
                    TranslateEntity(InitMaps.languageMap["en"], "woman; girl")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["女"] = template.save(
            Word(
                wordKanji = "女",
                pronunciation = "おんな",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "женщина"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) female; woman; female sex; (n) (2) female lover; girlfriend; mistress; (someone's) woman"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["n-pref"])
            )
        )
        InitMaps.wordsMap["女の人"] = template.save(
            Word(
                wordKanji = "女の人",
                pronunciation = "おんなのひと",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "женщина"),
                    TranslateEntity(InitMaps.languageMap["en"], "woman")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["exp"])
            )
        )
        InitMaps.wordsMap["彼女"] = template.save(
            Word(
                wordKanji = "彼女",
                pronunciation = "かのじょ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "она"),
                    TranslateEntity(InitMaps.languageMap["en"], "1) she; her 2) girlfriend")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["pn"])
            )
        )
        InitMaps.wordsMap["学校"] = template.save(
            Word(
                wordKanji = "学校",
                pronunciation = "がっこう",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) школа, училище; учебное заведение 2) (перен.) занятия (в учебном заведении)"
                    ), TranslateEntity(InitMaps.languageMap["en"], "school")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["先月"] = template.save(
            Word(
                wordKanji = "先月",
                pronunciation = "せんげつ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "прошлый месяц"),
                    TranslateEntity(InitMaps.languageMap["en"], "last month")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n-t"], InitMaps.partOfSpeechMap["n-adv"])
            )
        )
        InitMaps.wordsMap["私立大学"] = template.save(
            Word(
                wordKanji = "私立大学",
                pronunciation = "しりつだいがく",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "частный колледж (университет)"),
                    TranslateEntity(InitMaps.languageMap["en"], "private university")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["私立"] = template.save(
            Word(
                wordKanji = "私立",
                pronunciation = "しりつ",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "частный (содержащийся на частные средства)"
                    ), TranslateEntity(InitMaps.languageMap["en"], "private (establishment)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["火事"] = template.save(
            Word(
                wordKanji = "火事",
                pronunciation = "かじ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "пожар"),
                    TranslateEntity(InitMaps.languageMap["en"], "fire; conflagration")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["生年月日"] = template.save(
            Word(
                wordKanji = "生年月日",
                pronunciation = "せいねんがっぴ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "дата рождения"),
                    TranslateEntity(InitMaps.languageMap["en"], "birth date; date of birth")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["違う"] = template.save(
            Word(
                wordKanji = "違う",
                pronunciation = "ちがう",
                translateEntities = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "1) отличаться от чего-л., расходиться с чем-л. 2) нарушать что-л., идти против чего-л."
                    ),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) to differ (from); to vary 2) to not be in the usual condition 3) to not match the correct"
                    )
                ),
                partOfSpeeches = listOf(
                    InitMaps.partOfSpeechMap["v5u"],
                    InitMaps.partOfSpeechMap["vi"],
                    InitMaps.partOfSpeechMap["v"]
                )
            )
        )
        InitMaps.wordsMap["神戸"] = template.save(
            Word(
                wordKanji = "神戸",
                pronunciation = "こうべ",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "г. Кобэ"),
                    TranslateEntity(InitMaps.languageMap["en"], "Kobe (city)")
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["n"])
            )
        )
        InitMaps.wordsMap["そう"] = template.save(
            Word(
                wordKanji = "そう",
                pronunciation = "そう",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "так"),
                    TranslateEntity(
                        InitMaps.languageMap["en"],
                        "1) so; really; seeming; (adj-na,suf) 2) (after masu stem or adj-stem) appearing that; seeming that; looking like; having the appearance of"
                    )
                ),
                partOfSpeeches = listOf(InitMaps.partOfSpeechMap["adv"])
            )
        )


/*
        InitMaps.wordsMap.put("", template.save(
                new Word("", "",
                        listOf(new TranslateEntity(InitMaps.languageMap.get("ru"), ""), new TranslateEntity(InitMaps.languageMap.get("en"), "")),
                        partOfSpeeches = listOf(InitMaps.partOfSpeechMap.get("")))));
*/
    }
}