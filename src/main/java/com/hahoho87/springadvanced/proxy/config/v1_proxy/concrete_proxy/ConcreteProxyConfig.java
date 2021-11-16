package com.hahoho87.springadvanced.proxy.config.v1_proxy.concrete_proxy;

import com.hahoho87.springadvanced.proxy.app.v2.OrderControllerV2;
import com.hahoho87.springadvanced.proxy.app.v2.OrderRepositoryV2;
import com.hahoho87.springadvanced.proxy.app.v2.OrderServiceV2;
import com.hahoho87.springadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderController(LogTrace logTrace) {
        OrderControllerV2 target = new OrderControllerV2(orderService(logTrace));
        return new OrderControllerConcreteProxy(target, logTrace);
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace logTrace) {
        OrderServiceV2 target = new OrderServiceV2(orderRepository(logTrace));
        return new OrderServiceConcreteProxy(target, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV2 target = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(target, logTrace);
    }
}
