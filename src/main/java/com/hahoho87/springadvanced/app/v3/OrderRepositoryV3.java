package com.hahoho87.springadvanced.app.v3;

import com.hahoho87.springadvanced.trace.TraceStatus;
import com.hahoho87.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {
        sleep(1000);
        TraceStatus status = trace.begin("OrderRepository.save()");
        try {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
