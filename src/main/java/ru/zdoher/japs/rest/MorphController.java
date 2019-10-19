package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.morphology.KuramojiPartOfSpeech;
import ru.zdoher.japs.repositories.morphology.KuramojiPartOfSpeechRepository;

import java.util.List;

@RestController
@RequestMapping("/api/morph")
public class MorphController {

    private final KuramojiPartOfSpeechRepository kuramojiPartOfSpeechRepository;

    public MorphController(KuramojiPartOfSpeechRepository kuramojiPartOfSpeechRepository) {
        this.kuramojiPartOfSpeechRepository = kuramojiPartOfSpeechRepository;
    }

    @GetMapping("/")
    public Flux<KuramojiPartOfSpeech> getAll() {
        return kuramojiPartOfSpeechRepository.findAll();
    }

    @GetMapping("/{name}")
    public Mono<KuramojiPartOfSpeech> getByName(@PathVariable("name") String name) {
        return kuramojiPartOfSpeechRepository.findByName(name);
    }
}
