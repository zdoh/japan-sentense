package ru.zdoher.japs.service.user;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.user.User;
import ru.zdoher.japs.repositories.user.UserRepository;


@Service
public class MyReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    private UserRepository userRepository;

    public MyReactiveUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username).map(User::toUserDetails);
    }
}
