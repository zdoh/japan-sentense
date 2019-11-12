package ru.zdoher.japs.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YAMLConfig {
    private String secret;
    private String expiration;
    private String token_prefix;
}
