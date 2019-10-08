package ru.zdoher.japs.repositories.user;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import ru.zdoher.japs.domain.user.User;

public interface UserRepository
        extends ReactiveMongoRepository<User, String> {
    Flux<User> findByUsername(String username);
}
