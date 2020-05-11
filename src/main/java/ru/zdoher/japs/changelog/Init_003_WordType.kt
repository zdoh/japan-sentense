package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.PartOfSpeech
import ru.zdoher.japs.domain.TranslateEntity

@ChangeLog(order = "003")
class Init_003_WordType {

    @ChangeSet(order = "001", id = "initialWordType", author = "zdoh", runAlways = true)
    fun initWordType(template: MongoTemplate) {

        InitMaps.partOfSpeechMap["num"] = template.save(
            PartOfSpeech(
                shortName = "num",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "числительное"),
                    TranslateEntity(InitMaps.languageMap["en"], "numeral")
                ),
                japanName = "数詞"
            )
        )

        InitMaps.partOfSpeechMap["n"] = template.save(
            PartOfSpeech(
                shortName = "n",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "существительное"),
                    TranslateEntity(InitMaps.languageMap["en"], "noun (common)")
                ),
                japanName = "名詞"
            )
        )

        InitMaps.partOfSpeechMap["pn"] = template.save(
            PartOfSpeech(
                shortName = "pn",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "местоимение"),
                    TranslateEntity(InitMaps.languageMap["en"], "pronoun")
                ),
                japanName = "代名詞"
            )
        )

        InitMaps.partOfSpeechMap["hon"] = template.save(
            PartOfSpeech(
                shortName = "hon",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "вежливая речь"),
                    TranslateEntity(InitMaps.languageMap["en"], "honorific or respectful (sonkeigo) language")
                )
            )
        )

        InitMaps.partOfSpeechMap["adv"] = template.save(
            PartOfSpeech(
                shortName = "adv",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "наречие"),
                    TranslateEntity(InitMaps.languageMap["en"], "adverb")
                ),
                japanName = "副詞"
            )
        )

        InitMaps.partOfSpeechMap["int"] = template.save(
            PartOfSpeech(
                shortName = "int",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "междометие"),
                    TranslateEntity(InitMaps.languageMap["en"], "interjection")
                ),
                japanName = "感動詞"
            )
        )

        InitMaps.partOfSpeechMap["adj-na"] = template.save(
            PartOfSpeech(
                shortName = "adj-na",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "na-прилагательное (предикативное)"),
                    TranslateEntity(InitMaps.languageMap["en"], "adjectival nouns or quasi-adjectives")
                ),
                japanName = "な形容詞"
            )
        )

        InitMaps.partOfSpeechMap["adj-i"] = template.save(
            PartOfSpeech(
                shortName = "adj-i",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "i-прилагательное (полупредикативное)"),
                    TranslateEntity(InitMaps.languageMap["en"], "adjective")
                ),
                japanName = "い形容詞"
            )
        )

        InitMaps.partOfSpeechMap["v"] = template.save(
            PartOfSpeech(
                shortName = "v",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол"),
                    TranslateEntity(InitMaps.languageMap["en"], "verb")
                ),
                japanName = "動詞"
            )
        )

        InitMaps.partOfSpeechMap["v5b"] = template.save(
            PartOfSpeech(
                shortName = "v5b",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -ぶ"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'bu' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5g"] = template.save(
            PartOfSpeech(
                shortName = "v5g",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -ぐ"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'gu' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5k"] = template.save(
            PartOfSpeech(
                shortName = "v5k",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -く"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'ku' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5k-s"] = template.save(
            PartOfSpeech(
                shortName = "v5k-s",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -す (специальный клаас)"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'su' ending (special class)")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5m"] = template.save(
            PartOfSpeech(
                shortName = "v5m",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -む"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'mu' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5n"] = template.save(
            PartOfSpeech(
                shortName = "v5n",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -ぬ"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'nu' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5r"] = template.save(
            PartOfSpeech(
                shortName = "v5r",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -る"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'ru' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5s"] = template.save(
            PartOfSpeech(
                shortName = "v5s",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -す"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'su' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5t"] = template.save(
            PartOfSpeech(
                shortName = "v5t",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -つ"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'tu' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5u"] = template.save(
            PartOfSpeech(
                shortName = "v5u",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -う"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'u' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["v5z"] = template.save(
            PartOfSpeech(
                shortName = "v5z",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол I-спряжение, -ず"),
                    TranslateEntity(InitMaps.languageMap["en"], "Godan verb with 'zu' ending")
                )
            )
        )

        InitMaps.partOfSpeechMap["vi"] = template.save(
            PartOfSpeech(
                shortName = "vi",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "непереходный глагол"),
                    TranslateEntity(InitMaps.languageMap["en"], "intransitive verb")
                )
            )
        )

        InitMaps.partOfSpeechMap["prefix"] = template.save(
            PartOfSpeech(
                shortName = "prefix",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "префикс"),
                    TranslateEntity(InitMaps.languageMap["en"], "prefix")
                )
            )
        )

        InitMaps.partOfSpeechMap["v1"] = template.save(
            PartOfSpeech(
                shortName = "v1",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "глагол II-спряжение"),
                    TranslateEntity(InitMaps.languageMap["en"], "ichidan verb")
                )
            )
        )

        InitMaps.partOfSpeechMap["vt"] = template.save(
            PartOfSpeech(
                shortName = "vt",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "переходный глагол"),
                    TranslateEntity(InitMaps.languageMap["en"], "transitive verb")
                )
            )
        )

        InitMaps.partOfSpeechMap["n-adv"] = template.save(
            PartOfSpeech(
                shortName = "n-adv",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "отглагольное существительное"),
                    TranslateEntity(InitMaps.languageMap["en"], "adverbial noun")
                )
            )
        )

        InitMaps.partOfSpeechMap["n-t"] = template.save(
            PartOfSpeech(
                shortName = "n-t",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "существительное (временное)"),
                    TranslateEntity(InitMaps.languageMap["en"], "noun (temporal)")
                )
            )
        )

        InitMaps.partOfSpeechMap["vk"] = template.save(
            PartOfSpeech(
                shortName = "vk",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "специальный глагол 来る"),
                    TranslateEntity(InitMaps.languageMap["en"], "来る verb - special class")
                )
            )
        )

        InitMaps.partOfSpeechMap["vs"] = template.save(
            PartOfSpeech(
                shortName = "vs",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "существительное, которое используется с する"),
                    TranslateEntity(InitMaps.languageMap["en"], "noun or participle which takes the aux. verb suru")
                )
            )
        )

        InitMaps.partOfSpeechMap["ctr"] = template.save(
            PartOfSpeech(
                shortName = "ctr",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "счетчик"),
                    TranslateEntity(InitMaps.languageMap["en"], "counter")
                )
            )
        )

        InitMaps.partOfSpeechMap["n-suf"] = template.save(
            PartOfSpeech(
                shortName = "n-suf",
                translateName = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "существительное, котором может использоваться как суффикс"
                    ),
                    TranslateEntity(InitMaps.languageMap["en"], "noun, used as a suffix")
                )
            )
        )

        InitMaps.partOfSpeechMap["n-pref"] = template.save(
            PartOfSpeech(
                shortName = "n-pref",
                translateName = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "существительное, котором может использоваться как префикс"
                    ),
                    TranslateEntity(InitMaps.languageMap["en"], "noun, used as a prefix")
                )
            )
        )

        InitMaps.partOfSpeechMap["suf"] = template.save(
            PartOfSpeech(
                shortName = "suf",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "суффикс"),
                    TranslateEntity(InitMaps.languageMap["en"], "suffix")
                )
            )
        )

        InitMaps.partOfSpeechMap["exp"] = template.save(
            PartOfSpeech(
                shortName = "exp",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "выражение"),
                    TranslateEntity(InitMaps.languageMap["en"], "expressions (phrases, clauses, etc.)")
                )
            )
        )

        /// part of speech for grammar
        InitMaps.partOfSpeechMap["は"] = template.save(
            PartOfSpeech(
                shortName = "は",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "частица は"),
                    TranslateEntity(InitMaps.languageMap["en"], "particle は")
                )
            )
        )

        InitMaps.partOfSpeechMap["です"] = template.save(
            PartOfSpeech(
                shortName = "です",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "связка です"),
                    TranslateEntity(InitMaps.languageMap["en"], "....  です")
                )
            )
        )

        InitMaps.partOfSpeechMap["じゃありません"] = template.save(
            PartOfSpeech(
                shortName = "じゃありません",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "разговорная отрицательная форма связки です")
                )
            )
        )

        InitMaps.partOfSpeechMap["ではありません"] = template.save(
            PartOfSpeech(
                shortName = "ではありません",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "отрицательная форма связки です")
                )
            )
        )

        InitMaps.partOfSpeechMap["か"] = template.save(
            PartOfSpeech(
                shortName = "か",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "вопросительная частица か")
                )
            )
        )

        InitMaps.partOfSpeechMap["も"] = template.save(
            PartOfSpeech(
                shortName = "も",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "частица も")
                )
            )
        )

        InitMaps.partOfSpeechMap["の"] = template.save(
            PartOfSpeech(
                shortName = "の",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "частица の")
                )
            )
        )

        InitMaps.partOfSpeechMap["さん"] = template.save(
            PartOfSpeech(
                shortName = "さん",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "суффикс さん")
                )
            )
        )

        InitMaps.partOfSpeechMap["ちゃん"] = template.save(
            PartOfSpeech(
                shortName = "ちゃん",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "суффикс ちゃん")
                )
            )
        )

        InitMaps.partOfSpeechMap["これ"] = template.save(
            PartOfSpeech(
                shortName = "これ",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "предметно-указательное местоимение これ")
                )
            )
        )

        InitMaps.partOfSpeechMap["それ"] = template.save(
            PartOfSpeech(
                shortName = "それ",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "предметно-указательное местоимение それ")
                )
            )
        )

        InitMaps.partOfSpeechMap["あれ"] = template.save(
            PartOfSpeech(
                shortName = "あれ",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "предметно-указательное местоимение あれ")
                )
            )
        )

        InitMaps.partOfSpeechMap["この"] = template.save(
            PartOfSpeech(
                shortName = "この",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "относительно-указательное местоимение この")
                )
            )
        )

        InitMaps.partOfSpeechMap["その"] = template.save(
            PartOfSpeech(
                shortName = "その",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "относительно-указательное местоимение その")
                )
            )
        )

        InitMaps.partOfSpeechMap["あの"] = template.save(
            PartOfSpeech(
                shortName = "あの",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "относительно-указательное местоимение あの")
                )
            )
        )

        InitMaps.partOfSpeechMap["文"] = template.save(
            PartOfSpeech(
                shortName = "文",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "показатель предложения")
                )
            )
        )

        InitMaps.partOfSpeechMap["、"] = template.save(
            PartOfSpeech(
                shortName = "、",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "символ запятой")
                )
            )
        )

        InitMaps.partOfSpeechMap["。"] = template.save(
            PartOfSpeech(
                shortName = "。",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "символ точки")
                )
            )
        )

        InitMaps.partOfSpeechMap["お"] = template.save(
            PartOfSpeech(
                shortName = "お",
                translateName = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "показатель вежливости, префикс к существительному")
                )
            )
        )
    }
}