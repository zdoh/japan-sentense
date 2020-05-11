package ru.zdoher.japs.security

import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextImpl
import org.springframework.security.web.server.context.ServerSecurityContextRepository
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import ru.zdoher.japs.config.YAMLConfig
import java.util.function.Function

@Component
class SecurityContextRepository(
    private val authenticationManager: AuthenticationManager,
    private val yamlConfig: YAMLConfig
) : ServerSecurityContextRepository {
    override fun save(serverWebExchange: ServerWebExchange, securityContext: SecurityContext): Mono<Void> {
        throw UnsupportedOperationException("Not supported yet.")
    }

    override fun load(serverWebExchange: ServerWebExchange): Mono<SecurityContext> {
        val request = serverWebExchange.request
        println(serverWebExchange.request.headers)
        val authHeader =
            request.headers.getFirst(HttpHeaders.AUTHORIZATION)
        if (authHeader != null && authHeader.startsWith(yamlConfig.token_prefix!!)) {
            val authToken = authHeader.substring(7)
            val auth: Authentication = UsernamePasswordAuthenticationToken(authToken, authToken)

            return authenticationManager.authenticate(auth)
                .map { authentication ->
                    SecurityContextImpl(authentication)
                }
        }

        return Mono.empty()
    }

}