package ru.zdoher.japs.rest

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import ru.zdoher.japs.domain.Word
import ru.zdoher.japs.repositories.WordRepositories

@RestController
@RequestMapping("/api/word")
class WordController(private val wordRepositories: WordRepositories) {

    @GetMapping("/")
    fun all(): Flux<Word> = wordRepositories.findAll()

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable("id") id: String): Mono<Void> = wordRepositories.deleteById(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): Mono<Word> = wordRepositories.findById(id)

    @PutMapping("/")
    fun insert(@RequestBody word: Word): Mono<Word> = wordRepositories.save(word)

    @GetMapping("/random")
    fun random(): Mono<Word> = wordRepositories.getRandom(Word::class)

}