package ru.zdoher.japs.repositories.sentence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import ru.zdoher.japs.domain.sentence.Sentence
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation

@Repository
interface SentenceRepository : ReactiveMongoRepository<Sentence, String>, RepositoryAggregation<Sentence>