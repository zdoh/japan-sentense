package ru.zdoher.japs.rest.dto

import ru.zdoher.japs.domain.Grammar
import ru.zdoher.japs.domain.Word
import ru.zdoher.japs.domain.sentence.Sentence
import ru.zdoher.japs.domain.sentence.SentencePoliteness
import ru.zdoher.japs.domain.sentence.SentenceTranslate

data class SentenceDto(
    val id: String? = null,
    val sentence: String? = null,
    val translateList: List<SentenceTranslate>? = null,
    val sentenceSource: String? = null,
    val politeness: SentencePoliteness? = null,
    val conversation: Boolean = false,
    val grammarList: List<Grammar> = mutableListOf(),
    val words: List<Word> = mutableListOf()
) {
    fun fromDto(): Sentence {
        return Sentence(
            id,
            sentence!!,
            translateList!!,
            sentenceSource!!,
            politeness!!,
            conversation,
            grammarList,
            words
        )
    }

    companion object {
        fun toDto(sentence: Sentence): SentenceDto {
            return SentenceDto(
                sentence.id,
                sentence.sentence,
                sentence.translateList,
                sentence.sentenceSource,
                sentence.politeness,
                sentence.conversation,
                sentence.grammarList,
                sentence.words
            )
        }
    }
}