package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.*;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.WordRepositories;
import ru.zdoher.japs.rest.dto.WordDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/word")
public class WordController {

    private final WordRepositories wordRepositories;

    public WordController(WordRepositories wordRepositories) {
        this.wordRepositories = wordRepositories;
    }


    @GetMapping("/")
    public List<WordDto> getAll() {
        return wordRepositories.findAll().stream().map(WordDto::toDto).collect(Collectors.toList());
    }

    @DeleteMapping(value =  "/{id}")
    public void delete(@PathVariable("id") String id) {
        wordRepositories.deleteById(id);
    }


    @GetMapping("/{id}")
    public Optional<WordDto> getById(@PathVariable("id") String id) {
        return wordRepositories.findById(id).map(WordDto::toDto);
    }

    @PutMapping("/")
    public void insert(@RequestBody WordDto wordDto) {
        wordRepositories.save(wordDto.fromDto());
    }

    @GetMapping("/random")
    public WordDto getRandom() {
        return WordDto.toDto(wordRepositories.getRandom(Word.class));
    }

}
