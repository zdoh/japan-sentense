package ru.zdoher.japs

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.config.WebFluxConfigurerComposite

@SpringBootApplication
@EnableConfigurationProperties
open class JapanSentenceApplication {
    // для отдельной разработки ui
    /* @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/ **").allowedOrigins("http://localhost:9000");
            }
        };
    }*/
    @Bean
    open fun corsConfigurer(): WebFluxConfigurer {
        return object : WebFluxConfigurerComposite() {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/**").allowedOrigins("*")
                    .allowedMethods("*").allowedHeaders("*").allowCredentials(true)
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(JapanSentenceApplication::class.java, *args)
        }
    }
}