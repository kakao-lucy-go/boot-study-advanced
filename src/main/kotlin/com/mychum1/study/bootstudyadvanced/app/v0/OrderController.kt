package com.mychum1.study.bootstudyadvanced.app.v0

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class OrderController(private val orderServiceV0: OrderServiceV0) {


    @GetMapping("/v0/request")
    fun saveItem(itemId: String): String {
        return orderServiceV0.saveItem(itemId)
    }
}