package ru.zdoher.japs.config

import com.github.cloudyrock.mongock.Mongock
import com.github.cloudyrock.mongock.SpringMongockBuilder
import com.mongodb.MongoClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
open class ApplicationConfig {
    @Bean
    open fun mongock(
        mongoProps: MongoProps,
        mongoClient: MongoClient
    ): Mongock {
        return SpringMongockBuilder(mongoClient, mongoProps.database, CHANGELOGS_PACKAGE)
            .setLockQuickConfig()
            .build()
    }

    @Bean
    open fun htmlRouter(
        @Value("classpath:/public/index.html") html: Resource
    ): RouterFunction<ServerResponse> {
        return RouterFunctions.route(
            RequestPredicates.GET("/"),
            HandlerFunction { request: ServerRequest? ->
                ServerResponse.ok().contentType(MediaType.TEXT_HTML).syncBody(html)
            }
        ).andRoute(
            RequestPredicates.GET("/study/sentence"),
            HandlerFunction { request: ServerRequest? ->
                ServerResponse.ok().contentType(MediaType.TEXT_HTML).syncBody(html)
            }
        )
    }

    companion object {
        private const val CHANGELOGS_PACKAGE = "ru.zdoher.japs.changelog"
    }
}