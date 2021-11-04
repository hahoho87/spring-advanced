package com.hahoho87.springadvanced.app.trace.hellotrace;

import com.hahoho87.springadvanced.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceTest {

    @Test
    void begin_end_test() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello");
        trace.end(status);
    }

    @Test
    void begin_exception_test() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("Hello");
        trace.exception(status, new IllegalStateException());
    }


}