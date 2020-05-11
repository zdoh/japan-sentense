package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Language

@ChangeLog(order = "002")
class Init_002_Language {
    @ChangeSet(order = "001", id = "initialLanguage", author = "zdoh", runAlways = true)
    fun initAuthors(template: MongoTemplate) {
        InitMaps.languageMap[Constants.RUSSIAN_LANG_SHORT] = template.save(
            Language(
                shortName = Constants.RUSSIAN_LANG_SHORT,
                fullName = Constants.RUSSIAN_LANG
            )
        )
        InitMaps.languageMap[Constants.ENGLISH_LANG_SHORT] = template.save(
            Language(
                shortName = Constants.ENGLISH_LANG_SHORT,
                fullName = Constants.ENGLISH_LANG
            )
        )
    }
}