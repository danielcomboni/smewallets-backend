package com.screentech.cordamigrate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CordamigrateApplication

fun main(args: Array<String>) {
    runApplication<CordamigrateApplication>(*args)
}
