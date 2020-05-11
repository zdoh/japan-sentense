package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Language
import ru.zdoher.japs.domain.TranslateEntity
import ru.zdoher.japs.domain.sentence.SentencePoliteness

@ChangeLog(order = "013")
class Init_013_SentencePoliteness {

    @ChangeSet(order = "013", id = "initialSentencePoliteness", author = "zdoh", runAlways = true)
    fun initSentencePoliteness(template: MongoTemplate) {
        InitMaps.sentencePolitenessMap["polite"] = template.save(
            SentencePoliteness(
                japName = "丁寧語",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "нейтрально-вежливая речь"),
                    TranslateEntity(InitMaps.languageMap["en"], "polite language")
                )
            )
        )
        InitMaps.sentencePolitenessMap["respectful"] = template.save(
            SentencePoliteness(
                japName = "尊敬語",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "уважительная речь"),
                    TranslateEntity(InitMaps.languageMap["en"], "respectful language")
                )
            )
        )
        InitMaps.sentencePolitenessMap["humble"] = template.save(
            SentencePoliteness(
                japName = "謙譲語",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "скромная речь"),
                    TranslateEntity(InitMaps.languageMap["en"], "humble language")
                )
            )
        )
        InitMaps.sentencePolitenessMap["simple"] = template.save(
            SentencePoliteness(
                japName = "丁寧語",
                translateEntities = listOf(
                    TranslateEntity(InitMaps.languageMap["ru"], "не формальная речь"),
                    TranslateEntity(InitMaps.languageMap["en"], "informal language")
                )
            )
        )
    }

}