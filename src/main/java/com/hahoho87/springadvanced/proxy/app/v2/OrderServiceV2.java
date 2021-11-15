package com.hahoho87.springadvanced.proxy.app.v2;

import com.hahoho87.springadvanced.proxy.app.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceV2 implements OrderServiceV1 {

    private final OrderRepositoryV2 orderRepository;

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
