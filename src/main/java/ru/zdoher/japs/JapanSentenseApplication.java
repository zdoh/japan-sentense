package ru.zdoher.japs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.zdoher.japs.domain.sentence.Sentence;
import ru.zdoher.japs.utilz.MorphologyWorkClass;


@SpringBootApplication
@EnableConfigurationProperties
public class JapanSentenseApplication {
    public static void main(String[] args) {
        SpringApplication.run(JapanSentenseApplication.class, args);

       new MorphologyWorkClass().doWork();
    }


    // для отдельной разработки ui
    /*@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }*/
}
