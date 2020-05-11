package ru.zdoher.japs.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.zdoher.japs.domain.Kanji
import ru.zdoher.japs.repositories.KanjiRepository

@RestController
@RequestMapping("/api/kanji")
class KanjiController(private val kanjiRepository: KanjiRepository) {

    @GetMapping("/random")
    fun random(): Mono<Kanji> =  kanjiRepository.getRandom(Kanji::class)
}