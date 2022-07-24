package com.gdit.accounts.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person extends BaseEntity implements PersonInterface {
    @Column(name = "given_name", nullable = false)
    private String givenName;

    @Column(name = "sur_name", nullable = false)
    private String surName;

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

    @ManyToMany(/* fetch = FetchType.EAGER */)
    @JoinTable(name = "person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses = new LinkedHashSet<>();



    @Override
    public String getGivenName() {
        return givenName;
    }

    @Override
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public Set<Address> getAddresses() {
        return addresses;
    }

    @Override
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }




}