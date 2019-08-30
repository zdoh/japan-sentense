package ru.zdoher.japs.domain.sentence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.Language;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SentenceTranslate {

    // язык перевода
    private Language language;

    // перевод предложения на язык
    private String translate;

    // другие варианты перевода предложения с языка перевода на японский
    private List<OtherPossibleSentence> otherOrigin;

    public SentenceTranslate(Language language, String translate) {
        this.language = language;
        this.translate = translate;
    }


}
