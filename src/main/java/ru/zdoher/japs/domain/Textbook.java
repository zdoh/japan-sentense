package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Textbook {

    @Id
    private String id;

    private String japaneseName;

    private String englishName;

    @DBRef
    private TextbookSeries textbookSeries;

    private Boolean show;

    @DBRef
    private List<TextbookType> textbookType;

    private List<Lesson> lessonList;

    public Textbook(String japaneseName, String englishName, Boolean show) {
        this.japaneseName = japaneseName;
        this.englishName = englishName;
        this.show = show;
        textbookType = new ArrayList<>();
        lessonList = new ArrayList<>();
    }

    public Textbook(String japaneseName, String englishName, TextbookSeries textbookSeries, Boolean show) {
        this.japaneseName = japaneseName;
        this.englishName = englishName;
        this.textbookSeries = textbookSeries;
        this.show = show;
        textbookType = new ArrayList<>();
        lessonList = new ArrayList<>();
    }
}
