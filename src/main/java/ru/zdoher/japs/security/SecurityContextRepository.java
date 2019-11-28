package ru.zdoher.japs.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.config.YAMLConfig;

@Component
public class SecurityContextRepository implements ServerSecurityContextRepository {

    private AuthenticationManager authenticationManager;

    private YAMLConfig yamlConfig;


    public SecurityContextRepository(AuthenticationManager authenticationManager, YAMLConfig yamlConfig) {
        this.authenticationManager = authenticationManager;
        this.yamlConfig = yamlConfig;
    }

    @Override
    public Mono<Void> save(ServerWebExchange serverWebExchange, SecurityContext securityContext) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Mono<SecurityContext> load(ServerWebExchange serverWebExchange) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith(yamlConfig.getToken_prefix())) {
            String authToken = authHeader.substring(7);
            Authentication auth = new UsernamePasswordAuthenticationToken(authToken, authToken);
            return this.authenticationManager.authenticate(auth).map(SecurityContextImpl::new);
        }

        return Mono.empty();
    }
}
