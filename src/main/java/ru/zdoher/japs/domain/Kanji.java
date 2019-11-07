package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Kanji {

    @Id
    private String id;

    private String kanji;

    private List<TranslateEntity> meaning;

    private List<String> onyumi;

    private List<String> kunyumi;

    @DBRef
    private List<Word> words;

    @DBRef
    private Word anchor;

    public Kanji(String kanji, List<TranslateEntity> meaning, List<String> onyumi, List<String> kunyumi, List<Word> words, Word anchor) {
        this.kanji = kanji;
        this.meaning = meaning;
        this.onyumi = onyumi;
        this.kunyumi = kunyumi;
        this.words = words;
        this.anchor = anchor;
    }

    public Kanji(String kanji, List<TranslateEntity> meaning, List<String> onyumi, List<Word> words, Word anchor) {
        this.kanji = kanji;
        this.meaning = meaning;
        this.onyumi = onyumi;
        this.words = words;
        this.anchor = anchor;
    }
}
