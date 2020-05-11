package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.Word
import ru.zdoher.japs.domain.textbook.Textbook
import java.util.*

@ChangeLog(order = "011")
class Init_011_TextbookLessonWord {

    @ChangeSet(order = "012", id = "initialTextbookLessonWord", author = "zdoh", runAlways = true)
    fun initTextbookLessonWord(template: MongoTemplate) {
        val minnaGrWordsL1 = mutableListOf<Word?>()
        val minnaGrWordsL2 = mutableListOf<Word?>()
        val minnaKanjiWordsL0 = mutableListOf<Word?>()
        val minnaKanjiWordsL1 = mutableListOf<Word?>()
        val basicKanjiBookWordsL1 = mutableListOf<Word?>()
        val basicKanjiBookWordsL2 = mutableListOf<Word?>()

        ///
        minnaGrWordsL1.add(InitMaps.wordsMap["私"])
        minnaGrWordsL1.add(InitMaps.wordsMap["あなた"])
        minnaGrWordsL1.add(InitMaps.wordsMap["あの人"])
        minnaGrWordsL1.add(InitMaps.wordsMap["あの方"])
        minnaGrWordsL1.add(InitMaps.wordsMap["先生"])
        minnaGrWordsL1.add(InitMaps.wordsMap["教師"])
        minnaGrWordsL1.add(InitMaps.wordsMap["学生"])
        minnaGrWordsL1.add(InitMaps.wordsMap["会社員"])
        minnaGrWordsL1.add(InitMaps.wordsMap["社員"])
        minnaGrWordsL1.add(InitMaps.wordsMap["銀行員"])
        minnaGrWordsL1.add(InitMaps.wordsMap["医者"])
        minnaGrWordsL1.add(InitMaps.wordsMap["研究者"])
        minnaGrWordsL1.add(InitMaps.wordsMap["大学"])
        minnaGrWordsL1.add(InitMaps.wordsMap["病院"])
        minnaGrWordsL1.add(InitMaps.wordsMap["誰"])
        minnaGrWordsL1.add(InitMaps.wordsMap["どなた"])
        minnaGrWordsL1.add(InitMaps.wordsMap["何歳"])
        minnaGrWordsL1.add(InitMaps.wordsMap["いくつ"])
        minnaGrWordsL1.add(InitMaps.wordsMap["はい"])
        minnaGrWordsL1.add(InitMaps.wordsMap["いいえ"])
        minnaGrWordsL1.add(InitMaps.wordsMap["国"])
        minnaGrWordsL1.add(InitMaps.wordsMap["言葉"])
        minnaGrWordsL1.add(InitMaps.wordsMap["アメリカ"])
        minnaGrWordsL1.add(InitMaps.wordsMap["イギリス"])
        minnaGrWordsL1.add(InitMaps.wordsMap["イタリア"])
        minnaGrWordsL1.add(InitMaps.wordsMap["イラン"])
        minnaGrWordsL1.add(InitMaps.wordsMap["韓国"])
        minnaGrWordsL1.add(InitMaps.wordsMap["スペイン"])
        minnaGrWordsL1.add(InitMaps.wordsMap["ドイツ"])
        minnaGrWordsL1.add(InitMaps.wordsMap["日本"])
        minnaGrWordsL1.add(InitMaps.wordsMap["ロシア"])
        minnaGrWordsL1.add(InitMaps.wordsMap["中国"])
        minnaGrWordsL1.add(InitMaps.wordsMap["アメリカ人"])
        minnaGrWordsL1.add(InitMaps.wordsMap["韓国人"])
        minnaGrWordsL1.add(InitMaps.wordsMap["中国人"])
        minnaGrWordsL1.add(InitMaps.wordsMap["日本人"])
        minnaGrWordsL1.add(InitMaps.wordsMap["ロシア人"])
        minnaGrWordsL1.add(InitMaps.wordsMap["英語"])
        minnaGrWordsL1.add(InitMaps.wordsMap["韓国語"])
        minnaGrWordsL1.add(InitMaps.wordsMap["日本語"])
        minnaGrWordsL1.add(InitMaps.wordsMap["ロシア語"])


        ///
        minnaGrWordsL2.add(InitMaps.wordsMap["これ"])
        minnaGrWordsL2.add(InitMaps.wordsMap["それ"])
        minnaGrWordsL2.add(InitMaps.wordsMap["あれ"])
        minnaGrWordsL2.add(InitMaps.wordsMap["本"])
        minnaGrWordsL2.add(InitMaps.wordsMap["辞書"])
        minnaGrWordsL2.add(InitMaps.wordsMap["雑誌"])
        minnaGrWordsL2.add(InitMaps.wordsMap["新聞"])
        minnaGrWordsL2.add(InitMaps.wordsMap["ノット"])
        minnaGrWordsL2.add(InitMaps.wordsMap["手帳"])
        minnaGrWordsL2.add(InitMaps.wordsMap["名刺"])
        minnaGrWordsL2.add(InitMaps.wordsMap["カード"])
        minnaGrWordsL2.add(InitMaps.wordsMap["鉛筆"])
        minnaGrWordsL2.add(InitMaps.wordsMap["ボールペン"])
        minnaGrWordsL2.add(InitMaps.wordsMap["シャープペンシル"])
        minnaGrWordsL2.add(InitMaps.wordsMap["鍵"])
        minnaGrWordsL2.add(InitMaps.wordsMap["時計"])
        minnaGrWordsL2.add(InitMaps.wordsMap["傘"])
        minnaGrWordsL2.add(InitMaps.wordsMap["かばん"])
        minnaGrWordsL2.add(InitMaps.wordsMap["CD"])
        minnaGrWordsL2.add(InitMaps.wordsMap["テレビ"])
        minnaGrWordsL2.add(InitMaps.wordsMap["ラジオ"])
        minnaGrWordsL2.add(InitMaps.wordsMap["カメラ"])
        minnaGrWordsL2.add(InitMaps.wordsMap["コンピューター"])
        minnaGrWordsL2.add(InitMaps.wordsMap["車"])
        minnaGrWordsL2.add(InitMaps.wordsMap["机"])
        minnaGrWordsL2.add(InitMaps.wordsMap["椅子"])
        minnaGrWordsL2.add(InitMaps.wordsMap["チョコレート"])
        minnaGrWordsL2.add(InitMaps.wordsMap["コーヒー"])
        minnaGrWordsL2.add(InitMaps.wordsMap["土産"])
        minnaGrWordsL2.add(InitMaps.wordsMap["何"])
        minnaGrWordsL2.add(InitMaps.wordsMap["そう"])
        minnaGrWordsL2.add(InitMaps.wordsMap["違う"])

        ///
        minnaKanjiWordsL0.add(InitMaps.wordsMap["一つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["二つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["三つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["四つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["五つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["六つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["七つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["八つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["九つ"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["十"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["一月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["二月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["三月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["四月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["五月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["六月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["七月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["八月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["九月"])
        minnaKanjiWordsL0.add(InitMaps.wordsMap["十月"])

        ///
        minnaKanjiWordsL1.add(InitMaps.wordsMap["アメリカ人"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["あの人"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["人"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["日本人"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["だれ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["名前"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["名"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["あの方"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["方"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["カメラ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["本"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["日本"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["日"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["これ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["何"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["大きい"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["大学"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["大いに"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["学ぶ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["二十歳"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["社員"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["社"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["会社員"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["会う"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["先生"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["生む"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["生まれる"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["生"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["銀行員"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["行く"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["銀行"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["アメリカ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["来る"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["来年"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["車"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["電車"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["いいえ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["学生"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["どなた"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["失礼"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["ブラジル人"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["それ"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["雑誌"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["日本語"])
        minnaKanjiWordsL1.add(InitMaps.wordsMap["何歳"])

        ///
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["日本"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["日曜日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["3日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["一月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["月曜日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["木"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["木曜日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["山"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["富士山"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["火山"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["川"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["河川"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["田"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["田んぼ"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["水田"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["人"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["日本人"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["三人"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["口"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["出口"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["入り口"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["人口"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["車"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["電車"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["自動車"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["門"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["専門"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["日曜日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["今日"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["あの人"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["二月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["三月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["四月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["五月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["六月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["七月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["八月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["九月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["十月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["十一月"])
        basicKanjiBookWordsL1.add(InitMaps.wordsMap["十二月"])

        ///
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["火"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["火山"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["火曜日"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["水"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["水田"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["水曜日"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["お金"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["金曜日"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["土"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["土木"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["土曜日"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["子供"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["女の子"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["女子"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["女子学生"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["女"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["女の人"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["彼女"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["学ぶ"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["学生"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["大学"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["学校"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["生きる"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["生む"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["生まれる"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["先生"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["先"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["先月"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["私"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["私立"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["私立大学"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["すみません"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["生年月日"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap["火事"])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap[""])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap[""])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap[""])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap[""])
        basicKanjiBookWordsL2.add(InitMaps.wordsMap[""])


        //words.add(InitMaps.wordsMap.get(""));
        InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList[0].wordList.addAll(minnaGrWordsL1)
        InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList[1].wordList.addAll(minnaGrWordsL2)
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList[0].wordList.addAll(minnaKanjiWordsL0)
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList[1].wordList.addAll(minnaKanjiWordsL1)
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[0].wordList.addAll(basicKanjiBookWordsL1)
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[1].wordList.addAll(basicKanjiBookWordsL2)
        template.save(InitMaps.textbookMap[Constants.MINNA_GR_1]!!)
        template.save(InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!)
        template.save(InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!)

        /*InitMaps.textbookMap.put("Minna no nihongo begin grammar I - Lesson1",
                template.save(InitMaps.textbookMap.get("Minna no nihongo begin grammar I")));*/
    }
}