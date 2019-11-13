package ru.zdoher.japs.domain.sentence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.grammar.Grammar;
import ru.zdoher.japs.domain.Word;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Sentence {

    @Id
    private String id;

    private String sentence;

    private List<SentenceTranslate> translateList;

    private String sentenceSource;

    private SentencePoliteness sentencePoliteness;

    private Boolean conversation;

    private List<Grammar> grammarList;

    private List<Word> words;

    public Sentence(String sentence, List<SentenceTranslate> translateList, String sentenceSource, SentencePoliteness sentencePoliteness, Boolean conversation) {
        this.sentence = sentence;
        this.translateList = translateList;
        this.sentenceSource = sentenceSource;
        this.sentencePoliteness = sentencePoliteness;
        this.conversation = conversation;
    }

    public Sentence(String sentence, List<SentenceTranslate> translateList, String sentenceSource, SentencePoliteness sentencePoliteness, Boolean conversation, List<Grammar> grammarList) {
        this.sentence = sentence;
        this.translateList = translateList;
        this.sentenceSource = sentenceSource;
        this.sentencePoliteness = sentencePoliteness;
        this.conversation = conversation;
        this.grammarList = grammarList;
    }

    public Sentence(String sentence, List<SentenceTranslate> translateList, String sentenceSource, SentencePoliteness sentencePoliteness, Boolean conversation, List<Grammar> grammarList, List<Word> words) {
        this.sentence = sentence;
        this.translateList = translateList;
        this.sentenceSource = sentenceSource;
        this.sentencePoliteness = sentencePoliteness;
        this.conversation = conversation;
        this.grammarList = grammarList;
        this.words = words;
    }
}
