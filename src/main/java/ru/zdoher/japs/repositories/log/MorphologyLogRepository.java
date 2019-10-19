package ru.zdoher.japs.repositories.log;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.zdoher.japs.domain.log.MorphologyLog;

public interface MorphologyLogRepository
        extends ReactiveMongoRepository<MorphologyLog, String> {
}
