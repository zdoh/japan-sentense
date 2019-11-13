package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Language;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.domain.grammar.Grammar;
import ru.zdoher.japs.domain.sentence.OtherPossibleSentence;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.domain.sentence.SentenceTranslate;
import ru.zdoher.japs.domain.textbook.Textbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "014")
public class Init_014_Sentence {
    private Map<String, Textbook> textbookMap;
    private Map<String, Language> languageMap;
    private Map<String, SentencePoliteness> sentencePolitenessMap;
    private Map<String, Grammar> grammarMap;
    private Map<String, Word> wordsMap;

    public Init_014_Sentence() {
        textbookMap = InitMaps.textbookMap;
        languageMap = InitMaps.languageMap;
        sentencePolitenessMap = InitMaps.sentencePolitenessMap;
        grammarMap = InitMaps.grammarMap;
        wordsMap = InitMaps.wordsMap;
    }

    @ChangeSet(order = "014", id = "initialSentence", author = "zdoh", runAlways = true)
    public void initSentence(MongoTemplate template) {

        String minnaGrSourceL1 = textbookMap.get(Constants.MINNA_GR_1).getJapaneseName() + " - "
                + textbookMap.get(Constants.MINNA_GR_1).getLessonList().get(0).getName();

        String minnaGrSourceL2 = textbookMap.get(Constants.MINNA_GR_1).getJapaneseName() + " - "
                + textbookMap.get(Constants.MINNA_GR_1).getLessonList().get(1).getName();

        String minnaKjSourceL1 = textbookMap.get(Constants.MINNA_KANJI_1).getJapaneseName() + " - "
                + textbookMap.get(Constants.MINNA_KANJI_1).getLessonList().get(0).getName();

        String basicKjSourceL1 = textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getJapaneseName() + " - "
                + textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(0).getName();

        String basicKjSourceL2 = textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getJapaneseName() + " - "
                + textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(1).getName();

        ArrayList<Sentence> sentMinGrLes1 = new ArrayList<>();
        ArrayList<Sentence> sentMinGrLes2 = new ArrayList<>();
        ArrayList<Sentence> sentMinKjLes1 = new ArrayList<>();
        ArrayList<Sentence> sentBasKjLes1 = new ArrayList<>();
        ArrayList<Sentence> sentBasKjLes2 = new ArrayList<>();

        sentMinGrLes1.add(template.save(new Sentence("私はマイク・ミラーです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Я Майк Миллер.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false,
                List.of(grammarMap.get("nは"), grammarMap.get("nです")),
                List.of(wordsMap.get("私")))));

        sentMinGrLes1.add(template.save(new Sentence("私は会社員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Я сотрудник компании.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false,
                List.of(grammarMap.get("nは"), grammarMap.get("nです")),
                List.of(wordsMap.get("私"), wordsMap.get("会社員")))));

        sentMinGrLes1.add(template.save(new Sentence("「サントスさんは学生じゃありません。」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Сантос-сан не студент.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんはアメリカ人ですか」「はい、アメリカ人です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан американец?' 'Да, американец'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんは先生ですか」「いいえ、先生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан преподаватель?' 'Нет, не преподаватель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「（あの方は）ミラーです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан преподаватель?' 'Нет, не преподаватель'",
                        List.of(new OtherPossibleSentence("「あのひとはだれですか」「（あの人は）ミラーです」", "zdoh", 1)))), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("ミラーさんは会社員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Миллер-сан сотрудник компании.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ミラーさんはIMCの社員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Миллер-сан сотрудник компании IMC.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("あの方はミラーさんです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это Миллер-сан.",
                        List.of(new OtherPossibleSentence("あの人はミラーさんです。", "zdoh", 1)))), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「マイク・ミラーさんですか」「はい、マイク・ミラーです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Вы Майк Миллер?' 'Да, Майк Миллер'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんは学生ですか」「いいえ、学生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан студент?' 'Нет, не студент'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワンさんは銀行ですか」「いいえ、銀行じゃありません。医者です」 ",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ван-сан сотрудник банка?' 'Нет, не сотрудник банка. Врач'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「ワットさんです。さくら大学の先生です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Ватт-сан. Преподаватель университета Сакура.'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「テレーザちゃんは何歳ですか」「9歳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Терезе-чян?' '9 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("ワンさんは中国人です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ван-сан китаец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワンさんは医者です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ван-сан врач.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「私はカール・シュミットじゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Я не Карл Шмидт'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("私はカール・シュミットではありません。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Я не Карл Шмидт")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「私は教師じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "私は教師ではありません。")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「イーさんはアメリカ人じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ии-сан не американка'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("イーさんはアメリカ人ではありません",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ии-сан не американка.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「イーさんは学生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ии-сан не студентка'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("イーさんは学生ではありません",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ии-сан не студентка.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「あの人は木村さんですか」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он Кимура-сан?'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はマライさんですか」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Она Мария-сан?'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("あの方はだれですか",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Он кто?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("私はBMWの社員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Я сотрудник компании БМВ.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("カリナさんは富士大学の学生です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Карина-сан студентка университета Фудзи.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんはさくら大学の先生です",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ватт-сан преподаватель университета Сакура.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("サントスさんはブラジル人です。マリアさんもブラジル人です",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Сантос-сан бразилец. Мария-сан тоже бразильянка")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「太郎ちゃんは何歳ですか」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Таро-куну?'")), minnaGrSourceL1, sentencePolitenessMap.get(""), true)));

        sentMinGrLes1.add(template.save(new Sentence("山田さんは日本人です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ямада-сан японец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんはイギリス人です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ватт-сан англичанин.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("タワポンさんはタイ人です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Тавапон-сан таец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("シュミットさんはドイツ人です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Шмидт-сан немец.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("山田さんは銀行員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ямада-сан сотрудник банка.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんは先生です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ватт-сан учитель.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("タワポンさんは学生です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Тавапон-сан студент.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("シュミットさんは会社員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Шмидт-сан сотрудник компании.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「山田さんは学生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ямада-сан не студент'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんはドイツ人じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ватт-сан не англичанин'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「タワポンさんは先生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Тавапон-сан не учитель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「シュミットさんはアメリカ人じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Шмидт-сан не американец'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「山田さんは銀行員ですか」「はい、銀行員です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ямада-сан сотрудник банка?' 'Да, сотрудник банка.'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんは会社員ですか」「いいえ、会社員じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ватт-сан служащий компании?' 'Нет, не служащий банка'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「タワポンさんは先生ですか」「いいえ、先生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Тавапон-сан учитель?' 'Нет, не учитель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「シュミットさんはドイツ人ですか」「はい、ドイツ人です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Шмидт-сан немец?' 'Да, немец'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「イーさんです。AKCの研究者です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Ии-сан. Ученый (компании) АКЦ'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「ワンさんです。神戸病院の医者です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Ван-сан. Врач больницы Кобэ'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「カリナさんです。富士大学の学生です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Карина-сан. Студентка университета Фудзи'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はどなたですか」「サントスさんです。ブラジルエアーの社員です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Сантос-сан. Бразильский сотрудник'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("山田さんは銀行員です。イーさんも銀行員ですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ямада-сан сотрудник банка. Ии-сан тоже сотрудница банка?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワットさんは先生です。ワンさんも先生せうか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ватт-сан учитель. Ван-сан тоже учитель?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("タワポンさんは学生です。カリナサンも学生ですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Тавапон-сан студент. Карина-сан тоже студентка?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("シュミットさんはドイツ人です。サントスさんもドイツじんですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Шмидт-сан немец. Сантос-сан тоже немец?")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「山田さんは何歳ですか」「38歳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Ямада-сану?' '38 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんは何歳ですか」「45歳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Ват-сану?' '45 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「タワポンさんは何歳ですか」「19歳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Тавапон-сану?' '19 лет'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「シュミットさんは何歳ですか」「５２歳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Шмидт-сану?' '52 года'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あなたは学生ですか」「はい、学生です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ты студент?' 'Да, студент'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あなたはミラーですか」「はい、ミラーです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ты Миллер?' 'Да, Миллер'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ワットさんもアメリカ人ですか」「いいえ、アメリカ人じゃありません。イギリス人です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Ватт-сан тоже американец?' 'Нет, не американец. Англичанин'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「あの方はだれですか」「サントスさんです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Сантос-сан'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("私はミラーです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Я Миллер.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("ワンさん医者です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ван-сан врач.")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes1.add(template.save(new Sentence("「カリナさんは先生でうか」「いいえ、先生じゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Карина-сан учитель?' 'Нет, не учитель'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes1.add(template.save(new Sentence("「ミラーさんは会社員です」「サントスさんも会社員です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан сотруднки компании' 'Сантос-сан тоже сотрудник компании'")), minnaGrSourceL1, sentencePolitenessMap.get("polite"), true)));

        /////////

        sentMinGrLes2.add(template.save(new Sentence("それは辞書ですか",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это словарь?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはだれの傘ですか",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это чей зонт?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("この本は私のです",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Эта книга моя.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あの方はどなたですか",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Он кто?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("「それは辞書ですか」「はい、そうです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это словарь?' 'Да, это так'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それはミラーさんのですか」「いいえ、違います」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это миллера?' 'Нет, это не так.'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それはシャープペンシルですか」「いいえ、ボールペンです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это механический карандаш?' 'Нет, это шариковая ручка'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは９ですか、７ですか」「９です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это 9 или 7?' '9'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("これはコンピュータの本です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это компьютерная книга.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは私の本です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это моя книга.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("「あれはだれのかばんですか」「佐藤さんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чей портфель?' 'Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このかばんはあなたのですか」「いいえ、私のじゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот портфель твой?' 'Нет, не мой'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「ミラーさんはIMCの社員ですか」「はい、IMCの社員です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан сотрудник IMC?' 'Да, сотрудник IMC'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「この傘はあなたのですか」「いいえ、違います。シュミットさんのです。そうですか」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот зонт твой?' 'Нет, не так. Шмидта-сана. Понятно.'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはボールペンですか」「はい、そうです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это шариковая ручка?' 'Да, это так'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それはノートですか」「いいえ、手帳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это тетрадь?' 'Нет, блокнот'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何ですか」「名刺です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Визитка'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の雑誌ですか」「コンピューターの雑誌です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за журнал?' 'Компьютерный журнал'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「あれはだれのかばんですか」「佐藤さんのかばんです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чей портфель?' 'Портфель Сатоу-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはミラーさんのですか」「いいえ、私のじゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это Миллер-сана?' 'Нет, не мое'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このかばんはだれのですか」「私のです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот портфель чей?' 'Мой'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("これは机です",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это стол.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは新聞です",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это газета.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは名刺です",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это визитка.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは何ですか",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это что?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはボールペンですか、シャープペンシルですか",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это шариковая ручка или механический карандаш?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それは「１」ですか、「９」ですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это один или девять?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それは「あ」ですか、「お」ですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это 'а' или 'о'?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは車の本です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это книга о машинах.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これはコンピュータの本です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это книга о компьютерах.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは日本の本です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это книга о Японии.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは何の本です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это что за книга?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは私のかばんです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То мой портфель.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは佐藤さんのかばんです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То портфель Сатоу-сана.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは先生のかばんです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То портфель учителя?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれはだれのかばんですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То чей портфель?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは私のです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То мое.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは佐藤さんのです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То Сатоу-сана.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは先生のです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То учителя.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれはだれのですか。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То чье?")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("この手帳は私のです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Этот блокнот мой.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("この鍵は私のです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Эти ключи мои.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("このかばんは私のです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Этот портфель мой.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは雑誌です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это журнал.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはノートです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это тетрадь.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれは辞書です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То словарь.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("それはかばんです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То портфель.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("これは鍵です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это ключ.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("あれはテレビです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "То телевизор.")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentMinGrLes2.add(template.save(new Sentence("「これは本ですか」「はい、本です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это книга?' 'Да, книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは手帳ですか」「いいえ、本です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это блокнот?' 'Нет, книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは時計ですか」「はい、時計です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это часы?' 'Да, часы'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはラジオですか」「いいえ、カメラです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это радио?' 'Нет, фотоаппарат'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは鉛筆ですか」「いいえ、シャープペンシルです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это карандаш?' 'Нет, механический карандаш'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは椅子ですか」「はい、椅子です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это стул?' 'Да, стул'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「本です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「時計です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Часы'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「カメラです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Фотоаппарат'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「シャープペンシルです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Механический карандаш'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何ですか」「椅子です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Стул'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはシャープペンシルですか、ボールペンですか」「ボールペンです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это механический карандаш или шариковая ручка?' 'Шариковая ручка'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは本ですか、雑誌ですか」「本です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это книга или журнал?' 'Книга'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは「い」ですか、「り」ですか」「「り」です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это и или ри?' 'Ри'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは「１」ですか、「７」ですか」「「７」です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это 1 или 7?' '7'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは「シ」ですか、「ツ」ですか」「「ツ」です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это ши или цу?' 'Цу'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは何の鍵ですか」「車の鍵です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за ключ?' 'Ключ от машины'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の雑誌ですか」「車の雑誌です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за журнал?' 'Журнал о машинах'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何のCDですか」「日本語のCDです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за CD?' 'CD на японском языке'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の雑誌ですか」「カメラの雑誌です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за журнал?' 'Журнал о фотоаппаратах'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「それは何の本ですか」「日本語の本です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за книга?' 'Книга на японском языке'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれのノートですか」「カリナサンのノートです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чья тетрадь?' 'Тетрадь Карины-сан'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれのかばんですか」「山田さんのかばん」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чей портфель?' 'Портфель Ямада-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれのカメラですか」「サントスさんのカメラです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чей фотоаппарат?' 'Фотоаппарат Сансос-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれの傘ですか」「佐藤さんの傘です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чей зонт?' 'Зонт Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはだれの手帳ですか」「ミラーさんの手帳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это чей блокнот?' 'Блокнот Миллер-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはカリナさんのですか」「はい、カリナさんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это Карины-сан?' 'Да, Карины-сан?'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはミラーさんのですか」「いいえ、ミラーさんのじゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это Миллер-сана?' 'Нет, не Миллер-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはワンさんのですか」「いいえ、ワンさんのじゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это Ван-сана?' 'Нет, не Ван-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これは佐藤さんのですか」「はい、佐藤さんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это Сато-сана?' 'Да, Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「これはワットさんのですか」「いいえ、ワットさんのじゃありません」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это Ватто-сана?' 'Нет, не Ватто-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このノートはだれのですか」「カリナさんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Эта тетрадь чья?' 'Карины-сан'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このかばんはだれのですか」「山田さんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот портфель чей?' 'Ямады-сан'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「このカメラはだれのですか」「サントスさんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот фотоаппарат чей?' 'Сантос-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「この傘はだれのですか」「佐藤さんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот зонт чей?' 'Сато-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        sentMinGrLes2.add(template.save(new Sentence("「この手帳はだれのですか」「ミラーさんのです」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Этот блокнот чей?' 'Миллер-сана'")), minnaGrSourceL2, sentencePolitenessMap.get("polite"), true)));

        ///

        sentMinKjLes1.add(template.save(new Sentence("「ミラーさんは学生ですか」「いいえ、学生じゃありません。会社員です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Миллер-сан студент?' 'Нет, не студент. Сотрудник компании.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「あの方はどなたですか」「ワットさんです。さくら大学の先生です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Ван-сан. Преподаватель университета Сакура.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「失礼ですがお名前は？」「マイク・ミラーです。アメリカから来ました。どうぞよろしく」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Извините, как вас зовут?' 'Майк Миллре. Приехал из Америки. Приятно познакомиться.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「あの人はだれですか」「 サントスさんです。サントスさんはブラジル人です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Он кто?' 'Сантос-сан. Сантос-сан бразилец.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「これは何ですか」「車の雑誌」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что?' 'Журнал о машинах.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("山田さんは銀行員です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ямада-сан сотрудник банка.")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentMinKjLes1.add(template.save(new Sentence("「それは何の本ですか」「日本語の本です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Это что за книга?' 'Книга на японском языке.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        sentMinKjLes1.add(template.save(new Sentence("「イーさんは何歳ですか」「二十歳です」",
                List.of(new SentenceTranslate(languageMap.get("ru"), "'Сколько лет Ии-сан?' 'Двадцать.'")), minnaKjSourceL1, sentencePolitenessMap.get("polite"), true)));

        ////

        sentBasKjLes1.add(template.save(new Sentence("あの人は山川さんです。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Он Ямакава-сан.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("山川さんは日本人です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Ямакава-сан японец.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("あの山は筑波山です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Та гора - гора Тсубака.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("この川は利根川です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Эта река - река Тонэ.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("今日は3月15日です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Сегодня 15 марта.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes1.add(template.save(new Sentence("川田さんの専門は車です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Специальность Кавады-сана машины.")), basicKjSourceL1, sentencePolitenessMap.get("polite"), false)));

        ///

        sentBasKjLes2.add(template.save(new Sentence("これは山川さんのお金です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это деньги Ямакавы-сан.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("すみません。水をください。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Извините. Воду пожалуйста.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("あの女の人は学生です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Это жензина студентка.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("私は先生ではありません。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Я не учитель.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("金田さんは大学の先生です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Канеда-сан преподаватель университета.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("あの女子学生は21歳です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Этой студентке 21 год.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        sentBasKjLes2.add(template.save(new Sentence("私の生年月日は1960年3月11日です。",
                List.of(new SentenceTranslate(languageMap.get("ru"), "Моя дата рождения 11 марта 1960 год.")), basicKjSourceL2, sentencePolitenessMap.get("polite"), false)));

        /*
        sentences.add(template.save(new Sentence("",
                List.of(template.save(new SentenceTranslate(languageMap.get("ru"), ""))), source1)));
*/

        textbookMap.get(Constants.MINNA_GR_1).getLessonList().get(0).setSentencesList(sentMinGrLes1);
        textbookMap.get(Constants.MINNA_GR_1).getLessonList().get(1).setSentencesList(sentMinGrLes2);

        textbookMap.get(Constants.MINNA_KANJI_1).getLessonList().get(1).setSentencesList(sentMinKjLes1);

        textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(0).setSentencesList(sentBasKjLes1);
        textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(1).setSentencesList(sentBasKjLes2);


        template.save(textbookMap.get(Constants.MINNA_GR_1));
        template.save(textbookMap.get(Constants.MINNA_KANJI_1));
        template.save(textbookMap.get(Constants.BASIC_KANJI_BOOK_1));

    }

}
