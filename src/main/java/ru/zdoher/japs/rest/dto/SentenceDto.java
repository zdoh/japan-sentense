package ru.zdoher.japs.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zdoher.japs.domain.grammar.Grammar;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.domain.Politeness;
import ru.zdoher.japs.domain.sentence.SentenceTranslate;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SentenceDto {
    private String id;

    private String sentence;

    private List<SentenceTranslate> translateList;

    private String sentenceSource;

    private Politeness politeness;

    private Boolean conversation;

    private List<Grammar> grammarList;

    private List<Word> words;

    public static SentenceDto toDto(Sentence sentence) {
        return new SentenceDto(
                sentence.getId(),
                sentence.getSentence(),
                sentence.getTranslateList(),
                sentence.getSentenceSource(),
                sentence.getPoliteness(),
                sentence.getConversation(),
                sentence.getGrammarList(),
                sentence.getWords()
        );
    }

    public Sentence fromDto() {
        return new Sentence(id, sentence, translateList, sentenceSource, politeness, conversation, grammarList, words);
    }
}
