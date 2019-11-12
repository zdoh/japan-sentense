package ru.zdoher.japs.changelog;

import ru.zdoher.japs.domain.*;
import ru.zdoher.japs.domain.sentence.SentencePoliteness;
import ru.zdoher.japs.domain.textbook.Textbook;
import ru.zdoher.japs.domain.textbook.TextbookSeries;
import ru.zdoher.japs.domain.textbook.TextbookType;

import java.util.HashMap;
import java.util.Map;

class InitMaps {
    static Map<String, PartOfSpeech> partOfSpeechMap = new HashMap<>();
    static Map<String, Language> languageMap = new HashMap<>();
    static Map<String, TextbookType>  textbookTypeMap = new HashMap<>();
    static Map<String, Word> wordsMap = new HashMap<>();
    static Map<String, Kanji> kanjiMap = new HashMap<>();
    static Map<String, Grammar> grammarMap = new HashMap<>();
    static Map<String, TextbookSeries> textbookSeriesMap = new HashMap<>();
    static Map<String, Textbook> textbookMap = new HashMap<>();
    static Map<String, SentencePoliteness> sentencePolitenessMap = new HashMap<>();
}
