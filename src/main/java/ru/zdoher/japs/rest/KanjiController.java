package ru.zdoher.japs.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.repositories.KanjiRepository;

import java.util.Random;

@RestController
@RequestMapping("/api/kanji")
public class KanjiController {
    private final KanjiRepository kanjiRepository;

    public KanjiController(KanjiRepository kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }

    @GetMapping("/random")
    @HystrixCommand(commandKey = "getKanjiRandom", fallbackMethod = "buildFallbackKanjis")
    public Kanji getRandom() {
        sleepRandomly();
        return kanjiRepository.getRandom(Kanji.class);
    }

    private Kanji buildFallbackKanjis() {
        Kanji kanji = new Kanji();
        kanji.setId("1L");
        kanji.setKanji("none kanji");
        return kanji;
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
