package ru.zdoher.japs.domain.sentence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.zdoher.japs.domain.TranslateEntity

@Document
data class SentencePoliteness(
    @Id var id: String? = null,
    var japName: String,
    var translateEntities: List<TranslateEntity>
)