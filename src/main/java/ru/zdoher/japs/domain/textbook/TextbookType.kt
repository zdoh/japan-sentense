package ru.zdoher.japs.domain.textbook

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.zdoher.japs.domain.TranslateEntity

@Document
data class TextbookType(
    @Id var id: String? = null,
    var name: String,
    var translateName: List<TranslateEntity>
)