package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.repositories.KanjiRepository;

@RestController
@RequestMapping("/api/kanji")
public class KanjiController {
    private final KanjiRepository kanjiRepository;

    public KanjiController(KanjiRepository kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }

    @GetMapping("/random")
    public Mono<Kanji> getRandom() {
        return kanjiRepository.getRandom(Kanji.class);
    }
}
