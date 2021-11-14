package com.hahoho87.springadvanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
