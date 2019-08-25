package ru.zdoher.japs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class JapanSentenseApplication {
    public static void main(String[] args) {
        SpringApplication.run(JapanSentenseApplication.class, args);
    }
}
