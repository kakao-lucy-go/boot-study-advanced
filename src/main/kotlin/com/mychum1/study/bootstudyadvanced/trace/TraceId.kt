package com.mychum1.study.bootstudyadvanced.trace

import java.util.*

class TraceId private constructor(val id: String, val level: Int){
    constructor() : this(UUID.randomUUID().toString().substring(0, 8), 0)

    fun createNextId(): TraceId {
        return TraceId(id, level + 1)
    }

    fun createPreviousId(): TraceId {
        return TraceId(id, level - 1)
    }

    fun isFirstLevel(): Boolean {
        return level == 0
    }
}