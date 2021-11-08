package com.hahoho87.springadvanced.trace.logtrace;

import com.hahoho87.springadvanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);

}
