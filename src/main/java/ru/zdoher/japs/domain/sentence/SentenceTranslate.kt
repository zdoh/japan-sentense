package ru.zdoher.japs.domain.sentence

import ru.zdoher.japs.domain.Language

data class SentenceTranslate(
    var language: Language,
    var translate: String,
    var otherOrigin: MutableList<OtherPossibleSentence> = mutableListOf()
)