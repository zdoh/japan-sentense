package ru.zdoher.japs.domain.textbook;

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
public class TextbookType {

    @Id
    private String id;

    private String name;

    private List<TranslateEntity> translateName;

    public TextbookType(String name, List<TranslateEntity> translateName) {
        this.name = name;
        this.translateName = translateName;
    }
}
