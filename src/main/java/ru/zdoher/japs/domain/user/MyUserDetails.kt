package ru.zdoher.japs.domain.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

data class MyUserDetails(
    private var username: String,
    private var password: String,
    private var roles: Collection<String>
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return roles.stream()
            .map { role: String? ->
                SimpleGrantedAuthority(role)
            }.collect(Collectors.toList())
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    fun getRoles(): Collection<String> {
        return roles
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}