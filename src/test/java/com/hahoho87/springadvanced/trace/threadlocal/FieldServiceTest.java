package com.hahoho87.springadvanced.trace.threadlocal;

import com.hahoho87.springadvanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void threadTest() throws InterruptedException {
        log.info("main start");
        Runnable userA = () -> fieldService.logic("hahaha");
        Runnable userB = () -> fieldService.logic("hohoho");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제 발생 x
        sleep(100); // 동시성 문제 발생
        threadB.start();
        sleep(2000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
