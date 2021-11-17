package com.hahoho87.springadvanced.proxy.pureproxy.concreteproxy;

import com.hahoho87.springadvanced.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import com.hahoho87.springadvanced.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import com.hahoho87.springadvanced.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteClient concreteClient = new ConcreteClient(new ConcreteLogic());
        concreteClient.execute();
    }

    @Test
    void concreteProxyTest() {
        ConcreteClient concreteClient = new ConcreteClient(new TimeProxy(new ConcreteLogic()));
        concreteClient.execute();
    }
}
