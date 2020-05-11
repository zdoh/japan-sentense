package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.textbook.TextbookSeries

@ChangeLog(order = "008")
class Init_008_TextbookSeries {

    @ChangeSet(order = "001", id = "initialTextbookSeries", author = "zdoh", runAlways = true)
    fun initTextbookSeries(template: MongoTemplate) {
        InitMaps.textbookSeriesMap[Constants.MINNA_S] = template.save(
            TextbookSeries(
                name = "みんなの日本語",
                englishName = Constants.MINNA_S
            )
        )

        InitMaps.textbookSeriesMap[Constants.BASIC_KANJI_BOOK_S] = template.save(
            TextbookSeries(
                name = Constants.BASIC_KANJI_BOOK_S,
                englishName = Constants.BASIC_KANJI_BOOK_S
            )
        )
    }
}