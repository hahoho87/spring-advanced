package com.hahoho87.springadvanced.pureproxy.concreteproxy.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConcreteClient {

    private final ConcreteLogic concreteLogic;

    public void execute() {
        concreteLogic.operation();
    }

}
