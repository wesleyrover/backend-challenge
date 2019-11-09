package com.invillia.acme.order.service;

import com.invillia.acme.order.db.entity.Store;
import com.invillia.acme.order.repository.StoreRepository;
import com.invillia.acme.order.repository.predicates.StorePredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * StoreSercice
 *
 * @author wesley rover
 *
 */
@Service
public class StoreService extends BaseService<Store, StoreRepository> {

    @Autowired
    AddressService addressService;

    /**
     * Método de buscar uma Store
     *
     * @param name
     * @param address
     * @return List<Store>
     */
    public List<Store> findStore(String name , String address) {
        Specification<Store> spec = null;
        if (Objects.nonNull(name))
            spec = Specification.where(StorePredicates.nameContains(name));
        if (Objects.nonNull(spec) && Objects.nonNull(address))
            spec.or(StorePredicates.addressContains(address));
        if (Objects.isNull(spec) && Objects.nonNull(address))
            spec = Specification.where(StorePredicates.addressContains(address));
        return getRepository().findAll(spec);
    }

    public Store persistence(Store store) throws Exception {
        if(Objects.nonNull(store.getAddress()))
            store.setAddress(addressService.save(store.getAddress()));
        return this.save(store);
    }
}
