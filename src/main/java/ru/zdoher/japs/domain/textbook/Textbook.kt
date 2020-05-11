package ru.zdoher.japs.domain.textbook

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import ru.zdoher.japs.domain.Lesson

@Document
data class Textbook (
    @Id var id: String? = null,
    var japaneseName: String,
    var englishName: String,
    @DBRef var textbookSeries: TextbookSeries? = null,
    var show: Boolean? = null,
    @DBRef var textbookType: List<TextbookType?>? = null,
    var lessonList: MutableList<Lesson> = mutableListOf()
) {
    fun toTextbookSimple(): TextbookSimple {
        return TextbookSimple(id, japaneseName, englishName)
    }
}