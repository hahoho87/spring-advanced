package com.hahoho87.springadvanced.app.v5;

import com.hahoho87.springadvanced.trace.callback.TraceTemplate;
import com.hahoho87.springadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate traceTemplate;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.traceTemplate = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        traceTemplate.execute("OrderService.orderItem", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
