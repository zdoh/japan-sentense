package ru.zdoher.japs.domain.sentence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherPossibleSentence {

    // предложение
    private String sentence;

    // автор предложения
    private String author;

    // лайки за этот вариант
    private Integer likesCount;



}
