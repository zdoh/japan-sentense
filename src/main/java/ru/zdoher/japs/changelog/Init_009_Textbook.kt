package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.textbook.Textbook
import ru.zdoher.japs.domain.textbook.TextbookSeries
import ru.zdoher.japs.domain.textbook.TextbookType

@ChangeLog(order = "009")
class Init_009_Textbook {

    @ChangeSet(order = "001", id = "initialTextbook", author = "zdoh", runAlways = true)
    fun initTextbook(template: MongoTemplate) {
        InitMaps.textbookMap[Constants.MINNA_GR_1] = template.save(
            Textbook(
                japaneseName = "みんなの日本語初級I文法",
                englishName = Constants.MINNA_GR_1,
                textbookSeries = InitMaps.textbookSeriesMap[Constants.MINNA_S],
                show = true,
                textbookType = listOf(InitMaps.textbookTypeMap["文法"], InitMaps.textbookTypeMap["語彙"])
            )
        )
        InitMaps.textbookMap[Constants.MINNA_KANJI_1] = template.save(
            Textbook(
                japaneseName = "みんなの日本語初級I漢字",
                englishName = Constants.MINNA_KANJI_1,
                textbookSeries = InitMaps.textbookSeriesMap[Constants.MINNA_S],
                show = true,
                textbookType = listOf(InitMaps.textbookTypeMap["漢字"], InitMaps.textbookTypeMap["語彙"])
            )
        )
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1] = template.save(
            Textbook(
                japaneseName = "Basic kanji book",
                englishName = Constants.BASIC_KANJI_BOOK_1,
                textbookSeries = InitMaps.textbookSeriesMap[Constants.BASIC_KANJI_BOOK_S],
                show = true,
                textbookType = listOf(InitMaps.textbookTypeMap["漢字"], InitMaps.textbookTypeMap["語彙"])
            )
        )
    }

}