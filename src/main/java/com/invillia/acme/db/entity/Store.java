package com.invillia.acme.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "\"STORE\"")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {

    private static final long serialVersionUID = -1551032717620937428L;

    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
    private String id;

    @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
    private String name;

    @ManyToOne
    @JoinColumn(name="fk_address", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
    private Address address;
}
