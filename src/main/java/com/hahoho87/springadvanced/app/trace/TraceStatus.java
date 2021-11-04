package com.hahoho87.springadvanced.app.trace;

public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs;
    private Long message;

    public TraceStatus(TraceId traceId, Long startTimeMs, Long message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public Long getMessage() {
        return message;
    }
}
