package com.invillia.acme.db.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "\"ADDRESS\"")
@Data
@Builder
public class Address implements Serializable {

    private static final long serialVersionUID = -610932984856113786L;

    @Id
    @Column(name = "id", nullable = false, insertable=true, updatable=true)
    private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

    //@Column(name = "place", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.String place;
     
    //@Column(name = "complement", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.String complement;

    //@Column(name = "number", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.Integer number;

    //@Column(name = "neighborhood", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.String neighborhood;

    //@Column(name = "city", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.String city;

    //@Column(name = "zipcode", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.Double zipcode;

    //@Column(name = "state", nullable = true, unique = false, insertable=true, updatable=true)
    private java.lang.String state;
}
