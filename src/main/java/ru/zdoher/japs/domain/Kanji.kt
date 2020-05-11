package ru.zdoher.japs.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Kanji(
    @Id var id: String? = null,
    var kanji: String,
    var meaning: List<TranslateEntity>,
    var onyumi: List<String>? = null,
    var kunyumi: List<String>? = null,
    @DBRef var words: List<Word?>? = null,
    @DBRef var anchor: Word
)