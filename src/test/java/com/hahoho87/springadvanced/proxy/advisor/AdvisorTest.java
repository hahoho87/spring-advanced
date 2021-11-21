package com.hahoho87.springadvanced.proxy.advisor;

import com.hahoho87.springadvanced.proxy.common.advice.TimeAdvice;
import com.hahoho87.springadvanced.proxy.common.service.ServiceInterface;
import com.hahoho87.springadvanced.proxy.common.service.ServiceInterfaceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

class AdvisorTest {

    @Test
    void advisorTest1() {
        ServiceInterfaceImpl target = new ServiceInterfaceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor);
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.save();
        proxy.find();
    }

}
