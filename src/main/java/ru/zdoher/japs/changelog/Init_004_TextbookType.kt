package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Language
import ru.zdoher.japs.domain.TranslateEntity
import ru.zdoher.japs.domain.textbook.TextbookType

@ChangeLog(order = "004")
class Init_004_TextbookType {

    @ChangeSet(order = "001", id = "initialTextbookType", author = "zdoh", runAlways = true)
    fun initTextbookType(template: MongoTemplate) {
        InitMaps.textbookTypeMap["文法"] = template.save(
            TextbookType(
                name = "文法",
                translateName = listOf(TranslateEntity(InitMaps.languageMap["ru"], "Грамматика"))
            )
        )
        InitMaps.textbookTypeMap["読解"] = template.save(
            TextbookType(
                name = "読解",
                translateName = listOf(TranslateEntity(InitMaps.languageMap["ru"], "Чтение"))
            )
        )
        InitMaps.textbookTypeMap["語彙"] = template.save(
            TextbookType(
                name = "語彙",
                translateName = listOf(TranslateEntity(InitMaps.languageMap["ru"], "Слова"))
            )
        )
        InitMaps.textbookTypeMap["漢字"] = template.save(
            TextbookType(
                name = "漢字",
                translateName = listOf(TranslateEntity(InitMaps.languageMap["ru"], "Иероглифы"))
            )
        )
        InitMaps.textbookTypeMap["聴解"] = template.save(
            TextbookType(
                name = "聴解",
                translateName = listOf(TranslateEntity(InitMaps.languageMap["ru"], "Аудирование"))
            )
        )
        InitMaps.textbookTypeMap["other"] = template.save(
            TextbookType(
                name = "other",
                translateName = listOf(TranslateEntity(InitMaps.languageMap["ru"], "Другое"))
            )
        )
    }
}