package com.invillia.acme.order.repository.predicates;


import com.invillia.acme.order.db.entity.Order;
import com.invillia.acme.order.db.enums.OrderStatusEnum;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderPredicates {

    public static Specification<Order> idEquals(String id) {
        return (root, cq, cb) -> Objects.isNull(id) ? cb.isTrue(cb.literal(true))
                : cb.equal(root.get("id"), id);
    }

    public static Specification<Order> addressContains(String address) {
        return (root, cq, cb) -> Objects.isNull(address) ? cb.isTrue(cb.literal(true))
                : cb.like(cb.lower(root.get("address")), address.toLowerCase() + "%");
    }

    public static Specification<Order> statusEqualsTo(OrderStatusEnum status) {
        return (root, cq, cb) -> Objects.isNull(status) ? cb.isTrue(cb.literal(true)) : cb.equal(root.get("status"), status);
    }

    public static Specification<Order> confirmationDateEqualsTo(LocalDateTime confirmation) {
        return (root, cq, cb) -> Objects.isNull(confirmation) ? cb.isTrue(cb.literal(true))
                : cb.equal(root.get("confirmation"), confirmation);
    }

    public static Specification<Order> fetchItems() {
        return (root, cq, cb) -> {
            root.fetch("items", JoinType.INNER);
            return null;
        };
    }
}
