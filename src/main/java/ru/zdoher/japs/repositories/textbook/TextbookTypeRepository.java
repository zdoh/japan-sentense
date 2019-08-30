package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.TextbookType;

@Repository
public interface TextbookTypeRepository extends MongoRepository<TextbookType, String> {
}
