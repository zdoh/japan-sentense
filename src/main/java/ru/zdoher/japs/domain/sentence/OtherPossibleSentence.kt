package ru.zdoher.japs.domain.sentence

data class OtherPossibleSentence(
    var sentence: String,
    var author: String,
    var likesCount: Int = 0
)