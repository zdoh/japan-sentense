package ru.zdoher.japs.batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.batch.domain.H2Language;

@Repository
public interface H2LanguageRepository extends JpaRepository<H2Language, Long> {
    H2Language findByShortName(String shortName);
}
