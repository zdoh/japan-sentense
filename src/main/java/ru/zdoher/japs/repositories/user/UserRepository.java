package ru.zdoher.japs.repositories.user;

import org.springframework.data.repository.CrudRepository;
import ru.zdoher.japs.domain.user.User;

public interface UserRepository
        extends CrudRepository<User, String> {
    User findByUsername(String username);
}
