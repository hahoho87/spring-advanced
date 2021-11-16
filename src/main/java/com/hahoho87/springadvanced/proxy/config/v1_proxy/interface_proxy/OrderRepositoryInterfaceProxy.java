package com.hahoho87.springadvanced.proxy.config.v1_proxy.interface_proxy;

import com.hahoho87.springadvanced.proxy.app.v1.OrderRepositoryV1;
import com.hahoho87.springadvanced.trace.TraceStatus;
import com.hahoho87.springadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
