package com.hahoho87.springadvanced.proxy.pureproxy.decorator;

import com.hahoho87.springadvanced.proxy.pureproxy.decorator.code.DecoratorClientClient;
import com.hahoho87.springadvanced.proxy.pureproxy.decorator.code.MessageDecorator;
import com.hahoho87.springadvanced.proxy.pureproxy.decorator.code.RealComponent;
import com.hahoho87.springadvanced.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DecoratorPatternTest {

    @Test
    void noDecorator() {
        RealComponent realComponent = new RealComponent();
        DecoratorClientClient client = new DecoratorClientClient(realComponent);
        client.execute();
    }

    @Test
    void decoratorTest1() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorClientClient client = new DecoratorClientClient(messageDecorator);
        client.execute();
    }

    @Test
    void decoratorTest2() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorClientClient client = new DecoratorClientClient(timeDecorator);
        client.execute();
    }
}
