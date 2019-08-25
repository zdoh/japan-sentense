package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.sentence.Sentence;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Lesson {

    @Id
    private String id;

    private String name;

    @DBRef
    private List<Kanji> kanjiList;

    @DBRef
    private List<Word> wordList;

    @DBRef
    private List<Grammar> grammarsList;

    @DBRef
    private List<Sentence> sentencesList;

    public Lesson(String name) {
        this.name = name;
    }
}
