package ru.zdoher.japs.repositories.aggregation;

import ru.zdoher.japs.domain.sentence.Sentence;

public interface RepositorySentenceAggregation {

    Sentence getRandom();
}
