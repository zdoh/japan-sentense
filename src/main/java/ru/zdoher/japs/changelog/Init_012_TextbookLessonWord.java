package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.domain.textbook.Textbook;

import java.util.ArrayList;
import java.util.Map;

@ChangeLog(order = "012")
public class Init_012_TextbookLessonWord {
    private Map<String, Word> wordsMap;
    private Map<String, Textbook> textbookMap;

    public Init_012_TextbookLessonWord() {
        wordsMap = InitMaps.wordsMap;
        textbookMap = InitMaps.textbookMap;
    }

    @ChangeSet(order = "012", id = "initialTextbookLessonWord", author = "zdoh", runAlways = true)
    public void initTextbookLessonWord(MongoTemplate template) {
        ArrayList<Word> minnaGrWordsL1 = new ArrayList<>();
        ArrayList<Word> minnaGrWordsL2 = new ArrayList<>();
        ArrayList<Word> minnaKanjiWordsL0 = new ArrayList<>();
        ArrayList<Word> minnaKanjiWordsL1 = new ArrayList<>();
        ArrayList<Word> basicKanjiBookWordsL1 = new ArrayList<>();
        ArrayList<Word> basicKanjiBookWordsL2 = new ArrayList<>();

        ///

        minnaGrWordsL1.add(wordsMap.get("私"));
        minnaGrWordsL1.add(wordsMap.get("あなた"));
        minnaGrWordsL1.add(wordsMap.get("あの人"));
        minnaGrWordsL1.add(wordsMap.get("あの方"));
        minnaGrWordsL1.add(wordsMap.get("先生"));
        minnaGrWordsL1.add(wordsMap.get("教師"));
        minnaGrWordsL1.add(wordsMap.get("学生"));
        minnaGrWordsL1.add(wordsMap.get("会社員"));
        minnaGrWordsL1.add(wordsMap.get("社員"));
        minnaGrWordsL1.add(wordsMap.get("銀行員"));
        minnaGrWordsL1.add(wordsMap.get("医者"));
        minnaGrWordsL1.add(wordsMap.get("研究者"));
        minnaGrWordsL1.add(wordsMap.get("大学"));
        minnaGrWordsL1.add(wordsMap.get("病院"));
        minnaGrWordsL1.add(wordsMap.get("誰"));
        minnaGrWordsL1.add(wordsMap.get("どなた"));
        minnaGrWordsL1.add(wordsMap.get("何歳"));
        minnaGrWordsL1.add(wordsMap.get("いくつ"));
        minnaGrWordsL1.add(wordsMap.get("はい"));
        minnaGrWordsL1.add(wordsMap.get("いいえ"));
        minnaGrWordsL1.add(wordsMap.get("国"));
        minnaGrWordsL1.add(wordsMap.get("言葉"));
        minnaGrWordsL1.add(wordsMap.get("アメリカ"));
        minnaGrWordsL1.add(wordsMap.get("イギリス"));
        minnaGrWordsL1.add(wordsMap.get("イタリア"));
        minnaGrWordsL1.add(wordsMap.get("イラン"));
        minnaGrWordsL1.add(wordsMap.get("韓国"));
        minnaGrWordsL1.add(wordsMap.get("スペイン"));
        minnaGrWordsL1.add(wordsMap.get("ドイツ"));
        minnaGrWordsL1.add(wordsMap.get("日本"));
        minnaGrWordsL1.add(wordsMap.get("ロシア"));
        minnaGrWordsL1.add(wordsMap.get("中国"));
        minnaGrWordsL1.add(wordsMap.get("アメリカ人"));
        minnaGrWordsL1.add(wordsMap.get("韓国人"));
        minnaGrWordsL1.add(wordsMap.get("中国人"));
        minnaGrWordsL1.add(wordsMap.get("日本人"));
        minnaGrWordsL1.add(wordsMap.get("ロシア人"));
        minnaGrWordsL1.add(wordsMap.get("英語"));
        minnaGrWordsL1.add(wordsMap.get("韓国語"));
        minnaGrWordsL1.add(wordsMap.get("日本語"));
        minnaGrWordsL1.add(wordsMap.get("ロシア語"));


        ///

        minnaGrWordsL2.add(wordsMap.get("これ"));
        minnaGrWordsL2.add(wordsMap.get("それ"));
        minnaGrWordsL2.add(wordsMap.get("あれ"));
        minnaGrWordsL2.add(wordsMap.get("本"));
        minnaGrWordsL2.add(wordsMap.get("辞書"));
        minnaGrWordsL2.add(wordsMap.get("雑誌"));
        minnaGrWordsL2.add(wordsMap.get("新聞"));
        minnaGrWordsL2.add(wordsMap.get("ノット"));
        minnaGrWordsL2.add(wordsMap.get("手帳"));
        minnaGrWordsL2.add(wordsMap.get("名刺"));
        minnaGrWordsL2.add(wordsMap.get("カード"));
        minnaGrWordsL2.add(wordsMap.get("鉛筆"));
        minnaGrWordsL2.add(wordsMap.get("ボールペン"));
        minnaGrWordsL2.add(wordsMap.get("シャープペンシル"));
        minnaGrWordsL2.add(wordsMap.get("鍵"));
        minnaGrWordsL2.add(wordsMap.get("時計"));
        minnaGrWordsL2.add(wordsMap.get("傘"));
        minnaGrWordsL2.add(wordsMap.get("かばん"));
        minnaGrWordsL2.add(wordsMap.get("CD"));
        minnaGrWordsL2.add(wordsMap.get("テレビ"));
        minnaGrWordsL2.add(wordsMap.get("ラジオ"));
        minnaGrWordsL2.add(wordsMap.get("カメラ"));
        minnaGrWordsL2.add(wordsMap.get("コンピューター"));
        minnaGrWordsL2.add(wordsMap.get("車"));
        minnaGrWordsL2.add(wordsMap.get("机"));
        minnaGrWordsL2.add(wordsMap.get("椅子"));
        minnaGrWordsL2.add(wordsMap.get("チョコレート"));
        minnaGrWordsL2.add(wordsMap.get("コーヒー"));
        minnaGrWordsL2.add(wordsMap.get("土産"));
        minnaGrWordsL2.add(wordsMap.get("何"));
        minnaGrWordsL2.add(wordsMap.get("そう"));
        minnaGrWordsL2.add(wordsMap.get("違う"));

        ///

        minnaKanjiWordsL0.add(wordsMap.get("一つ"));
        minnaKanjiWordsL0.add(wordsMap.get("二つ"));
        minnaKanjiWordsL0.add(wordsMap.get("三つ"));
        minnaKanjiWordsL0.add(wordsMap.get("四つ"));
        minnaKanjiWordsL0.add(wordsMap.get("五つ"));
        minnaKanjiWordsL0.add(wordsMap.get("六つ"));
        minnaKanjiWordsL0.add(wordsMap.get("七つ"));
        minnaKanjiWordsL0.add(wordsMap.get("八つ"));
        minnaKanjiWordsL0.add(wordsMap.get("九つ"));
        minnaKanjiWordsL0.add(wordsMap.get("十"));
        minnaKanjiWordsL0.add(wordsMap.get("一月"));
        minnaKanjiWordsL0.add(wordsMap.get("二月"));
        minnaKanjiWordsL0.add(wordsMap.get("三月"));
        minnaKanjiWordsL0.add(wordsMap.get("四月"));
        minnaKanjiWordsL0.add(wordsMap.get("五月"));
        minnaKanjiWordsL0.add(wordsMap.get("六月"));
        minnaKanjiWordsL0.add(wordsMap.get("七月"));
        minnaKanjiWordsL0.add(wordsMap.get("八月"));
        minnaKanjiWordsL0.add(wordsMap.get("九月"));
        minnaKanjiWordsL0.add(wordsMap.get("十月"));

        ///

        minnaKanjiWordsL1.add(wordsMap.get("アメリカ人"));
        minnaKanjiWordsL1.add(wordsMap.get("あの人"));
        minnaKanjiWordsL1.add(wordsMap.get("人"));
        minnaKanjiWordsL1.add(wordsMap.get("日本人"));
        minnaKanjiWordsL1.add(wordsMap.get("だれ"));
        minnaKanjiWordsL1.add(wordsMap.get("名前"));
        minnaKanjiWordsL1.add(wordsMap.get("名"));
        minnaKanjiWordsL1.add(wordsMap.get("あの方"));
        minnaKanjiWordsL1.add(wordsMap.get("方"));
        minnaKanjiWordsL1.add(wordsMap.get("カメラ"));
        minnaKanjiWordsL1.add(wordsMap.get("本"));
        minnaKanjiWordsL1.add(wordsMap.get("日本"));
        minnaKanjiWordsL1.add(wordsMap.get("日"));
        minnaKanjiWordsL1.add(wordsMap.get("これ"));
        minnaKanjiWordsL1.add(wordsMap.get("何"));
        minnaKanjiWordsL1.add(wordsMap.get("大きい"));
        minnaKanjiWordsL1.add(wordsMap.get("大学"));
        minnaKanjiWordsL1.add(wordsMap.get("大いに"));
        minnaKanjiWordsL1.add(wordsMap.get("学ぶ"));
        minnaKanjiWordsL1.add(wordsMap.get("二十歳"));
        minnaKanjiWordsL1.add(wordsMap.get("社員"));
        minnaKanjiWordsL1.add(wordsMap.get("社"));
        minnaKanjiWordsL1.add(wordsMap.get("会社員"));
        minnaKanjiWordsL1.add(wordsMap.get("会う"));
        minnaKanjiWordsL1.add(wordsMap.get("先生"));
        minnaKanjiWordsL1.add(wordsMap.get("生む"));
        minnaKanjiWordsL1.add(wordsMap.get("生まれる"));
        minnaKanjiWordsL1.add(wordsMap.get("生"));
        minnaKanjiWordsL1.add(wordsMap.get("銀行員"));
        minnaKanjiWordsL1.add(wordsMap.get("行く"));
        minnaKanjiWordsL1.add(wordsMap.get("銀行"));
        minnaKanjiWordsL1.add(wordsMap.get("アメリカ"));
        minnaKanjiWordsL1.add(wordsMap.get("来る"));
        minnaKanjiWordsL1.add(wordsMap.get("来年"));
        minnaKanjiWordsL1.add(wordsMap.get("車"));
        minnaKanjiWordsL1.add(wordsMap.get("電車"));
        minnaKanjiWordsL1.add(wordsMap.get("いいえ"));
        minnaKanjiWordsL1.add(wordsMap.get("学生"));
        minnaKanjiWordsL1.add(wordsMap.get("どなた"));
        minnaKanjiWordsL1.add(wordsMap.get("失礼"));
        minnaKanjiWordsL1.add(wordsMap.get("ブラジル人"));
        minnaKanjiWordsL1.add(wordsMap.get("それ"));
        minnaKanjiWordsL1.add(wordsMap.get("雑誌"));
        minnaKanjiWordsL1.add(wordsMap.get("日本語"));
        minnaKanjiWordsL1.add(wordsMap.get("何歳"));

        ///

        basicKanjiBookWordsL1.add(wordsMap.get("日"));
        basicKanjiBookWordsL1.add(wordsMap.get("日本"));
        basicKanjiBookWordsL1.add(wordsMap.get("日曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("3日"));
        basicKanjiBookWordsL1.add(wordsMap.get("月"));
        basicKanjiBookWordsL1.add(wordsMap.get("一月"));
        basicKanjiBookWordsL1.add(wordsMap.get("月曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("木"));
        basicKanjiBookWordsL1.add(wordsMap.get("木曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("山"));
        basicKanjiBookWordsL1.add(wordsMap.get("富士山"));
        basicKanjiBookWordsL1.add(wordsMap.get("火山"));
        basicKanjiBookWordsL1.add(wordsMap.get("川"));
        basicKanjiBookWordsL1.add(wordsMap.get("河川"));
        basicKanjiBookWordsL1.add(wordsMap.get("田"));
        basicKanjiBookWordsL1.add(wordsMap.get("田んぼ"));
        basicKanjiBookWordsL1.add(wordsMap.get("水田"));
        basicKanjiBookWordsL1.add(wordsMap.get("人"));
        basicKanjiBookWordsL1.add(wordsMap.get("日本人"));
        basicKanjiBookWordsL1.add(wordsMap.get("三人"));
        basicKanjiBookWordsL1.add(wordsMap.get("口"));
        basicKanjiBookWordsL1.add(wordsMap.get("出口"));
        basicKanjiBookWordsL1.add(wordsMap.get("入り口"));
        basicKanjiBookWordsL1.add(wordsMap.get("人口"));
        basicKanjiBookWordsL1.add(wordsMap.get("車"));
        basicKanjiBookWordsL1.add(wordsMap.get("電車"));
        basicKanjiBookWordsL1.add(wordsMap.get("自動車"));
        basicKanjiBookWordsL1.add(wordsMap.get("門"));
        basicKanjiBookWordsL1.add(wordsMap.get("専門"));
        basicKanjiBookWordsL1.add(wordsMap.get("日曜日"));
        basicKanjiBookWordsL1.add(wordsMap.get("今日"));
        basicKanjiBookWordsL1.add(wordsMap.get("あの人"));
        basicKanjiBookWordsL1.add(wordsMap.get("二月"));
        basicKanjiBookWordsL1.add(wordsMap.get("三月"));
        basicKanjiBookWordsL1.add(wordsMap.get("四月"));
        basicKanjiBookWordsL1.add(wordsMap.get("五月"));
        basicKanjiBookWordsL1.add(wordsMap.get("六月"));
        basicKanjiBookWordsL1.add(wordsMap.get("七月"));
        basicKanjiBookWordsL1.add(wordsMap.get("八月"));
        basicKanjiBookWordsL1.add(wordsMap.get("九月"));
        basicKanjiBookWordsL1.add(wordsMap.get("十月"));
        basicKanjiBookWordsL1.add(wordsMap.get("十一月"));
        basicKanjiBookWordsL1.add(wordsMap.get("十二月"));

        ///

        basicKanjiBookWordsL2.add(wordsMap.get("火"));
        basicKanjiBookWordsL2.add(wordsMap.get("火山"));
        basicKanjiBookWordsL2.add(wordsMap.get("火曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("水"));
        basicKanjiBookWordsL2.add(wordsMap.get("水田"));
        basicKanjiBookWordsL2.add(wordsMap.get("水曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("お金"));
        basicKanjiBookWordsL2.add(wordsMap.get("金曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("土"));
        basicKanjiBookWordsL2.add(wordsMap.get("土木"));
        basicKanjiBookWordsL2.add(wordsMap.get("土曜日"));
        basicKanjiBookWordsL2.add(wordsMap.get("子供"));
        basicKanjiBookWordsL2.add(wordsMap.get("女の子"));
        basicKanjiBookWordsL2.add(wordsMap.get("女子"));
        basicKanjiBookWordsL2.add(wordsMap.get("女子学生"));
        basicKanjiBookWordsL2.add(wordsMap.get("女"));
        basicKanjiBookWordsL2.add(wordsMap.get("女の人"));
        basicKanjiBookWordsL2.add(wordsMap.get("彼女"));
        basicKanjiBookWordsL2.add(wordsMap.get("学ぶ"));
        basicKanjiBookWordsL2.add(wordsMap.get("学生"));
        basicKanjiBookWordsL2.add(wordsMap.get("大学"));
        basicKanjiBookWordsL2.add(wordsMap.get("学校"));
        basicKanjiBookWordsL2.add(wordsMap.get("生きる"));
        basicKanjiBookWordsL2.add(wordsMap.get("生む"));
        basicKanjiBookWordsL2.add(wordsMap.get("生まれる"));
        basicKanjiBookWordsL2.add(wordsMap.get("先生"));
        basicKanjiBookWordsL2.add(wordsMap.get("先"));
        basicKanjiBookWordsL2.add(wordsMap.get("先月"));
        basicKanjiBookWordsL2.add(wordsMap.get("私"));
        basicKanjiBookWordsL2.add(wordsMap.get("私立"));
        basicKanjiBookWordsL2.add(wordsMap.get("私立大学"));
        basicKanjiBookWordsL2.add(wordsMap.get("すみません"));
        basicKanjiBookWordsL2.add(wordsMap.get("生年月日"));
        basicKanjiBookWordsL2.add(wordsMap.get("火事"));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));
        basicKanjiBookWordsL2.add(wordsMap.get(""));




        //words.add(wordsMap.get(""));


        textbookMap.get(Constants.MINNA_GR_1).getLessonList().get(0).setWordList(minnaGrWordsL1);
        textbookMap.get(Constants.MINNA_GR_1).getLessonList().get(1).setWordList(minnaGrWordsL2);

        textbookMap.get(Constants.MINNA_KANJI_1).getLessonList().get(0).setWordList(minnaKanjiWordsL0);
        textbookMap.get(Constants.MINNA_KANJI_1).getLessonList().get(1).setWordList(minnaKanjiWordsL1);

        textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(0).setWordList(basicKanjiBookWordsL1);
        textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(1).setWordList(basicKanjiBookWordsL2);

        template.save(textbookMap.get(Constants.MINNA_GR_1));

        /*textbookMap.put("Minna no nihongo begin grammar I - Lesson1",
                template.save(textbookMap.get("Minna no nihongo begin grammar I")));*/
    }

}
