package ru.zdoher.japs.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import ru.zdoher.japs.config.YAMLConfig;
import ru.zdoher.japs.domain.user.MyUserDetails;
import ru.zdoher.japs.domain.user.User;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    private YAMLConfig yamlConfig;

    public JWTUtil(YAMLConfig yamlConfig) {
        this.yamlConfig = yamlConfig;
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(yamlConfig.getSecret()).parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public AuthResponse generateToken(MyUserDetails user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRoles());
        return doGenerateToken(claims, user);
    }

    private AuthResponse doGenerateToken(Map<String, Object> claims, MyUserDetails user) {
        long expirationTimeLong = Long.parseLong(yamlConfig.getExpiration());
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, yamlConfig.getSecret())
                .compact();

        return new AuthResponse(user.getUsername(), token, user.getRoles(), expirationDate);
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
