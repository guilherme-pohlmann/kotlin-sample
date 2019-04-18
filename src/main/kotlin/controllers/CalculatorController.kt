package myFirstKotlinSpringApp.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculator")
class CalculatorController {

    @GetMapping("/sum")
    fun sum(n1: Int, n2: Int): Int = n1 + n2

}