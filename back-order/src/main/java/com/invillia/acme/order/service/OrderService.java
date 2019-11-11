package com.invillia.acme.order.service;

import com.invillia.acme.order.db.entity.Order;
import com.invillia.acme.order.db.enums.OrderStatusEnum;
import com.invillia.acme.order.repository.OrderRepository;
import com.invillia.acme.order.repository.predicates.OrderPredicates;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

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
     * @param order
     * @return List<Store>
     */
    public List<Order> findOrder(String order ) {
        Specification<Order> spec = null;
        if (Objects.nonNull(order))
            spec = Specification.where(OrderPredicates.idEquals(order));
        return getRepository().findAll(spec);
    }

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

    /**
     * Método de recursar a Order
     *
     * @param order
     * @return Order
     */
    public Order refund(Order order) throws Exception {
        AtomicReference<Order> retorno = new AtomicReference<>();
        getRepository().findById(order.getId()).ifPresent(order1 -> retorno.set(order1));
        if ( Objects.nonNull(retorno.get()) && !retorno.get().getStatus().getCode().equals(OrderStatusEnum.REFUND)){
            order.setStatus(OrderStatusEnum.REFUND);
            return this.save(order);
        }
       return retorno.get();
    }
}
