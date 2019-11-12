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
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

    private AuthenticationManager authenticationManager;

    private SecurityContextRepository securityContextRepository;

    public SecurityConfiguration(AuthenticationManager authenticationManager, SecurityContextRepository securityContextRepository) {
        this.authenticationManager = authenticationManager;
        this.securityContextRepository = securityContextRepository;
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.csrf().disable()
                .authorizeExchange()
//                    .pathMatchers("/api/word/random").hasRole("USER")
//                    .pathMatchers("/api/word/**").hasRole("ADMIN")
//                    .pathMatchers("/api/sentence/random").hasRole("USER")
//                    .pathMatchers("/api/sentence/**").hasRole("ADMIN")
//                    .pathMatchers("/api/kanji/random").hasRole("USER")
//                    .pathMatchers("/api/kanji/**").hasRole("ADMIN")
//                    .pathMatchers("/api/textbook/simple").hasRole("ADMIN")
//                    .pathMatchers("/api/textbook/**").hasRole("ADMIN")
//                    .pathMatchers("/**").permitAll()
//                    .pathMatchers("/login").permitAll()
                
                .pathMatchers("/**").permitAll()
                .pathMatchers("/login").permitAll()

                .anyExchange().authenticated()
                .and().formLogin().disable().httpBasic().disable()
                    .authenticationManager(authenticationManager)
                    .securityContextRepository(securityContextRepository)
                .exceptionHandling()
                    .authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
                    .accessDeniedHandler(new HttpStatusServerAccessDeniedHandler(HttpStatus.FORBIDDEN))
                .and().build();
    }

    @Bean
    public PasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

}
