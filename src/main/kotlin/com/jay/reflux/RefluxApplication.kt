package com.jay.reflux

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication
@EnableWebFlux
class RefluxApplication

fun main(args: Array<String>) {
    runApplication<RefluxApplication>(*args)
}
