package com.invillia.acme.order.repository;

import com.invillia.acme.order.db.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StoreRepository extends JpaRepository<Store, String>, JpaSpecificationExecutor<Store> {

}
