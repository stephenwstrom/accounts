/*
 * Copyright (c) 2022. Stephen W. Strom
 */

package com.stephenwstrom.accounts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.time.Clock;
import java.time.Instant;
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

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setModificationTimeStamp(Instant modificationTimeStamp) {
        this.modificationTimeStamp = modificationTimeStamp;
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

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationDateTime) {
        this.creationTimeStamp = creationDateTime;
    }

    @Column(name = "creation_time_stamp", nullable = false, columnDefinition="TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    // @Temporal(TemporalType.TIMESTAMP)
    Instant creationTimeStamp;


    public Instant getModificationTimeStamp() {
        return modificationTimeStamp;
    }

    public void setModificationTimeStampTimeStamp(Instant modificationTimeStamp) {
        this.modificationTimeStamp = modificationTimeStamp;
    }

    @Column(name = "modification_time_stamp", nullable = false, columnDefinition="TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    // @Temporal(TemporalType.TIMESTAMP)
    Instant modificationTimeStamp;


}