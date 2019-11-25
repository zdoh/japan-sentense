package ru.zdoher.japs.batch.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class H2PartOfSpeech {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortName;

    @OneToMany(targetEntity = H2TranslateEntity.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "h2part_of_speech_id")
    private List<H2TranslateEntity> h2TranslateEntity;

    private String japanName;

}
