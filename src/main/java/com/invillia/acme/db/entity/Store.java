package com.invillia.acme.db.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "\"STORE\"")
@Data
@Builder
public class Store implements Serializable {

    private static final long serialVersionUID = -1551032717620937428L;

    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
    private String id = UUID.randomUUID().toString().toUpperCase();

    @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
    private String name;

    //@ManyToOne
    //@JoinColumn(name="fk_address", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
    private Address address;
}
