package ru.zdoher.japs.rest.dto

import ru.zdoher.japs.domain.PartOfSpeech
import ru.zdoher.japs.domain.TranslateEntity
import ru.zdoher.japs.domain.Word

data class WordDto (
    val id: String?,
    val wordKanji: String?,
    val pronunciation: String,
    val translateEntities: List<TranslateEntity>,
    val partOfSpeeches: List<PartOfSpeech?>,
    val dontShow: Boolean

    ){
    fun fromDto(): Word {
        return Word(id, wordKanji, pronunciation, translateEntities, partOfSpeeches, dontShow)
    }

    companion object {
        fun toDto(word: Word): WordDto {
            return WordDto(
                word.id,
                word.wordKanji,
                word.pronunciation,
                word.translateEntities,
                word.partOfSpeeches,
                word.dontShow
            )
        }
    }
}