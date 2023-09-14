/*
 * Copyright (c) 2022. Stephen W. Strom
 */

package com.stephenwstrom.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PersonHumanResource extends Person {

    public boolean isEmployed() {
        return employed;
    }

    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    @Column(name = "employed")
    private boolean employed;
}