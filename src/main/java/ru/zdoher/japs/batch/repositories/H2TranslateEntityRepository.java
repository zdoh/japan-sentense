package ru.zdoher.japs.batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.batch.domain.H2TranslateEntity;

@Repository
public interface H2TranslateEntityRepository extends JpaRepository<H2TranslateEntity, Long> {
}