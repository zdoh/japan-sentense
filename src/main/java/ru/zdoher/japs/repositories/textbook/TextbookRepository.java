package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.Textbook;

@Repository
public interface TextbookRepository extends MongoRepository<Textbook, String> {
}
