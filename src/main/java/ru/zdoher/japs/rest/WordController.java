package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.WordRepositories;


@RestController
@RequestMapping("/api/word")
public class WordController {

    private final WordRepositories wordRepositories;

    public WordController(WordRepositories wordRepositories) {
        this.wordRepositories = wordRepositories;
    }

    @GetMapping("/")
    public Flux<Word> getAll() {
        return wordRepositories.findAll();
    }

    @DeleteMapping(value =  "/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return wordRepositories.deleteById(id);
    }


    @GetMapping("/{id}")
    public Mono<Word> getById(@PathVariable("id") String id) {
        return wordRepositories.findById(id);
    }

    @PutMapping("/")
    public Mono<Word> insert(@RequestBody Word word) {
        return wordRepositories.save(word);
    }

    @GetMapping("/random")
    public Mono<Word> getRandom() {
        return wordRepositories.getRandom(Word.class);
    }

}
