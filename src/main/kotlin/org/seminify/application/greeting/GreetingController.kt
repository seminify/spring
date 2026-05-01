package org.seminify.application.greeting

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

private const val template = "Hello, %s!"

@RestController
class GreetingController {
    private val counter = AtomicLong()

    @GetMapping("greeting")
    fun greeting(@RequestParam name: String = "World") = Greeting(counter.incrementAndGet(), template.format(name))
}
