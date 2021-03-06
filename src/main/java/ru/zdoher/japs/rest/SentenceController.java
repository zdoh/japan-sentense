package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.repositories.sentence.SentenceRepository;
import ru.zdoher.japs.rest.dto.SentenceDto;

@RestController
@RequestMapping("/api/sentence")
public class SentenceController {
    private final SentenceRepository sentenceRepository;

    public SentenceController(SentenceRepository sentenceRepository) {
        this.sentenceRepository = sentenceRepository;
    }

    @GetMapping("/random")
    public Mono<Sentence> getStudySentence() {
        return sentenceRepository.getRandom(Sentence.class);
    }
}
