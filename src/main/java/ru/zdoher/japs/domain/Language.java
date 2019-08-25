package ru.zdoher.japs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Language {

    @Id
    private String id;


    private String shortName;

    private String fullName;

    public Language(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
    }
}
