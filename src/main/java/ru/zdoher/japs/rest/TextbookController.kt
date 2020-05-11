package ru.zdoher.japs.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.zdoher.japs.domain.textbook.Textbook
import ru.zdoher.japs.domain.textbook.TextbookSimple
import ru.zdoher.japs.repositories.textbook.TextbookRepository

@RestController
@RequestMapping("/api/textbook")
class TextbookController(private val textbookRepository: TextbookRepository) {
    @GetMapping("/simple")
    fun simpleList(): Flux<TextbookSimple> = textbookRepository
        .findAll()
        .map {
            it.toTextbookSimple()
        }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): Mono<Textbook> = textbookRepository.findById(id)
}