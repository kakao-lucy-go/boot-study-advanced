package com.mychum1.study.bootstudyadvanced.trace.hellotrace

import com.mychum1.study.bootstudyadvanced.trace.TraceId
import com.mychum1.study.bootstudyadvanced.trace.TraceStatus
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.lang.Exception
import java.lang.StringBuilder

@Slf4j
@Component
class HelloTraceV1 {

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startTimeMs = System.currentTimeMillis()
        log.info("{${traceId.id}] ${addSpace(START_PREFIX, traceId.level)}${message}")
        return TraceStatus(traceId, startTimeMs, message)
    }

    fun end(status: TraceStatus) {
        complete(status)
    }

    fun exception(status: TraceStatus, e: Exception) {
        complete(status, e)
    }

    fun complete(status: TraceStatus, e: Exception? = null) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId
        e?.let {
            log.info("[${traceId.id}] ${addSpace(EX_PREFIX, traceId.level)}${status.message} time=${resultTimeMs}ms ex=${e}")
        } ?: log.info("[${traceId.id}] ${addSpace(COMPLETE_PREFIX, traceId.level)}${status.message} time=${resultTimeMs}ms")
    }

    private fun addSpace(prefix: String, level: Int): String {
        val sb = StringBuilder()
        repeat(level) {
            sb.append( if(it == level -1) { "|${prefix}" } else {"|   "} )
        }
        return sb.toString()
    }

    companion object {
        private val log = LoggerFactory.getLogger(HelloTraceV1::class.java)
        private const val START_PREFIX = "-->"
        private const val COMPLETE_PREFIX = "<--"
        private const val EX_PREFIX = "<X->"
    }
}