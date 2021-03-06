package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.TextbookType;

@Repository
public interface TextbookTypeRepository
        extends ReactiveMongoRepository<TextbookType, String> {
}
