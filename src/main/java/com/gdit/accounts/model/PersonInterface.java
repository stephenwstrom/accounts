package com.gdit.accounts.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;
import java.util.UUID;

public interface PersonInterface {
    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    UUID getId();

    void setId(UUID id);

    Integer getVersion();

    String getGivenName();

    void setGivenName(String givenName);

    String getSurName();

    void setSurName(String surName);

    Set<Address> getAddresses();

    void setAddresses(Set<Address> addresses);

    default int age(){
        var now = LocalDate.now();
        var period = Period.between(getBirthDate(), now);

        return period.getYears();
    }
}
