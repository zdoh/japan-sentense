package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Grammar
import ru.zdoher.japs.domain.Language
import ru.zdoher.japs.domain.PartOfSpeech
import ru.zdoher.japs.domain.TranslateEntity

@ChangeLog(order = "007")
class Init_007_Grammar {

    @ChangeSet(order = "001", id = "initialGrammar", author = "zdoh", runAlways = true)
    fun initGrammar(template: MongoTemplate) {
        InitMaps.grammarMap["nは"] = template.save(
            Grammar(
                name = "nは",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["は"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Частица 「は」 указывает, что перед ней стоит существительное, является темой высказывания."
                    )
                )
            )
        )
        InitMaps.grammarMap["nです"] = template.save(
            Grammar(
                name = "nです",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["です"]),
                resultPartOfSpeech = InitMaps.partOfSpeechMap["文"],
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Существительное, оформленное связной 「です」, является именным сказуемым. " +
                                "です указывает на суждения или утверждение. " +
                                "です выражает нейтрально-вежливый стиль речи говорящего по отношению к собеседнику." +
                                "です изменяется в отрицательных предложениях и в прошедшем времени."
                    )
                )
            )
        )
        InitMaps.grammarMap["nじゃありません"] = template.save(
            Grammar(
                name = "nじゃありません",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["じゃありません"]),
                resultPartOfSpeech = InitMaps.partOfSpeechMap["文"],
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "じゃありません является разговорной отрицательной версией 「です」."
                    )
                )
            )
        )
        InitMaps.grammarMap["nではありません"] = template.save(
            Grammar(
                name = "nではありません",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["ではありません"]),
                resultPartOfSpeech = InitMaps.partOfSpeechMap["文"],
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"], "ではありません　является отрицательной версией 「です」. " +
                                "Используется в нейтрально-вежливом или информационном стиле, а также в письменной речи."
                    )
                )
            )
        )
        InitMaps.grammarMap["nですか"] = template.save(
            Grammar(
                name = "nですか",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["です"], InitMaps.partOfSpeechMap["か"]),
                resultPartOfSpeech = InitMaps.partOfSpeechMap["文"],
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"], "Частица か указывает на сомнение, вопрос и тд говорящего. " +
                                "Вопросительное предложение образуется путем добавление частицы 「か」 в конец предложения."
                    )
                )
            )
        )
        InitMaps.grammarMap["nも"] = template.save(
            Grammar(
                name = "nも",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["も"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"], "Вместо тематической частицы 「は」 употребляется частица 「も」, " +
                                "если утверждается то же самое, что и по поводу предыдущей темы"
                    )
                )
            )
        )
        InitMaps.grammarMap["nのn"] = template.save(
            Grammar(
                name = "nのn",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["の"], InitMaps.partOfSpeechMap["n"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Частица 「の」 служит для связи двух существительных, если второе существительное" +
                                "является определениек к первому существительному. Например 'моя книга'"
                    )
                )
            )
        )
        InitMaps.grammarMap["nの"] = template.save(
            Grammar(
                name = "nの",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["n"], InitMaps.partOfSpeechMap["の"], InitMaps.partOfSpeechMap["n"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "В конструкции 「nのn」, в случае если из контекста понятно о каком втором существительном " +
                                "идет речь, то второе существительное может опускаться. Например 「この本は私のです」"
                    )
                )
            )
        )
        InitMaps.grammarMap["これは"] = template.save(
            Grammar(
                name = "これは",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["これ"], InitMaps.partOfSpeechMap["は"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                                "грамматически функционируют иак же, как и имена существительные. これ указывает на предмет, более близкий к говорящему."
                    )
                )
            )
        )
        InitMaps.grammarMap["それは"] = template.save(
            Grammar(
                name = "それは",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["それ"], InitMaps.partOfSpeechMap["は"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                                "грамматически функционируют иак же, как и имена существительные. それ указывает на предмет, более близкий к собеседнику."
                    )
                )
            )
        )
        InitMaps.grammarMap["あれは"] = template.save(
            Grammar(
                name = "あれは",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["それ"], InitMaps.partOfSpeechMap["は"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Предметно-указательное местоимение, употребляющиеся вместо названий предметов и " +
                                "грамматически функционируют иак же, как и имена существительные. あれ указывает на предмет, равноудаленный от собеседников."
                    )
                )
            )
        )
        InitMaps.grammarMap["このn"] = template.save(
            Grammar(
                name = "このn",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["この"], InitMaps.partOfSpeechMap["n"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Относительно-указательное местоимение 「この」 определяет существительное и используется " +
                                "с ним. 「このn」 указывает на предмет, более близкий к говорящему."
                    )
                )
            )
        )
        InitMaps.grammarMap["そのn"] = template.save(
            Grammar(
                name = "そのn",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["その"], InitMaps.partOfSpeechMap["n"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Относительно-указательное местоимение 「その」 определяет существительное и используется " +
                                "с ним. 「そのn」 указывает на предмет, более близкий к собеседнику."
                    )
                )
            )
        )
        InitMaps.grammarMap["あのn"] = template.save(
            Grammar(
                name = "あのn",
                grammarCreate = listOf(InitMaps.partOfSpeechMap["あの"], InitMaps.partOfSpeechMap["n"]),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Относительно-указательное местоимение 「あの」 определяет существительное и используется " +
                                "с ним. 「あのn」 указывает на предмет, равноудаленный от говорящих."
                    )
                )
            )
        )
        InitMaps.grammarMap["文か、文か"] = template.save(
            Grammar(
                name = "文か、文か",
                grammarCreate = listOf(
                    InitMaps.partOfSpeechMap["文"],
                    InitMaps.partOfSpeechMap["か"],
                    InitMaps.partOfSpeechMap["、"],
                    InitMaps.partOfSpeechMap["文"],
                    InitMaps.partOfSpeechMap["か"]
                ),
                grammarComment = listOf(
                    TranslateEntity(
                        InitMaps.languageMap["ru"],
                        "Альтернативный вопрос, при ответе на который требуется выбрать правильное утверждение " +
                                "из двух (или более) предложенных. Ответом является повторение правильного утверждения без добавления 「はい」 или 「いいえ」"
                    )
                )
            )
        )

/*
        InitMaps.grammarMap.put("", template.save(new Grammar(
                listOf(InitMaps.partOfSpeechMap.get(""), InitMaps.partOfSpeechMap.get("")),
                listOf(new TranslateEntity(InitMaps.languageMap.get("ru"), "")))));
*/
    }
}