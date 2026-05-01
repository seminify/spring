package org.seminify.application

import org.seminify.application.quote.QuoteResponse
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import org.springframework.web.client.RestClient

private val logger = LoggerFactory.getLogger(Application::class.java)

@SpringBootApplication
class Application {
    @Bean
    @Profile("!test")
    fun applicationRunner(builder: RestClient.Builder) = ApplicationRunner {
        logger.info(
            builder.build().get().uri("http://localhost:8080/api/random").retrieve().body(QuoteResponse::class.java)
                .toString()
        )
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
