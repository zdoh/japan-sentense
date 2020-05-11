package ru.zdoher.japs.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Grammar(
    @Id var id: String? = null,
    var name: String,
    var grammarCreate: List<PartOfSpeech?>,
    var resultPartOfSpeech: PartOfSpeech? = null,
    var grammarComment: List<TranslateEntity>? = null
)