package com.hahoho87.springadvanced.proxy.bytebuddy;

import com.hahoho87.springadvanced.proxy.common.service.ConcreteService;
import com.hahoho87.springadvanced.proxy.jdkdynamic.code.TimeInvocationHandler;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

@Slf4j
class ByteBuddyProxyTest {

    @Test
    void byteBuddyProxyTest() throws Exception {
        Class<? extends ConcreteService> proxyClass = new ByteBuddy().subclass(ConcreteService.class)
                .method(named("call")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    ConcreteService concreteService = new ConcreteService();

                    @Override
                    public Object invoke(Object obj, Method method, Object[] args) throws Throwable {

                        final Object target = obj;
                        log.info("Time Proxy Start");
                        long startTime = System.currentTimeMillis();

                        Object result = method.invoke(concreteService, args);

                        long endTime = System.currentTimeMillis();
                        long resultTime = endTime - startTime;
                        log.info("ConcreteService end | resultTime = {}", resultTime);

                        return result;
                    }
                }))
                .make().load(ConcreteService.class.getClassLoader()).getLoaded();
        ConcreteService concreteService = proxyClass.getConstructor().newInstance();

        concreteService.call();
    }

    @Test
    void byteBuddyInvocationHandlerTest() throws Exception {
        Class<? extends ConcreteService> proxyClass = new ByteBuddy().subclass(ConcreteService.class)
                .method(named("call")).intercept(InvocationHandlerAdapter.of(new TimeInvocationHandler(new ConcreteService())))
                .make().load(ConcreteService.class.getClassLoader()).getLoaded();

        ConcreteService concreteService = proxyClass.getConstructor().newInstance();
        concreteService.call();
    }
}
