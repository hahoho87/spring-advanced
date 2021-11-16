package com.hahoho87.springadvanced.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorClientClient {

    private Component component;

    public DecoratorClientClient(Component component) {
        this.component = component;
    }

    public void execute() {
        String result = component.operation();
        log.info("result = {}", result);
    }
}
