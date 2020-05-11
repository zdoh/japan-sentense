package ru.zdoher.japs.security

import java.util.*

data class AuthResponse (
    val username: String? = null,
    val token: String? = null,
    val roles: Collection<String>? = null,
    val exp: Date? = null
    )