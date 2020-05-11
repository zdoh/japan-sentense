package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Lesson
import ru.zdoher.japs.domain.textbook.Textbook

@ChangeLog(order = "010")
class Init_010_Lesson {

    @ChangeSet(order = "011", id = "initialLesson", author = "zdoh", runAlways = true)
    fun initLesson(template: MongoTemplate) {
        InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList.add(Lesson(name = "Lesson 1"))
        InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList.add(Lesson(name = "Lesson 2"))
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList.add(Lesson(name = "Lesson 0"))
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList.add(Lesson(name = "Lesson 1-2"))
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList.add(Lesson(name = "Lesson 1"))
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList.add(Lesson(name = "Lesson 2"))
        template.save(InitMaps.textbookMap[Constants.MINNA_GR_1]!!)
        template.save(InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!)
        template.save(InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!)
    }
}