package ru.zdoher.japs.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.textbook.Textbook;
import ru.zdoher.japs.domain.textbook.TextbookSimple;
import ru.zdoher.japs.repositories.textbook.TextbookRepository;

@RestController
@RequestMapping("/api/textbook")
public class TextbookController {
    private final TextbookRepository textbookRepository;

    public TextbookController(TextbookRepository textbookRepository) {
        this.textbookRepository = textbookRepository;
    }

    @GetMapping("/simple")
    public Flux<TextbookSimple> getSimpleList() {
        return textbookRepository.findAll().map(Textbook::toTextbookSimple);
    }

    @GetMapping("/{id}")
    public Mono<Textbook> getById(@PathVariable("id") String id) {
        return textbookRepository.findById(id);
    }
}
