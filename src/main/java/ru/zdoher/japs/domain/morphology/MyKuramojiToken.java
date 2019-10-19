package ru.zdoher.japs.domain.morphology;

import com.atilika.kuromoji.ipadic.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyKuramojiToken {
    private Token token;

    private List<KuramojiPartOfSpeech> kuramojiPartOfSpeeches;

    public MyKuramojiToken(Token token) {
        this.token = token;
        kuramojiPartOfSpeeches = new ArrayList<>();
    }
}
