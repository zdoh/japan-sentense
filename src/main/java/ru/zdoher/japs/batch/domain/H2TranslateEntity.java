package ru.zdoher.japs.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zdoher.japs.domain.Language;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class H2TranslateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = H2Language.class)
    private H2Language language;

    private String translate;

    public H2TranslateEntity(H2Language language, String translate) {
        this.language = language;
        this.translate = translate;
    }
}
