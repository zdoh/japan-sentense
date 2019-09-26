package ru.zdoher.japs.security;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
        /*return http.csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .pathMatchers("/login", "/logout").permitAll()
                .pathMatchers("/study/**").permitAll()
                .pathMatchers("/index.html").permitAll()
                .pathMatchers("/**").permitAll()
                .pathMatchers("/word").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and().formLogin()
                .loginPage("/login")
                .authenticationFailureHandler((exchange, exception) -> Mono.error(exception))
                .authenticationSuccessHandler(new WebFilterChainServerAuthenticationSuccessHandler())
                .and().build();*/


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


       /* return http.csrf().disable()
                .exceptionHandling()
                //.authenticationEntryPoint((exchange, exception) -> Mono.error(exception))
                .accessDeniedHandler((exchange, exception) -> Mono.error(exception)).and()
                .authorizeExchange()
                .pathMatchers("/api/word/random").permitAll()
                .pathMatchers("/api/word/**").hasRole("ADMIN")
                .pathMatchers("/api/sentence/random").permitAll()
                .pathMatchers("/api/sentence/**").hasRole("ADMIN")
                .pathMatchers("/api/kanji/random").permitAll()
                .pathMatchers("/api/kanji/**").hasRole("ADMIN")
                .pathMatchers("/**").permitAll()
                //.and().httpBasic()
                .and().formLogin()
                .loginPage("/login")
                .authenticationFailureHandler((exchange, exception) -> Mono.error(exception))
                .authenticationSuccessHandler(new WebFilterChainServerAuthenticationSuccessHandler())
                .and().build();*/
    }

    @Bean
    public PasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }

}
