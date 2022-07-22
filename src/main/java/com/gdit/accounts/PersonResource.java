package com.gdit.accounts;

import com.gdit.accounts.model.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/person")
public class PersonResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> get() {

        var query = em.createQuery("select p from Person p");
        List resultList = query.getResultList();

        return resultList;
    }



}
