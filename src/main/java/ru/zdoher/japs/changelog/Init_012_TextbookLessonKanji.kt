package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Kanji
import ru.zdoher.japs.domain.textbook.Textbook
import java.util.*

@ChangeLog(order = "012")
class Init_012_TextbookLessonKanji {

    @ChangeSet(order = "001", id = "initialTextbookLessonKanji", author = "zdoh", runAlways = true)
    fun initialTextbookLessonKanji(template: MongoTemplate) {
        val minnaKanjiL0: MutableList<Kanji?> = ArrayList()
        val minnaKanjiL1: MutableList<Kanji?> = ArrayList()
        val basicKanjiL1: MutableList<Kanji?> = ArrayList()
        val basicKanjiL2: MutableList<Kanji?> = ArrayList()
        minnaKanjiL0.add(InitMaps.kanjiMap["一"])
        minnaKanjiL0.add(InitMaps.kanjiMap["二"])
        minnaKanjiL0.add(InitMaps.kanjiMap["三"])
        minnaKanjiL0.add(InitMaps.kanjiMap["四"])
        minnaKanjiL0.add(InitMaps.kanjiMap["五"])
        minnaKanjiL0.add(InitMaps.kanjiMap["六"])
        minnaKanjiL0.add(InitMaps.kanjiMap["七"])
        minnaKanjiL0.add(InitMaps.kanjiMap["八"])
        minnaKanjiL0.add(InitMaps.kanjiMap["九"])
        minnaKanjiL0.add(InitMaps.kanjiMap["十"])
        minnaKanjiL1.add(InitMaps.kanjiMap["人"])
        minnaKanjiL1.add(InitMaps.kanjiMap["名"])
        minnaKanjiL1.add(InitMaps.kanjiMap["方"])
        minnaKanjiL1.add(InitMaps.kanjiMap["本"])
        minnaKanjiL1.add(InitMaps.kanjiMap["日"])
        minnaKanjiL1.add(InitMaps.kanjiMap["何"])
        minnaKanjiL1.add(InitMaps.kanjiMap["大"])
        minnaKanjiL1.add(InitMaps.kanjiMap["学"])
        minnaKanjiL1.add(InitMaps.kanjiMap["社"])
        minnaKanjiL1.add(InitMaps.kanjiMap["員"])
        minnaKanjiL1.add(InitMaps.kanjiMap["会"])
        minnaKanjiL1.add(InitMaps.kanjiMap["先"])
        minnaKanjiL1.add(InitMaps.kanjiMap["生"])
        minnaKanjiL1.add(InitMaps.kanjiMap["行"])
        minnaKanjiL1.add(InitMaps.kanjiMap["来"])
        minnaKanjiL1.add(InitMaps.kanjiMap["車"])
        basicKanjiL1.add(InitMaps.kanjiMap["日"])
        basicKanjiL1.add(InitMaps.kanjiMap["月"])
        basicKanjiL1.add(InitMaps.kanjiMap["木"])
        basicKanjiL1.add(InitMaps.kanjiMap["山"])
        basicKanjiL1.add(InitMaps.kanjiMap["川"])
        basicKanjiL1.add(InitMaps.kanjiMap["田"])
        basicKanjiL1.add(InitMaps.kanjiMap["人"])
        basicKanjiL1.add(InitMaps.kanjiMap["口"])
        basicKanjiL1.add(InitMaps.kanjiMap["車"])
        basicKanjiL1.add(InitMaps.kanjiMap["門"])
        basicKanjiL2.add(InitMaps.kanjiMap["火"])
        basicKanjiL2.add(InitMaps.kanjiMap["水"])
        basicKanjiL2.add(InitMaps.kanjiMap["金"])
        basicKanjiL2.add(InitMaps.kanjiMap["土"])
        basicKanjiL2.add(InitMaps.kanjiMap["子"])
        basicKanjiL2.add(InitMaps.kanjiMap["女"])
        basicKanjiL2.add(InitMaps.kanjiMap["学"])
        basicKanjiL2.add(InitMaps.kanjiMap["生"])
        basicKanjiL2.add(InitMaps.kanjiMap["先"])
        basicKanjiL2.add(InitMaps.kanjiMap["私"])

        // basicKanjiL2.add(InitMaps.kanjiMap.get(""));
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList[0].kanjiList.addAll(minnaKanjiL0)
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList[1].kanjiList.addAll(minnaKanjiL1)
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[0].kanjiList.addAll(basicKanjiL1)
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[1].kanjiList.addAll(basicKanjiL2)
        template.save(InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!)
        template.save(InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!)
    }

}