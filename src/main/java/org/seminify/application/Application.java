package org.seminify.application;

import java.util.stream.Stream;
import org.seminify.application.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(
    Application.class
  );
  private final JdbcTemplate jdbcTemplate;

  public Application(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    LOGGER.info("Creating tables");
    jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
    jdbcTemplate.execute(
      "CREATE TABLE customers(" +
        "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))"
    );
    jdbcTemplate.batchUpdate(
      "INSERT INTO customers(first_name, last_name) VALUES (?,?)",
      Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
        .map(arg0 -> {
          var split = arg0.split(" ");
          LOGGER.info(
            "Inserting customer record for {} {}",
            split[0],
            split[1]
          );
          return new Object[] { split[0], split[1] };
        })
        .toList()
    );
    LOGGER.info("Querying for customer records where first_name = 'Josh':");
    jdbcTemplate
      .query(
        "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
        (rs, _) ->
          new Customer(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name")
          ),
        "Josh"
      )
      .forEach(customer -> LOGGER.info(customer.toString()));
  }
}
