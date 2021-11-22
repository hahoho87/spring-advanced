package com.hahoho87.springadvanced;

import com.hahoho87.springadvanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import com.hahoho87.springadvanced.trace.logtrace.LogTrace;
import com.hahoho87.springadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
@Import(ProxyFactoryConfigV2.class)
@SpringBootApplication(scanBasePackages = "com.hahoho87.springadvanced.proxy.app")
public class SpringAdvancedApplication {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedApplication.class, args);
    }

}
