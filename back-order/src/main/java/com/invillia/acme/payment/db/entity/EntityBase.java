package com.invillia.acme.payment.db.entity;

import com.invillia.acme.payment.exception.EntityException;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class EntityBase {

    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
    private String id;

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(id))
            throw new EntityException("Entity ".concat(this.getClass().getSimpleName()).concat(": id is null."), null);
        return obj !=null && (super.equals(obj)
                || (this.getClass().equals(obj.getClass()) && this.id.equals(((EntityBase) obj).getId())));
    }
}
