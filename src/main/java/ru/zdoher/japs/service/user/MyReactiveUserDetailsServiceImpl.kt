package ru.zdoher.japs.service.user

import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.zdoher.japs.repositories.user.UserRepository

@Service
class MyReactiveUserDetailsServiceImpl(private val userRepository: UserRepository) : ReactiveUserDetailsService {

    override fun findByUsername(username: String): Mono<UserDetails> =
        userRepository.findByUsername(username)
            .map { user ->
                user.toUserDetails()
            }
}