package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Word {

    @Id
    private String id;

    private String wordKanji;

    private String pronunciation;

    private List<TranslateEntity> translateEntities;

    private PartOfSpeech mainPartOfSpeech;

    private List<PartOfSpeech> sidePartOfSpeeches;

    private boolean dontShow;
}
