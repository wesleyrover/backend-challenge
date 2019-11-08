package com.invillia.acme.service;

import com.invillia.acme.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public abstract class BaseService<Entity, Repository extends JpaRepository<Entity, String>> {

    @Autowired
    private Repository repository;

    public Entity save(Entity entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            log.error("Fail Save", e);
            throw new ServiceException("Fail Save.", e);
        }
    }
}
