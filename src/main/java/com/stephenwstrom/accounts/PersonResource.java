/*
 * Copyright (c) 2022. Stephen W. Strom
 */

package com.stephenwstrom.accounts;

import com.stephenwstrom.accounts.model.Person;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@GraphQLApi
public class PersonResource {

    @Inject
    EntityManager em;

    @Query("allPeople")
    @Description("Get all people")
    public List<Person> getAllPeople() {
        var query = em.createQuery("select p from Person p");
        List<Person> resultList = (List<Person>) query.getResultList();

        return resultList;
    }
}
