package org.seminify.application

import org.seminify.application.customer.Customer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.query

private val logger: Logger = LoggerFactory.getLogger(Application::class.java)

@SpringBootApplication
class Application(private val jdbcTemplate: JdbcTemplate) : CommandLineRunner {
    override fun run(vararg args: String) {
        logger.info("Creating tables")
        jdbcTemplate.execute("DROP TABLE IF EXISTS customers")
        jdbcTemplate.execute(
            """
            CREATE TABLE customers(
                id SERIAL, 
                first_name VARCHAR(255), 
                last_name VARCHAR(255)
            )
        """.trimIndent()
        )
        val arrays = arrayOf("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
            .map {
                val split = it.split(" ");
                logger.info("Inserting customer record for {} {}", split[0], split[1])
                split.toTypedArray()
            }
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", arrays)
        logger.info("Querying for customer records where first_name = 'Josh':")
        jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", "Josh")
        { rs, _ ->
            Customer(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name")
            )
        }.forEach { logger.info(it.toString()) }
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
