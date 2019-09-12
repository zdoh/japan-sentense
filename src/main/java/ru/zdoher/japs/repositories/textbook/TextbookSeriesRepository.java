package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.TextbookSeries;

@Repository
public interface TextbookSeriesRepository extends MongoRepository<TextbookSeries, String> {
}
