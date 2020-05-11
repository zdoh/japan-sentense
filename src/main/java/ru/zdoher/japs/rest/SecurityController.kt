package ru.zdoher.japs.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.zdoher.japs.domain.user.MyUserDetails;
import ru.zdoher.japs.domain.user.User;
import ru.zdoher.japs.repositories.user.UserRepository;
import ru.zdoher.japs.security.AuthRequest;
import ru.zdoher.japs.security.JWTUtil;

@RestController
public class SecurityController {

    private JWTUtil jwtUtil;

    private UserRepository userRepository;

    public SecurityController(JWTUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest authRequest) {
        Mono<User> user = userRepository.findByUsername(authRequest.getUsername());

        return user.map(User::toUserDetails)
                .map(userDetail -> {
            if (BCrypt.checkpw(authRequest.getPassword(), userDetail.getPassword())) {
                return ResponseEntity.ok(jwtUtil.generateToken(userDetail));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}
