package ru.zdoher.japs.service.log;

import ru.zdoher.japs.domain.sentence.Sentence;

public interface MorphologyLogService {
    void missingKuramojiPartOfSpeech(String sentence, String word, String kuramojiPartOfSpeech);
    void missingWord(String sentence, String word);
    void cannotAddSentence(String sentence);
}
