package ru.zdoher.japs.domain.sentence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.zdoher.japs.domain.Grammar
import ru.zdoher.japs.domain.Word

@Document
class Sentence(
    @Id var id: String? = null,
    var sentence: String,
    var translateList: List<SentenceTranslate>,
    var sentenceSource: String,
    var politeness: SentencePoliteness,
    var conversation: Boolean,
    var grammarList: List<Grammar> = mutableListOf(),
    var words: List<Word> = mutableListOf()
)
