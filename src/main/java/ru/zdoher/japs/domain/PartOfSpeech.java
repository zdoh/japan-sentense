package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.morphology.KuramojiTypeOfSpeech;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class PartOfSpeech {

    @Id
    private String id;

    private String shortName;

    private List<TranslateEntity> translateName;

    private String japanName;

    private KuramojiTypeOfSpeech kuramojiTypeOfSpeech;

    private boolean hidden;
}
