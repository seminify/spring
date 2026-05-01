package org.seminify.application;

import org.seminify.application.quote.QuoteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Application {

  private static final Logger LOGGER = LoggerFactory.getLogger(
    Application.class
  );

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  @Profile("!test")
  public ApplicationRunner applicationRunner(RestClient.Builder builder) {
    return args -> {
      LOGGER.info(
        builder
          .baseUrl("http://localhost:8080")
          .build()
          .get()
          .uri("/api/random")
          .retrieve()
          .body(QuoteResponse.class)
          .toString()
      );
    };
  }
}
