package com.hahoho87.springadvanced.proxy.pureproxy.proxy;

import com.hahoho87.springadvanced.proxy.pureproxy.proxy.code.ProxyPatternClient;
import com.hahoho87.springadvanced.proxy.pureproxy.proxy.code.RealSubject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }
}
