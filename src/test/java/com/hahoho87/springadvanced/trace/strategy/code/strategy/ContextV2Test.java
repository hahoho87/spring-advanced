package com.hahoho87.springadvanced.trace.strategy.code.strategy;

import org.junit.jupiter.api.Test;

class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }
}
