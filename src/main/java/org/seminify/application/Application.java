package org.seminify.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.FullyQualifiedConfigurationBeanNameGenerator;

@SpringBootApplication(
  nameGenerator = FullyQualifiedConfigurationBeanNameGenerator.class
)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
