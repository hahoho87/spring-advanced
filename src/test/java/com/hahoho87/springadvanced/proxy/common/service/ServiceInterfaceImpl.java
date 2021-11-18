package com.hahoho87.springadvanced.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceInterfaceImpl implements ServiceInterface {

    @Override
    public void save() {
        log.info("save");
    }

    @Override
    public void find() {
        log.info("find");
    }
}
