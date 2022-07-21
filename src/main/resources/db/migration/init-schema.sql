CREATE TABLE address
(
    id     UUID NOT NULL,
    street TEXT NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE person
(
    id         UUID NOT NULL,
    given_name TEXT NOT NULL,
    sur_name   TEXT NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY (id)
);

CREATE TABLE person_address
(
    address_id UUID NOT NULL,
    person_id  UUID NOT NULL,
    CONSTRAINT pk_person_address PRIMARY KEY (address_id, person_id)
);

ALTER TABLE person_address
    ADD CONSTRAINT fk_peradd_on_address FOREIGN KEY (address_id) REFERENCES address (id);

ALTER TABLE person_address
    ADD CONSTRAINT fk_peradd_on_person FOREIGN KEY (person_id) REFERENCES person (id);