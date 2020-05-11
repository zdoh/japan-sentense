package ru.zdoher.japs.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Word (
    @Id var id: String? = null,
    var wordKanji: String? = null,
    var pronunciation: String,
    var translateEntities: List<TranslateEntity>,
    var partOfSpeeches: List<PartOfSpeech?>,
    var dontShow: Boolean = true
)