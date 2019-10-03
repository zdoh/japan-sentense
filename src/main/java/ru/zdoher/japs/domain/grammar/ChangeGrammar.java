package ru.zdoher.japs.domain.grammar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeGrammar {

    private String name;

    private String deletingPart;

    private String addingPart;

    private PartOfSpeech resultPartOfSpeech;

    private List<Word> exception;
}
