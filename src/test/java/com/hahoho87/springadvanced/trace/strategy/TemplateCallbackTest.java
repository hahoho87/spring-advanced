package com.hahoho87.springadvanced.trace.strategy;

import com.hahoho87.springadvanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class TemplateCallbackTest {

    @Test
    void templateCallbackTest() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> log.info("비지니스 실행"));
    }

}
