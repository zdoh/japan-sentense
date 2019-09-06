package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.*;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.WordRepositories;
import ru.zdoher.japs.rest.dto.WordDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WordController {

    private final WordRepositories wordRepositories;

    public WordController(WordRepositories wordRepositories) {
        this.wordRepositories = wordRepositories;
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/words")
    public List<WordDto> getAll() {
        return wordRepositories.findAll().stream().map(WordDto::toDto).collect(Collectors.toList());
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value =  "/word/{id}")
    public void delete(@PathVariable("id") String id) {
        wordRepositories.deleteById(id);
    }


    @GetMapping("/word/{id}")
    public Optional<WordDto> getById(@PathVariable("id") String id) {
        return wordRepositories.findById(id).map(WordDto::toDto);
    }

    @PostMapping("/word")
    public void insert(@RequestBody WordDto wordDto) {

        Word word = wordRepositories.save(wordDto.fromDto());
        System.out.println("save " + word);
    }

    @GetMapping("/study/word")
    public WordDto getRandom() {
        return WordDto.toDto(wordRepositories.getRandom());
    }

}