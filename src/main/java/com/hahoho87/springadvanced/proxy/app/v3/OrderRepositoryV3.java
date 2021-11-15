package com.hahoho87.springadvanced.proxy.app.v3;

import com.hahoho87.springadvanced.proxy.app.v1.OrderRepositoryV1;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV3 implements OrderRepositoryV1 {

    @Override
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("exception occurred");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
