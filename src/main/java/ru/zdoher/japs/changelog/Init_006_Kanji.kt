package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Kanji
import ru.zdoher.japs.domain.Language
import ru.zdoher.japs.domain.TranslateEntity
import ru.zdoher.japs.domain.Word

@ChangeLog(order = "006")
class Init_006_Kanji {

    @ChangeSet(order = "001", id = "initialKanji", author = "zdoh", runAlways = true)
    fun initKanji(template: MongoTemplate) {
        InitMaps.kanjiMap["一"] = template.save(
            Kanji(
                kanji = "一",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "один"),
                    TranslateEntity(InitMaps.languageMap["en"], "one")
                ),
                onyumi = listOf("イチ", "イツ"),
                kunyumi = listOf<String>("ひと"),
                words = listOf(InitMaps.wordsMap["一つ"]),
                anchor = InitMaps.wordsMap["一月"]!!
            )
        )
        InitMaps.kanjiMap["二"] = template.save(
            Kanji(
                kanji = "二",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "два"),
                    TranslateEntity(InitMaps.languageMap["en"], "two")
                ),
                onyumi = listOf("ニ"),
                kunyumi = listOf<String>("ふた"),
                words = listOf(InitMaps.wordsMap["二つ"]),
                anchor = InitMaps.wordsMap["二月"]!!
            )
        )
        InitMaps.kanjiMap["三"] = template.save(
            Kanji(
                kanji = "三",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "три"),
                    TranslateEntity(InitMaps.languageMap["en"], "three")
                ),
                onyumi = listOf<String>("サン"),
                kunyumi = listOf<String>("み", "みっ"),
                words = listOf(InitMaps.wordsMap["三つ"]),
                anchor = InitMaps.wordsMap["三月"]!!
            )
        )
        InitMaps.kanjiMap["四"] = template.save(
            Kanji(
                kanji = "四",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "четыре"),
                    TranslateEntity(InitMaps.languageMap["en"], "four")
                ),
                onyumi = listOf<String>("シ"),
                kunyumi = listOf<String>("よ", "よつ", "よん"),
                words = listOf(InitMaps.wordsMap["四つ"]),
                anchor = InitMaps.wordsMap["四月"]!!
            )
        )
        InitMaps.kanjiMap["五"] = template.save(
            Kanji(
                kanji = "五",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "пять"),
                    TranslateEntity(InitMaps.languageMap["en"], "five")
                ),
                onyumi = listOf<String>("ゴ"),
                kunyumi = listOf<String>("いつ"),
                words = listOf(InitMaps.wordsMap["五つ"]),
                anchor = InitMaps.wordsMap["五月"]!!
            )
        )
        InitMaps.kanjiMap["六"] = template.save(
            Kanji(
                kanji = "六",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "шесть"),
                    TranslateEntity(InitMaps.languageMap["en"], "six")
                ),
                onyumi = listOf<String>("ロク"),
                kunyumi = listOf<String>("むつ", "むい"),
                words = listOf(InitMaps.wordsMap["六つ"]),
                anchor = InitMaps.wordsMap["六月"]!!
            )
        )
        InitMaps.kanjiMap["七"] = template.save(
            Kanji(
                kanji = "七",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "семь"),
                    TranslateEntity(InitMaps.languageMap["en"], "seven")
                ),
                onyumi = listOf<String>("シチ"),
                kunyumi = listOf<String>("なな", "なの"),
                words = listOf(InitMaps.wordsMap["七つ"]),
                anchor =  InitMaps.wordsMap["七月"]!!
            )
        )
        InitMaps.kanjiMap["八"] = template.save(
            Kanji(
                kanji = "八",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "восемь"),
                    TranslateEntity(InitMaps.languageMap["en"], "eight")
                ),
                onyumi = listOf<String>("ハチ"),
                kunyumi = listOf<String>("や", "やつ", "よう"),
                words = listOf(InitMaps.wordsMap["八つ"]),
                anchor = InitMaps.wordsMap["八月"]!!
            )
        )
        InitMaps.kanjiMap["九"] = template.save(
            Kanji(
                kanji = "九",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "девять"),
                    TranslateEntity(InitMaps.languageMap["en"], "nine")
                ),
                onyumi = listOf<String>("キュウ", "ク"),
                kunyumi = listOf<String>("ここの"),
                words = listOf(InitMaps.wordsMap["九つ"]),
                anchor = InitMaps.wordsMap["九月"]!!
            )
        )
        InitMaps.kanjiMap["十"] = template.save(
            Kanji(
                kanji = "十",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "пять"),
                    TranslateEntity(InitMaps.languageMap["en"], "five")
                ),
                onyumi = listOf<String>("サン"),
                kunyumi = listOf<String>("と"),
                words = listOf(InitMaps.wordsMap["十"]),
                anchor = InitMaps.wordsMap["十日"]!!
            )
        )
        InitMaps.kanjiMap["人"] = template.save(
            Kanji(
                kanji = "人",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "человек")),
                onyumi = listOf<String>("ジン", "ニン"),
                words = listOf(InitMaps.wordsMap["人"]),
                anchor = InitMaps.wordsMap["日本人"]!!
            )
        )
        InitMaps.kanjiMap["名"] = template.save(
            Kanji(
                kanji = "名",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "имя")),
                onyumi = listOf<String>("メイ", "ミョウ"),
                words = listOf(InitMaps.wordsMap["名"]),
                anchor = InitMaps.wordsMap["有名"]!!
            )
        )
        InitMaps.kanjiMap["方"] = template.save(
            Kanji(
                kanji = "方",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "направление; сторона")),
                onyumi = listOf<String>("ホウ"),
                kunyumi =  listOf<String>("かた"),
                anchor = InitMaps.wordsMap["方法"]!!
            )
        )
        InitMaps.kanjiMap["本"] = template.save(
            Kanji(
                kanji = "本",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "книга; основа; источник")),
                onyumi = listOf<String>("ホン"),
                kunyumi = listOf<String>("もと"),
                anchor = InitMaps.wordsMap["日本"]!!
            )
        )
        InitMaps.kanjiMap["日"] = template.save(
            Kanji(
                kanji = "日",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "день, солнце, счетчик для дней")),
                onyumi = listOf<String>("ニチ", "ジツ"),
                kunyumi = listOf<String>("か"),
                words = listOf(InitMaps.wordsMap["日"]),
                anchor = InitMaps.wordsMap["毎日"]!!
            )
        )
        InitMaps.kanjiMap["何"] = template.save(
            Kanji(
                kanji = "何",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "что")),
                onyumi = listOf<String>("カ"),
                words = listOf(InitMaps.wordsMap["何"]),
                anchor = InitMaps.wordsMap["何"]!!
            )
        )
        InitMaps.kanjiMap["大"] = template.save(
            Kanji(
                kanji = "大",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "большой")),
                onyumi = listOf<String>("ダイ", "タイ"),
                kunyumi = listOf<String>("おお"),
                words = listOf(InitMaps.wordsMap["大きい"], InitMaps.wordsMap["大いに"]),
                anchor = InitMaps.wordsMap["大学"]!!
            )
        )
        InitMaps.kanjiMap["学"] = template.save(
            Kanji(
                kanji = "学",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "учиться; учеба; наука")),
                onyumi = listOf<String>("ガク"),
                words = listOf(InitMaps.wordsMap["学ぶ"]),
                anchor = InitMaps.wordsMap["大学"]!!
            )
        )
        InitMaps.kanjiMap["社"] = template.save(
            Kanji(
                kanji = "社",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "фирма")),
                onyumi = listOf<String>("シャ"),
                words = listOf(InitMaps.wordsMap["社"]),
                anchor = InitMaps.wordsMap["社員"]!!
            )
        )
        InitMaps.kanjiMap["員"] = template.save(
            Kanji(
                kanji = "員",
                meaning = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "работник; сотрудник; член персонала; суффикс профессии")
                ),
                onyumi = listOf<String>("イン"),
                anchor = InitMaps.wordsMap["社員"]!!
            )
        )
        InitMaps.kanjiMap["会"] = template.save(
            Kanji(
                kanji = "会",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "встреча")),
                onyumi = listOf<String>("カイ", "エ"),
                words = listOf(InitMaps.wordsMap["会う"]),
                anchor = InitMaps.wordsMap["会社"]!!
            )
        )
        InitMaps.kanjiMap["先"] = template.save(
            Kanji(
                kanji = "先",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "впереди; перед")),
                onyumi = listOf<String>("セン"),
                words = listOf(InitMaps.wordsMap["先"]),
                anchor = InitMaps.wordsMap["先生"]!!
            )
        )
        InitMaps.kanjiMap["生"] = template.save(
            Kanji(
                kanji = "生",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "жизнь")),
                onyumi = listOf<String>("セイ", "ショウ"),
                words = listOf(
                    InitMaps.wordsMap["生きる"],
                    InitMaps.wordsMap["生かす"],
                    InitMaps.wordsMap["生ける"],
                    InitMaps.wordsMap["生まれる"],
                    InitMaps.wordsMap["生む"],
                    InitMaps.wordsMap["生える"],
                    InitMaps.wordsMap["生やす"],
                    InitMaps.wordsMap["生"]
                ),
                anchor = InitMaps.wordsMap["先生"]!!
            )
        )
        InitMaps.kanjiMap["行"] = template.save(
            Kanji(
                kanji = "行",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "идти")),
                onyumi = listOf<String>("コウ", "ギョウ", "アン"),
                words = listOf(InitMaps.wordsMap["行く"], InitMaps.wordsMap["行う"]),
                anchor = InitMaps.wordsMap["銀行"]!!
            )
        )
        InitMaps.kanjiMap["来"] = template.save(
            Kanji(
                kanji = "来",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "приходить")),
                onyumi = listOf<String>("ライ"),
                words = listOf(InitMaps.wordsMap["来る"]),
                anchor = InitMaps.wordsMap["来年"]!!
            )
        )
        InitMaps.kanjiMap["車"] = template.save(
            Kanji(
                kanji = "車",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "машина; автомобиль")),
                onyumi = listOf<String>("シャ"),
                words = listOf(InitMaps.wordsMap["車"]),
                anchor = InitMaps.wordsMap["電車"]!!
            )
        )
        InitMaps.kanjiMap["月"] = template.save(
            Kanji(
                kanji = "月",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "месяц (календарный); месяц; луна")),
                onyumi = listOf<String>("ゲツ", "ガツ"),
                words = listOf(InitMaps.wordsMap["月"]),
                anchor = InitMaps.wordsMap["月曜日"]!!
            )
        )
        InitMaps.kanjiMap["木"] = template.save(
            Kanji(
                kanji = "木",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "дерево")),
                onyumi = listOf<String>("ボク", "モク"),
                kunyumi = listOf<String>("こ"),
                words = listOf(InitMaps.wordsMap["木"]),
                anchor = InitMaps.wordsMap["木曜日"]!!
            )
        )
        InitMaps.kanjiMap["山"] = template.save(
            Kanji(
                kanji = "山",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "гора")),
                onyumi = listOf<String>("サン"),
                words = listOf(InitMaps.wordsMap["山"]),
                anchor = InitMaps.wordsMap["火山"]!!
            )
        )
        InitMaps.kanjiMap["川"] = template.save(
            Kanji(
                kanji = "川",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "река")),
                onyumi = listOf<String>("セン"),
                words = listOf(InitMaps.wordsMap["川"]),
                anchor = InitMaps.wordsMap["河川"]!!
            )
        )
        InitMaps.kanjiMap["田"] = template.save(
            Kanji(
                kanji = "田",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "рисовое поле")),
                onyumi = listOf<String>("デン"),
                words = listOf(InitMaps.wordsMap["田"]),
                anchor = InitMaps.wordsMap["水田"]!!
            )
        )
        InitMaps.kanjiMap["口"] = template.save(
            Kanji(
                kanji = "口",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "рот")),
                onyumi = listOf<String>("コウ", "ク"),
                words = listOf(InitMaps.wordsMap["口"]),
                anchor = InitMaps.wordsMap["人口"]!!
            )
        )
        InitMaps.kanjiMap["門"] = template.save(
            Kanji(
                kanji = "門",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "ворота")),
                onyumi = listOf<String>("モン"),
                words = listOf(InitMaps.wordsMap["門"]),
                anchor = InitMaps.wordsMap["専門"]!!
            )
        )
        InitMaps.kanjiMap["火"] = template.save(
            Kanji(
                kanji = "火",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "огонь")),
                onyumi = listOf<String>("カ"),
                kunyumi = listOf<String>("ほ"),
                words = listOf(InitMaps.wordsMap["火"]),
                anchor = InitMaps.wordsMap["火曜日"]!!
            )
        )
        InitMaps.kanjiMap["水"] = template.save(
            Kanji(
                kanji = "水",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "вода")),
                onyumi = listOf<String>("スイ"),
                words = listOf(InitMaps.wordsMap["水"]),
                anchor = InitMaps.wordsMap["水曜日"]!!
            )
        )
        InitMaps.kanjiMap["金"] = template.save(
            Kanji(
                kanji = "金",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "золото; деньги; металл")),
                onyumi = listOf<String>("キン", "コン"),
                words = listOf(InitMaps.wordsMap["金"]),
                anchor = InitMaps.wordsMap["金曜日"]!!
            )
        )
        InitMaps.kanjiMap["土"] = template.save(
            Kanji(
                kanji = "土",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "земля")),
                onyumi = listOf<String>("ド", "ト"),
                words = listOf(InitMaps.wordsMap["土"]),
                anchor = InitMaps.wordsMap["土曜日"]!!
            )
        )
        InitMaps.kanjiMap["子"] = template.save(
            Kanji(
                kanji = "子",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "ребенок")),
                onyumi = listOf<String>("シ", "ス"),
                words = listOf(InitMaps.wordsMap["子"]),
                anchor = InitMaps.wordsMap["女子"]!!
            )
        )
        InitMaps.kanjiMap["女"] = template.save(
            Kanji(
                kanji = "女",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "женщина")),
                onyumi = listOf<String>("ジョ", "ニョ", "ニョウ"),
                words = listOf(InitMaps.wordsMap["女"]),
                anchor = InitMaps.wordsMap["女子"]!!
            )
        )
        InitMaps.kanjiMap["私"] = template.save(
            Kanji(
                kanji = "私",
                meaning = listOf(TranslateEntity(InitMaps.languageMap["ru"], "я; свой; личный; приватный")),
                onyumi = listOf<String>("シ"),
                words = listOf(InitMaps.wordsMap["私"]),
                anchor = InitMaps.wordsMap["私立"]!!
            )
        )
/*
        kanjiList.put("", template.save(
                new Kanji("",
                        listOf(new TranslateEntity(InitMaps.languageMap.get("ru"), "")),
                        listOf(""), listOf(InitMaps.wordsMap.get("")), InitMaps.wordsMap.get(""))));
*/
    }
}