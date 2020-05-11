package ru.zdoher.japs.security

import org.springframework.security.authentication.ReactiveAuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import ru.zdoher.japs.domain.user.Role
import java.util.*
import java.util.stream.Collectors

@Component
class AuthenticationManager(private val jwtUtil: JWTUtil) : ReactiveAuthenticationManager {

    override fun authenticate(authentication: Authentication): Mono<Authentication> {
        val authToken = authentication.credentials.toString()
        val username: String?
        username = try {
            jwtUtil.getUsernameFromToken(authToken)
        } catch (e: Exception) {
            null
        }
        if (username != null && jwtUtil.validateToken(authToken)) {
            val claims = jwtUtil.getAllClaimsFromToken(authToken)
            val rolesMap: List<*> =
                claims.get("role", List::class.java)
            val roles: MutableList<Role> =
                ArrayList()
            for (rolemap in rolesMap) {
                roles.add(Role.valueOf(rolemap.toString()))
            }
            val auth = UsernamePasswordAuthenticationToken(
                username,
                null,
                roles.stream()
                    .map { authority: Role ->
                        SimpleGrantedAuthority(authority.name)
                    }.collect(Collectors.toList())
            )
            return Mono.just(auth)
        }
        return Mono.empty()
    }

}