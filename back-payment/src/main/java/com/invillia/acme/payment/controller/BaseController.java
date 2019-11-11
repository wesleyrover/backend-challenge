package com.invillia.acme.payment.controller;

import com.invillia.acme.payment.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public abstract class BaseController<Entity, Service extends BaseService> {

    @Getter
    @Autowired
    private Service service;

}
