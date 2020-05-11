package ru.zdoher.japs.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("spring.data.mongodb")
data class MongoProps(
    var port: Int = 0,
    var database: String? = null,
    var uri: String? = null
)