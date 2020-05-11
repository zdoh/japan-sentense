package ru.zdoher.japs.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import ru.zdoher.japs.config.YAMLConfig
import ru.zdoher.japs.domain.user.MyUserDetails
import java.io.Serializable
import java.util.*

@Component
class JWTUtil(private val yamlConfig: YAMLConfig) : Serializable {
    fun getAllClaimsFromToken(token: String?): Claims =
        Jwts.parser().setSigningKey(yamlConfig.secret).parseClaimsJws(token).body

    fun getUsernameFromToken(token: String?): String = getAllClaimsFromToken(token).subject

    fun getExpirationDateFromToken(token: String?): Date = getAllClaimsFromToken(token).expiration

    fun generateToken(user: MyUserDetails): AuthResponse {
        val claims: MutableMap<String, Any> = HashMap()
        claims["role"] = user.getRoles()
        return doGenerateToken(claims, user)
    }

    fun validateToken(token: String): Boolean = !isTokenExpired(token)

    private fun isTokenExpired(token: String): Boolean = getExpirationDateFromToken(token).before(Date())

    private fun doGenerateToken(
        claims: Map<String, Any>,
        user: MyUserDetails
    ): AuthResponse {
        val expirationTimeLong = yamlConfig.expiration!!.toLong()
        val createdDate = Date()
        val expirationDate = Date(createdDate.time + expirationTimeLong * 1000)
        val token = Jwts.builder()
            .setClaims(claims)
            .setSubject(user.username)
            .setIssuedAt(createdDate)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS256, yamlConfig.secret)
            .compact()
        return AuthResponse(user.username, token, user.getRoles(), expirationDate)
    }

    companion object {
        private const val serialVersionUID = 1L
    }

}