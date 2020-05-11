package ru.zdoher.japs.changelog

import ru.zdoher.japs.domain.*
import ru.zdoher.japs.domain.sentence.SentencePoliteness
import ru.zdoher.japs.domain.textbook.Textbook
import ru.zdoher.japs.domain.textbook.TextbookSeries
import ru.zdoher.japs.domain.textbook.TextbookType
import java.util.*

internal object InitMaps {
    val partOfSpeechMap = mutableMapOf<String, PartOfSpeech>()
    val languageMap = mutableMapOf<String, Language>()
    val textbookTypeMap = mutableMapOf<String, TextbookType>()
    val wordsMap= mutableMapOf<String, Word>()
    val kanjiMap= mutableMapOf<String, Kanji>()
    val grammarMap = mutableMapOf<String, Grammar>()
    val textbookSeriesMap= mutableMapOf<String, TextbookSeries>()
    val textbookMap = mutableMapOf<String, Textbook>()
    val sentencePolitenessMap = mutableMapOf<String, SentencePoliteness>()
}
