package com.example.springdemo.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping("/hello")
    fun hello(name: String?): String {
        return "Hello world: $name"
    }
}