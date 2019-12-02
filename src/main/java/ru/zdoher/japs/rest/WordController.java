package ru.zdoher.japs.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;
import ru.zdoher.japs.domain.Word;
import ru.zdoher.japs.repositories.WordRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/word")
public class WordController {

    private final WordRepositories wordRepositories;

    public WordController(WordRepositories wordRepositories) {
        this.wordRepositories = wordRepositories;
    }


    @GetMapping("/")
    @HystrixCommand(commandKey = "getAllWord", fallbackMethod = "buildFallbackWordsList")
    public List<Word> getAll() {
        sleepRandomly();
        return wordRepositories.findAll();
    }

    @DeleteMapping(value =  "/{id}")
    @HystrixCommand(commandKey = "deletWordById", defaultFallback = "")
    public void delete(@PathVariable("id") String id) {
        wordRepositories.deleteById(id);
    }


    @GetMapping("/{id}")
    @HystrixCommand(commandKey = "getWordById", fallbackMethod = "buildFallbackWord")
    public Word getById(@PathVariable("id") String id) {
        return wordRepositories.findById(id).orElse(null);
    }

    @PutMapping("/")
    @HystrixCommand(commandKey = "getWordInsert", fallbackMethod = "buildFallbackWord")
    public Word insert(@RequestBody Word word) {
        return wordRepositories.save(word);
    }

    @GetMapping("/random")
    @HystrixCommand(commandKey = "getWordRandom", fallbackMethod = "buildFallbackWord")
    public Word getRandom() {
        return wordRepositories.getRandom(Word.class);
    }

    private Word buildFallbackWord() {
        Word kanji = new Word();
        kanji.setId("1L");
        kanji.setWordKanji("none word");
        return kanji;
    }

    private List<Word> buildFallbackWordsList() {
        Word word = new Word();
        word.setId("1L");
        word.setWordKanji("none word");
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        return wordList;
    }

    private void sleepRandomly() {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if(randomNum == 3) {
            System.out.println("Проверка работы хистрикса");
            try {
                System.out.println("засыпаю на " + System.currentTimeMillis());
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                System.out.println("Хистрикс сработал" + System.currentTimeMillis());
            }
        }
    }

}
