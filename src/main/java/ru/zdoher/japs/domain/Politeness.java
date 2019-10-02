package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.TranslateEntity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Politeness {

    @Id
    private String id;

    private String japName;

    private List<TranslateEntity> translateEntities;

    public Politeness(String japName, List<TranslateEntity> translateEntities) {
        this.japName = japName;
        this.translateEntities = translateEntities;
    }
}
