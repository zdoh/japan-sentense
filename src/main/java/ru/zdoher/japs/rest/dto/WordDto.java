package ru.zdoher.japs.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zdoher.japs.domain.PartOfSpeech;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordDto {

    private String id;

    private String wordKanji;

    private String pronunciation;

    private List<TranslateEntity> translateEntities;

    private List<PartOfSpeech> partOfSpeeches;

    private boolean dontShow;

    public static WordDto toDto(Word word) {
        return new WordDto(
                word.getId(),
                word.getWordKanji(),
                word.getPronunciation(),
                word.getTranslateEntities(),
                word.getPartOfSpeeches(),
                word.isDontShow());
    }

    public Word fromDto() {
        return new Word(id, wordKanji, pronunciation, translateEntities, partOfSpeeches, dontShow);
    }
}
