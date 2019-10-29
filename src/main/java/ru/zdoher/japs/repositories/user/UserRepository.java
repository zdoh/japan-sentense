package ru.zdoher.japs.repositories.user;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.user.User;

public interface UserRepository
        extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String username);
}
