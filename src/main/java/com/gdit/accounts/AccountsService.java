package com.gdit.accounts;

import com.gdit.accounts.model.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/accounts")
public class AccountsService {

    @Inject
    EntityManager em;

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> get() {

        var query = em.createQuery("select p from Person p");
        List resultList = query.getResultList();

        return resultList;
    }



}
