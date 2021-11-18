package com.hahoho87.springadvanced.proxy.cglib;

import com.hahoho87.springadvanced.proxy.cglib.code.TimeMethodInterceptor;
import com.hahoho87.springadvanced.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("TargetClass = {}", target.getClass());
        log.info("ProxyClass = {}", proxy.getClass());

        proxy.call();
    }
}
