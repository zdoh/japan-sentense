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
public class PartOfSpeech {

    @Id
    private String id;

    private String shortName;

    private List<TranslateEntity> translateName;

    private String japanName;

    public PartOfSpeech(String shortName, List<TranslateEntity> translateName, String japanName) {
        this.shortName = shortName;
        this.translateName = translateName;
        this.japanName = japanName;
    }

    public PartOfSpeech(String shortName, List<TranslateEntity> translateName) {
        this.shortName = shortName;
        this.translateName = translateName;
    }
}
