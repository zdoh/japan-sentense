package ru.zdoher.japs.domain.textbook

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class TextbookSeries(
    @Id var id: String? = null,
    var name: String,
    var englishName: String
)