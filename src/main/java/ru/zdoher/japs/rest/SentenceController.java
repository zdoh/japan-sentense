package ru.zdoher.japs.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.repositories.sentence.SentenceRepository;
import ru.zdoher.japs.rest.dto.SentenceDto;

import java.util.Random;

@RestController
@RequestMapping("/api/sentence")
public class SentenceController {
    private final SentenceRepository sentenceRepository;

    public SentenceController(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    @GetMapping("/random")
    @HystrixCommand(commandKey = "getSentenceRandom", fallbackMethod = "buildFallbackSentence")
    public Sentence getStudySentence() {
        return sentenceRepository.getRandom(Sentence.class);
    }

    private Sentence buildFallbackSentence() {
        Sentence kanji = new Sentence();
        kanji.setId("1L");
        kanji.setSentence("none sentence");
        return kanji;
    }

}
