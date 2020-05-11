package ru.zdoher.japs.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import ru.zdoher.japs.domain.sentence.Sentence

@Document
data class Lesson(
    @Id var id: String? = null,
    var name: String,
    @DBRef var kanjiList: MutableList<Kanji?> = mutableListOf(),
    @DBRef var wordList: MutableList<Word?> = mutableListOf(),
    @DBRef var grammarsList: MutableList<Grammar?> = mutableListOf(),
    @DBRef var sentencesList: MutableList<Sentence?> = mutableListOf()
)