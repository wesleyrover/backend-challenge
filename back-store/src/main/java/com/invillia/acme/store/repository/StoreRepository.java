package com.invillia.acme.store.repository;

import com.invillia.acme.store.db.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreRepository extends JpaRepository<Store, String>, JpaSpecificationExecutor<Store> {

}
