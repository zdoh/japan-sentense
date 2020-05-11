package ru.zdoher.japs.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.zdoher.japs.domain.sentence.Sentence
import ru.zdoher.japs.repositories.sentence.SentenceRepository

@RestController
@RequestMapping("/api/sentence")
class SentenceController(private val sentenceRepository: SentenceRepository) {

    @GetMapping("/random")
    fun studySentence(): Mono<Sentence> = sentenceRepository.getRandom(Sentence::class)
}