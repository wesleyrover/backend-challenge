package com.invillia.acme.auth.service;

import com.invillia.acme.auth.db.entity.Order;
import com.invillia.acme.auth.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

/**
 * OrderService
 *
 * @author wesley rover
 *
 */
@Service
public class OrderService extends BaseService<Order, OrderRepository> {

    /**
     * Método de buscar uma Store
     *
     * @param name
     * @param address
     * @return List<Store>
     */
//    public List<Store> findStore(String name , String address) {
//        Specification<Store> spec = null;
//        if (Objects.nonNull(name))
//            spec = Specification.where(StorePredicates.nameContains(name));
//        if (Objects.nonNull(spec) && Objects.nonNull(address))
//            spec.or(StorePredicates.addressContains(address));
//        if (Objects.isNull(spec) && Objects.nonNull(address))
//            spec = Specification.where(StorePredicates.addressContains(address));
//        return getRepository().findAll(spec);
//    }

    /**
     * Método de salvar Order
     *
     * @param order
     * @return Order
     */
    public Order persistence(Order order) throws Exception {
        if(Objects.nonNull(order.getItems()) && order.getItems().stream().filter(Objects::nonNull).count() > 0)
            order.getItems().forEach(item -> {if (Objects.isNull(item.getId())) item.setId(UUID.randomUUID().toString().toUpperCase()); });
        return this.save(order);
    }
}
