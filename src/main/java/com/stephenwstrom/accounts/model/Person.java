/*
 * Copyright (c) 2022. Stephen W. Strom
 */

package com.stephenwstrom.accounts.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person extends BaseEntity implements PersonInterface {


    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }


    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Override
    public PersonName getName() {
        return name;
    }

    @Override
    public void setName(PersonName name) {
        this.name = name;
        // assert that the name is not null
        assert name != null;

        // assert that if the name is smith, the name is not john   (this is a contrived example)

        var x = 3;
        var y = 4;

        // assert that x is less than y
        assert x < y;

        // assert that y is greater than x




    }

    @Embedded
    PersonName name;

    @ManyToMany(/* fetch = FetchType.EAGER */)
    @JoinTable(name = "person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses = new LinkedHashSet<>();





    @Override
    public Set<Address> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }




}