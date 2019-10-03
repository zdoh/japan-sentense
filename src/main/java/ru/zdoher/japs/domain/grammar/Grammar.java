package ru.zdoher.japs.domain.grammar;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.zdoher.japs.domain.Politeness;

import java.util.List;
import java.util.Map;

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

    private Politeness politeness;

    private boolean conversation;
}
