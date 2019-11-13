package ru.zdoher.japs.domain.grammar;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;

import java.util.List;

@Data
@Builder
@Document
public class Grammar {

    @Id
    private String id;

    private String name;

    private GrammarType grammarType;


    private AddingGrammar addingGrammar;

    private List<ChangeGrammar> changeGrammarMap;

    private SentencePoliteness sentencePoliteness;

    private boolean conversation;
}
