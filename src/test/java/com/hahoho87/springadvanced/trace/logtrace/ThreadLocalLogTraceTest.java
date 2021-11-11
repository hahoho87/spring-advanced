package com.hahoho87.springadvanced.trace.logtrace;

import com.hahoho87.springadvanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void traceBeginAndEndTest() {
        TraceStatus status1 = trace.begin("hello_1");
        TraceStatus status2 = trace.begin("hello_2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void traceBeginAndExceptionTest() {
        TraceStatus status1 = trace.begin("hello_1");
        TraceStatus status2 = trace.begin("hello_2");
        trace.exception(status2, new IllegalArgumentException("Exception_2"));
        trace.exception(status1, new IllegalArgumentException("Exception_1"));
    }
}