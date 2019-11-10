package com.invillia.acme.auth.controller;

import com.invillia.acme.store.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class BaseController<Entity, Service extends BaseService> {

    @Getter
    @Autowired
    private Service service;

}
