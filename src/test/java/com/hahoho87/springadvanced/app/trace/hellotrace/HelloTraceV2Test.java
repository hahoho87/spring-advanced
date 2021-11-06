package com.hahoho87.springadvanced.app.trace.hellotrace;

import com.hahoho87.springadvanced.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void createNextTraceIdTest() {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.beginSync(status1.getTraceId(), "trace");
        trace.end(status2);
        trace.end(status1);
    }
}