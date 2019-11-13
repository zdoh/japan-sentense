package ru.zdoher.japs.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.zdoher.japs.domain.Lesson;
import ru.zdoher.japs.domain.textbook.Textbook;

import java.util.Map;

@ChangeLog(order = "011")
public class Init_011_Lesson {
    private Map<String, Textbook> textbookMap;

    public Init_011_Lesson() {
        textbookMap = InitMaps.textbookMap;
    }

    @ChangeSet(order = "011", id = "initialLesson", author = "zdoh", runAlways = true)
    public void initLesson(MongoTemplate template) {
        Textbook textbook = textbookMap.get(Constants.MINNA_GR_1);
        textbook.getLessonList().add(new Lesson("Lesson 1"));
        textbook.getLessonList().add(new Lesson("Lesson 2"));

        Textbook textbook1 = textbookMap.get(Constants.MINNA_KANJI_1);
        textbook1.getLessonList().add(new Lesson("Lesson 0"));
        textbook1.getLessonList().add(new Lesson("Lesson 1-2"));

        Textbook textbook2 = textbookMap.get(Constants.BASIC_KANJI_BOOK_1);
        textbook2.getLessonList().add(new Lesson("Lesson 1"));
        textbook2.getLessonList().add(new Lesson("Lesson 2"));

        template.save(textbook);
        template.save(textbook1);
        template.save(textbook2);
    }

}
