package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.TextbookSeries;

@Repository
public interface TextbookSeriesRepository
        extends ReactiveMongoRepository<TextbookSeries, String> {
}
