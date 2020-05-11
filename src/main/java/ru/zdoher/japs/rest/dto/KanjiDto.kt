package ru.zdoher.japs.rest.dto

import ru.zdoher.japs.domain.Kanji
import ru.zdoher.japs.domain.TranslateEntity
import ru.zdoher.japs.domain.Word

data class KanjiDto(
    val id: String? = null,
    val kanji: String,
    val meaning: List<TranslateEntity>,
    val onyumi: List<String>? = null,
    val kunyumi: List<String>? = null,
    val words: List<Word?>? = null,
    val anchor: Word
) {
    fun fromDto(kanjiDto: KanjiDto?): Kanji {
        return Kanji(id, kanji, meaning, onyumi, kunyumi, words, anchor)

    }
    companion object {
        fun toDto(kanji: Kanji): KanjiDto {
            return KanjiDto(
                kanji.id,
                kanji.kanji,
                kanji.meaning,
                kanji.onyumi,
                kanji.kunyumi,
                kanji.words,
                kanji.anchor
            )
        }
    }
}