package com.gdit.accounts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Clock;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NotNull
    @Version
    private Integer version;

    public Integer getVersion() {
        return version;
    }


    @Transient
    private Clock clock = Clock.systemUTC();

    @JsonIgnore

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }


}