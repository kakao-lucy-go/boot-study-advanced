package com.mychum1.study.bootstudyadvanced.trace.hellotrace

import org.junit.jupiter.api.Test

internal class HelloTraceV1Test {

    @Test
    fun begin() {
        val trace = HelloTraceV1()
        val status = trace.begin("hello")
        trace.end(status)
    }

    @Test
    fun exception() {
        val trace = HelloTraceV1()
        val status = trace.begin("hello")
        trace.exception(status, IllegalStateException())
    }
}