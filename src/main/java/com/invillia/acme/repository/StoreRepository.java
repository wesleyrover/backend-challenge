package com.invillia.acme.repository;

import com.invillia.acme.db.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreRepository extends JpaRepository<Store, String>, JpaSpecificationExecutor<Store> {

}
