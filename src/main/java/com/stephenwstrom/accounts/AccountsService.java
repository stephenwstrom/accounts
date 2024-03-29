/*
 * Copyright (c) 2022. Stephen W. Strom
 */

package com.stephenwstrom.accounts;

import com.stephenwstrom.accounts.model.Address;
import com.stephenwstrom.accounts.model.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/accounts")
@Transactional
public class AccountsService {

    @Inject
    EntityManager em;

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> get() {
        var query = em.createQuery("select p from Person p");
        List<Person> resultList = (List<Person>) query.getResultList();
        for (Person p: resultList) {
            p.getAddresses().size();
        }

        return resultList;
    }

    @GET
    @Path("/person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Person get(@PathParam("id") UUID id) {
        var query = em.createQuery("select p from Person p where p.id = ?1");
        query.setParameter(1, id);
        Person result = (Person) query.getSingleResult();
        result.getAddresses().size();

        return result;
    }

    @GET
    @Path("/address/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Address getAddress(UUID id) {
        var query = em.createQuery("select a from Address a where a.id = ?1");
        query.setParameter(1, id);
        Address result = (Address) query.getSingleResult();
        return result;
    }

    @PUT
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public UUID put(Person p) {
        em.persist(p);
        em.persist(p.getAddresses().toArray()[0]);
        p.getAddresses().size();
        return p.getId();
     }

    @POST
    @Path("/person/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Person p, @PathParam("id") UUID id) {
        var query = em.createQuery("select p from Person p where p.id = ?1");
        query.setParameter(1, id);
        var pold = (Person) query.getSingleResult();
        pold.getName().setGivenName(p.getName().getGivenName());
     }



}
