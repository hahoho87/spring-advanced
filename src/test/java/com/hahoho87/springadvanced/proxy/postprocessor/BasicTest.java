package com.hahoho87.springadvanced.proxy.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class BasicTest {

    @Test
    void basicConfigTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloConfig.class);
        A beanA = applicationContext.getBean("beanA", A.class);
        beanA.helloA();

        Throwable throwable = catchThrowable(() -> applicationContext.getBean(B.class));
        assertThat(throwable).isInstanceOf(NoSuchBeanDefinitionException.class);
    }

    @Test
    void postProcessorTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
        B beanA = applicationContext.getBean("beanA", B.class);
        beanA.helloB();

        Throwable throwable = catchThrowable(() -> applicationContext.getBean(A.class));
        assertThat(throwable).isInstanceOf(NoSuchBeanDefinitionException.class);
    }


    @Configuration
    static class HelloConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }
    }

    @Configuration
    static class BeanPostProcessorConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }

        @Bean
        public AToBPostProcessor helloPostProcessor() {
            return new AToBPostProcessor();
        }
    }

    @Slf4j
    static class A {
        public void helloA() {
            log.info("hello A");
        }
    }

    @Slf4j
    static class B {
        public void helloB() {
            log.info("hello B");
        }
    }

    @Slf4j
    static class AToBPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("beanName = {}, bean = {}", beanName, bean);
            if (bean instanceof A) {
                return new B();
            }
            return bean;
        }
    }
}
