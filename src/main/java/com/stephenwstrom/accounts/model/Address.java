/*
 * Copyright (c) 2022. Stephen W. Strom
 */

package com.stephenwstrom.accounts.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "street", nullable = false)
    private String street;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}