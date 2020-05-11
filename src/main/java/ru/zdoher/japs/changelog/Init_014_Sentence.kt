package ru.zdoher.japs.changelog

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.zdoher.japs.domain.sentence.OtherPossibleSentence
import ru.zdoher.japs.domain.sentence.Sentence
import ru.zdoher.japs.domain.sentence.SentenceTranslate
import java.util.*

@ChangeLog(order = "014")
class Init_014_Sentence {

    @ChangeSet(order = "014", id = "initialSentence", author = "zdoh", runAlways = true)
    fun initSentence(template: MongoTemplate) {
        val minnaGrSourceL1 =
            (InitMaps.textbookMap[Constants.MINNA_GR_1]!!.japaneseName + " - "
                    + InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList[0].name)
        val minnaGrSourceL2 =
            (InitMaps.textbookMap[Constants.MINNA_GR_1]!!.japaneseName + " - "
                    + InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList[1].name)
        val minnaKjSourceL1 =
            (InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.japaneseName + " - "
                    + InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList[0].name)
        val basicKjSourceL1 =
            (InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.japaneseName + " - "
                    + InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[0].name)
        val basicKjSourceL2 =
            (InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.japaneseName + " - "
                    + InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[1].name)
        val sentMinGrLes1 = mutableListOf<Sentence>()
        val sentMinGrLes2 = mutableListOf<Sentence>()
        val sentMinKjLes1 = mutableListOf<Sentence>()
        val sentBasKjLes1 = mutableListOf<Sentence>()
        val sentBasKjLes2 = mutableListOf<Sentence>()

        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "私はマイク・ミラーです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Я Майк Миллер.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false,
                    grammarList = mutableListOf(InitMaps.grammarMap["nは"]!!, InitMaps.grammarMap["nです"]!!),
                    words = mutableListOf(InitMaps.wordsMap["私"]!!)
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "私は会社員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Я сотрудник компании.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false,
                    grammarList = listOf(InitMaps.grammarMap["nは"]!!, InitMaps.grammarMap["nです"]!!),
                    words = listOf(InitMaps.wordsMap["私"]!!, InitMaps.wordsMap["会社員"]!!)
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「サントスさんは学生じゃありません。」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Сантос-сан не студент.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ミラーさんはアメリカ人ですか」「はい、アメリカ人です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Миллер-сан американец?' 'Да, американец'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ミラーさんは先生ですか」「いいえ、先生じゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Миллер-сан преподаватель?' 'Нет, не преподаватель'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「（あの方は）ミラーです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!, "'Миллер-сан преподаватель?' 'Нет, не преподаватель'",
                            mutableListOf(OtherPossibleSentence("「あのひとはだれですか」「（あの人は）ミラーです」", "zdoh", 1))
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ミラーさんは会社員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Миллер-сан сотрудник компании.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ミラーさんはIMCの社員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Миллер-сан сотрудник компании IMC.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "あの方はミラーさんです。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!, "Это Миллер-сан.",
                            mutableListOf(OtherPossibleSentence("あの人はミラーさんです。", "zdoh", 1))
                        )
                    ), 
                    sentenceSource = minnaGrSourceL1, 
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「マイク・ミラーさんですか」「はい、マイク・ミラーです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Вы Майк Миллер?' 'Да, Майк Миллер'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ミラーさんは学生ですか」「いいえ、学生じゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Миллер-сан студент?' 'Нет, не студент'"
                        )
                    ), 
                    sentenceSource = minnaGrSourceL1, 
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ワンさんは銀行ですか」「いいえ、銀行じゃありません。医者です」 ",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Ван-сан сотрудник банка?' 'Нет, не сотрудник банка. Врач'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「ワットさんです。さくら大学の先生です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Ватт-сан. Преподаватель университета Сакура.'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「テレーザちゃんは何歳ですか」「9歳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Терезе-чян?' '9 лет'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワンさんは中国人です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ван-сан китаец.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワンさんは医者です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ван-сан врач.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「私はカール・シュミットじゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Я не Карл Шмидт'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "私はカール・シュミットではありません。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Я не Карл Шмидт")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「私は教師じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "私は教師ではありません。")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「イーさんはアメリカ人じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Ии-сан не американка'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "イーさんはアメリカ人ではありません",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ии-сан не американка.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「イーさんは学生じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Ии-сан не студентка'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "イーさんは学生ではありません",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ии-сан не студентка.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの人は木村さんですか」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Он Кимура-сан?'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はマライさんですか」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Она Мария-сан?'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "あの方はだれですか",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Он кто?")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "私はBMWの社員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Я сотрудник компании БМВ.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "カリナさんは富士大学の学生です。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Карина-сан студентка университета Фудзи."
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワットさんはさくら大学の先生です",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Ватт-сан преподаватель университета Сакура."
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "サントスさんはブラジル人です。マリアさんもブラジル人です",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Сантос-сан бразилец. Мария-сан тоже бразильянка"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「太郎ちゃんは何歳ですか」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Таро-куну?'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "山田さんは日本人です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ямада-сан японец.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワットさんはイギリス人です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ватт-сан англичанин.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "タワポンさんはタイ人です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Тавапон-сан таец.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "シュミットさんはドイツ人です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Шмидт-сан немец.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "山田さんは銀行員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ямада-сан сотрудник банка.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワットさんは先生です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ватт-сан учитель.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "タワポンさんは学生です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Тавапон-сан студент.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "シュミットさんは会社員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Шмидт-сан сотрудник компании.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「山田さんは学生じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Ямада-сан не студент'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ワットさんはドイツ人じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Ватт-сан не англичанин'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「タワポンさんは先生じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Тавапон-сан не учитель'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「シュミットさんはアメリカ人じゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Шмидт-сан не американец'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「山田さんは銀行員ですか」「はい、銀行員です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Ямада-сан сотрудник банка?' 'Да, сотрудник банка.'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ワットさんは会社員ですか」「いいえ、会社員じゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Ватт-сан служащий компании?' 'Нет, не служащий банка'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「タワポンさんは先生ですか」「いいえ、先生じゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Тавапон-сан учитель?' 'Нет, не учитель'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「シュミットさんはドイツ人ですか」「はい、ドイツ人です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Шмидт-сан немец?' 'Да, немец'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「イーさんです。AKCの研究者です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Ии-сан. Ученый (компании) АКЦ'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「ワンさんです。神戸病院の医者です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Ван-сан. Врач больницы Кобэ'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「カリナさんです。富士大学の学生です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Карина-сан. Студентка университета Фудзи'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「サントスさんです。ブラジルエアーの社員です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Сантос-сан. Бразильский сотрудник'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "山田さんは銀行員です。イーさんも銀行員ですか。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Ямада-сан сотрудник банка. Ии-сан тоже сотрудница банка?"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワットさんは先生です。ワンさんも先生せうか。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Ватт-сан учитель. Ван-сан тоже учитель?"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "タワポンさんは学生です。カリナサンも学生ですか。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Тавапон-сан студент. Карина-сан тоже студентка?"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "シュミットさんはドイツ人です。サントスさんもドイツじんですか。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Шмидт-сан немец. Сантос-сан тоже немец?"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「山田さんは何歳ですか」「38歳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Ямада-сану?' '38 лет'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ワットさんは何歳ですか」「45歳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Ват-сану?' '45 лет'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「タワポンさんは何歳ですか」「19歳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Тавапон-сану?' '19 лет'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「シュミットさんは何歳ですか」「５２歳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Шмидт-сану?' '52 года'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あなたは学生ですか」「はい、学生です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Ты студент?' 'Да, студент'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あなたはミラーですか」「はい、ミラーです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Ты Миллер?' 'Да, Миллер'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ワットさんもアメリカ人ですか」「いいえ、アメリカ人じゃありません。イギリス人です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Ватт-сан тоже американец?' 'Нет, не американец. Англичанин'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はだれですか」「サントスさんです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Он кто?' 'Сантос-сан'")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "私はミラーです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Я Миллер.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "ワンさん医者です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ван-сан врач.")),
                    sentenceSource = minnaGrSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「カリナさんは先生でうか」「いいえ、先生じゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Карина-сан учитель?' 'Нет, не учитель'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness = InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes1.add(
            template.save(
                Sentence(
                    sentence = "「ミラーさんは会社員です」「サントスさんも会社員です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Миллер-сан сотруднки компании' 'Сантос-сан тоже сотрудник компании'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL1,
                    politeness = InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation = true
                )
            )
        )

        /////////
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それは辞書ですか",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это словарь?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それはだれの傘ですか",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это чей зонт?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "この本は私のです",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Эта книга моя.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あの方はどなたですか",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Он кто?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは辞書ですか」「はい、そうです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это словарь?' 'Да, это так'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それはミラーさんのですか」「いいえ、違います」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это миллера?' 'Нет, это не так.'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それはシャープペンシルですか」「いいえ、ボールペンです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это механический карандаш?' 'Нет, это шариковая ручка'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは９ですか、７ですか」「９です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это 9 или 7?' '9'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これはコンピュータの本です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это компьютерная книга.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは私の本です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это моя книга.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「あれはだれのかばんですか」「佐藤さんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это чей портфель?' 'Сато-сана'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「このかばんはあなたのですか」「いいえ、私のじゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Этот портфель твой?' 'Нет, не мой'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「ミラーさんはIMCの社員ですか」「はい、IMCの社員です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Миллер-сан сотрудник IMC?' 'Да, сотрудник IMC'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「この傘はあなたのですか」「いいえ、違います。シュミットさんのです。そうですか」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Этот зонт твой?' 'Нет, не так. Шмидта-сана. Понятно.'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはボールペンですか」「はい、そうです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это шариковая ручка?' 'Да, это так'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それはノートですか」「いいえ、手帳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это тетрадь?' 'Нет, блокнот'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは何ですか」「名刺です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Визитка'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは何の雑誌ですか」「コンピューターの雑誌です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это что за журнал?' 'Компьютерный журнал'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「あれはだれのかばんですか」「佐藤さんのかばんです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это чей портфель?' 'Портфель Сатоу-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはミラーさんのですか」「いいえ、私のじゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это Миллер-сана?' 'Нет, не мое'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「このかばんはだれのですか」「私のです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Этот портфель чей?' 'Мой'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは机です",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это стол.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは新聞です",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это газета.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは名刺です",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это визитка.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは何ですか",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это что?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それはボールペンですか、シャープペンシルですか",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Это шариковая ручка или механический карандаш?"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それは「１」ですか、「９」ですか。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это один или девять?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それは「あ」ですか、「お」ですか。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это 'а' или 'о'?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは車の本です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это книга о машинах.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これはコンピュータの本です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это книга о компьютерах.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは日本の本です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это книга о Японии.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは何の本です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это что за книга?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは私のかばんです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То мой портфель.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは佐藤さんのかばんです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То портфель Сатоу-сана.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは先生のかばんです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То портфель учителя?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれはだれのかばんですか。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То чей портфель?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは私のです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То мое.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは佐藤さんのです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То Сатоу-сана.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは先生のです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То учителя.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれはだれのですか。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То чье?")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "この手帳は私のです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Этот блокнот мой.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "この鍵は私のです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Эти ключи мои.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "このかばんは私のです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Этот портфель мой.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは雑誌です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это журнал.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それはノートです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это тетрадь.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれは辞書です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То словарь.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "それはかばんです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То портфель.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "これは鍵です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это ключ.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "あれはテレビです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "То телевизор.")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは本ですか」「はい、本です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это книга?' 'Да, книга'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは手帳ですか」「いいえ、本です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это блокнот?' 'Нет, книга'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは時計ですか」「はい、時計です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это часы?' 'Да, часы'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはラジオですか」「いいえ、カメラです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это радио?' 'Нет, фотоаппарат'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは鉛筆ですか」「いいえ、シャープペンシルです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это карандаш?' 'Нет, механический карандаш'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは椅子ですか」「はい、椅子です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это стул?' 'Да, стул'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは何ですか」「本です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Книга'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは何ですか」「時計です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Часы'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは何ですか」「カメラです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Фотоаппарат'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは何ですか」「シャープペンシルです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Механический карандаш'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは何ですか」「椅子です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Стул'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはシャープペンシルですか、ボールペンですか」「ボールペンです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это механический карандаш или шариковая ручка?' 'Шариковая ручка'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは本ですか、雑誌ですか」「本です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это книга или журнал?' 'Книга'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは「い」ですか、「り」ですか」「「り」です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это и или ри?' 'Ри'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは「１」ですか、「７」ですか」「「７」です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это 1 или 7?' '7'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは「シ」ですか、「ツ」ですか」「「ツ」です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это ши или цу?' 'Цу'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは何の鍵ですか」「車の鍵です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что за ключ?' 'Ключ от машины'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは何の雑誌ですか」「車の雑誌です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это что за журнал?' 'Журнал о машинах'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは何のCDですか」「日本語のCDです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это что за CD?' 'CD на японском языке'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは何の雑誌ですか」「カメラの雑誌です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это что за журнал?' 'Журнал о фотоаппаратах'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「それは何の本ですか」「日本語の本です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это что за книга?' 'Книга на японском языке'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはだれのノートですか」「カリナサンのノートです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это чья тетрадь?' 'Тетрадь Карины-сан'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはだれのかばんですか」「山田さんのかばん」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это чей портфель?' 'Портфель Ямада-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはだれのカメラですか」「サントスさんのカメラです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это чей фотоаппарат?' 'Фотоаппарат Сансос-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはだれの傘ですか」「佐藤さんの傘です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это чей зонт?' 'Зонт Сато-сана'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはだれの手帳ですか」「ミラーさんの手帳です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это чей блокнот?' 'Блокнот Миллер-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはカリナさんのですか」「はい、カリナさんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это Карины-сан?' 'Да, Карины-сан?'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはミラーさんのですか」「いいえ、ミラーさんのじゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это Миллер-сана?' 'Нет, не Миллер-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはワンさんのですか」「いいえ、ワンさんのじゃありません」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это Ван-сана?' 'Нет, не Ван-сана'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これは佐藤さんのですか」「はい、佐藤さんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это Сато-сана?' 'Да, Сато-сана'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「これはワットさんのですか」「いいえ、ワットさんのじゃありません」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это Ватто-сана?' 'Нет, не Ватто-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「このノートはだれのですか」「カリナさんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Эта тетрадь чья?' 'Карины-сан'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「このかばんはだれのですか」「山田さんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Этот портфель чей?' 'Ямады-сан'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「このカメラはだれのですか」「サントスさんのです」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Этот фотоаппарат чей?' 'Сантос-сана'"
                        )
                    ),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「この傘はだれのですか」「佐藤さんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Этот зонт чей?' 'Сато-сана'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinGrLes2.add(
            template.save(
                Sentence(
                    sentence = "「この手帳はだれのですか」「ミラーさんのです」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Этот блокнот чей?' 'Миллер-сана'")),
                    sentenceSource = minnaGrSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )

        ///
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「ミラーさんは学生ですか」「いいえ、学生じゃありません。会社員です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Миллер-сан студент?' 'Нет, не студент. Сотрудник компании.'"
                        )
                    ),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの方はどなたですか」「ワットさんです。さくら大学の先生です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Ван-сан. Преподаватель университета Сакура.'"
                        )
                    ),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「失礼ですがお名前は？」「マイク・ミラーです。アメリカから来ました。どうぞよろしく」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Извините, как вас зовут?' 'Майк Миллре. Приехал из Америки. Приятно познакомиться.'"
                        )
                    ),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「あの人はだれですか」「 サントスさんです。サントスさんはブラジル人です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Он кто?' 'Сантос-сан. Сантос-сан бразилец.'"
                        )
                    ),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「これは何ですか」「車の雑誌」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Это что?' 'Журнал о машинах.'")),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "山田さんは銀行員です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ямада-сан сотрудник банка.")),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「それは何の本ですか」「日本語の本です」",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "'Это что за книга?' 'Книга на японском языке.'"
                        )
                    ),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )
        sentMinKjLes1.add(
            template.save(
                Sentence(
                    sentence = "「イーさんは何歳ですか」「二十歳です」",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "'Сколько лет Ии-сан?' 'Двадцать.'")),
                    sentenceSource = minnaKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  true
                )
            )
        )

        ////
        sentBasKjLes1.add(
            template.save(
                Sentence(
                    sentence = "あの人は山川さんです。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Он Ямакава-сан.")),
                    sentenceSource = basicKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes1.add(
            template.save(
                Sentence(
                    sentence = "山川さんは日本人です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Ямакава-сан японец.")),
                    sentenceSource = basicKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes1.add(
            template.save(
                Sentence(
                    sentence = "あの山は筑波山です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Та гора - гора Тсубака.")),
                    sentenceSource = basicKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes1.add(
            template.save(
                Sentence(
                    sentence = "この川は利根川です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Эта река - река Тонэ.")),
                    sentenceSource = basicKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes1.add(
            template.save(
                Sentence(
                    sentence = "今日は3月15日です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Сегодня 15 марта.")),
                    sentenceSource = basicKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes1.add(
            template.save(
                Sentence(
                    sentence = "川田さんの専門は車です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Специальность Кавады-сана машины.")),
                    sentenceSource = basicKjSourceL1,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )

        ///
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "これは山川さんのお金です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это деньги Ямакавы-сан.")),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "すみません。水をください。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Извините. Воду пожалуйста.")),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "あの女の人は学生です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Это жензина студентка.")),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "私は先生ではありません。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Я не учитель.")),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "金田さんは大学の先生です。",
                    translateList = listOf(
                        SentenceTranslate(
                            InitMaps.languageMap["ru"]!!,
                            "Канеда-сан преподаватель университета."
                        )
                    ),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "あの女子学生は21歳です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Этой студентке 21 год.")),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )
        sentBasKjLes2.add(
            template.save(
                Sentence(
                    sentence = "私の生年月日は1960年3月11日です。",
                    translateList = listOf(SentenceTranslate(InitMaps.languageMap["ru"]!!, "Моя дата рождения 11 марта 1960 год.")),
                    sentenceSource = basicKjSourceL2,
                    politeness =  InitMaps.sentencePolitenessMap["polite"]!!,
                    conversation =  false
                )
            )
        )

        /*
        sentences.add(template.save(new Sentence("",
                listOf(template.save(new SentenceTranslate(InitMaps.languageMap.get("ru"), ""))), source1)));
        */



        InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList[0].sentencesList.addAll(sentMinGrLes1)
        InitMaps.textbookMap[Constants.MINNA_GR_1]!!.lessonList[1].sentencesList.addAll(sentMinGrLes2)
        InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!.lessonList[1].sentencesList.addAll(sentMinKjLes1)
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[0].sentencesList.addAll(sentBasKjLes1)
        InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!.lessonList[1].sentencesList.addAll(sentBasKjLes2)
        template.save(InitMaps.textbookMap[Constants.MINNA_GR_1]!!)
        template.save(InitMaps.textbookMap[Constants.MINNA_KANJI_1]!!)
        template.save(InitMaps.textbookMap[Constants.BASIC_KANJI_BOOK_1]!!)
    }

}