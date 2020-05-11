package ru.zdoher.japs.repositories

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import ru.zdoher.japs.domain.Word
import ru.zdoher.japs.repositories.aggregation.RepositoryAggregation

@Repository
interface WordRepositories : ReactiveMongoRepository<Word, String>, RepositoryAggregation<Word>