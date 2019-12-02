package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.TextbookType;

@Repository
public interface TextbookTypeRepository
        extends CrudRepository<TextbookType, String> {
}
