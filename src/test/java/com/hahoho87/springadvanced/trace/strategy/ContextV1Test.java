package com.hahoho87.springadvanced.trace.strategy;

import com.hahoho87.springadvanced.trace.strategy.code.strategy.ContextV1;
import com.hahoho87.springadvanced.trace.strategy.code.strategy.Strategy;
import com.hahoho87.springadvanced.trace.strategy.code.strategy.StrategyLogic1;
import com.hahoho87.springadvanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyPatternTest() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("비지니스 로직 1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("비지니스 로직 2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    @Test
    void strategyPatternTestV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyPatternTestV2() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스 로직 1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("비지니스 로직 1 실행"));
        contextV2.execute();
    }
}