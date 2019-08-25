package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class TextbookSeries {

    @Id
    private String id;

    private String name;

    private String englishName;

    public TextbookSeries(String name, String englishName) {
        this.name = name;
        this.englishName = englishName;
    }
}
