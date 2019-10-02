package ru.zdoher.japs.domain.grammar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddingGrammar {

    private List<PartOfSpeech> grammarCreate;

    private PartOfSpeech resultPartOfSpeech;

    private List<TranslateEntity> grammarComment;

    public AddingGrammar(List<PartOfSpeech> grammarCreate, List<TranslateEntity> grammarComment) {
        this.grammarCreate = grammarCreate;
        this.grammarComment = grammarComment;
    }
}
