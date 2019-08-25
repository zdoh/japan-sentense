package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Word {

    @Id
    private String id;

    private String wordKanji;

    private String pronunciation;

    private List<TranslateEntity> translateEntities;

    private List<WordType> wordTypes;

    public Word(String wordKanji, String pronunciation, List<TranslateEntity> translateEntities, List<WordType> wordTypes) {
        this.wordKanji = wordKanji;
        this.pronunciation = pronunciation;
        this.translateEntities = translateEntities;
        this.wordTypes = wordTypes;
    }

    public Word(String wordKanji) {
        this.wordKanji = wordKanji;
    }
}
