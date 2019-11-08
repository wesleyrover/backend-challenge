package com.invillia.acme.service;

import com.invillia.acme.exception.ServiceException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@Slf4j
public abstract class BaseService<Entity, Repository extends JpaRepository<Entity, String>> {

    @Getter
    @Autowired
    private Repository repository;

    /**
     * Método abstract para salvar
     *
     * @param entity
     * @return Entity
     */
    public Entity save(Entity entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            log.error("Fail Save", e);
            throw new ServiceException("Fail Save.", e);
        }
    }

    /**
     * Método abstract para update e tratamento de concorrência.
     *
     * @param entity
     * @param id
     * @return Store
     */
    public Entity update(Entity entity, String id) throws Exception {
        if(!repository.findById(id).isPresent())
            throw new ServiceException("Registro não pode ser localizado, o mesmo no existe ou foi excluído.", null);
        return this.save(entity);
    }
}
