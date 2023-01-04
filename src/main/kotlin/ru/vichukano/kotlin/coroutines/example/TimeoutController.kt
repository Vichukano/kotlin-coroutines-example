package ru.vichukano.kotlin.coroutines.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class TimeoutController {
    private val log = LoggerFactory.getLogger(javaClass)

    @GetMapping(value = ["/timeout/{count}"])
    fun startTimeout(@PathVariable count: Int) {
        log.info("Start timeout count: $count")
        for (i in 0..count) {
            val randDelay = Random.nextLong(1000, 10000)
            GlobalScope.launch {
                runTimeout(i, randDelay)
            }
        }
        log.info("Finish timeout with uid: $count")
    }

    private suspend fun runTimeout(i: Int, delay: Long) = coroutineScope {
        delay(delay)
        log.info("Fire $i with delay: $delay")
    }

}
