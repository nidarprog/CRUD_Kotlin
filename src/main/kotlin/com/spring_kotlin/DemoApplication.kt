package com.spring_kotlin

import com.spring_kotlin.domain.Person
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class DemoApplication{

	@GetMapping
	fun hi(): Person{
		return Person(lastName = "Lopez", name = "Ola")
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
