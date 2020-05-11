package ru.zdoher.japs.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "config")
open class YAMLConfig (
    var secret: String? = null,
    var expiration: String? = null,
    var token_prefix: String? = null
)