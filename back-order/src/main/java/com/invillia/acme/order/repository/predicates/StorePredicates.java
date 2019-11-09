package com.invillia.acme.order.repository.predicates;


import com.invillia.acme.order.db.entity.Store;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class StorePredicates {

    public static Specification<Store> nameContains(String name) {
        return (root, cq, cb) -> Objects.isNull(name) ? cb.isTrue(cb.literal(true)) : cb.like(cb.lower(root.get("nome")), name.toLowerCase() + "%");
    }

    public static Specification<Store> addressContains(String address) {
        return (root, cq, cb) ->
                Objects.isNull(address) ? cb.isTrue(cb.literal(true)) : cb.like(cb.lower(root.get("address").get("place")), address.toLowerCase() + "%");
    }
}
