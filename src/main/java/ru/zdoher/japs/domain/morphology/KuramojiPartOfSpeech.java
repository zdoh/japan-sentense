package ru.zdoher.japs.domain.morphology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class KuramojiPartOfSpeech {

    @Id
    private String id;

    private String name;

    private List<TranslateEntity> translateName;

    private KuramojiTypeOfSpeech type;

    public KuramojiPartOfSpeech(String name, List<TranslateEntity> translateName, KuramojiTypeOfSpeech type) {
        this.name = name;
        this.translateName = translateName;
        this.type = type;
    }
}
