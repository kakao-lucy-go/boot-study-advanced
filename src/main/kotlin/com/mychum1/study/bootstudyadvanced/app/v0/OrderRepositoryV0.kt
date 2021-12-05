package com.mychum1.study.bootstudyadvanced.app.v0

import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV0 {
    fun saveItem(item: String) {
        if (item == "ex") {
            throw IllegalStateException("오류")
        }
        sleep(1000)
    }

    private fun sleep(i: Long) {
        try {
            Thread.sleep(i)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}