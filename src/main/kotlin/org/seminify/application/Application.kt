package org.seminify.application

import org.seminify.application.file.FileProperties
import org.seminify.application.file.FileService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties(FileProperties::class)
class Application {
    @Bean
    fun commandLineRunner(fileService: FileService) = CommandLineRunner {
        fileService.deleteAll()
        fileService.init()
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
