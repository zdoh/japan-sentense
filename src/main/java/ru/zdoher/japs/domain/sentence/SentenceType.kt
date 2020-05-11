package ru.zdoher.japs.domain.sentence

import org.springframework.data.annotation.Id

data class SentenceType (
    @Id var id: String? = null,
    var respectful: String
)