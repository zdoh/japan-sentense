package ru.zdoher.japs.repositories.textbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.domain.textbook.Textbook;

import java.util.List;

@Repository
public interface TextbookRepository
        extends CrudRepository<Textbook, String> {
    List<Textbook> findAll();
}
