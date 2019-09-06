package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zdoher.japs.domain.Kanji;
import ru.zdoher.japs.repositories.KanjiRepository;
import ru.zdoher.japs.rest.dto.KanjiDto;

@RestController
@RequestMapping("/api")
public class KanjiController {
    private final KanjiRepository kanjiRepository;

    public KanjiController(KanjiRepository kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }

    @GetMapping("/study/kanji")
    public KanjiDto getRandom() {
        return KanjiDto.toDto(kanjiRepository.getRandom());
    }
}
