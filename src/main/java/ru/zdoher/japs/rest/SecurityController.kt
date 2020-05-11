package ru.zdoher.japs.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.zdoher.japs.domain.user.MyUserDetails
import ru.zdoher.japs.domain.user.User
import ru.zdoher.japs.repositories.user.UserRepository
import ru.zdoher.japs.security.AuthRequest
import ru.zdoher.japs.security.JWTUtil

@RestController
data class SecurityController(
    val jwtUtil: JWTUtil,
    val userRepository: UserRepository
) {

    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): Mono<ResponseEntity<*>> {
        val user = userRepository.findByUsername(authRequest.username)

        return user.map { obj: User -> obj.toUserDetails() }
            .map {
                if (BCrypt.checkpw(authRequest.password, it.password)) {
                    return@map ResponseEntity.ok(jwtUtil.generateToken(it))
                } else {
                    return@map ResponseEntity.status(HttpStatus.UNAUTHORIZED).build<Any>()
                }
            }.defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build())
    }

}