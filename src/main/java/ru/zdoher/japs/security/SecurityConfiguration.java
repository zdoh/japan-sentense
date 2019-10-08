package ru.zdoher.japs.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;
import org.springframework.security.web.server.authentication.WebFilterChainServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;
import reactor.core.publisher.Mono;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        return http.csrf().disable()
                .authorizeExchange()
                    .pathMatchers("/api/word/random").permitAll()
                    .pathMatchers("/api/word/**").hasRole("ADMIN")
                    .pathMatchers("/api/sentence/random").permitAll()
                    .pathMatchers("/api/sentence/**").hasRole("ADMIN")
                    .pathMatchers("/api/kanji/random").permitAll()
                    .pathMatchers("/api/kanji/**").hasRole("ADMIN")
                    .pathMatchers("/**").permitAll()
                .and().formLogin().loginPage("/login")
                    .authenticationFailureHandler((exchange, exception) -> Mono.error(exception))
                    .authenticationSuccessHandler(new WebFilterChainServerAuthenticationSuccessHandler())
                .and().exceptionHandling()
                    .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
                    .accessDeniedHandler(new HttpStatusServerAccessDeniedHandler(HttpStatus.FORBIDDEN))
                .and().build();

    }

    @Bean
    public PasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

}
