package ru.zdoher.japs.config;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ApplicationConfig {

    private static final String CHANGELOGS_PACKAGE = "ru.zdoher.japs.changelog";

    @Bean
    public Mongock mongock(MongoProps mongoProps, MongoClient mongoClient) {
        return new SpringMongockBuilder(mongoClient, mongoProps.getDatabase(), CHANGELOGS_PACKAGE)
                .setLockQuickConfig()
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> htmlRouter(
        @Value("classpath:/public/index.html") Resource html) {
        return route(GET("/"), request
                -> ok().contentType(MediaType.TEXT_HTML).syncBody(html)
        ).andRoute(GET("/study/sentence"), request
                -> ok().contentType(MediaType.TEXT_HTML).syncBody(html));
    }
}
