package ru.zdoher.japs.rest.log;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.zdoher.japs.domain.log.MorphologyLog;
import ru.zdoher.japs.repositories.log.MorphologyLogRepository;

@RestController
@RequestMapping("/api/log")
public class MorphologyLogController {
    private MorphologyLogRepository morphologyLogRepository;

    public MorphologyLogController(MorphologyLogRepository morphologyLogRepository) {
        this.morphologyLogRepository = morphologyLogRepository;
    }

    @GetMapping("/")
    public Flux<MorphologyLog> getAll() {
        return morphologyLogRepository.findAll();
    }
}
