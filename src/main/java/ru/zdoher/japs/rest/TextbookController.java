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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/textbook")
public class TextbookController {
    private final TextbookRepository textbookRepository;

    public TextbookController(TextbookRepository textbookRepository) {
        this.textbookRepository = textbookRepository;
    }

    @GetMapping("/simple")
    public List<TextbookSimple> getSimpleList() {
        return textbookRepository.findAll().stream().map(Textbook::toTextbookSimple).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Textbook getById(@PathVariable("id") String id) {
        return textbookRepository.findById(id).orElse(null);
    }
}
