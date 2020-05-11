package ru.zdoher.japs.domain.user

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Indexed(unique = true) var username: String,
    var password: String,
    var roles: List<String>
) {

    fun toUserDetails(): MyUserDetails {
        return MyUserDetails(username, password, roles)
    }
}