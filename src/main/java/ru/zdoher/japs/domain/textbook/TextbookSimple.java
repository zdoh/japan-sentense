package ru.zdoher.japs.domain.textbook;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextbookSimple {
    private String id;
    private String japaneseName;
    private String englishName;
}
