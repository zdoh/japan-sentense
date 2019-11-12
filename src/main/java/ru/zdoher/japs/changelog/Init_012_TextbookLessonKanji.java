package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.domain.textbook.Textbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ChangeLog(order = "012")
public class Init_012_TextbookLessonKanji {
    private Map<String, Kanji> kanjiMap;
    private Map<String, Textbook> textbookMap;

    public Init_012_TextbookLessonKanji() {
        kanjiMap = InitMaps.kanjiMap;
        textbookMap = InitMaps.textbookMap;
    }

    @ChangeSet(order = "001", id = "initialTextbookLessonKanji", author = "zdoh", runAlways = true)
    public void initialTextbookLessonKanji(MongoTemplate template) {
        List<Kanji> minnaKanjiL0 = new ArrayList<>();
        List<Kanji> minnaKanjiL1 = new ArrayList<>();

        List<Kanji> basicKanjiL1 = new ArrayList<>();
        List<Kanji> basicKanjiL2 = new ArrayList<>();



        minnaKanjiL0.add(kanjiMap.get("一"));
        minnaKanjiL0.add(kanjiMap.get("二"));
        minnaKanjiL0.add(kanjiMap.get("三"));
        minnaKanjiL0.add(kanjiMap.get("四"));
        minnaKanjiL0.add(kanjiMap.get("五"));
        minnaKanjiL0.add(kanjiMap.get("六"));
        minnaKanjiL0.add(kanjiMap.get("七"));
        minnaKanjiL0.add(kanjiMap.get("八"));
        minnaKanjiL0.add(kanjiMap.get("九"));
        minnaKanjiL0.add(kanjiMap.get("十"));

        minnaKanjiL1.add(kanjiMap.get("人"));
        minnaKanjiL1.add(kanjiMap.get("名"));
        minnaKanjiL1.add(kanjiMap.get("方"));
        minnaKanjiL1.add(kanjiMap.get("本"));
        minnaKanjiL1.add(kanjiMap.get("日"));
        minnaKanjiL1.add(kanjiMap.get("何"));
        minnaKanjiL1.add(kanjiMap.get("大"));
        minnaKanjiL1.add(kanjiMap.get("学"));
        minnaKanjiL1.add(kanjiMap.get("社"));
        minnaKanjiL1.add(kanjiMap.get("員"));
        minnaKanjiL1.add(kanjiMap.get("会"));
        minnaKanjiL1.add(kanjiMap.get("先"));
        minnaKanjiL1.add(kanjiMap.get("生"));
        minnaKanjiL1.add(kanjiMap.get("行"));
        minnaKanjiL1.add(kanjiMap.get("来"));
        minnaKanjiL1.add(kanjiMap.get("車"));

        basicKanjiL1.add(kanjiMap.get("日"));
        basicKanjiL1.add(kanjiMap.get("月"));
        basicKanjiL1.add(kanjiMap.get("木"));
        basicKanjiL1.add(kanjiMap.get("山"));
        basicKanjiL1.add(kanjiMap.get("川"));
        basicKanjiL1.add(kanjiMap.get("田"));
        basicKanjiL1.add(kanjiMap.get("人"));
        basicKanjiL1.add(kanjiMap.get("口"));
        basicKanjiL1.add(kanjiMap.get("車"));
        basicKanjiL1.add(kanjiMap.get("門"));

        basicKanjiL2.add(kanjiMap.get("火"));
        basicKanjiL2.add(kanjiMap.get("水"));
        basicKanjiL2.add(kanjiMap.get("金"));
        basicKanjiL2.add(kanjiMap.get("土"));
        basicKanjiL2.add(kanjiMap.get("子"));
        basicKanjiL2.add(kanjiMap.get("女"));
        basicKanjiL2.add(kanjiMap.get("学"));
        basicKanjiL2.add(kanjiMap.get("生"));
        basicKanjiL2.add(kanjiMap.get("先"));
        basicKanjiL2.add(kanjiMap.get("私"));

        // basicKanjiL2.add(kanjiMap.get(""));

        textbookMap.get(Constants.MINNA_KANJI_1).getLessonList().get(0).setKanjiList(minnaKanjiL0);
        textbookMap.get(Constants.MINNA_KANJI_1).getLessonList().get(1).setKanjiList(minnaKanjiL1);

        textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(0).setKanjiList(basicKanjiL1);
        textbookMap.get(Constants.BASIC_KANJI_BOOK_1).getLessonList().get(1).setKanjiList(basicKanjiL2);

        template.save(textbookMap.get(Constants.MINNA_KANJI_1));
        template.save(textbookMap.get(Constants.BASIC_KANJI_BOOK_1));
    }

}
