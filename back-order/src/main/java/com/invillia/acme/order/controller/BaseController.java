package com.invillia.acme.order.controller;

import com.invillia.acme.store.service.BaseService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
public abstract class BaseController<Entity, Service extends BaseService> {

    @Getter
    @Autowired
    private Service service;

}
