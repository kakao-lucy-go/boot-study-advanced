package com.mychum1.study.bootstudyadvanced.app.v0

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderServiceV0(private val orderRepository: OrderRepositoryV0) {
    fun saveItem(item: String): String {
        orderRepository.saveItem(item)
        return item
    }
}