package ru.zdoher.japs.service;

import org.springframework.stereotype.Service;
import ru.zdoher.japs.domain.sentence.Sentence;

@Service
public class SentenceMorphologyDecisionImpl {

    public Sentence grammarDecide(Sentence sentence) {

        return sentence;
    }

    public Sentence wordDecide(Sentence sentence) {

        return sentence;
    }
}
