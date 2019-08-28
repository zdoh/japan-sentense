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
public class Grammar {

    @Id
    private String id;

    private List<PartOfSpeech> grammarCreate;

    private PartOfSpeech resultPartOfSpeech;

    private List<TranslateEntity> grammarComment;

    public Grammar(List<PartOfSpeech> grammarCreate, List<TranslateEntity> grammarComment) {
        this.grammarCreate = grammarCreate;
        this.grammarComment = grammarComment;
    }

    public Grammar(List<PartOfSpeech> grammarCreate, PartOfSpeech resultPartOfSpeech, List<TranslateEntity> grammarComment) {
        this.grammarCreate = grammarCreate;
        this.resultPartOfSpeech = resultPartOfSpeech;
        this.grammarComment = grammarComment;
    }
}
