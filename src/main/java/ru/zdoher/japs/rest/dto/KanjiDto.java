package ru.zdoher.japs.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.domain.TranslateEntity;
import ru.zdoher.japs.domain.Word;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KanjiDto {
    private String id;

    private String kanji;

    private List<TranslateEntity> meaning;

    private List<String> onyumi;

    private List<Word> kunyumi;

    private Word anchor;

    public static KanjiDto toDto(Kanji kanji) {
        return new KanjiDto(
                kanji.getId(),
                kanji.getKanji(),
                kanji.getMeaning(),
                kanji.getOnyumi(),
                kanji.getKunyumi(),
                kanji.getAnchor()
        );
    }

    public Kanji fromDto(KanjiDto kanjiDto) {
        return new Kanji(id, kanji, meaning, onyumi, kunyumi, anchor);
    }
}
