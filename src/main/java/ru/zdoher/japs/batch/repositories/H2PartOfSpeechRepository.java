package ru.zdoher.japs.batch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zdoher.japs.batch.domain.H2PartOfSpeech;

@Repository
public interface H2PartOfSpeechRepository extends JpaRepository<H2PartOfSpeech, Long> {
}
