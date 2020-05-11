package ru.zdoher.japs.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Language(
    @Id var id: String? = null,
    var shortName: String,
    var fullName: String
)