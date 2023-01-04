package ru.vichukano.kotlin.coroutines.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class KotlinCoroutinesExampleApplication

fun main(args: Array<String>) {
	runApplication<KotlinCoroutinesExampleApplication>(*args)
}
